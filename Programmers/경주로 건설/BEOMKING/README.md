# [2020 카카오 인턴십] 경주로 건설

## 분류
>그래프 이론
>
>너비 우선 탐색
>
>다익스트라

## 문제풀이

처음 4 방향에서 오는 경우의 수를 따로 처리하지 않고 PQ를 사용해 방문처리를 했으나 틀렸습니다.

동 서 남 북 각 방향에서 들어오는 경우마다 결과가 다를 수 있습니다.

그렇기 때문에 방향마다 다르게 처리를 해줘야합니다.

맨 처음에는 특정 방향에서 오는 것이 아니기 때문에 배열의 크기를 하나 늘렸습니다.

방향마다 경우의 수가 다르고 모든 경우의 수를 다 찾아봐야하기 때문에 PQ를 사용할 필요는 없습니다.

가장 먼저 도착한다고 해서 가장 적은 비용은 아니기 때문에 계속 최소값을 갱신했습니다.

비용값이 저장된 배열을 사용해서 특정 배열값보다 현재 비용이 작아야만 조건을 충족하게 해서 굳이 방문 체크 배열을 사용할 필요가 없었습니다.

## 코드

```java
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

```

