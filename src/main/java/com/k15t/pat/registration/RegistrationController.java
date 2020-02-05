package com.k15t.pat.registration;

import java.io.StringWriter;
import java.util.Map;

import javax.validation.Valid;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.k15t.pat.registration.model.ParticipantModel;

/**
 * Controller to registers all requests
 * 
 * @author Sumanth
 *
 */
@RestController
public class RegistrationController {

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	private RegistrationResource registrationResource;

	/**
	 * Default velocity rendering of welcome page
	 * 
	 * @return html
	 */
	@RequestMapping("/registration.html")
	public String registration() {

		Template template = velocityEngine.getTemplate("templates/registration.vm");
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		template.merge(context, writer);

		return writer.toString();
	}

	/**
	 * Save participant details on form submission
	 * 
	 * @param p
	 * @param result
	 * @return html
	 * @throws Exception
	 */
	@RequestMapping(value = "/registration.html", method = RequestMethod.POST)
	public String registerParticipant(@Valid @ModelAttribute("participant") ParticipantModel p, BindingResult result)
			throws Exception {
		Map<String, Object> model = registrationResource.save(p, result);
		return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "registration.vm", "UTF-8", model);
	}

}
