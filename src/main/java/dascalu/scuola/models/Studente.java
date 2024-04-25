package dascalu.scuola.models;

import java.sql.Date;
import java.util.Objects;

public class Studente {
	int idStudente;
	String nome;
	String cognome;
	String codiceFiscale;
	String luogoNascita;
	Date dataNascita;
	String email;
	String numeroTelefono;
	String indirizzo;
	String cittadinanza;
	int CAP;
	Classe classe;

	
	public Studente(int idStudente, String nome, String cognome, String codiceFiscale, String luogoNascita,
			Date dataNascita, String indirizzo, String cittadinanza, int CAP, String email,
			String numeroTelefono, Classe classe) {
		this.idStudente = idStudente;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.indirizzo = indirizzo;
		this.cittadinanza = cittadinanza;
		this.CAP = CAP;
		this.classe = classe;
	}
	
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCittadinanza() {
		return cittadinanza;
	}
	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}
	public int getCAP() {
		return CAP;
	}
	public void setCAP(int CAP) {
		this.CAP = CAP;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStudente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return idStudente == other.idStudente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Studente [idStudente=");
		builder.append(idStudente);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", codiceFiscale=");
		builder.append(codiceFiscale);
		builder.append(", luogoNascita=");
		builder.append(luogoNascita);
		builder.append(", dataNascita=");
		builder.append(dataNascita);
		builder.append(", email=");
		builder.append(email);
		builder.append(", numeroTelefono=");
		builder.append(numeroTelefono);
		builder.append(", indirizzo=");
		builder.append(indirizzo);
		builder.append(", cittadinanza=");
		builder.append(cittadinanza);
		builder.append(", CAP=");
		builder.append(CAP);
		builder.append(", rifClasse=");
		builder.append(classe);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
