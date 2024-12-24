class Solution {
    public double solution(int[] arr) {
        int result = 0;
        for(int num : arr) {
            result += num;
        }
        double len = arr.length;
        double answer = result/len;
        return answer;
    }
}