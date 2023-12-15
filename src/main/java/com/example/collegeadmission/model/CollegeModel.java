package com.example.collegeadmission.model;

public class CollegeModel {
private int admissionid;
private String courseforadmission;
private String counsellingdetails;
private int dateofadmission;
private String feesstructure;

public int getAdmissionid() {
	return admissionid;
}
public void setAdmissionid(int admissionid) {
	this.admissionid = admissionid;
}
public String getCourseforadmission() {
	return courseforadmission;
}
public void setCourseforadmission(String courseforadmission) {
	this.courseforadmission = courseforadmission;
}
public String getCounsellingdetails() {
	return counsellingdetails;
}
public void setCounsellingdetails(String counsellingdetails) {
	this.counsellingdetails = counsellingdetails;
}
public int getDateofadmission() {
	return dateofadmission;
}
public void setDateofadmission(int dateofadmission) {
	this.dateofadmission = dateofadmission;
}
public String getFeesstructure() {
	return feesstructure;
}
public void setFeesstructure(String feesstructure) {
	this.feesstructure = feesstructure;
}
@Override
public String toString() {
	return "CollegeModel [admissionid=" + admissionid + ", courseforadmission=" + courseforadmission
			+ ", counsellingdetails=" + counsellingdetails + ", dateofadmission=" + dateofadmission + ", feesstructure="
			+ feesstructure + "]";
}
public CollegeModel(int admissionid, String courseforadmission, String counsellingdetails, int dateofadmission,
		String feesstructure) {
	super();
	this.admissionid = admissionid;
	this.courseforadmission = courseforadmission;
	this.counsellingdetails = counsellingdetails;
	this.dateofadmission = dateofadmission;
	this.feesstructure = feesstructure;
}
public CollegeModel() {
	super();
	// TODO Auto-generated constructor stub
}




}












