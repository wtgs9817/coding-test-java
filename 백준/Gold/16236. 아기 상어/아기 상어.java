import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};  // 위, 왼, 오, 아래 (위/왼 우선)
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        
        int sx = 0, sy = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i; sy = j;
                    map[i][j] = 0;  // 상어 위치는 빈 칸으로
                }
            }
        }
        
        int size = 2;       // 상어 크기
        int eaten = 0;      // 현재 크기에서 먹은 마리 수
        int time = 0;       // 누적 시간
        
        while (true) {
            int[] target = bfs(sx, sy, size);
            if (target == null) break;  // 먹을 수 있는 물고기 없음
            
            int tx = target[0], ty = target[1], dist = target[2];
            
            time += dist;
            map[tx][ty] = 0;  // 먹음
            sx = tx; sy = ty; // 이동
            eaten++;
            
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }
        
        System.out.println(time);
    }
    
    // 상어 위치에서 BFS 돌려서 먹을 수 있는 물고기 중 우선순위 1마리 반환
    // 우선순위: 거리 짧은 것 → 행 작은 것 → 열 작은 것
    static int[] bfs(int sx, int sy, int size) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;
        
        // 후보들을 모은 뒤 우선순위로 정렬
        List<int[]> candidates = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] != -1) continue;       // 이미 방문
                if (map[nx][ny] > size) continue;        // 못 지나감
                
                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx, ny});
                
                // 먹을 수 있는 물고기 (1~size-1)
                if (map[nx][ny] >= 1 && map[nx][ny] < size) {
                    candidates.add(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
        
        if (candidates.isEmpty()) return null;
        
        // 거리 → 행 → 열 순 정렬
        candidates.sort((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        return candidates.get(0);
    }
}