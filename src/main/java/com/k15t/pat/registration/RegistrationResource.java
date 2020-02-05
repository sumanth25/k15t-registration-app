package com.k15t.pat.registration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.k15t.pat.registration.model.ParticipantModel;
import com.k15t.pat.registration.service.RegistrationService;
import com.k15t.pat.registration.util.FieldsUtil;
import com.k15t.pat.registraton.constants.RegistrationConstants;

/**
 * Business Logic to call registration service
 * 
 * @author Sumanth
 *
 */
@Service
public class RegistrationResource {

	@Autowired
	private RegistrationService regService;

	// Extend the current resource to receive and store the data in memory.
	// Return a success information to the user including the entered information.
	// In case of the address split the information into a better format/structure
	// for better handling later on.
	/**
	 * Save participant
	 * 
	 * @param p
	 * @param result
	 * @return model
	 */
	public Map<String, Object> save(ParticipantModel p, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		// copy participant details into model
		model = FieldsUtil.populateFieldValues(p);
		if (result.hasFieldErrors()) {
			// fill error messages into model
			model = FieldsUtil.populateFieldErrors(result, model);
		} else if (regService.saveParticipantData(p)) {
			// display success message along with entered information
			model.put(RegistrationConstants.SUCCESS, RegistrationConstants.SUCCESS_MESSAGE);
			model.put(RegistrationConstants.REGISTRATION_DETAILS, p);
		} else {
			// notify if already participant has registered
			model.put(RegistrationConstants.NOTIFY, RegistrationConstants.NOTIFY_MESSAGE);
		}
		return model;
	}

}
