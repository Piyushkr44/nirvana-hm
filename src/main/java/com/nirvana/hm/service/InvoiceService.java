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
		Guest guest = (guestRepository.findById(1)).get();
		System.out.println("Inside getInvoiceByResId 3");
		Invoice invoice = new Invoice();
		invoice.setGuestId(guest.getGuestId());
		invoice.setReservationId(id);
		invoice.setRoomNumber(reservation.getRoomNumber());
		invoice.setGuestName(guest.getGuestName());
		invoice.setBillDate(getCurrentDate());
		invoice.setCheckInDate(reservation.getCheckInDate());
		invoice.setCheckOutDate(reservation.getCheckOutDate());
		invoice.setGst(12.00f);
		invoice.setPerDayCharges(1200.00f);
		invoice.setTotalAmount(calculateTotalCharges(reservation.getCheckInDate(), reservation.getCheckOutDate()));
		System.out.println("Inside getInvoiceByResId 4");
		return invoice;
	}
	
	public String getCurrentDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		return formatter.format(date);
	}
	
	public float calculateTotalCharges(Date checkInDate, Date checkOutDate){
		float totalCostWithoutGST = Float.valueOf(calculateBoookingDays(checkInDate, checkOutDate)*Long.valueOf(1200));
		System.out.println("TotalCost: "+totalCostWithoutGST);
		float gstCharges = calculateGstCharges(checkInDate, checkOutDate);
		System.out.println("Total: "+totalCostWithoutGST+gstCharges);
		return totalCostWithoutGST+gstCharges;	
		//return calculateGstCharges(checkInDate, checkOutDate)+((calculateBoookingDays(checkInDate, checkOutDate)*Long.valueOf(1200)));
	}
	
	public long calculateBoookingDays(Date checkInDate, Date checkOutDate){
		long diff = checkOutDate.getTime() - checkInDate.getTime();
		return diff/(24*60*60*1000);
	}
	
	public float calculateGstCharges(Date checkInDate, Date checkOutDate){
		float oneDayGstCharge = (float) ((18*1200)/100);
		System.out.println("One Day GST:"+oneDayGstCharge);
		System.out.println((Float.valueOf(calculateBoookingDays(checkInDate, checkOutDate)))*oneDayGstCharge);
		return (Float.valueOf(calculateBoookingDays(checkInDate, checkOutDate)))*oneDayGstCharge;
	}

}
