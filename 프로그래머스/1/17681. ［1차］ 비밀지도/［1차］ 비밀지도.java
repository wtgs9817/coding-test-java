/*
입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2
1 ≦ n ≦ 16
arr1, arr2는 길이 n인 정수 배열
정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하
0 ≦ x ≦ 2n - 1

지도1 지도2 둘 중 하나라도 #(벽)이면 전체 지도에서도 벽
지도1 지도2 모두 공백 -> 전체 지도에서도 공백

비트 연산 복습
*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            int a = arr1[i];
            int b = arr2[i];
            
            int ab = a | b;
            String str ="";
            for(int k=n-1; k>= 0; k--) {
                if((ab & (1 << k)) != 0) str+="#";
                else str+=" ";
            }
            answer[i] = str;
        }
        return answer;
    }
}