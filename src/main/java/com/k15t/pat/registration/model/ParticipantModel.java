package com.k15t.pat.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

/**
 * This Model class contains all required fields for participant registration
 * along with validation It supports below fields Full Name (required)<br>
 * Password (required)<br>
 * Address (required)<br>
 * Email (required)<br>
 * Phone number (optional)
 * 
 * @author Sumanth
 */
@Data
@Entity
public class ParticipantModel {
	@Id
	@GeneratedValue
	private long id;

	@NotNull(message = "You must enter Full Name")
	@Size(min = 1, message = "You must enter atleast 1 character")
	@Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Full Name cannot have numbers or special characters")
	private String fullName;

	@NotNull(message = "You must enter a Password")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{6,20})", message = "  #   must contain one digit from 0-9<br>"
			+ "  #   must contain one lowercase characters<br>" + "  #   must contain one uppercase characters<br>"
			+ "  #   must contains one special symbols in the list \"@#$%\"<br>"
			+ "  #   no whitespace allowed in the entire string<br>"
			+ "  #   length at least 6 characters and maximum of 20")
	private String password;

	@NotNull(message = "You must enter an Address")
	@Size(min = 5, max = 500, message = "You must enter atleast 5 characters")
	private String address;

	@NotNull(message = "You must enter an Email")
	@Size(min = 3, message = "You must fill valid email id")
	@Email(message = "Invalid email address! Please enter valid email")
	private String email;

	@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Please enter valid phone number along with country code")
	private String phone;

}
