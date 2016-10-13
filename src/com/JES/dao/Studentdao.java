package com.JES.dao;



import java.util.List;

import com.JES.model.Student;

public interface Studentdao {
	public List<Student> searchStudent(String type,String value);
}
