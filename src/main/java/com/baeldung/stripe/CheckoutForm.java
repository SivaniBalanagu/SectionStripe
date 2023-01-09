package com.baeldung.stripe;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class CheckoutForm {

	private Integer amount;

	private String featureRequest;

	@Email
	private String email;
}
