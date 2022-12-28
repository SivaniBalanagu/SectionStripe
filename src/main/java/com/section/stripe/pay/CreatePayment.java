package com.section.stripe.pay;

import lombok.Data;

@Data
public class CreatePayment {

	private Integer amount;

	private String featureRequest;
}
