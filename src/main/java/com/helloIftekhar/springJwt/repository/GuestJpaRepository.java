package com.helloIftekhar.springJwt.repository;


import com.helloIftekhar.springJwt.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestJpaRepository extends JpaRepository<Guest, Integer> {
}
