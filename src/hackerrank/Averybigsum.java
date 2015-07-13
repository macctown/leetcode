import java.util.Scanner;

public class Averybigsum {
    public static long Solution(int total, long[] nums){
        long sum = 0;
        for(int i=0;i<total;i++){
            sum += nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total;
        total = in.nextInt();
        long[] nums = new long[total];

        for(int i=0;i<total;i++){
            nums[i] = in.nextLong();
        }

        System.out.println(Solution(total, nums));
    }
}
