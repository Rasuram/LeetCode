package allexamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class MAxmin {


    public static List<Long> getMaxMin(List<String> operations, List<Integer> integers) {
        Queue<Long> stack = new LinkedList<>();
        List<Long> result = new ArrayList<>();
        Long max, min;

        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals("push")) {
                Long value = Long.valueOf(integers.get(i));
                stack.add(value);
                min = stack.stream().min(Comparator.naturalOrder()).get();
                max = stack.stream().max(Comparator.naturalOrder()).get();
                result.add(min * max);
            } else {
                stack.poll();
                min = stack.stream().min(Comparator.naturalOrder()).get();
                max = stack.stream().max(Comparator.naturalOrder()).get();
                result.add(min * max);
            }

        }
        return result;

    }

    public static List<String> getMovieTitles(String title) {
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";
        url = String.format(url, title);
        List<String> result = new ArrayList<>();
        StringBuffer response = new StringBuffer();
        URL obj;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(response);

        return result;
    }


    public static void main(String[] args) {
/*
        List<String> operations = Arrays.asList("push", "push", "push", "pop");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1);
        System.out.println(getMaxMin(operations, numbers));
        List<String> sortedTitles = getMovieTitles("Spiderman");

        System.out.println(sortedTitles);*/


        String c = Integer.toBinaryString(10269);
        System.out.println(c);
        long count = c.chars().filter((i) -> (i - '0') == 1).count();
        System.out.println(count);
      /*  int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c - '0';
        }
        System.out.println(sum);*/


    }
}
