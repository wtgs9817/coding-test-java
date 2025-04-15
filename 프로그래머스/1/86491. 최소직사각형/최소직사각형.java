
//3번째 풀이  
class Solution {
    public int solution(int[][] sizes) {
    
        int maxwidth = 0;
        int maxheight = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            maxwidth = Math.max(maxwidth, max);
            maxheight = Math.max(maxheight, min);
            
        }
        
        return maxwidth*maxheight;
    } 
}