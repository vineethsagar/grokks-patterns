package SlidingWindow;

import java.util.Arrays;

public class FirstExample{
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2 };
    //    double[] avg = findAveragesBruteForce(5,array );
       double[] avgSlidingWindow = findAveragesSlidingWindow(5,array );
       System.out.println(Arrays.toString(avgSlidingWindow));
    }

    /*
     * complexity is O(k*n) - k size of window , n is array size
     */
    public static double[] findAveragesBruteForce(int k , int[] arr) {
        double[] result =  new double[arr.length -k + 1];

        for (int start = 0; start <= arr.length-k; start++) {
            double sum = 0;
            for (int i = start; i < start+k; i++) {
                sum+=arr[i];
                result[start] = sum/k;
                System.out.println(sum/k);
            }
        }
        return result;
    }

    /*
     * complexity - o(N) , N - size of an array
     */
    public static double[] findAveragesSlidingWindow(int k , int[] arr) {
        double[] result =  new double[arr.length -k + 1];
        double sum = 0;
        int windowStart = 0;
        for (int start = 0; start < arr.length; start++) {
            sum+=arr[start];

            if(start>=k -1 ){
                result[windowStart] = sum/k;
                sum-=arr[windowStart];
                windowStart++;
            }
            
        }
        return result;
    }
}