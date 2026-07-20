//복습
/*
1 ≤ users의 길이 = n ≤ 100
users의 원소는 [비율, 가격]
users[i]는 i+1번 고객의 구매 기준을 의미
비율% 이상의 할인이 있는 이모티콘을 모두 구매한다는 의미
가격이상의 돈을 이모티콘 구매에 사용한다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입한다는 의미

*/
class Solution {
    static int[] result;
    static int[] dis = {10, 20, 30, 40};
    static int[] dis2;
    
    public int[] solution(int[][] users, int[] emoticons) {
        result = new int[2];
        dis2 = new int[emoticons.length];
        dfs(0, users, emoticons);
        
        return result;
    }
    
    static void dfs(int depth, int[][] users, int[] emoticons) {
        if(depth == emoticons.length) {
            int[] em = new int[2];
            
            for(int i=0; i<users.length; i++) {
                int[] arr = users[i];
                int a = arr[0]; //비율
                int b = arr[1]; //가격
                
                int uTotal = 0;
                
                for(int k=0; k<dis2.length; k++) {
                    if(a <= dis2[k]) {
                        int per = (100 - dis2[k]);
                        uTotal += (emoticons[k] * per) / 100; 
                    }
                }
                if(uTotal >= b){
                    uTotal = 0;
                    em[0]++;
                }
                else em[1] += uTotal;  
            }
            
            if(result[0] < em[0]) result = em.clone();
            else if(result[0] == em[0]) {
                if(result[1] < em[1]) result = em.clone();
            }
            return;
        }
        
        for(int i=0; i<dis.length; i++) {
            dis2[depth] = dis[i];
            dfs(depth+1, users, emoticons);
            dis2[depth] = 0;
        }
    }
}