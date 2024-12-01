package com.helloIftekhar.springJwt.controller;


import com.helloIftekhar.springJwt.model.Booking;
import com.helloIftekhar.springJwt.model.Guest;
import com.helloIftekhar.springJwt.model.Room;
import com.helloIftekhar.springJwt.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add_booking")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @GetMapping("/all_bookings")
    public ArrayList<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/rooms/{guestId}")
    public ResponseEntity<List<Room>> getRoomsByGuestId(@PathVariable int guestId) {
        List<Room> rooms = bookingService.getRoomsByGuestId(guestId);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{roomId}/guests")
    public ResponseEntity<List<Guest>> getGuestsByRoomId(@PathVariable int roomId) {
        List<Guest> guests = bookingService.getGuestsByRoomId(roomId);
        return ResponseEntity.ok(guests);
    }

    @PostMapping("/bookings")
    public String bookRoom(@RequestBody Room room){
        return  bookingService.bookRoom(room);
    }


}
