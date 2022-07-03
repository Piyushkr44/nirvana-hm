package com.nirvana.hm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nirvana.hm.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {

}
