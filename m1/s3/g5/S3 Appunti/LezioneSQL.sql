 /* DDL – Data Definition Language */
 
 -- CREATE DATABASE dbtest; -- Crea un database di nome dbtest
 -- DROP DATABASE dbtest; -- Cancella un database di nome dbtest
 
 CREATE TABLE citta (
 	id SERIAL PRIMARY KEY, -- 1, 2, 3, 4 ...
	nome VARCHAR NOT NULL, -- 'Roma', 'Milano', 'Napoli', 'Torino' ... 
	provincia VARCHAR NOT NULL,
	regione VARCHAR NOT NULL
 );
 
 CREATE TABLE utente (
	id SERIAL,
 	nome VARCHAR NOT NULL DEFAULT '---',
	cognome VARCHAR NOT NULL DEFAULT '---',
	anni INTEGER NOT NULL,
	email VARCHAR NOT NULL UNIQUE,
	citta INTEGER NOT NULL,
	CONSTRAINT utente_PK PRIMARY KEY (id),
	CONSTRAINT utente_citta_FK FOREIGN KEY (citta) REFERENCES citta (id) 
	 -- creo un vincolo di FOREIGN KEY tra il campo citta della tabella 
	 -- utenti(la tabella in cui mi trovo) che si referenzia con la tabella 
	 -- citta sul campo univoco id
 );
 
 DROP TABLE utente; -- Cancellare una tabella
 DROP TABLE citta; -- Cancellare una tabella
 
 ALTER TABLE utente ADD cf VARCHAR NOT NULL UNIQUE; -- Modifico la struttura di una tabella senza perdere dati andando ad aggiungere una nuova proprietà
 ALTER TABLE utente DROP cf; -- Modifico la struttura di una tabella senza perdere dati andando a cancellare una proprietà esistente
 ALTER TABLE utente RENAME COLUMN cf TO codice_fiscale;  -- Modifico la struttura di una tabella senza perdere dati andando a rinominare una proprietà esistente
 ALTER TABLE utente DROP codice_fiscale;
 ALTER TABLE utente DROP CONSTRAINT utente_citta_fk; -- Modifico la struttura di una tabella senza perdere dati andando a rimuove una vincolo esistente 
 ALTER TABLE utente ADD CONSTRAINT utente_citta_fk FOREIGN KEY (citta) REFERENCES citta (id); -- Modifico la struttura di una tabella senza perdere dati andando ad aggiunger un vincolo 
 
 /* DML – Data Manipulation Language */
 
 INSERT INTO citta (nome, provincia, regione) VALUES ('Roma', 'Roma', 'Lazio');
 INSERT INTO citta (nome, provincia, regione) VALUES ('Milano', 'Milano', 'Lombardia');
 INSERT INTO citta (nome, provincia, regione) VALUES ('Rozzano', 'Milano', 'Lombardia');
 INSERT INTO citta (nome, provincia, regione) VALUES ('San Cesareo', 'Roma', 'Lazio');
 INSERT INTO citta (nome, provincia, regione) VALUES ('Pompei', 'Napoli', 'Campania');
 
 INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Mario', 'Rossi', 25, 'm.rossi@example.com', 2);
 INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Giuseppe', 'Verdi', 49, 'g.verdi@example.com', 3);
 INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Francesca', 'Neri', 37, 'f.neri@example.com', 5);
 INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Antonio', 'Bianchi', 19, 'a.bianchi@example.com', 1);
 
 DELETE FROM utente WHERE id = 3; -- Cancella una entità con id = 3
 DELETE FROM utente; -- Cancella tutti i dati nella tabella utente
 
 UPDATE utente SET citta = 4 WHERE id = 9;  -- Modifico il valore citta solo per la riga con l'id 9 nella tabella utente
 UPDATE utente SET citta = 4; -- Modifico tutti i dati del campo citta nella tabella utente
 
 /* DQL – Data Query Language */
 
 SELECT * FROM utente; -- Leggo tutti i dati presenti nella tabella utente
 SELECT * FROM citta;
 
 SELECT nome, cognome FROM utente;
 
 SELECT * FROM utente WHERE citta = 4;
 SELECT * FROM citta WHERE provincia = 'Milano';
 SELECT * FROM citta WHERE provincia = 'Milano' AND nome = 'Rozzano';
 SELECT * FROM citta WHERE regione LIKE '%mba%';
 SELECT * FROM citta WHERE regione LIKE 'L%';
 SELECT * FROM citta WHERE regione LIKE 'L_z%';
 SELECT * FROM utente WHERE email LIKE '_.%@%.com'-;
 SELECT * FROM utente WHERE anni > 30;
 
 /* INNER JOIN - LEFT JOIN - RIGHT JOIN - FULL JOIN */
 
 SELECT * FROM utente INNER JOIN citta ON utente.citta = citta.id;
 SELECT * FROM utente LEFT JOIN citta ON utente.citta = citta.id;
 SELECT * FROM utente RIGHT JOIN citta ON utente.citta = citta.id;
 SELECT * FROM utente FULL JOIN citta ON utente.citta = citta.id;
 
 SELECT * FROM utente ORDER BY anni DESC;
 SELECT DISTINCT provincia FROM citta;