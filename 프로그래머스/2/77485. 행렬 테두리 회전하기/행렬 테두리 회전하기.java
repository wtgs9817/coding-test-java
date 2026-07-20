/*
rows는 2 이상 100 이하인 자연수
columns는 2 이상 100 이하인 자연수
queries의 행의 개수(회전의 개수)는 1 이상 10,000 이하
queries의 각 행은 4개의 정수 [x1, y1, x2, y2] => x1 행 y1 열부터 x2 행 y2 열까지 영역의 테두리를 시계방향으로 회전 
1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns

x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전
*/
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int num = 1;
        for(int i=0; i<rows; i++) {
            for(int k=0; k<columns; k++) {
                arr[i][k] = num++;
            }
        }
    
        for(int i=0; i<queries.length; i++) {
            int[] loc = queries[i];
            //x1 행 y1 열부터 x2 행 y2 열
            int x1 = loc[0] - 1;
            int y1 = loc[1] - 1;
            int x2 = loc[2] - 1;
            int y2 = loc[3] - 1;
            
            int temp = arr[x1][y1]; 
            int m = temp;
            
            //좌측 (아래 -> 위)
            for(int x = x1; x<x2; x++) {
                arr[x][y1] = arr[x+1][y1];
                m = Math.min(m, arr[x][y1]);
            }
            //하단 (우 -> 좌)
            for(int y = y1; y<y2; y++) {
                arr[x2][y] = arr[x2][y+1];
                m = Math.min(m, arr[x2][y]);
            }
            
            //우측 (위 -> 아래)
            for(int x = x2; x>x1; x--) {
                arr[x][y2] = arr[x-1][y2];
                m = Math.min(m, arr[x][y2]);
            }
            
            //상단 (좌 -> 우)
            for(int y = y2; y > y1+1; y--) {
                arr[x1][y] = arr[x1][y-1];
                m = Math.min(m, arr[x1][y]);
            }
            arr[x1][y1 + 1] = temp;
            result[i] = m;
        }        
        
        return result;
    }
}