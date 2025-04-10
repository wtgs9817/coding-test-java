
//2번째 풀이  
class Solution {
    public int solution(int[][] sizes) {
        int maxwidth = 0;
        int maxheight = 0;
        
        for(int[] arr : sizes) {
            int w = Math.max(arr[0], arr[1]);
            int h = Math.min(arr[0], arr[1]);
            
            maxwidth = Math.max(maxwidth, w);
            maxheight = Math.max(maxheight, h);
        }
        
        return maxwidth * maxheight;
    }
}