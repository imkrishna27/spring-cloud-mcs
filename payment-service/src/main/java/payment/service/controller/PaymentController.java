package payment.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    public static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping(value = "/pay/{price}")
    public String payNow(@PathVariable int price) {
        logger.info("Inside the payNow() method of Payment-Service");
        return "payment done: price is : " + price;
    }
}
