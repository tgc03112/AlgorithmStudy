package 구현;

import java.util.Arrays;

public class Pro_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        char[][] map1 = new char[n][n];
        char[][] map2 = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map1[i], '0');
            Arrays.fill(map2[i], '0');
        }

        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i]);
            int length = binary.length();
            for (int j = n - length; j < n; j++) {
                map1[i][j] = binary.charAt(length);
            }
        }

        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr2[i]);
            int length = binary.length();
            for (int j = n - 1; j >= n - binary.length(); j--) {
                map2[i][j] = binary.charAt(--length);
            }
        }

        char[][] map3 = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map1[i][j] == '1' || map2[i][j] == '1') map3[i][j] = '#';
                else map3[i][j] = ' ';
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(map3[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
    // 다른 풀이
    public String[] othersolution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }

        return answer;
    }
}
