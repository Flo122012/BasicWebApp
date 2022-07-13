package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            //} else if (query.contains("which of the following numbers is the largest")) {
            //    String n1 = query.split("largest: ")[1].split(",")[0];
            //    String n2 = query.split("largest: ")[1].split(", ")[1];
            //    if (Integer.parseInt(n1) > Integer.parseInt(n2)) {
            //        return n1;
            //    } else {
            //        return n2;
            //    }
        } else if (query.contains("what is") && query.contains("plus")) {
            String n1 = query.split("what is ")[1].split(" plus ")[0];
            String n2 = query.split(" plus ")[1];
            return "" + (Integer.parseInt(n1) + Integer.parseInt(n2));
        } else if (query.contains("what is") && query.contains("multiplied")) {
            String n1 = query.split("what is ")[1].split(" multiplied by ")[0];
            String n2 = query.split(" multiplied by ")[1];
            return "" + (Integer.parseInt(n1) * Integer.parseInt(n2));
            //which of the following numbers is the largest: 964, 14, 97, 37
        } else if (query.contains("which of the following numbers is the largest")) {
            String n1 = query.split("the largest: ")[1];
            String[] numbers = n1.split(",");
            Integer[] nAsInt = new Integer[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nAsInt[i] = Integer.parseInt(numbers[i].replace(" ", ""));
            }

            List<Integer> n = Arrays.asList(nAsInt);
            Collections.sort(n);
            return "" + n.get(n.size() - 1);

        }

        return "";
    }
}
