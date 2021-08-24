package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_10026_적록색약 {
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static char[][] map;
    static boolean[][] isvisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isvisited = new boolean[N][N];
        int no = 0, yes = 0;

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        Queue<Location> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isvisited[i][j]) continue;
                queue.add(new Location(i, j, map[i][j]));
                no++;
                isvisited[i][j] = true;

                while (!queue.isEmpty()) {
                    Location now = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int ny = now.y + dy[k];
                        int nx = now.x + dx[k];

                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                        if (isvisited[ny][nx]) continue;
                        if(map[ny][nx] != now.color) continue;

                        queue.add(new Location(ny, nx, map[ny][nx]));
                        isvisited[ny][nx] = true;
                    }
                }
            }
        }

        isvisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isvisited[i][j]) continue;
                queue.add(new Location(i, j, map[i][j]));
                yes++;
                isvisited[i][j] = true;

                while (!queue.isEmpty()) {
                    Location now = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int ny = now.y + dy[k];
                        int nx = now.x + dx[k];

                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                        if (isvisited[ny][nx]) continue;
                        if(map[now.y][now.x] == 'B' && map[ny][nx] != now.color) continue;
                        if((map[now.y][now.x] == 'R' || map[now.y][now.x] == 'G') && map[ny][nx] == 'B') continue;

                        queue.add(new Location(ny, nx, map[ny][nx]));
                        isvisited[ny][nx] = true;
                    }
                }
            }
        }

        System.out.println(no + " " + yes);
    }
    static class Location {
        int y, x;
        char color;

        public Location(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }
}
