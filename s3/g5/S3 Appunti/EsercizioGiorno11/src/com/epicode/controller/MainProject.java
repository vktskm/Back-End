package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.epicode.model.DbConnection;
import com.epicode.model.Student;

public class MainProject {

	public static void main(String[] args) {
		
		try {
			DbConnection db = new DbConnection();
			
			// Insert
			//Student s1 = new Student("Mario", "Rossi", 'm', LocalDate.of(2000, 10, 22), 8.0, 6.0, 10.0);
			//Student s2 = new Student("Francesca", "Neri", 'f', LocalDate.of(2003, 6, 11), 7.4, 5.5, 9.0);
			//db.insertStudent(s1);
			//db.insertStudent(s2);
			
			// GetById
			//Student s = db.getStudentdById(2);
			//System.out.println(s);
			
			// UpdateStudent
			//HashMap<String, Object> obj = new HashMap<String, Object>();
			//obj.put("name", s.getName());
			//obj.put("lastname", "Nerina");
			//obj.put("gender", s.getGender());
			//obj.put("avg", s.getAvg());
			//obj.put("birthdate", s.getBirthdate());
			//obj.put("min_vote", s.getMin_vote());
			//obj.put("max_vote", s.getMax_vote());
			
			//db.updateStudent(s.getId(), obj);
			
			// DeletedStudent
			//db.deleteStudent(2);
			
			// GetBest Avg
			//Student sAvg = db.getBest();
			//System.out.println(sAvg);
			
			// getVoteRange
			//List<Student> listaStudentiVoteRange = db.getVoteRange(5, 10);
			//listaStudentiVoteRange.forEach(e -> System.out.println(e));
			
			
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

}
