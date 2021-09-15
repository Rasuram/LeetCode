package allexamples;

import java.util.*;

public class TextFormat {

    public static int textFormatting(List<Integer> starting, List<Integer> ending, List<Character> style) {
        Map<Character, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < starting.size(); i++) {
            List<int[]> tmp = map.getOrDefault(style.get(i), new ArrayList<>());
            tmp.add(new int[]{starting.get(i), ending.get(i)});
            map.put(style.get(i), tmp);

        }

        for (char c : map.keySet()) {
            map.put(c, disjoint(map.get(c)));
        }

        List<int[]> first = null;
        int count = 0;
        for (char c : map.keySet()) {
            if (first == null) {
                first = map.get(c);
            } else {
                List<int[]> tmp = merge(first, map.get(c));
                count += first.size() + map.get(c).size() - tmp.size();
                //System.out.println("first " + first.size());
                //System.out.println(map.get(c).size());System.out.println(tmp.size());
                first = tmp;
            }
        }
        //System.out.println(first);
        //System.out.println(count);
        return first.size() * 2 + count;
    }


    public static List<int[]> merge(List<int[]> first, List<int[]> second) {

        List<int[]> res = new ArrayList<>();

        int index1 = 0, index2 = 0;

        while (index1 < first.size() && index2 < second.size()) {
            int[] tmp1 = first.get(index1);
            int[] tmp2 = second.get(index2);

            if (tmp1[0] == tmp2[0]) {
                if (tmp1[1] == tmp2[1]) {
                    res.add(tmp1);
                    index1++;
                    index2++;
                } else if (tmp1[1] < tmp2[1]) {
                    res.add(tmp1);
                    index1++;
                } else {
                    res.add(tmp2);
                    index2++;
                }
            } else if (tmp1[0] < tmp2[0]) {
                res.add(tmp1);
                index1++;
            } else {
                res.add(tmp2);
                index2++;
            }
        }

        while (index1 < first.size()) {
            res.add(first.get(index1));
            index1++;
        }

        while (index2 < second.size()) {
            res.add(second.get(index2));
            index2++;
        }

        return res;

    }

    public static List<int[]> disjoint(List<int[]> list) {
        Collections.sort(list, Comparator.comparingInt(a -> a[1]));

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];

            while (i < list.size() - 1 && list.get(i + 1)[0] <= end + 1) {
                start = Math.min(start, list.get(i + 1)[0]);
                end = list.get(i + 1)[1];
                i++;

            }

            res.add(new int[]{start, end});

        }
        Set<Integer> s = new HashSet<>();
        //System.out.println(res.size() + " res size ");
        return res;
    }

    public static long numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        long prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k){
                prod /= nums[(int) left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] n = {1,2,3,4};
        System.out.println(numSubarrayProductLessThanK(n,65));
    }
}
