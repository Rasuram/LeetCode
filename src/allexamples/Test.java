package allexamples;/*

We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

EMPTY
badge_records_1 = [
   MISSING ENTRY for Martha
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Paul",     "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  MISSING EXIT for Paul
  ["Martha",   "exit"],
]
EMPTY

Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]

Additional test cases:

badge_records_2 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], []

badge_records_3 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: [], ["Paul"]

badge_records_4 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Martha", "enter"],
  ["Martha", "exit"],
]

Expected output: ["Paul"], ["Paul"]

badge_records_5 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

badge_records_6 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]


n: length of the badge records array

*/


import java.util.*;
import java.util.stream.Collectors;

public class Test {

    Map<String, Entry> map;

    class Entry {
        String enter;
        String exit;
        int index;

        Entry(String enter, String exit, int index) {
            this.enter = enter;
            this.exit = exit;
            this.index = index;
        }
    }

    public List<List<String>> getMisiingEntries(String[][] badgeRecords) {
        map = new HashMap<>();
        for (int i = 0; i < badgeRecords.length; i++) {
            String name = badgeRecords[i][0];
            String status = badgeRecords[i][1];
            String exit = status.equals("exit") ? "exit" : "";
            String enter = status.equals("enter") ? "enter" : "";
            Entry e;
            if (map.containsKey(name)) {
                e = map.get(name);
                e.exit = status;
            } else {
                e = new Entry(enter, exit, i);
            }
            map.put(name, e);
        }

        System.out.println(map);
        List<String> missingExit = map.entrySet().stream().filter(entry -> {
            Entry e = entry.getValue();
            return ((e.enter.equals("") || e.enter.equals("enter")) && (e.exit.equals("") || e.exit.equals("enter")));
        }).map(Map.Entry::getKey).collect(Collectors.toList());

        List<String> missingEnterList = map.entrySet().stream().filter(entry -> {
            Entry e = entry.getValue();
            return (e.enter.equals("") || (e.enter.equals("exit") && e.exit.equals("exit")));
        }).map(Map.Entry::getKey).collect(Collectors.toList());

        return Arrays.asList(missingExit, missingEnterList);

    }


    public static void main(String[] argv) {


        Test s = new Test();

        String badgeRecords1[][] = new String[][]{
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
        };
        // [[Jennifer, Curtis, Paul, Martha], [Jennifer, Curtis, Paul, Martha]]
        System.out.println(s.getMisiingEntries(badgeRecords1));
        //  ["Curtis", "Paul"], ["Martha", "Curtis"]

        String badgeRecords2[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
        };
        System.out.println(s.getMisiingEntries(badgeRecords2));
        String badgeRecords3[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String badgeRecords4[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
        };

        String badgeRecords5[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String badgeRecords6[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

    }
}

