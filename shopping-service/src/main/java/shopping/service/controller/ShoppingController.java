package shopping.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shopping")
@RefreshScope
public class ShoppingController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${payment.service.url}")
    private String url;

    public static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);

    @GetMapping(value = "/invoke-payment-service/{price}")
    public String invokePaymentService(@PathVariable int price) {
        // traditional way
        // String url = "http://localhost:9990/payment/pay/"+price;

        // eureka way
        logger.info("inside invokePaymentService() method of Payment-Service");
        String finalUrl = this.url + price;
        return restTemplate.getForObject(finalUrl,String.class);
    }
}
