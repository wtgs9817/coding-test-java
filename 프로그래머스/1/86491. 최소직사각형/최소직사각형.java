
//3번째 풀이  
//4번째 풀이
class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = Math.max(sizes[0][0], sizes[0][1]);
        int maxHeight = Math.min(sizes[0][0], sizes[0][1]);
        
        
        for(int i=0; i<sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int minMax = Math.min(sizes[i][0], sizes[i][1]);
            
            if(maxWidth < max) {
                maxWidth = max;
            }
            
            if(maxHeight < minMax) {
                maxHeight = minMax;
            }
        }
        
        int answer = maxWidth * maxHeight;
        
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        int maxwidth = 0;
        int maxheight = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            maxwidth = Math.max(maxwidth, max);
            maxheight = Math.max(maxheight, min);
            
        }
        
        return maxwidth*maxheight;
        
        */
    } 
}