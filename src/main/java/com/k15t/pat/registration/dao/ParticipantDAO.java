package com.k15t.pat.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k15t.pat.registration.model.ParticipantModel;

/**
 * This Data Access Object extends JPA repository to store and fetch from H2 DB
 * 
 * @author Sumanth
 */
public interface ParticipantDAO extends JpaRepository<ParticipantModel, Long> {
	/**
	 * Fetches participant by email
	 * 
	 * @param email
	 * @return ParticipantModel
	 */
	public ParticipantModel findByEmail(String email);
}
