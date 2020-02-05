package com.k15t.pat.registraton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k15t.pat.registration.dao.ParticipantDAO;
import com.k15t.pat.registration.model.ParticipantModel;
import com.k15t.pat.registration.service.RegistrationService;

/**
 * Registration Service Impl to register participant
 * 
 * @author Sumanth
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private ParticipantDAO participantDAO;

	/**
	 * Save Participant Data
	 * 
	 * @param participant
	 * @return true/false
	 */
	@Override
	public boolean saveParticipantData(ParticipantModel participant) {
		ParticipantModel exisitingParticipant = participantDAO.findByEmail(participant.getEmail());
		if (exisitingParticipant == null) {
			participantDAO.save(participant);
			return true;
		}
		return false;
	}

}
