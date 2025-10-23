class Solution {
    
    int solution(int[][] land) {
        int[] prev = new int[4];
        
        for(int i=1; i<land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
        
        int answer = 0;
        for(int i=0; i<4; i++) {
            if(answer < land[land.length-1][i]) {
                answer = land[land.length-1][i];
            }
        }
          
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}