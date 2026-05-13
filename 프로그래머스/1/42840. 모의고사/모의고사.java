import java.util.*;

//복습
class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        ArrayList<int[]> list = new ArrayList<>();
        int max = 0;
        for(int i=0; i<3; i++) {
            int cnt = 0;
            for(int k=0; k<answers.length; k++) {
                if(answers[k] == arr[i][ k % arr[i].length ]) cnt++;
            }
            list.add(new int[]{i,cnt});
            max = Math.max(max, cnt);
        }
        List<Integer> list2 = new ArrayList<>();
        for(int a[] : list) if(max == a[1]) list2.add(a[0]+1);
        
        int len = list2.size();
        int[] result = new int[len];
        int count = 0;
        for(int a : list2) result[count++] = a;
    
        return result;
    }
}