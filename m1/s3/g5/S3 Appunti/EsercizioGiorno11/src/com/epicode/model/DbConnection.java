package com.epicode.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "jdbcschool";
	String user = "postgres";
	String pass = "root";
	Statement st;
	
	public DbConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url+dbName, user, pass); // Configura una connessione con il DB passandogli come paramentro il path del DB la username e la password di accesso
		st = conn.createStatement(); // un flusso di dati che mi permette di comunicare con il DB
		createTableSchoolStudents();
		System.out.println("DB Connect!!!");
	}
	
	public void createTableSchoolStudents() throws SQLException {
		// id, name, lastname, gender (m/f), birthdate, avg, min_vote, max_vote
		String sql =  " CREATE TABLE IF NOT EXISTS school_students ("
					+ "		id SERIAL PRIMARY KEY,"
					+ " 	name VARCHAR NOT NULL,"
					+ "		lastname VARCHAR NOT NULL,"
					+ "		gender CHAR NOT NULL,"
					+ "		birthdate DATE NOT NULL,"
					+ "		avg DECIMAL,"
					+ "		min_vote DECIMAL,"
					+ "		max_vote DECIMAL"
					+ " );" ;
		st.executeUpdate(sql);
		System.out.println("Table school_students created!!!");
	}
	
	// -   insertStudent(Student s)  -> inserisce un nuovo studente (valori a piacere)
	public void insertStudent(Student s) throws SQLException {
		String sql = " INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote) "
				   + "VALUES ('"+s.getName()+"', '"+s.getLastname()+"', '"
				   + s.getGender()+"', '"+s.getBirthdate()+"', " + s.getAvg() + ", " + s.getMin_vote() + ", " + s.getMax_vote() + ");";
		st.executeUpdate(sql);
		System.out.println(s.getName() + " " + s.getLastname() + " created!!!");
	}
	
	// - getStudentdById(int id)
	public Student getStudentdById(long id) throws SQLException {
	String sql = "SELECT * FROM school_students WHERE id = " + id;
	ResultSet rs = st.executeQuery(sql); // Eseguo la query di ricerca e mi salvo il risultato in un ogg di tipo ResultSet
	Student s = null;
	// Controllo se è presente un valore nel ResultSet che mi retituisce il db
	// ciò che può contenere il ResultSet è null oppure un ogg Utente
	if(rs.next()) {
		Long studentId = rs.getLong("id");
		String name = rs.getString("name");
		String lastname = rs.getString("lastname");
		Character gender = rs.getString("gender").charAt(0);
		LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
		Double avg = rs.getDouble("avg");
		Double min_vote = rs.getDouble("min_vote");
		Double max_vote = rs.getDouble("max_vote");
		s = new Student(studentId, name, lastname, gender, birthdate, avg, min_vote, max_vote);
	}
	return s;
}
	
	
//	updateStudent(int id, HashMap<String, Object> s) -> modifica i campi dello studente con id «id» indicati da «s» 

	public void updateStudent(long id, HashMap<String, Object> s) throws SQLException {
		String sql = "UPDATE school_students SET "
				   + " name = '" + s.get("name").toString() + "', "
				   + " lastname = '" + s.get("lastname").toString() + "', "
				   + " gender = '" + s.get("gender").toString() + "', "
				   + " birthdate = '" + s.get("birthdate") + "', "
				   + " avg = " + s.get("avg") + ", "
				   + " min_vote = " + s.get("min_vote") + ", "
				   + " max_vote = " + s.get("max_vote")
				   + " WHERE id = " + id;
		st.executeUpdate(sql);
		System.out.println(s.get("name") + " " + s.get("lastname") + " modified!!!");
	}
	
	// deleteStudent(int id)
	public void deleteStudent(long id) throws SQLException {
		String sql = "DELETE FROM school_students WHERE id = " + id;
		st.executeUpdate(sql);
		System.out.println("Student deleted!!!");
	}

	
	//getBest() -> restituisce lo studente con la media voto più alta
	public Student getBest() throws SQLException {
		//String sql = "SELECT * FROM school_students ORDER BY avg DESC";
		// SELECT MAX(avg) FROM school_students
		String sql = "SELECT * FROM school_students WHERE avg = (SELECT MAX(avg) FROM school_students)";
		ResultSet rs = st.executeQuery(sql);
		Student s = null;
		if(rs.next()) {
			Long studentId = rs.getLong("id");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			Character gender = rs.getString("gender").charAt(0);
			LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
			Double avg = rs.getDouble("avg");
			Double min_vote = rs.getDouble("min_vote");
			Double max_vote = rs.getDouble("max_vote");
			s = new Student(studentId, name, lastname, gender, birthdate, avg, min_vote, max_vote);
		}
		return s;
	}

	//getVoteRange(int min, int max) -> restituisce la lista di studenti 
	//che hanno voto minimo (minVote) >= min e voto massimo (maxVote) <= max. 
	//Stampa la lista con tutti i dati relativi allo studente. 
	public List<Student> getVoteRange(int min, int max) throws SQLException {
		String sql = "SELECT * FROM school_students WHERE min_vote >= " + min + " AND max_vote <= " + max;
		ResultSet rs = st.executeQuery(sql);
		List<Student> listaStudenti = new ArrayList<Student>();
		while(rs.next()) {
			Long studentId = rs.getLong("id");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			Character gender = rs.getString("gender").charAt(0);
			LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
			Double avg = rs.getDouble("avg");
			Double min_vote = rs.getDouble("min_vote");
			Double max_vote = rs.getDouble("max_vote");
			listaStudenti.add(new Student(studentId, name, lastname, gender, birthdate, avg, min_vote, max_vote));
		}
		return listaStudenti;
	}
	
	
