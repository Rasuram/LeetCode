package allexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CiberGlobal {


    public static void main(String[] args) {
        //  System.out.println(getCount("EHM"));
        // intCountPalindrome("aaa");

        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("p1"));
        list.add(Arrays.asList("p2", "2", "1"));
        //list.add(Arrays.asList("vjrrisdfxe", "20", "88046739"));

        System.out.println(fetchItemsToDisplay(list, 0, 0, 1, 0));

    }

    static int getCount(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case 'E':
                    counter += 1;
                    break;
                case 'M':
                    counter += 3;
                    break;
                case 'H':
                    counter += 5;
                    break;
                default:
                    counter += 0;
            }
        }
        return counter;
    }


    static boolean isPalindrome(String s) {
        StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }
        return s.equals(reverse.toString());
    }

    static int intCountPalindrome(String s) {
        // Put all distinct substring in a HashSet
        int palindromeCounter = 0;
        // List All Substrings
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // Add each substring in Set
                if (isPalindrome(s.substring(i, j))) {
                    palindromeCounter++;
                }
            }
        }
        return palindromeCounter;
    }


    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {



        items = items.stream().sorted((o1, o2) -> {
            String obj1 = o1.get(sortParameter);
            String obj2 = o2.get(sortParameter);
            if (obj1 == obj2) {
                return 0;
            }
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return sortOrder == 1 ? obj2.compareTo(obj1) : obj1.compareTo(obj2);
        }).collect(Collectors.toList());

        int size = items.size();
        int startIndex = 0;
        List<List<String>> li = new ArrayList<>();
        while (size > 0) {
            int temp = startIndex+itemsPerPage;
            List<List<String>> l = items.subList(startIndex, Math.min(temp, items.size()));
            li.add(l.stream().map((ls) -> ls.get(0)).collect(Collectors.toList()));
            startIndex = temp;
            size = size - itemsPerPage;
        }

        return (pageNumber>li.size()) ? new ArrayList<>(): li.get(pageNumber);

    }
}



