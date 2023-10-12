package com.epicode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "jdbctest";
	String user = "postgres";
	String pass = "root";
	Statement st;
	
	public DbConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url+dbName, user, pass); // Configura una connessione con il DB passandogli come paramentro il path del DB la username e la password di accesso
		st = conn.createStatement(); // un flusso di dati che mi permette di comunicare con il DB
		createTableUtenti();
		System.out.println("DB Connect!!!");
	}
	
	public void createTableUtenti() throws SQLException {
		String sql =  " CREATE TABLE IF NOT EXISTS utenti ("
					+ "		id SERIAL PRIMARY KEY,"
					+ " 	nome VARCHAR NOT NULL,"
					+ "		cognome VARCHAR NOT NULL,"
					+ "		anni INTEGER NOT NULL,"
					+ "		email VARCHAR NOT NULL UNIQUE"
					+ " );" ;
		st.executeUpdate(sql);
		System.out.println("Table utenti created!!!");
	}
	
	
	public void inserisciUtente(Utente u) throws SQLException {
		String sql = " INSERT INTO utenti (nome, cognome, anni, email) "
				   + "VALUES ('"+u.getNome()+"', '"+u.getCognome()+"', "
				   + u.getAnni()+", '"+u.getEmail()+"');";
		st.executeUpdate(sql);
		System.out.println(u.getNome() + " " + u.getCognome() + " created!!!");
	}
	
	public void modificaUtente(Utente u) throws SQLException {
		String sql = "UPDATE utenti SET "
				   + " nome = '" + u.getNome() + "', "
				   + " cognome = '" + u.getCognome() + "', "
				   + " anni = " + u.getAnni() + ", "
				   + " email = '" + u.getEmail() + "' "
				   + " WHERE id = " + u.getId();
		st.executeUpdate(sql);
		System.out.println(u.getNome() + " " + u.getCognome() + " udpate!!!");
	}
	
	public void cancellaUtente(Utente u) throws SQLException {
		String sql = "DELETE FROM utenti WHERE id = " + u.getId();
		st.executeUpdate(sql);
		System.out.println(u.getNome() + " " + u.getCognome() + " deleted!!!");
	}
	
	public List<Utente> leggiUtenti() throws SQLException {
		String sql = "SELECT * FROM utenti";
		ResultSet rs = st.executeQuery(sql); // Eseguo la query di ricerca e mi salvo il risultato in un ogg di tipo ResultSet
		List<Utente> listaUtenti = new ArrayList<Utente>();
		while (rs.next()) {
			int utenteId = rs.getInt("id"); // leggo il valore nella colonna id della riga che leggo dal DB 
			String nome = rs.getString("nome"); // leggo il valore nella colonna nome della riga che leggo dal DB 
			String cognome = rs.getString("cognome"); // leggo il valore nella colonna cognome della riga che leggo dal DB 
			int anni = rs.getInt("anni"); // leggo il valore nella colonna anni della riga che leggo dal DB 
			String email = rs.getString("email"); // leggo il valore nella colonna email della riga che leggo dal DB 
			Utente u = new Utente(utenteId, nome, cognome, anni, email); // Creo un ogg di tipo Utente con tutti i valori letti dal DB	
			listaUtenti.add(u); // aggiungo un ogg di tipo utente letto dal DB in una lista
		}
		return listaUtenti;
	}
	
	public Utente leggiDettaglioUtente(int id) throws SQLException {
		String sql = "SELECT * FROM utenti WHERE id = " + id;
		ResultSet rs = st.executeQuery(sql); // Eseguo la query di ricerca e mi salvo il risultato in un ogg di tipo ResultSet
		Utente u = null;
		// Controllo se è presente un valore nel ResultSet che mi retituisce il db
		// ciò che può contenere il ResultSet è null oppure un ogg Utente
		if(rs.next()) {
			int utenteId = rs.getInt("id"); // leggo il valore nella colonna id della riga che leggo dal DB 
			String nome = rs.getString("nome"); // leggo il valore nella colonna nome della riga che leggo dal DB 
			String cognome = rs.getString("cognome"); // leggo il valore nella colonna cognome della riga che leggo dal DB 
			int anni = rs.getInt("anni"); // leggo il valore nella colonna anni della riga che leggo dal DB 
			String email = rs.getString("email"); // leggo il valore nella colonna email della riga che leggo dal DB 
			u = new Utente(utenteId, nome, cognome, anni, email); // Creo un ogg di tipo Utente con tutti i valori letti dal DB	
		}
		return u;
	}
	

}
