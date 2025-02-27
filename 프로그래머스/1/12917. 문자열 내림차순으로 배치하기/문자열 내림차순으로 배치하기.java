import java.util.Arrays;
class Solution {
    public String solution(String s) {
        
        Character[] ch = new Character[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            ch[i] = s.charAt(i);            
        }
        Arrays.sort(ch , (a,b) -> b-a);
        
        StringBuilder sb = new StringBuilder();
        for(char s1 : ch) sb.append(s1);
        
        String answer = sb.toString();
        
        
        
        return answer;
    }
}