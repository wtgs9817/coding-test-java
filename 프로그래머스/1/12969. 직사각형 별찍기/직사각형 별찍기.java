//2번째 풀이
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        for(int i=0; i<b; i++) {
            for(int k=0; k<a; k++) {
                System.out.print("*");
            }
            System.out.println();           
        }
        

        
    }
}