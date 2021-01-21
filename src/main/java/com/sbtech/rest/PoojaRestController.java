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

import com.sbtech.entities.Pooja;
import com.sbtech.service.PoojaService;


@RestController
@RequestMapping("sss/api")
public class PoojaRestController {

	@Autowired
	private PoojaService poojaService;
   
	@PostMapping("/pooja")
	public Pooja createPooja(@RequestBody Pooja thePooja) throws Exception {		
		thePooja.setId(0);
		Pooja pooja = poojaService.savePooja(thePooja);
		if (pooja != null) {
			return pooja;
		}else {
			throw new Exception("Pooja slot is not empty for given date please try again with different date.");
		}
	}
	
	@PutMapping("/pooja")
	public Pooja updatePooja(@RequestBody Pooja thePooja) {		
		return poojaService.savePooja(thePooja);
	}
	
	@GetMapping("/pooja/{poojaId}")
	public Pooja getPooja(@PathVariable int poojaId) {
		return poojaService.getPooja(poojaId);
	}
	
	@GetMapping("/pooja/Poojas")
	public List<Pooja> getPoojas() {
		return poojaService.getPoojas();
	}
	
	@DeleteMapping("/pooja/{poojaId}")
	public int deleteAarti(@PathVariable int poojaId) {
		return poojaService.deletePooja(poojaId);
	}

	
}
