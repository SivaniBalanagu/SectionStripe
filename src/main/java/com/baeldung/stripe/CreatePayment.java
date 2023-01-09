package com.baeldung.stripe;

import lombok.Data;

@Data
public class CreatePayment {
	private Integer amount;

	private String featureRequest;
}
