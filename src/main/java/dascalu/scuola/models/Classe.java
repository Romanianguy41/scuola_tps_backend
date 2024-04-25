package dascalu.scuola.models;

import java.util.ArrayList;
import java.util.Objects;

public class Classe {
	int idClasse;
	int classe;
	String sezione;
	ArrayList <ProfessoreMateria> docenti;
	
	
	public Classe(int idClasse, int classe, String sezione, ArrayList <ProfessoreMateria> docenti) {
		this.idClasse = idClasse;
		this.classe = classe;
		this.sezione = sezione;
		this.docenti = new ArrayList<ProfessoreMateria>();
		this.docenti = docenti;
	}
	
	public Classe(int idClasse) {
		this.idClasse = idClasse;
		this.docenti = new ArrayList<ProfessoreMateria>();
	}
	
	public int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	public String getSezione() {
		return sezione;
	}
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
	
	public ArrayList<ProfessoreMateria> getDocenti() {
		return docenti;
	}

	public void setDocenti(ArrayList<ProfessoreMateria> docenti) {
		this.docenti = docenti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClasse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classe other = (Classe) obj;
		return idClasse == other.idClasse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Classe [idClasse=");
		builder.append(idClasse);
		builder.append(", classe=");
		builder.append(classe);
		builder.append(", sezione=");
		builder.append(sezione);
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
	
}
