// n은 1 이상 1,000 이하
class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        int x = -1;
        int y = 0;
        
        for(int i=0; i<n; i++) {
            for(int k=i; k<n; k++) {
                if(i % 3 == 0) x++;
                if(i % 3 == 1) y++;
                if(i % 3 == 2) {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        
        int[] result = new int[num - 1];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(arr[i][k] == 0) break;
                result[cnt++] = arr[i][k];
            }
        }
        
        return result;
    } 
}