package dascalu.scuola.models;

import java.util.Objects;

public class ProfessoreMateria {
	Professore professore;
	String materia;
	public ProfessoreMateria(Professore professore, String materia) {
		this.professore = professore;
		this.materia = materia;
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
		return Objects.hash(materia, professore);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessoreMateria other = (ProfessoreMateria) obj;
		return Objects.equals(materia, other.materia) && Objects.equals(professore, other.professore);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfessoreMateria [professore=");
		builder.append(professore);
		builder.append(", materia=");
		builder.append(materia);
		builder.append("]");
		return builder.toString();
	}
	
}
