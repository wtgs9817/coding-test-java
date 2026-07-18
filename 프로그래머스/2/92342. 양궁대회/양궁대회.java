/*
1 ≤ n ≤ 10
info의 길이 = 11
0 ≤ info의 원소 ≤ n
info의 i번째 원소는 과녁의 10 - i 점을 맞힌 화살 개수

*/

//복습
class Solution {
    static int[] result;
    static int max;
    
    public int[] solution(int n, int[] info) {
        result = new int[]{-1};
        max = 0;
        
        int[] lion = new int[11];
        dfs(0, n, info, lion);
        
        return result;
    }
    
    static void dfs(int depth, int arrow, int[] apeach, int[] lion) {
        if(depth == 11) {
            if(arrow > 0) lion[10]+=arrow;
            
            int lionScore = 0;
            int apeachScore = 0;
            
            for(int i=0; i<=10; i++) {
                if(apeach[i] == 0 && lion[i] == 0) continue;
                
                if(apeach[i] < lion[i]) lionScore+=(10 - i);    
                else apeachScore+=(10 - i);
            }
            
            int total = lionScore - apeachScore;
            
            if(total > 0) {
                if(max < total) {
                    max = total;
                    result = lion.clone();
                }
                else if(max == total) {
                    for(int i=10; i>=0; i--) {
                        if(lion[i] == result[i]) continue;
                        if(lion[i] > result[i]) {
                            result = lion.clone();
                            break;
                        }
                        else break;
                    }
                }
            }
            
            if(arrow > 0) lion[10]-=arrow;
            return;
        }
        
        if(apeach[depth] < arrow) {
            lion[depth] = apeach[depth] + 1;
            arrow -= (lion[depth]);
            dfs(depth+1, arrow, apeach, lion);
            arrow +=(lion[depth]);
            lion[depth] = 0;
        }
        dfs(depth+1, arrow, apeach, lion);
    }
}