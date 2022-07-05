package com.nirvana.hm.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nirvana.hm.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {
	
	public Optional<Guest> findByGuestId(String id);
	public Optional<Guest> deleteByGuestId(String id);
}
