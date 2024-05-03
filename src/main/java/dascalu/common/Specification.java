package dascalu.common;

public class Specification {

    public static String convertToSQL(String search) {
        StringBuilder whereCondition = new StringBuilder();

        // Check for special characters
        if (search.contains(";") || search.contains(",") || search.contains("$")) {
            // Handle parentheses
            if (search.contains("$")) {
            	System.out.println(search);
                int start = search.indexOf("$");
                int end = search.lastIndexOf("$");
                whereCondition.append(search);
                whereCondition.setCharAt(start, '(');
                whereCondition.setCharAt(end, ')');
                search = whereCondition.toString();
                whereCondition.setLength(0); // Clear the StringBuilder
                if (!(search.contains(",") || search.contains(";"))) {
                    whereCondition.append(search.replace(":", "="));
                }
                System.out.println(search);
            }

            // Handle comma-separated elements
            if (search.contains(",")) {
                String[] elementsOr = search.split(",");
                for (int i = 0; i < elementsOr.length; i++) {
                    if (elementsOr[i].contains("(")) {
                        whereCondition.append(elementsOr[i].replace("(", "(LOWER(").replace(":", ")="));
                    } else {
                        whereCondition.append("LOWER(").append(elementsOr[i].replace(":", ")=").replace(");", "));"));
                    }
                    if (i < elementsOr.length - 1) {
                        whereCondition.append(" OR ");
                    }
                }
               System.out.println(whereCondition.toString());
               search = whereCondition.toString();
            }

            // Handle semicolon-separated elements
            if (search.contains(";")) {
                whereCondition.setLength(0); // Clear the StringBuilder
                String[] elementsAnd = search.split(";");
                for (int i = 0; i < elementsAnd.length; i++) {
                    whereCondition.append("(LOWER(").append(elementsAnd[i].replace(":", ")=")).append(")");
                    if (i < elementsAnd.length - 1) {
                        whereCondition.append(" AND ");
                    }
                    System.out.println(whereCondition.toString());
                }
            }
        } else {
            whereCondition.append(search.replace(":", "="));
        }

        return whereCondition.toString();
    }
}
