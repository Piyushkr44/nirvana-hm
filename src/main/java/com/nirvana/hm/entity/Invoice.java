package com.nirvana.hm.entity;

import java.util.Date;

public class Invoice {
	
	private String billDate;
	private String guestId;
	private String guestName;
	private int reservationId;
	private Date checkInDate;
	private Date checkOutDate;
	private int roomNumber;
	private float perDayCharges;
	private float gst;
	private float totalAmount;
	private float roomRent;
	private long totalDay;
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public float getPerDayCharges() {
		return perDayCharges;
	}
	public void setPerDayCharges(float perDayCharges) {
		this.perDayCharges = perDayCharges;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(float roomRent) {
		this.roomRent = roomRent;
	}
	public long getTotalDay() {
		return totalDay;
	}
	public void setTotalDay(long totalDay) {
		this.totalDay = totalDay;
	}
}
