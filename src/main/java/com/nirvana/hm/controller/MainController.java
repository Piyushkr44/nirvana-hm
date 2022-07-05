package com.nirvana.hm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nirvana.hm.constant.Utils;
import com.nirvana.hm.entity.Guest;
import com.nirvana.hm.entity.Reservation;
import com.nirvana.hm.entity.User;
import com.nirvana.hm.service.GuestService;
import com.nirvana.hm.service.InvoiceService;
import com.nirvana.hm.service.ReservationService;
import com.nirvana.hm.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private GuestService guestService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private Utils utils;

	@RequestMapping("/")
	public String displayLogin(HttpServletRequest request) {

		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping("/welcome")
	public String displayWelcome() {

		return "welcome";
	}

	@PostMapping("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (userService.findByUsernameAndPassword(user.getUserName(), user.getPassword()) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "welcome";
		} else {
			return "error";

		}
	}

	@GetMapping("/guests")
	public String allGuests(HttpServletRequest request) {
		request.setAttribute("guests", guestService.findAllGuests());
		request.setAttribute("mode", "MODE_GUESTS");
		return "manageGuests";
	}

	@GetMapping("/new-guest")
	public String newGuest(HttpServletRequest request) {
		request.setAttribute("mode", "GUES_NEW");
		return "manageGuests";
	}

	@PostMapping("/save-guest")
	public String saveGuest(@ModelAttribute Guest guest, BindingResult bindingResult, HttpServletRequest request) {
		String guestId = null;
		List<Guest> guestList = guestService.findAllGuests();
		for (Guest g : guestList) {
			System.out.println("Inside for");
			if (guest.getGuestId().equalsIgnoreCase(g.getGuestId())) {
				System.out.println("Inside if for");
				guestId = guest.getGuestId();
				break;
			}
		}
		if(guestId == null){
			System.out.println("Inside if generate id");
			guestId = utils.generateId();
		}
		guest.setGuestId(guestId);
		guestService.saveGues(guest);
		request.setAttribute("guests", guestService.findAllGuests());
		request.setAttribute("mode", "MODE_GUESTS");
		return "manageGuests";

	}

	@GetMapping("/update-guest")
	public String updateGuest(@RequestParam String id, HttpServletRequest request) {
		Optional<Guest> guest = guestService.findGuest(id);
		if (guest.isPresent()) {
			request.setAttribute("guest", guest.get());
			request.setAttribute("mode", "GUES_UPDATE");
		}
		return "manageGuests";
	}

	@GetMapping("/delete-guest")
	public String deleteGuest(@RequestParam String id, HttpServletRequest request) {
		guestService.deleteGues(id);
		request.setAttribute("guests", guestService.findAllGuests());
		request.setAttribute("mode", "MODE_GUESTS");
		return "manageGuests";
	}

	@GetMapping("/reservations")
	public String allReservations(HttpServletRequest request) {
		request.setAttribute("reservations", reservationService.findAllReservations());
		request.setAttribute("mode", "MODE_RESERVATIONS");
		return "manageReservations";
	}

	@GetMapping("/new-reservation")
	public String newReservation(HttpServletRequest request) {
		request.setAttribute("mode", "RES_NEW");
		return "manageReservations";
	}

	@PostMapping("/save-reservation")
	public String saveReservation(@ModelAttribute Reservation reservation, BindingResult bindingResult,
			HttpServletRequest request) {
		reservation.setGuestId(reservation.getGuestId());
		reservationService.saveRes(reservation);
		request.setAttribute("reservations", reservationService.findAllReservations());
		request.setAttribute("mode", "MODE_RESERVATIONS");
		return "manageReservations";
	}

	@GetMapping("/update-reservation")
	public String updateReservation(@RequestParam int id, HttpServletRequest request) {
		Optional<Reservation> reservation = reservationService.findReservation(id);
		if (reservation.isPresent()) {
			request.setAttribute("reservation", reservation.get());
			request.setAttribute("mode", "RES_UPDATE");
		}
		return "manageReservations";
	}

	@GetMapping("/delete-reservation")
	public String deleteReservation(@RequestParam int id, HttpServletRequest request) {
		reservationService.deleteRes(id);
		request.setAttribute("reservations", reservationService.findAllReservations());
		request.setAttribute("mode", "MODE_RESERVATIONS");
		return "manageReservations";
	}

	@GetMapping("/invoice")
	public String getInvoice(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("invoice", invoiceService.getInvoiceByResId(id));
		return "invoice";
	}

	@PostMapping("/register-user")
	public String registerUser(@ModelAttribute User user, HttpServletRequest request) {
		userService.saveUser(user);
		return "registerSuccess";
	}

	@GetMapping("/register")
	public String register(HttpServletRequest request) {
		return "register";
	}
}
