package com.nirvana.hm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirvana.hm.dao.GuestRepository;
import com.nirvana.hm.entity.Guest;

@Service
@Transactional
public class GuestService {
	@Autowired
	private GuestRepository guestRepository;
	
	public GuestService(GuestRepository guestRepo) {
		this.guestRepository = guestRepo;
	}
	
	public List<Guest> findAllGuests() {
		List<Guest> guests = new ArrayList<>();
		for (Guest guest : guestRepository.findAll()) {
			guests.add(guest);
		}
		return guests;
	}
	
	public Optional<Guest> findGuest(int id){
		return guestRepository.findById(id);
	}
	
	public void saveGues(Guest guest){
		guestRepository.save(guest);
	}
	
	public void deleteGues(int id){
		guestRepository.deleteById(id);
	}
}

