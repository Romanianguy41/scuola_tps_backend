package dascalu.scuola.service;

import java.sql.SQLException;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

import dascalu.common.Utils;
import dascalu.scuola.manager.StudenteManager;
import dascalu.scuola.models.Studente;
import dascalu.scuola.repositories.studente.StudenteRepository;

public class StudenteService {

	public static String getStudents() throws ClassNotFoundException, SQLException {
		return JsonIo.toJson(StudenteManager.getStudents(), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	
	}
	
	public static String getStudents(String search) throws ClassNotFoundException, SQLException {
		return  JsonIo.toJson(StudenteManager.getStudents(search), new WriteOptionsBuilder()
				.prettyPrint(true) 
				.showTypeInfoNever()
				.build()
				);
	}
	
	public static void createStudenteFromForum(Studente studente) throws ClassNotFoundException, SQLException {
		StudenteManager.createStudent(studente);
	}
	
	public static void updateStudent(String userRequest) throws ClassNotFoundException, SQLException{
		Studente studente = JsonIo.toObjects(Utils.convertDate(userRequest), null, Studente.class);
		StudenteManager.updateStudent(studente);
	}
	
	public static void deleteStudent(String idStudente) throws ClassNotFoundException, SQLException{
		StudenteManager.deleteStudent(idStudente);
	} 
	
	public static void createStudent(String userRequest) throws ClassNotFoundException, SQLException{
		Studente studente = JsonIo.toObjects(Utils.convertDate(userRequest), null, Studente.class);
		System.out.println(studente);
		StudenteManager.createStudent(studente);
	} 
	
	public static void removeStudentClass(String idStudent) throws ClassNotFoundException, SQLException{
		StudenteManager.removeStudentClass(idStudent);
	}
	
	public static void removeClassReference(String idClasse) throws ClassNotFoundException, SQLException{
		StudenteManager.removeClassReference(idClasse);
	}
}
