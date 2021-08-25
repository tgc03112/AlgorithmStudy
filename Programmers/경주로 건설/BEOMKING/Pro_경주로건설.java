package 최단거리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_경주로건설 {
    public static int solution(int[][] board) {
        int[] dy = {-1, 0, 1, 0}; // 북 동 남 서
        int[] dx = {0, 1, 0, -1};

        int N = board.length;
        int answer = Integer.MAX_VALUE;

        Queue<Location> q = new LinkedList<>();
        int[][][] distance = new int[N][N][5]; // 4방향 + 초기 무방향
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        distance[0][0][0] = 0; distance[0][0][1] = 0;
        distance[0][0][2] = 0; distance[0][0][3] = 0; distance[0][0][4] = 0;
        q.add(new Location(0, 0, 0, 4));

        while (!q.isEmpty()) {
            Location now = q.poll();
            int y = now.y; int x = now.x;
            int dir = now.direct;

            if (y == N - 1 && x == N - 1) answer = Math.min(answer, now.cost);

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) continue;

                int addcost = (dir == i || dir == 4) ? 100 : 600;
                int cost = now.cost + addcost;

                if(distance[ny][nx][i] > cost){
                    distance[ny][nx][i] = cost;
                    q.add(new Location(ny, nx, cost, i));
                }
            }
        }
        return answer;
    }

    static class Location implements Comparable<Location> {
        int y, x, cost, direct;
        public Location(int y, int x, int cost, int direct) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direct = direct;
        }

        @Override
        public int compareTo(Location o) {
            return cost - o.cost;
        }
    }
}
