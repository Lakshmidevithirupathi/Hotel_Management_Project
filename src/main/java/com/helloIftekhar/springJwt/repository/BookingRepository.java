package com.helloIftekhar.springJwt.repository;



//import java.time.LocalDate;
import com.helloIftekhar.springJwt.model.Booking;
import com.helloIftekhar.springJwt.model.Guest;
import com.helloIftekhar.springJwt.model.Room;

import java.util.ArrayList;
import java.util.List;

public interface BookingRepository {
    Booking createBooking(Booking booking);

    ArrayList<Booking> getAllBookings();

    List<Room> getRoomsByGuestId(int guestId);

    List<Guest> getGuestsByRoomId(int roomId);

//    String bookRoom(Booking booking);

    String bookRoom(Room room);

}
