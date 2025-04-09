

class Solution {
    public int solution(int[][] sizes) {
        int maxwidth = 0;
        int maxheight = 0;
        
        
        for(int[] arr : sizes) {
            //가로에 큰값을 넣고
            //세로에 작은 값을 넣고
            
            int w = Math.max(arr[0], arr[1]);
            int h = Math.min(arr[0], arr[1]);
            
            //큰 값들 중에 최대값 구하고 
            //작은 값들 중에 최대값 구하고
            maxwidth = Math.max(maxwidth, w);
            maxheight = Math.max(maxheight, h);
       
        }
        
        return maxwidth * maxheight;       
    }
}