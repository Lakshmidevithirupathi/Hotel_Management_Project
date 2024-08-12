package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Guest;

import java.util.ArrayList;

public interface GuestRepository {

    Guest addGuest(Guest guest);

    ArrayList<Guest> getAllGuests();

    Guest getGuestById(int guestId);

    Guest updateGuest(int guestId,Guest guest);

    void deleteGuest(int guestId);

}

