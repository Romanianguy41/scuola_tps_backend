package dascalu.scuola.controllers;


import java.sql.SQLException;
import java.util.List;

import com.cedarsoftware.io.JsonIo;
import com.cedarsoftware.io.WriteOptionsBuilder;

import dascalu.scuola.models.Classe;
import dascalu.scuola.service.ClasseService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("classe")
public class ClasseController {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getClassi() throws ClassNotFoundException, SQLException {
		List<Classe> classi = ClasseService.getClasses();
		String result =
			JsonIo.toJson(
				classi,
	    		new WriteOptionsBuilder()
	    			.prettyPrint(true) // per stamparlo in modo tale da essere letto da un umano
	    			.showTypeInfoNever()
	    			.skipNullFields(true)
	    			.build() // IMPORTANTE !!!
	    		);
		
		return result;
	}
	
	@GET
	@Path("filter")
	@Produces(MediaType.TEXT_PLAIN)
	public String getClassi(@QueryParam("search") String search) throws ClassNotFoundException, SQLException {
		List<Classe> classi = ClasseService.getClasses(search);
		String result =
			JsonIo.toJson(
				classi,
	    		new WriteOptionsBuilder()
	    			.prettyPrint(true) // per stamparlo in modo tale da essere letto da un umano
	    			.showTypeInfoNever()
	    			.skipNullFields(true)
	    			.build() // IMPORTANTE !!!
	    		);
		
		return result;
	}
	
}
