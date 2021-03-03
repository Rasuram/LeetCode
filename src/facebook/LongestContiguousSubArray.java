package facebook;

public class LongestContiguousSubArray {

    static int[] countSubarrays(int[] arr) {
        // initialization: this holds true because each element is its own subarray.
        int[] ans = new int[arr.length];
        for(int i=0; i< arr.length; i++) {
            ans[i] = 1;
        }

        // walk through 1..n element
        // go left and right from current element checking conditions in while loop
        for(int i=0; i < arr.length; i++) {
            /** maintenance: if it holds true before an iteration of a loop, then it
             *  holds true before the next iteration of the loop.
             * i = 0, current = arr[0], left=-1, right=1
             */
            int current = arr[i];
            int left = i-1;
            int right = i+1;

            // termination: compare each element to the left of 'current' element to 'current' and
            // increment ans[i] (counter) till neither conditions are met.
            while (left >= 0 && current > arr[left]) {
                ans[i]++;
                left--;
            }

            // termination: compare each element to the right of 'current' element to 'current' and
            // increment ans[i] (counter) till neither conditions not met.
            while (right < arr.length && current > arr[right]) {
                ans[i]++;
                right++;
            }
        }
        return ans;
    }

    public static int maxSubArray(int[] in){

        int start=0,end=0;
        int longestSubString = Integer.MIN_VALUE;
        int n = in.length;

        for(int i=0;i<n;i++){
            int runningWindowSum = 0;
            for(int j=i;j<n;j++){
                runningWindowSum+=in[j];
                if(runningWindowSum>longestSubString){
                    longestSubString = runningWindowSum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println(start+"---"+end);
        return longestSubString;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3, 1,-8,4, -1, 2, 1,-5,5};
        System.out.println(maxSubArray(arr));
    }
}
