# [10026] 적록색약

## 분류
> 그래프 이론
> 그래프 탐색
> 너비 우선 탐색
> 깊이 우선 탐색

## 문제풀이

간단한 DFS BFS 문제입니다.

for문을 이용해 방문하지 않은 맵을 Queue에 넣어 탐색했습니다.

적록색약이 없는 경우와 있는 경우를 다르게 처리합니다.

없는 경우에는 현재 색과 다음 색이 다르다면 넘어가고 있다면

```
if(map[now.y][now.x] == 'B' && map[ny][nx] != now.color) continue;
if((map[now.y][now.x] == 'R' || map[now.y][now.x] == 'G') && map[ny][nx] == 'B') continue;
```

조건을 이용해서 R과 G를 같게 처리합니다.

## 코드

```java
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
```

