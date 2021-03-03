package allexamples;

import java.util.Arrays;
import java.util.List;
public class Checkr {
    public static boolean nameMatch(String[] knownAliases, String recordName) {
        boolean aliasMatch = false;
        for (String alias : knownAliases) {
            //Exact match
            if (recordName.equalsIgnoreCase(alias)) {
                return true;
                //middle name match
            } else {
                String[] split = alias.split(" ");
                String[] nameSplit = recordName.split(" ");
                List<String> list = Arrays.asList(nameSplit);
                for (String s : split) {
                    aliasMatch = list.contains(s);
                }
            }
        }

        return aliasMatch;
    }

    public static void assertEqual(boolean expected, boolean result, String errorMessage) {
        if (result != expected) {
            System.out.println(errorMessage);
            System.out.println("expected: " + expected);
            System.out.println("actual: " + result);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String[] knownAliases = new String[]{"Alphonse Gabriel Capone", "Al Capone"};
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Gabriel Capone"), "error 1.1");
        assertEqual(true,  nameMatch(knownAliases, "Al Capone"),               "error 1.2");
        assertEqual(false, nameMatch(knownAliases, "Alphonse Francis Capone"), "error 1.3");

        knownAliases = new String[]{"Alphonse Capone"};
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Gabriel Capone"), "error 2.1");
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Francis Capone"), "error 2.2");
        assertEqual(false, nameMatch(knownAliases, "Alexander Capone"),        "error 2.3");

        knownAliases = new String[]{"Alphonse Gabriel Capone"};
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Capone"),         "error 3.1");
        assertEqual(false, nameMatch(knownAliases, "Alphonse Francis Capone"), "error 3.2");
        assertEqual(false, nameMatch(knownAliases, "Alphonse Edward Capone"),  "error 3.3");

        knownAliases = new String[]{"Alphonse Gabriel Capone", "Alphonse Francis Capone"};
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Gabriel Capone"), "error 4.1");
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Francis Capone"), "error 4.2");
        assertEqual(false, nameMatch(knownAliases, "Alphonse Edward Capone"),  "error 4.3");

        knownAliases = new String[]{"Alphonse Gabriel Capone", "Alphonse F Capone"};
        assertEqual(true,  nameMatch(knownAliases, "Alphonse G Capone"),       "error 5.1");
        assertEqual(true,  nameMatch(knownAliases, "Alphonse Francis Capone"), "error 5.2");
        assertEqual(false, nameMatch(knownAliases, "Alphonse E Capone"),       "error 5.3");
        assertEqual(false, nameMatch(knownAliases, "Alphonse Edward Capone"),  "error 5.4");
        assertEqual(false, nameMatch(knownAliases, "Alphonse Gregory Capone"), "error 5.5");

        knownAliases = new String[]{"Alphonse Gabriel Capone"};
        assertEqual(true,  nameMatch(knownAliases, "Gabriel Alphonse Capone"), "error 6.1");
        assertEqual(true,  nameMatch(knownAliases, "Gabriel A Capone"),        "error 6.2");
        assertEqual(true,  nameMatch(knownAliases, "Gabriel Capone"),          "error 6.3");
        assertEqual(false, nameMatch(knownAliases, "Gabriel Francis Capone"),  "error 6.4");

        knownAliases = new String[]{"Alphonse Gabriel Capone"};
        assertEqual(false, nameMatch(knownAliases, "Alphonse Capone Gabriel"), "error 7.1");
        assertEqual(false, nameMatch(knownAliases, "Capone Alphonse Gabriel"), "error 7.2");
        assertEqual(false, nameMatch(knownAliases, "Capone Gabriel"),          "error 7.3");

        System.out.println("allexamples.Test run finished");
    }
}
