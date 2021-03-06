package com.nirvana.hm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservationId")
	private int reservationId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="checkInDate")
	private Date checkInDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="checkOutDate")
	private Date checkOutDate;
	
	@Column(name="roomNumber")
	private int roomNumber;
	
	/*@ManyToOne
	private Guest guest;*/
	@Column(name="guestId")
	private String guestId;

	public Reservation() {
		
	}

	public Reservation(int reservationId, Date checkInDate, Date checkOutDate, int roomNumber, String guestGuestId) {
		super();
		this.reservationId = reservationId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomNumber = roomNumber;
		this.guestId = guestGuestId;
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

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}


	/*public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}*/
	
	
	
}
