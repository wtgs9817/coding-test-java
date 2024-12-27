class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;
        
        
        for(int i=0; i<arr1.length; i++) {
            
            for(int k=0; k<arr1[i].length; k++) {
                answer[i][k] += arr2[i][k];                 
            }
            
        }
        return answer;
    }
}