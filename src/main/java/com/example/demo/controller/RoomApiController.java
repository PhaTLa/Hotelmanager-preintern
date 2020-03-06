package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Room;
import com.example.demo.services.RoomService;

@RestController
@RequestMapping(value="/api")
public class RoomApiController {
	public static Logger logger=LoggerFactory.getLogger(RoomApiController.class);
	
	@Autowired
	RoomService roomservice;
	
	@RequestMapping(value="/room",method=RequestMethod.GET)
	public ResponseEntity<List<Room>> getAllRoom(){
		List<Room> listRoom=roomservice.findAll();
		
		if(listRoom.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Room>>(listRoom, HttpStatus.OK);
	}
	@RequestMapping(value="/room/{id}",method=RequestMethod.GET)
	public Room getARoom(@PathVariable("id") int id) {
		Room aroom=roomservice.getOne(id);
		if(aroom==null) {
			ResponseEntity.notFound().build();
		}
		return aroom;
	}
	@RequestMapping(value="/newroom",method=RequestMethod.POST)
	public Room creatARoom(@Valid @RequestBody Room room) {
		return roomservice.save(room);
	}
	@RequestMapping(value="/editroom/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Room> updateARoom(@PathVariable("id") int roomID,
												@Valid @RequestBody Room expectRoom){
		Room target=roomservice.getOne(roomID);
		if(target==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		target.setStatus(expectRoom.getStatus());
		target.setIdprice(expectRoom.getIdprice());
		Room modifieredTarget=roomservice.save(target);
		return ResponseEntity.ok(modifieredTarget);
	}
	
	@RequestMapping(value="/deleteroom/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Room> deleteARoom(@PathVariable("id") int roomID){
		Room target=roomservice.getOne(roomID);
		if(target==null) {
			return ResponseEntity.notFound().build();
		}
		roomservice.delete(target);
		return ResponseEntity.ok().build();
	}
}
