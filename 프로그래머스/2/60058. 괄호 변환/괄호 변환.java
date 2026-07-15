/*
( ) 개수가 같으면 균형잡힌 괄호 문자열
짝도 모두 맞으면 올바른 괄호 문자열

*/
class Solution {
    public String solution(String p) {
        if(p.isEmpty()) return "";
        
        //단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며 --> 앞에서부터 ( 는 +1, ) 는 -1 세면서, 처음으로 0이 되는 지점
        int count = 0;
        int splitIndex = 0;
        
        for(int i=0; i<p.length(); i++) {
            count += (p.charAt(i) == '(' ? 1 : -1);
            
            if(count == 0 ) {
                splitIndex = i + 1;
                break;
            }
        }
        
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);
        
        //u가 올바른 괄호 문자열일 때
        if(isCorrect(u)) return u + solution(v);
         
        //아닐 때
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        
        for(int i=1; i<u.length()-1; i++) sb.append((u.charAt(i) == '(') ? ')' : '(');
        
        return sb.toString();
    }
    
    static boolean isCorrect(String u) {
        int count = 0;
        for(char c : u.toCharArray()) {
            count += (c == '(') ? 1 : -1;
            if(count < 0 ) return false;
        }
        return true;
    }
}