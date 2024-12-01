package com.helloIftekhar.springJwt.service;



import com.helloIftekhar.springJwt.model.Booking;
import com.helloIftekhar.springJwt.model.Payment;
import com.helloIftekhar.springJwt.repository.BookingJpaRepository;
import com.helloIftekhar.springJwt.repository.PaymentJpaRepository;
import com.helloIftekhar.springJwt.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService implements PaymentRepository {

        @Autowired
        private PaymentJpaRepository paymentJpaRepository;


        @Autowired
        private BookingJpaRepository bookingJpaRepository;

        @Override
        public Payment addPayment (Payment payment){

            return paymentJpaRepository.save(payment);

        }

        @Override

        public Payment updatePayment ( int bookingId, Payment payment){
            Booking booking = bookingJpaRepository.findAll().get(bookingId);
            System.out.println(booking.getTotalAmount());

            return payment;
        }

        @Override
        public ArrayList<Payment> getAllPayements () {
            List<Payment> paymentList = paymentJpaRepository.findAll();
            ArrayList<Payment> payments = new ArrayList<>(paymentList);
            return payments;
        }

        @Override
        public void deletePayment ( int paymentId){
            try {
                paymentJpaRepository.deleteById(paymentId);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
