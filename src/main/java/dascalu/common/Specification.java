package dascalu.common;

public class Specification {

	public static String convertToSQL(String search) {
		StringBuilder whereCondition = new StringBuilder(); 
		if(search.contains(";") || search.contains(",") || search.contains("^"))
		{
			if(search.contains(",")) {
				String elementsOr[] = search.split(","); //equivalente or
				for(int i = 0; i < elementsOr.length; i++) {
					whereCondition.append("LOWER(");
					whereCondition.append(elementsOr[i].replace(":", ")="));
					if(i < elementsOr.length -1)
						whereCondition.append(" OR ");
				}
			}
			
			if(search.contains(";")) {
				String elementsAnd[] = search.split(";"); //equivalente dell end
				for(int i = 0; i < elementsAnd.length; i++) {
					whereCondition.append("LOWER(");
					whereCondition.append(elementsAnd[i].replace(":", ")="));
					if( i < elementsAnd.length -1)
						whereCondition.append(" AND ");
				}
			}
		}
		else {
			whereCondition.append(search.replace(":", "="));
			
		}
		return whereCondition.toString();
		
		
	}
	
}
