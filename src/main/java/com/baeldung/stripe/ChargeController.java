package com.baeldung.stripe;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stripe.exception.StripeException;

import lombok.extern.java.Log;

@Log
@Controller
public class ChargeController {

	@Autowired
	StripeService paymentsService;

	@Value("${STRIPE_PUBLIC_KEY}")
	String stripePublicKey;

	@PostMapping("/charge")
//    public String charge(CheckoutForm chargeRequest, Model model) throws StripeException {
//        chargeRequest.setDescription("Example charge");
//        chargeRequest.setCurrency(Currency.EUR);
//        Charge charge = paymentsService.charge(chargeRequest);
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
	public String charge(@ModelAttribute @Valid CheckoutForm checkoutForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "checkout";
		}

		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("amount", checkoutForm.getAmount());
		model.addAttribute("email", checkoutForm.getEmail());
		model.addAttribute("featureRequest", checkoutForm.getFeatureRequest());
		return "result";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}

//	public CreatePaymentResponse createPaymentIntent(@RequestBody @Valid CreatePayment createPayment)
//			throws StripeException {
//		PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder().setCurrency("inr")
//				.putMetadata("featureRequest", createPayment.getFeatureRequest())
//				.setAmount(createPayment.getAmount() * 100L).build();
//
//		PaymentIntent intent = PaymentIntent.create(createParams);
//		return new CreatePaymentResponse(intent.getClientSecret());
}
