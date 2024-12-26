class Solution {
    public String solution(String s) {
        String answer = "";
        
        int a = s.length();
        StringBuilder sb = new StringBuilder();
        if(a%2 == 0 ) {
            sb.append(s.charAt(a/2-1)).append(s.charAt(a/2));
        }
        
        else {
            sb.append(s.charAt(a/2));
        }
        answer = sb.toString();
        
        return answer;
    }
}