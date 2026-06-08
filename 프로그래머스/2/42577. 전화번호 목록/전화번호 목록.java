import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String book : phone_book) map.put(book, 1);
        
        for(String book : phone_book) {
            
            for(int i=1; i<book.length(); i++) {
                String p = book.substring(0,i);
                if(map.containsKey(p)) return false;
            }
        }
        return true;
    }
}