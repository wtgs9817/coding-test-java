//두번째 풀이

class Solution {
    boolean solution(String s) {
        
        String str = s.toLowerCase();
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            
            
            if(str.charAt(i) =='p') {
                count++;
            }
            
            if(str.charAt(i) == 'y') {
                count--;
            }
        }
        
        if(count == 0) {
            return true;
        }
        else {
            return false;
        }
        
        
        
        
        
        
        
        
        
        
        
        /*
        boolean answer = true;

        String str = s.toLowerCase();
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            if(str.charAt(i) == 'p') {
                count++;
            }
            
            if(str.charAt(i) == 'y') {
                count--;
            }
        }
        
        if(count == 0) answer = true;
        else answer = false;
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
        
        */
    }
}