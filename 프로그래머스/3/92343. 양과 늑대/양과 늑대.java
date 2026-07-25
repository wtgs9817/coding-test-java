import java.util.*;
/*
2 ≤ info의 길이 ≤ 17
info의 원소는 0 또는 1  0 -> 양 / 1 -> 늑대
edges의 세로(행) 길이 = info의 길이 - 1
edges의 가로(열) 길이 = 2
edges의 각 행은 [부모 노드 번호, 자식 노드 번호] 형태로, 서로 연결된 두 노드를 나타냄
당신이 모은 양의 수보다 늑대의 수가 같거나 더 많아지면 바로 모든 양을 잡아먹어 버림
*/
class Solution {
    static List<Integer>[] tree;
    static int maxSheep;
    static List<Integer> nextNodes;
    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        maxSheep = 0;
        
        for(int i=0; i<info.length; i++) tree[i] = new ArrayList<>();
        for(int[] arr : edges) tree[arr[0]].add(arr[1]);
        
        nextNodes = new ArrayList<>(tree[0]);
        dfs(1, 0, nextNodes, info);
        
        return maxSheep;
    }
    
    static void dfs(int sheep, int wolf, List<Integer> nextNode, int[] info) {
        maxSheep = Math.max(sheep, maxSheep);
        
        for(int i=0; i<nextNode.size(); i++) {
            int a = nextNode.get(i);
            int isWolf = info[a];
            
            if(sheep <= wolf + isWolf) continue;
            
            List<Integer> next = new ArrayList<>(nextNode);
            next.remove(i);
            next.addAll(tree[a]);
            dfs(sheep + (1 - isWolf), wolf + isWolf, next, info);
        }
    }
}