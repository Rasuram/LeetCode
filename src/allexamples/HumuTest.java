package allexamples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HumuTest {

    static Map<String, Family> familyTree = new HashMap<>();

    public static List<String> readFile(List<String> input, String today) {
        for (int i = 0; i < input.size(); i++) {
            getRecordFromLine(input.get(i));
        }
        buildRelation(today);
        List<Family> list = new ArrayList<>(familyTree.values());

        Collections.sort(list);

        return constructOutput(list);
    }


    private static List<String> constructOutput(List<Family> familyTree) {

        List<String> l = new LinkedList<>();
        String header = "id,name,gender,birth,death,parent1,parent2,age,descendents";
        l.add(header);
        for (Family f : familyTree) {
            l.add(f.toString());
        }
        return l;
    }

    private static List<String> getRecordFromLine(String line) {
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            Family f = new Family(rowScanner.hasNext() ? rowScanner.next() : "",
                    rowScanner.hasNext() ? rowScanner.next() : "",
                    rowScanner.hasNext() ? rowScanner.next() : "",
                    rowScanner.hasNext() ? rowScanner.next() : "", rowScanner.hasNext() ?
                    rowScanner.next() : "", rowScanner.hasNext() ?
                    rowScanner.next() : "",
                    rowScanner.hasNext() ? rowScanner.next() : "", 0);
            familyTree.put(f.id, f);
            return null;
        }
    }


    private static void buildRelation(String today) {
        for (Map.Entry<String, Family> entry : familyTree.entrySet()) {
            Family f = entry.getValue();
            String parent1 = f.parent1;
            String parent2 = f.parent2;

            if (!f.birth.isEmpty()) {
                f.age = Math.toIntExact(getAge(f.birth, f.death.isEmpty() ? today : f.death));
            }

            Stack<String> stack = new Stack<>();
            stack.push(parent1);
            stack.push(parent2);
            while (!stack.isEmpty()) {
                String key = stack.pop();
                if (familyTree.containsKey(key)) {
                    Family parent = familyTree.get(key);
                    parent.descendents = parent.descendents + 1;
                    familyTree.put(key, parent);
                    stack.push(parent.parent1);
                    stack.push(parent.parent2);
                }
            }
        }
    }


    public static long getAge(String from, String to) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat1 = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = myFormat.parse(from);
            date2 = myFormat.parse(to);
        } catch (ParseException e) {
            try {
                date1 = myFormat1.parse(from);
                date2 = myFormat1.parse(to);
                long diff = date2.getTime() - date1.getTime();
                return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }


    public static void main(String[] args) {
        String inputString1 = "1906-12-05";
        String inputString2 = "1966-12-05";
        System.out.println(getAge(inputString1, inputString2));

        // String s1 = "id,name,gender,birth,death,parent1,parent1";
        String s1 = "1,Marilyn Paris,female,1906-12-05,1966-12-05,,";
        String s2 = "2,Marilyn Paris,female,1927-01-30,,1,5";
        String s3 = "3,Marilyn Paris,female,1953-08-07,2003-04-21,2,";
        String s4 = "4,Marilyn Paris,female,1923-07-12,1988-03-01,1,5";
        String s5 = "5,Marilyn Paris,female,1892-02-11,1955-03-29,,";
        String s6 = "6,Marilyn Paris,female,1944-05-07,,4,";
        String s7 = "7,Marilyn Paris,female,1951-06-05,2008-06-17,2,";
        List<String> result = readFile(Arrays.asList(s1, s2, s3, s4, s5, s6, s7), "2018-12-20");
        System.out.println(result);
    }

    static class Family implements Comparable<Family> {
        String id;
        String name;
        String gender;
        String birth;
        String death;
        String parent1;
        String parent2;
        int age;
        int descendents;

        public Family(String id, String name, String gender, String birth, String death, String parent1, String parent2, int descendents) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.birth = birth;
            this.death = death;
            this.parent1 = parent1;
            this.parent2 = parent2;
            this.age = -1;
            this.descendents = descendents;
        }

        @Override
        public int compareTo(Family o) {
            int birth =  this.birth.compareTo(o.birth);

            if(birth!=0){
                return birth;
            }
            return o.age-this.age;
        }

        @Override
        public String toString() {
            return id + "," + name + "," + gender + "," + birth + "," + death + "," + parent1 + "," + parent2 + "," + age + "," + descendents;
        }
    }
}
