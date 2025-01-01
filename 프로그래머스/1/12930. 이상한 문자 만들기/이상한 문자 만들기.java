class Solution {
     public String solution(String s) {
        String answer ="";
        String[] arr = s.split(" ", -1);
       
        for(int i=0; i<arr.length; i++) {
            
            for(int k=0; k<arr[i].length(); k++) {
                if(k % 2 ==0) {
                    answer += String.valueOf(arr[i].charAt(k)).toUpperCase();
                }
                else {
                    answer += String.valueOf(arr[i].charAt(k)).toLowerCase();        
                }
            }
            
            if(i != arr.length-1) {
                answer+=" ";
            }
            
            
        }
         
        return answer;
    }
}