package allexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {
        //1.Integer stream
        //System.out.println(IntStream.range(1,10).sum());
        //System.out.println();
        //Stream.of("test","check").sorted().findFirst().ifPresent(System.out::println);
        List<String> arr = Arrays.asList("cat","bat","rat","jam","man");
        //System.out.println(arr.stream().sorted().filter(x->x.startsWith("b")).collect(Collectors.toMap(x->"name",x->"test")));


        double total = Stream.of(1.0,20.0,1.0).reduce(1.0,(Double a,  Double b)->a+b);
        findGreatest(new int[]{10,2,3,20,6});
    }

    static void findGreatest(int[] ints){
        System.out.println();
        //return IntStream.of(ints).max().getAsInt();
        //IntStream.of(ints).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> m = new HashMap<>();
        m.put("key1","hari");
        m.put("key2","gopi");
        Map<String,String> m1 = new HashMap<>();
        m1.put("key1","kiran");
        m1.put("key2","krishna");
        list.add(m);
        list.add(m1);


        //Stream<Map<String, String>> st = list.stream();
        //st.forEach(System.out::println);
       // st.forEach(System.out::println);

      //  System.out.println(list.stream().allMatch(map->map.containsKey("key2")));

        for(int i=0;i<5;i++){
            System.out.print(" ");
            for(int j=1;j<=i/2;j++){
                System.out.println("*");
            }
            System.out.println("");
        }

    }
}
