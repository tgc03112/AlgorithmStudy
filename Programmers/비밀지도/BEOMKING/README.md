# 비밀지도

## 분류
>구현
>
>문자열

## 문제풀이

간단한 문자열 구현 문제입니다.

조건에 맞게 구현을 해주면 해결되는 문제이지만 코드가 길고 시간이 오래 걸립니다.

Integer.toBinaryString()을 사이에 '|'를 넣어 or 비트 연산이 가능합니다.

이후 String.format을 이용해서 자릿수를 맞추어줍니다. n이 5이고 비트 연산 결과가 '01011'이라면 원래 '1011'이 나오지만 ' 1011'이 나오게됩니다.

이후 replaceAll을 사용하여 변환시켜주면 해결이 됩니다.

String.format, replaceAll 등의 문자열 관련 메소드에 익숙해질 필요성을 느꼈습니다.

실행 속도는 단순 구현이 더 빠르지만 자바의 기본 라이브러리를 이용해 해결하는 것이 문제 풀이 시간 측면에서 더 좋다고 생각합니다.

## 코드

```java
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
```
