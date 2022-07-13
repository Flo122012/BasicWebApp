package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Flo";
        } else if (query.contains("which of the following numbers is the largest")) {
            String n1 = query.split("largest: ")[1].split(",")[0];
            String n2 = query.split("largest: ")[1].split(", ")[1];
            if (Integer.parseInt(n1) > Integer.parseInt(n2)) {
                return n1;
            } else {
                return n2;
            }
        }

        return "";
    }
}
