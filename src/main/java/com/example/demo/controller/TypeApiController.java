package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Type;
import com.example.demo.services.TypeService;

@RestController
@RequestMapping(value="/api")
public class TypeApiController {
	
	@Autowired
	TypeService typeservice;
	
	@RequestMapping(value="/type", method=RequestMethod.GET)
	public ResponseEntity<List<Type>> getAllType(){
		List<Type> listtype=typeservice.findAll();
		if(listtype.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Type>>(listtype,HttpStatus.OK);
	}
	@RequestMapping(value="/type/{id}",method=RequestMethod.GET)
	public Type getAType(@PathVariable("id") int typeid) {
		Type atype=typeservice.getOne(typeid);
		if(atype==null) {
			ResponseEntity.notFound().build();
		}
		return atype;
	}
	@RequestMapping(value="/type",method=RequestMethod.POST)
	public Type newType(@Valid @RequestBody Type anewtype) {
		return typeservice.save(anewtype);
	}
	@RequestMapping(value="/type/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Type> updateType(@PathVariable("id") int idtarget,@Valid @RequestBody Type newone) {
		Type target=typeservice.getOne(idtarget);
		if(target==null) {
			ResponseEntity.notFound().build();
		}
		target.setRoomType(newone.getRoomType());
		target.setDes(newone.getDes());
		
		Type modifiedType=typeservice.save(target);
		return ResponseEntity.ok(modifiedType);
	}
	@RequestMapping(value="/type/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Type> deleteType(@PathVariable("id") int idtarget){
		Type target=typeservice.getOne(idtarget);
		if(target==null) {
			ResponseEntity.notFound().build();
		}
		typeservice.delete(target);
		return ResponseEntity.ok().build();
	}
}
