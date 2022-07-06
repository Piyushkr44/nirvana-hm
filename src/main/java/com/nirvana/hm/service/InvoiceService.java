package com.nirvana.hm.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirvana.hm.constant.Constants;
import com.nirvana.hm.dao.GuestRepository;
import com.nirvana.hm.dao.ReservationRepository;
import com.nirvana.hm.entity.Guest;
import com.nirvana.hm.entity.Invoice;
import com.nirvana.hm.entity.Reservation;

@Service
@Transactional
public class InvoiceService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private GuestRepository guestRepository;
	
	public InvoiceService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public Invoice getInvoiceByResId(int id){
		System.out.println("Inside getInvoiceByResId 1");
		Reservation reservation = (reservationRepository.findById(id)).get();
		System.out.println("Inside getInvoiceByResId 2");
		Optional<Guest> guest = guestRepository.findByGuestId(reservation.getGuestId());
		System.out.println("Inside getInvoiceByResId 3");
		Invoice invoice = new Invoice();
		invoice.setGuestId(guest.get().getGuestId());
		invoice.setReservationId(id);
		invoice.setRoomNumber(reservation.getRoomNumber());
		invoice.setGuestName(guest.get().getGuestName());
		invoice.setBillDate(getCurrentDate());
		invoice.setCheckInDate(reservation.getCheckInDate());
		invoice.setCheckOutDate(reservation.getCheckOutDate());
		invoice.setGst(calculateGstCharges(reservation.getCheckInDate(), reservation.getCheckOutDate()));
		invoice.setPerDayCharges(Constants.PER_DAY_CHARGES);
		invoice.setTotalAmount(calculateTotalCharges(reservation.getCheckInDate(), reservation.getCheckOutDate()));
		invoice.setTotalDay(calculateBoookingDays(reservation.getCheckInDate(), reservation.getCheckOutDate()));
		System.out.println("Inside getInvoiceByResId 4");
		return invoice;
	}
	
	public String getCurrentDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		return formatter.format(date);
	}
	
	public float calculateTotalCharges(Date checkInDate, Date checkOutDate){
		float totalCostWithoutGST = Float.valueOf(calculateBoookingDays(checkInDate, checkOutDate)*Constants.PER_DAY_CHARGES);
		System.out.println("TotalCost: "+totalCostWithoutGST);
		float gstCharges = calculateGstCharges(checkInDate, checkOutDate);
		System.out.println("Total: "+totalCostWithoutGST+gstCharges);
		return totalCostWithoutGST+gstCharges;	
	}
	
	public long calculateBoookingDays(Date checkInDate, Date checkOutDate){
		long diff = checkOutDate.getTime() - checkInDate.getTime();
		return diff/(24*60*60*1000);
	}
	
	public float calculateGstCharges(Date checkInDate, Date checkOutDate){
		float oneDayGstCharge = (float) ((Constants.GST_VALUE*Constants.PER_DAY_CHARGES)/100);
		System.out.println("One Day GST:"+oneDayGstCharge);
		System.out.println((Float.valueOf(calculateBoookingDays(checkInDate, checkOutDate)))*oneDayGstCharge);
		return (Float.valueOf(calculateBoookingDays(checkInDate, checkOutDate)))*oneDayGstCharge;
	}

}
