package adobe;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatingElement {


    public static void findNonRepeatingElement() {
        int[] arr = {1, 2, 5, 7, 2, 7, 4};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Optional<Integer> firstNonRepeating =
                map.entrySet().stream().filter(e -> 1 == e.getValue()).map(Map.Entry::getKey).findFirst();
        System.out.println(firstNonRepeating.get());
    }


    public static void main(String[] args) {
        findNonRepeatingElement();
    }
}