//	
//	public List<Utente> leggiUtenti() throws SQLException {
//		String sql = "SELECT * FROM utenti";
//		ResultSet rs = st.executeQuery(sql); // Eseguo la query di ricerca e mi salvo il risultato in un ogg di tipo ResultSet
//		List<Utente> listaUtenti = new ArrayList<Utente>();
//		while (rs.next()) {
//			int utenteId = rs.getInt("id"); // leggo il valore nella colonna id della riga che leggo dal DB 
//			String nome = rs.getString("nome"); // leggo il valore nella colonna nome della riga che leggo dal DB 
//			String cognome = rs.getString("cognome"); // leggo il valore nella colonna cognome della riga che leggo dal DB 
//			int anni = rs.getInt("anni"); // leggo il valore nella colonna anni della riga che leggo dal DB 
//			String email = rs.getString("email"); // leggo il valore nella colonna email della riga che leggo dal DB 
//			Utente u = new Utente(utenteId, nome, cognome, anni, email); // Creo un ogg di tipo Utente con tutti i valori letti dal DB	
//			listaUtenti.add(u); // aggiungo un ogg di tipo utente letto dal DB in una lista
//		}
//		return listaUtenti;
//	}
//	
//	public Utente leggiDettaglioUtente(int id) throws SQLException {
//		String sql = "SELECT * FROM utenti WHERE id = " + id;
//		ResultSet rs = st.executeQuery(sql); // Eseguo la query di ricerca e mi salvo il risultato in un ogg di tipo ResultSet
//		Utente u = null;
//		// Controllo se è presente un valore nel ResultSet che mi retituisce il db
//		// ciò che può contenere il ResultSet è null oppure un ogg Utente
//		if(rs.next()) {
//			int utenteId = rs.getInt("id"); // leggo il valore nella colonna id della riga che leggo dal DB 
//			String nome = rs.getString("nome"); // leggo il valore nella colonna nome della riga che leggo dal DB 
//			String cognome = rs.getString("cognome"); // leggo il valore nella colonna cognome della riga che leggo dal DB 
//			int anni = rs.getInt("anni"); // leggo il valore nella colonna anni della riga che leggo dal DB 
//			String email = rs.getString("email"); // leggo il valore nella colonna email della riga che leggo dal DB 
//			u = new Utente(utenteId, nome, cognome, anni, email); // Creo un ogg di tipo Utente con tutti i valori letti dal DB	
//		}
//		return u;
//	}
	

}
