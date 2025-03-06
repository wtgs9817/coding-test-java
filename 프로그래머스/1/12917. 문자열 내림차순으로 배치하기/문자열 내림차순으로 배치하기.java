import java.util.Arrays;
class Solution {
    public String solution(String s) {
        
        Character[] ch = new Character[s.length()];
        for(int i=0; i<s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        
        Arrays.sort(ch, (c1,c2) -> c2 - c1);
        
        StringBuilder sb = new StringBuilder();  
        for(char c1 : ch) sb.append(c1);
        
        String answer = sb.toString();
        

        return answer;
       
    }
}