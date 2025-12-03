class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int count = 0;
        
        String str = Integer.toBinaryString(n);
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
        
        int num = n+1;
        int cnt = 0;
        while(true) {
            String str2 = Integer.toBinaryString(num);
            
            for(int i=0; i<str2.length(); i++) {
                if(str2.charAt(i) == '1') cnt++;
            }
            
            if(cnt == count) {
                answer = num;
                break;
            }
            
            cnt = 0;
            num++; 
        }
        
        return answer;
    }
}