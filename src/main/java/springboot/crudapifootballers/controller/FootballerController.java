package springboot.crudapifootballers.controller;

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

import springboot.crudapifootballers.model.Footballer;
import springboot.crudapifootballers.service.FootballerService;

@RestController
@RequestMapping("/api")
public class FootballerController {
	@Autowired
	private FootballerService footballerService;
	
	@GetMapping("/footballers")
	public List<Footballer> getAllFootballers(){
		return footballerService.getAllFootballers();
	}
	
	@PostMapping("/footballers")
	public Footballer saveFootballer(@RequestBody Footballer footballer) {
		footballerService.saveFootballer(footballer);
		return footballer;
	}
	
	@GetMapping("/footballers/{id}")
	public Footballer getFootballer(@PathVariable int id) {	
		Footballer footballer=footballerService.getFootballer(id);
		if(footballer==null) {
			throw new RuntimeException("Footballer with id "+id+" is not found");
		}
		return footballer;
		
		
	}
	
	@DeleteMapping("/footballers/{id}")
	public String deleteFootballer(@PathVariable int id) {
		Footballer footballer=footballerService.getFootballer(id);
		if(footballer==null) {
			throw new RuntimeException("Footballer with id "+id+" cannot be deleted because it doesn't exist in the database");
		}
		footballerService.deleteFootballer(id);
		return "Footballer with id "+id+" is deleted";	
	}
	
	
	@PutMapping("/footballers")
	public Footballer updateFootballer(@RequestBody Footballer footballer) {
		footballerService.saveFootballer(footballer);
		return footballer;
		
	}
	
	
}
