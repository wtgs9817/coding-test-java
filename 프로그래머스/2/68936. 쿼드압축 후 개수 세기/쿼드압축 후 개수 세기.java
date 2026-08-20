/*
arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭 제곱수 형태
즉, arr의 행의 개수는 1, 2, 4, 8, ..., 1024 중 하나
arr의 각 행의 길이는 arr의 행의 개수와 같습니다. 즉, arr은 정사각형 배열
arr의 각 행에 있는 모든 값은 0 또는 1 


복습 
*/
class Solution {
    static int[] result;
    public int[] solution(int[][] arr) {
        result = new int[2];
        div(0, 0, arr.length, arr);
        
        return result;
    }
    
    static void div(int r, int c, int size, int[][] arr) {
        if(isSame(r,c,size,arr)) {
            result[arr[r][c]]++;
            return;
        }
        
        int half = size/2;
        div(r, c, half, arr);
        div(r, c + half, half, arr);
        div(r + half, c, half, arr);
        div(r + half, c + half, half, arr);
    }
    
    
    static boolean isSame(int r, int c, int size, int[][] arr) {
        int n = arr[r][c];
        
        for(int i=r; i< r + size; i++) {
            for(int k=c; k< c + size; k++) {
                if(n != arr[i][k]) return false;
            }     
        }
        return true;
    }
}