class Solution {
   String solution(String s) {
        String[] arr = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            int num = Integer.parseInt(arr[i]);

            if(num < min) {
                min = num;
            }

            if(num > max ) {
                max = num;
            }
        }

        String answer =min + " " + max;
        return answer;
   }
}