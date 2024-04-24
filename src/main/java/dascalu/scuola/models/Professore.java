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
	String indirizzo;
	String cittadinanza;
	int CAP;
	int rifClasse;
	
	public Professore(int idProfessore, String nome, String cognome, String codiceFiscale, String luogoNascita,
			LocalDate dataNascita, String indirizzo, String cittadinanza, int CAP, int rifClasse) {
		this.idProfessore = idProfessore;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.luogoNascita = luogoNascita;
		this.dataNascita = LocalDate.from(dataNascita);
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

	@Override
	public int hashCode() {
		return Objects.hash(CAP, cittadinanza, codiceFiscale, cognome, dataNascita, idProfessore, indirizzo,
				luogoNascita, nome, rifClasse);
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
		return CAP == other.CAP && Objects.equals(cittadinanza, other.cittadinanza)
				&& Objects.equals(codiceFiscale, other.codiceFiscale) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataNascita, other.dataNascita) && idProfessore == other.idProfessore
				&& Objects.equals(indirizzo, other.indirizzo) && Objects.equals(luogoNascita, other.luogoNascita)
				&& Objects.equals(nome, other.nome) && rifClasse == other.rifClasse;
	}

	@Override
	public String toString() {
		return "Professore [idProfessore=" + idProfessore + ", nome=" + nome + ", cognome=" + cognome
				+ ", codiceFiscale=" + codiceFiscale + ", luogoNascita=" + luogoNascita + ", dataNascita=" + dataNascita
				+ ", indirizzo=" + indirizzo + ", cittadinanza=" + cittadinanza + ", CAP=" + CAP + ", rifClasse="
				+ rifClasse + "]";
	}

	
	
}
