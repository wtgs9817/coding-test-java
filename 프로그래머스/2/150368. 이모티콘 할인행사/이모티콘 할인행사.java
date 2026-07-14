/*
1 ≤ users의 길이 = n ≤ 100
users의 원소는 [비율, 가격]의 형태
1 ≤ emoticons의 길이 = m ≤ 7 --> emoticons[i]는 i+1번 이모티콘의 정가를 의미
플러스 가입자 늘리는 게 우선 그 다음 판매액
할인율 10~40% -> 이모티콘마다 다를 수 있음

문제 좀 제발 잘 읽고 하자
*/
class Solution {
    static int[] result = new int[2];
    static int[] darr;
    static int[] dis = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        darr = new int[emoticons.length];
        
        dfs(0, users, emoticons);    
        
        return result;
    }
    static void dfs(int depth, int[][] users, int[] emoticons) {
        if(depth == emoticons.length) {
            int[] test = new int[2]; 
            for(int i=0; i<users.length; i++) {
                int[] arr = users[i];
                int a = arr[0]; //비율
                int b = arr[1]; //가격
                int ab = 0;
                boolean flag = false;
                
                for(int k=0; k<darr.length; k++) {
                    if(darr[k] >= a) {
                        ab = ab + (emoticons[k] * (100 - darr[k]) / 100);
                    }
                    
                    if(ab >= b) {
                        test[0]++;
                        flag = true;
                        break;
                    }
                }
                
                if(!flag) test[1] += ab;
            }
            
            if(result[0] == test[0]) {
                if(result[1] < test[1]) {
                    result[0] = test[0];
                    result[1] = test[1];
                }
            }
            else if(result[0] < test[0]) {
                result[0] = test[0];
                result[1] = test[1];    
            }
            return;
        }
        
        for(int i=0; i<dis.length; i++) {
            darr[depth] = dis[i];
            dfs(depth+1, users, emoticons);
        }
    }
}