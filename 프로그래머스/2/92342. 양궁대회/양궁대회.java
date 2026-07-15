/*
1 ≤ n ≤ 10
라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return
*/
class Solution {
    static int[] result;
    static int maxScore;
    
    public int[] solution(int n, int[] info) {
        // info -> apeach
        result = new int[]{-1};
        maxScore = 0;
        int[] lion = new int[11];
        
        dfs(0, n, info, lion);
        
        return result;
    }
    
    static void dfs(int depth, int arrow, int[] apeach, int[] lion) {
        if(depth == 11) {
            if(arrow > 0) lion[10] += arrow;
            
            int a = 0;
            int l = 0;
            
            for(int i=0; i<=10; i++) {
                if(apeach[i] == 0 && lion[i] == 0) continue;
                if(apeach[i] < lion[i]) l += (10 - i);    
                else a+= (10 - i);
            }
            
            int score = l - a;
            
            if(score > 0) {
                if(maxScore < score) {  //라이언 값의 최대가 아니라 l-a 가 최대가 되는 값을 구해야 함.
                    result = lion.clone();
                    maxScore = score;
                }
                else if(maxScore == score) {
                    for(int i=10; i>=0; i--) {
                        if(result[i] < lion[i]) {
                            result = lion.clone();
                            break;
                        }
                        else if(result[i] > lion[i]) break;
                    }
                }
            }
            if(arrow > 0) lion[10] -= arrow;
            return;
        }
        
        if(arrow > apeach[depth]) {
            lion[depth] = apeach[depth] + 1;
            dfs(depth+1, arrow - lion[depth], apeach, lion);
            lion[depth] = 0;
        }
        dfs(depth+1, arrow, apeach, lion);
    }
}