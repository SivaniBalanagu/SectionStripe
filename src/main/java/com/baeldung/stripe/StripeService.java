package com.baeldung.stripe;

import org.springframework.stereotype.Service;

@Service
public class StripeService {

//    @Value("${STRIPE_SECRET_KEY}")
//    String secretKey;
//
//    @PostConstruct
//    public void init() {
//        Stripe.apiKey = secretKey;
//    }
//
//    public Charge charge(ChargeRequest chargeRequest)
//            throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
//        Map<String, Object> chargeParams = new HashMap<>();
//        chargeParams.put("amount", chargeRequest.getAmount());
//        chargeParams.put("currency", chargeRequest.getCurrency());
//        chargeParams.put("description", chargeRequest.getDescription());
//        chargeParams.put("source", chargeRequest.getStripeToken());
//        return Charge.create(chargeParams);
//    }
}
