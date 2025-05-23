package com.helloIftekhar.springJwt.controller;



import com.helloIftekhar.springJwt.model.Payment;
import com.helloIftekhar.springJwt.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add_payment")

    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @PutMapping("/update_payment/{bookingId}")
    public Payment updatePayment(@PathVariable("bookingId") int bookingId,@RequestBody Payment payment){
        return  paymentService.updatePayment(bookingId,payment);
    }


    @GetMapping("/all_payments")
    public ArrayList<Payment> getAllPayements(){
        return paymentService.getAllPayements();
    }



    @DeleteMapping("delete_payment/{paymentId}")

    public void deletePayment(@PathVariable("paymentId") int paymentId){
        paymentService.deletePayment(paymentId);
    }




}



