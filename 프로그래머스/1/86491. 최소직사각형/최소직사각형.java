

class Solution {
    public int solution(int[][] sizes) {
        
        int maxwidth = 0;
        int maxheight = 0;
        
        for(int[] len : sizes) {
            
            int w = Math.max(len[0],len[1]);
            int h = Math.min(len[0],len[1]);
            
            maxwidth = Math.max(maxwidth , w);
            maxheight = Math.max(maxheight, h);
        
        }
        
        return maxwidth * maxheight;
        
        
    }
}