package com.k15t.pat.registration.service;

import com.k15t.pat.registration.model.ParticipantModel;

/**
 * Registration Service to register participant
 * 
 * @author Sumanth
 *
 */
public interface RegistrationService {

	/**
	 * Save Participant Data
	 * 
	 * @param participant
	 * @return true/false
	 */
	public boolean saveParticipantData(ParticipantModel participant);
}
