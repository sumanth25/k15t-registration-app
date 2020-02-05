package com.k15t.pat.registration.util;

import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k15t.pat.registration.model.ParticipantModel;

/**
 * Util class which manipulates on participant fields
 * 
 * @author Sumanth
 *
 */
public class FieldsUtil {
	/**
	 * Populates field values into Map
	 * 
	 * @param p
	 * @return map
	 */
	public static Map<String, Object> populateFieldValues(ParticipantModel p) {
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Object> map = oMapper.convertValue(p, Map.class);
		return map;
	}

	/**
	 * Populates field errors into model
	 * 
	 * @param result
	 * @param model
	 * @return map
	 */
	public static Map<String, Object> populateFieldErrors(BindingResult result, Map<String, Object> model) {
		List<FieldError> fieldErrors = result.getFieldErrors();
		if (fieldErrors.size() > 0) {
			for (FieldError fieldError : fieldErrors) {
				model.put(fieldError.getField() + "Error", fieldError.getDefaultMessage());
			}
		}
		return model;
	}
}
