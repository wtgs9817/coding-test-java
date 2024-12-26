class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        int num = arr[0];
        
        if(arr.length ==1) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        
        for(int i=1; i<arr.length; i++) {
            if(num > arr[i]) {
                num = arr[i];
            }
        }
        int cnt =0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != num) {
                answer[cnt] = arr[i];
                cnt++;
            }
        }
        
        
        
        return answer;
    }
}