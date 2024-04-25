package dascalu.scuola.models;

import java.util.Objects;

public class Insegna {

	int idInsegna;
	Classe classe;
	Professore professore;
	String materia;
	
	public Insegna(int idInsegna, Classe classe, Professore professore, String materia) {
		this.idInsegna = idInsegna;
		this.classe = classe;
		this.professore = professore;
		this.materia = materia;
	}
	
	public int getIdInsegna() {
		return idInsegna;
	}

	public void setIdInsegna(int idInsegna) {
		this.idInsegna = idInsegna;
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
		return Objects.hash(classe, idInsegna, materia, professore);
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
		return Objects.equals(classe, other.classe) && idInsegna == other.idInsegna
				&& Objects.equals(materia, other.materia) && Objects.equals(professore, other.professore);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Insegna [idInsegna=");
		builder.append(idInsegna);
		builder.append(", classe=");
		builder.append(classe);
		builder.append(", professore=");
		builder.append(professore);
		builder.append(", materia=");
		builder.append(materia);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
