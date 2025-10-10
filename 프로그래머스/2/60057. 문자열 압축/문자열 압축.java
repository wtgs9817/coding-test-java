class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<= s.length()/2; i++) {
            String str = s.substring(0,i);
            
            int count = 1;
            String save = "";
            
            for(int k=i; k<s.length(); k+=i) {
                String value = s.substring(k, Math.min(k+i, s.length()));
                
                if(str.equals(value)) {
                    count++;
                }
                else {
                    if(count > 1) {
                        save += count + str;
                    }
                    else {
                        save += str;
                    }
                    str = value;
                    count = 1;
                }
                
            }
            if(count > 1) save += count + str;
            else save += str;          
                    
            answer = Math.min(answer, save.length());
        }
        
        return answer;
    }
}