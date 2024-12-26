class Solution {
    public String solution(String phone_number) {
        
        
        StringBuilder sb = new StringBuilder(phone_number);
        int len = phone_number.length()-4;
        
        sb.replace(0, len ,"*".repeat(len));
        
        String answer = sb.toString();
        
        return answer;
    }
}