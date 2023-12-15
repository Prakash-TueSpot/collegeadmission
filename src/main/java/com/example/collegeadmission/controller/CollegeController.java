package com.example.collegeadmission.controller;

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

import com.example.collegeadmission.model.CollegeModel;
import com.example.collegeadmission.service.CollegeService;

@RestController
@RequestMapping("/api/v9/college")
public class CollegeController {
	@Autowired
	private CollegeService collserv;

//Post Method
	@PostMapping("/")
	private String savecollege(@RequestBody CollegeModel collmod) {
		System.out.println(collmod.toString());
		return collserv.savecollege(collmod);
	}

//Put Mapping
	@PutMapping("/")
	private String updatecollege(@RequestBody CollegeModel coll) {
		System.out.println(coll.toString());
		return collserv.updatecollege(coll);
	}

//Get Mapping
	@GetMapping("/")
	List<CollegeModel> getCollegeModel() {

		return collserv.getuser();
	}

	@GetMapping("/{id}")
	public void getuser(@PathVariable("id") Integer Id) {
		System.out.println("get By id" + Id);
	}

	@DeleteMapping("/{id}")
	public void deleteuser(@PathVariable("id") Integer Id) {
		System.out.println("delete By id" + Id);
		this.collserv.deleteuser(Id);

	}
}
