package com.sbtech.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbtech.entities.Aarti;
import com.sbtech.service.AartiService;


@RestController
@RequestMapping("sss/api")
public class AartiRestController {
	
	@Autowired
	private AartiService aartiService;
   
	@PostMapping("/aarti")
	public Aarti createAarti(@RequestBody Aarti theAarti) {		
		theAarti.setId(0);
		return aartiService.saveAarti(theAarti);
	}
	
	@PutMapping("/aarti")
	public Aarti updateAarti(@RequestBody Aarti theAarti) {		
		return aartiService.saveAarti(theAarti);
	}
	
	@GetMapping("/aarti/{aartiId}")
	public Aarti getAarti(@PathVariable int aartiId) {
		return aartiService.getAarti(aartiId);
	}
	
	@GetMapping("/aarti/aarties")
	public List<Aarti> getAartis() {
		return aartiService.getAarties();
	}
	
	@DeleteMapping("/aarti/{aartiId}")
	public int deleteAarti(@PathVariable int aartiId) {
		return aartiService.deleteAarti(aartiId);
	}
	
}
