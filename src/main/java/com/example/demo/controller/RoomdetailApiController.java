package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Roomdetail;
import com.example.demo.services.RoomdetailService;

@RestController
@RequestMapping(value="/api")
public class RoomdetailApiController {
	@Autowired
	RoomdetailService roomdetailService;
	
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public ResponseEntity<List<Roomdetail>> getAll(){
		List<Roomdetail> listBooking=roomdetailService.getAllRoomDetail();
		if(listBooking.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Roomdetail>>(listBooking, HttpStatus.OK);
	}
	@RequestMapping(value="/booking/{id}")
	public Roomdetail getA(@PathVariable("id") int id) {
		Roomdetail booking=roomdetailService.getARoomDetail(id);
		if(booking==null) {
			ResponseEntity.notFound().build();
		}
		return booking;
	}
}
