import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int sc1 = scan.nextInt();
        int sc2 = scan.nextInt();
        
        for(int i =0; i<sc2; i++) {
            for(int k =0; k<sc1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        

        
    }
}