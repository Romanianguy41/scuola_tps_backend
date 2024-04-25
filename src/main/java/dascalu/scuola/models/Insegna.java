package dascalu.scuola.models;

import java.util.Objects;

public class Insegna {

	Classe classe;
	Professore professore;
	String materia;
	
	public Insegna(Classe classe, Professore professore, String materia) {
		this.classe = classe;
		this.professore = professore;
		this.materia = materia;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Professore getProfessore() {
		return professore;
	}
	public void setProfessore(Professore professore) {
		this.professore = professore;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(classe, materia, professore);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insegna other = (Insegna) obj;
		return Objects.equals(classe, other.classe) && Objects.equals(materia, other.materia)
				&& Objects.equals(professore, other.professore);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClasseProfessore [classe=");
		builder.append(classe);
		builder.append(", professore=");
		builder.append(professore);
		builder.append(", materia=");
		builder.append(materia);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
