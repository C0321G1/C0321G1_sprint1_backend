package c0321g1_gaming.controller.paypal;

import c0321g1_gaming.config_paypal.PaypalPaymentIntent;
import c0321g1_gaming.config_paypal.PaypalPaymentMethod;
import c0321g1_gaming.model.entity.paypal_link.PayPalLink;
import c0321g1_gaming.model.service.paypal.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Huynh Code

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("")
public class PayPalRestController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private PaypalService paypalService;
    private final String URL_PAYPAL_SUCCESS = "http://localhost:4200/order/payment-success";
    private final String URL_PAYPAL_CANCEL = "http://localhost:4200/order/payment-cancel";

    @GetMapping("/pay")
    public ResponseEntity<PayPalLink> pay(@RequestParam("price") double price) {
        String cancelUrl = this.URL_PAYPAL_CANCEL;
        String successUrl = this.URL_PAYPAL_SUCCESS;
        try {
            Payment payment = paypalService.createPayment(
                    price,
                    "USD",
                    PaypalPaymentMethod.PAYPAL,
                    PaypalPaymentIntent.SALE,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return ResponseEntity.ok(new PayPalLink(links.getHref()));
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(new PayPalLink(""), HttpStatus.OK);
    }

}
