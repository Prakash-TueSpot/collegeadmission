package com.example.collegeadmission.service;

import java.util.List;

import com.example.collegeadmission.model.CollegeModel;


public interface CollegeService {
	public String savecollege(CollegeModel collmod);
	public String updatecollege(CollegeModel coll);
	 public  List <CollegeModel> getuser();
	 public  String deleteuser(Integer Id);//Using single data for delete

}
