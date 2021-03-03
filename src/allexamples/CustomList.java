package allexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomList<E> {
    private Object[] intArray = {};
    private int currentIndex = 0;

    CustomList() {
        //initiate array with 5 by default


    }

    public void add(E o) {
        if (isArraFull()) {
            intArray = Arrays.copyOf(intArray, 10);
        }else{
            intArray[currentIndex] = o;
            currentIndex++;
        }
    }

    public E get(int index) {
        return (E)this.intArray[index];
    }

    boolean isArraFull() {
        return currentIndex >= intArray.length || (currentIndex + 1) >= intArray.length;
    }

    public static void main(String[] args) {
        CustomList<Object> cust = new CustomList<>();
        cust.add(10);
        cust.add("test");
        cust.add(30);
        cust.add(30);
        cust.add(30);
        cust.add(60);
        cust.add("ffff");
        cust.add("ddd");
        cust.add("check");
List<String> li = new ArrayList<>();
        System.out.println(cust.get(6));
    }

}
