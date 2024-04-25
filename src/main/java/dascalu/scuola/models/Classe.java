package dascalu.scuola.models;

import java.util.Objects;

public class Classe {
	int idClasse;
	int classe;
	String sezione;
	
	
	public Classe(int idClasse, int classe, String sezione) {
		this.idClasse = idClasse;
		this.classe = classe;
		this.sezione = sezione;
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
