import java.util.*;
/*
2 ≤ info의 길이 ≤ 17
info의 원소는 0 또는 1 
info[i]는 i번 노드에 있는 양 또는 늑대(0은 양, 1은 늑대)
info[0]의 값은 항상 0입니다. 즉, 0번 노드(루트 노드)에는 항상 양

edges의 세로(행) 길이 = info의 길이 - 1
edges의 가로(열) 길이 = 2
edges의 각 행은 [부모 노드 번호, 자식 노드 번호] 형태로, 서로 연결된 두 노드를 나타냄
*/
class Solution {
    static List<Integer>[] tree;
    static int maxSheep;
    public int solution(int[] info, int[][] edges) {
        maxSheep = 0;
        int len = info.length;
        int eLen = edges.length;
        tree = new ArrayList[len];
        
        for(int i=0; i<len; i++) tree[i] = new ArrayList<>();
        
        for(int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];
            
            tree[a].add(b);
        }
        
        List<Integer> save = new ArrayList<>();
        save.addAll(tree[0]);
        
        dfs(1, 0, info, save);
        return maxSheep;
        
    }
    public void dfs(int sheep, int wolf, int[] info ,List<Integer> save) {
        maxSheep = Math.max(sheep, maxSheep);
        
        for(int i=0; i<save.size(); i++) {
            int a = save.get(i);
            int isWolf = info[a];
            
            if(sheep <= isWolf + wolf) continue;
            
            List<Integer> back = new ArrayList<>(save);
            back.remove(i);
            back.addAll(tree[a]);

            dfs(sheep + (1- isWolf), wolf + isWolf, info, back); 
        }
    }
}