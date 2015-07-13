import java.util.Scanner;

/**
 * Created by zhangwei on 7/11/15.
 */
public class PlusMinus {
    public static void Solution(int num, int[] matrix){
        double total0 = 0;
        double total1 = 0;
        double total2 = 0;
        for(int i=0;i<num;i++){
            if(matrix[i]==0){
                total0++;
            }
            else if(matrix[i]>0){
                total1++;
            }
            else if(matrix[i]<0){
                total2++;
            }
        }


        System.out.println(total0/(double)num);
        System.out.println(total1/(double)num);
        System.out.println(total2/(double)num);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        int num = scan.nextInt();

        String inputStr = strScan.nextLine();
        String[] matStr = inputStr.split(" ");

        int[] matrix =new int[num];


        for(int i=0;i<num;i++){
            matrix[i] = Integer.parseInt(matStr[i]);
        }

        Solution(num, matrix);
    }
}
