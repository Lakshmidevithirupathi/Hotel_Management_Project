package com.helloIftekhar.springJwt.repository;



import com.helloIftekhar.springJwt.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment,Integer> {
}
