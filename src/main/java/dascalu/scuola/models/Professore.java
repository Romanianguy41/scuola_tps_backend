package dascalu.scuola.models;

import java.time.LocalDate;
import java.util.Objects;

public class Professore {
	int idProfessore;
	String nome;
	String cognome;
	String codiceFiscale;
	String luogoNascita;
	LocalDate dataNascita;
	String email;
	String numeroTelefono;
	String indirizzo;
	String cittadinanza;
	int CAP;
	int rifClasse;
	
	public Professore(int idProfessore, String nome, String cognome, String codiceFiscale, String luogoNascita,
			LocalDate dataNascita, String indirizzo, String cittadinanza, int CAP, int rifClasse, String email,
			String numeroTelefono) {
		this.idProfessore = idProfessore;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.luogoNascita = luogoNascita;
		this.dataNascita = LocalDate.from(dataNascita);
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.indirizzo = indirizzo;
		this.cittadinanza = cittadinanza;
		this.CAP = CAP;
		this.rifClasse = rifClasse;
	}
	
	public int getIdProfessore() {
		return idProfessore;
	}
	public void setIdProfessore(int idProfessore) {
		this.idProfessore = idProfessore;
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
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = LocalDate.from(dataNascita);
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
	public int getRifClasse() {
		return rifClasse;
	}
	public void setRifClasse(int rifClasse) {
		this.rifClasse = rifClasse;
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
		return Objects.hash(idProfessore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professore other = (Professore) obj;
		return idProfessore == other.idProfessore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Professore [idProfessore=");
		builder.append(idProfessore);
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
		builder.append(rifClasse);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
