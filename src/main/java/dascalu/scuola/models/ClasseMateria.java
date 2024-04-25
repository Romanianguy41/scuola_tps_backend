package dascalu.scuola.models;

import java.util.Objects;

public class ClasseMateria {
	Classe classe;
	String materia;
	public ClasseMateria(Classe classe, String materia) {
		this.classe = classe;
		this.materia = materia;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classe, materia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClasseMateria other = (ClasseMateria) obj;
		return Objects.equals(classe, other.classe) && Objects.equals(materia, other.materia);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClasseMateria [classe=");
		builder.append(classe);
		builder.append(", materia=");
		builder.append(materia);
		builder.append("]");
		return builder.toString();
	}
	
	
}
