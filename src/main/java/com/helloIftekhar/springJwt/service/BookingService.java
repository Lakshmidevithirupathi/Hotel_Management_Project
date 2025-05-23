package com.helloIftekhar.springJwt.service;


import com.helloIftekhar.springJwt.exception.RoomNotFoundException;
import com.helloIftekhar.springJwt.model.Booking;
import com.helloIftekhar.springJwt.model.Guest;
import com.helloIftekhar.springJwt.model.Room;
import com.helloIftekhar.springJwt.repository.BookingJpaRepository;
import com.helloIftekhar.springJwt.repository.BookingRepository;
import com.helloIftekhar.springJwt.repository.GuestJpaRepository;
import com.helloIftekhar.springJwt.repository.RoomJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements BookingRepository {


    @Autowired
    private BookingJpaRepository bookingJpaRepository;

    @Autowired
    private GuestJpaRepository guestJpaRepository;

    @Autowired
    private RoomJpaRepository roomJpaRepository;

    @Override
    public Booking createBooking(Booking booking) {
        // Validate guest and room existence
        bookingJpaRepository.save(booking);
        return booking;
    }

    @Override
    public ArrayList<Booking> getAllBookings(){
        List<Booking> bookingList=bookingJpaRepository.findAll();
        ArrayList<Booking> bookings=new ArrayList<>(bookingList);

        return bookings;

    }

    @Override
    public List<Room> getRoomsByGuestId(int guestId) {
        return bookingJpaRepository.findRoomsByGuestId(guestId);
    }

    @Override
    public List<Guest> getGuestsByRoomId(int roomId) {
        return bookingJpaRepository.findGuestsByRoomId(roomId);
    }





    @Override
    public String bookRoom(Room room) {
        Room newRoom = roomJpaRepository.findById(room.getRoomId()).orElseThrow(() -> new RoomNotFoundException("Room not found"));


        if (!newRoom.getAvailable()) {
            return "Room is not available";
        }

        Booking booking = new Booking();
        booking.setCheckInDate(booking.getCheckInDate());
        booking.setCheckOutDate(booking.getCheckOutDate());
        booking.setBookingDate(booking.getBookingDate());
        booking.setStatus(booking.getStatus());
        booking.setTotalAmount(booking.getTotalAmount());
        room.setAvailable(false);
        roomJpaRepository.save(room);
        booking.setRoom(room);

        bookingJpaRepository.save(booking);
        return "Room booked successfully";

    }

}
