//두번째 풀이
class Solution {
    public int solution(int a, int b, int n) {
    //콜라를 받기 위해 마트에 주어야 하는 병 수 a 
    //빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b 
    //상빈이가 가지고 있는 빈 병의 개수 n
        int exchange = 0;
        int result = 0;
        while(true) {
            
            exchange = b * (n / a);
                
            result += exchange;
            n = exchange + (n % a);   
            
            
            if(n < a) {
                break;
            }
        }
        
        return result;
            
        
            
    }    
}