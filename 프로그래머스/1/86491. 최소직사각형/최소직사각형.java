class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int[] arr = sizes[i];
            
            int w = arr[0];
            int h = arr[1];
            
            if(w > h) {
                maxW = Math.max(maxW, w);
                maxH = Math.max(maxH, h);
            }
            else {
                maxW = Math.max(maxW, h);
                maxH = Math.max(maxH, w);
            }
        }
        
        return maxW * maxH;
    }
}