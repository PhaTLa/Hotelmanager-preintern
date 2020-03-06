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

import com.example.demo.model.Price;
import com.example.demo.services.PriceService;



@RestController
@RequestMapping(value="/api")
public class PriceApiController {
	@Autowired
	PriceService priceservice;
	
	@RequestMapping(value="/price", method=RequestMethod.GET)
	public ResponseEntity<List<Price>> getAllPrice(){
		List<Price> listprice=priceservice.findAll();
		if(listprice.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Price>>(listprice,HttpStatus.OK);
	}
	@RequestMapping(value="/price/{id}",method=RequestMethod.GET)
	public Price getAPrice(@PathVariable("id") int priceid) {
		Price aprice=priceservice.getOne(priceid);
		if(aprice==null) {
			ResponseEntity.notFound().build();
		}
		return aprice;
	}
	@RequestMapping(value="/price",method=RequestMethod.POST)
	public Price newPrice(@Valid @RequestBody Price anewprice) {
		return priceservice.save(anewprice);
	}
	@RequestMapping(value="/price/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Price> updatePrice(@PathVariable("id") int idprice,@Valid @RequestBody Price newone) {
		Price target=priceservice.getOne(idprice);
		if(target==null) {
			ResponseEntity.notFound().build();
		}
		target.setPerD(newone.getPerD());
		target.setPerH(newone.getPerH());
		target.setDes(newone.getDes());
		target.setIdType(newone.getIdType());
		
		Price modifiedprice=priceservice.save(target);
		return ResponseEntity.ok(modifiedprice);
	}
	@RequestMapping(value="/price/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Price> deletePrice(@PathVariable("id") int idprice){
		Price target=priceservice.getOne(idprice);
		if(target==null) {
			ResponseEntity.notFound().build();
		}
		priceservice.delete(target);
		return ResponseEntity.ok().build();
	}
}
