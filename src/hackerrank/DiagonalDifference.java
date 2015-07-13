import java.util.Scanner;

/**
 * Created by zhangwei on 7/10/15.
 */
public class DiagonalDifference {
    public static int Solution(int num, int[][] matrix){
        int total1 = 0;
        int total2 = 0;
        for(int i=0;i<num;i++){
            total1 += matrix[i][i];
        }

        for(int j=0;j<num;j++){
            total2 += matrix[j][num-j-1];
        }


        return Math.abs(total1-total2);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[][] matrix = new int[num][num];

        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                matrix[i][j] = scan.nextInt();
            }
        }

        System.out.println(Solution(num, matrix));
    }
}
