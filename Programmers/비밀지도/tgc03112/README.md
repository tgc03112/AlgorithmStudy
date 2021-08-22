# 섬 연결하기

## 분류
> 문자열

## 코드
```java
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map1[i][j] = "0";
                map2[i][j] = "0";
            }
        }

        for(int i=0;i<n;i++) {
            String convert1 = Integer.toBinaryString(arr1[i]);
            int k=0;
            for(int j=n-convert1.length();j<n;j++) {
                map1[i][j] = Character.toString(convert1.charAt(k++));
            }
        }

        for(int i=0;i<n;i++) {
            String convert2 = Integer.toBinaryString(arr2[i]);
            int k=0;
            for(int j=n-convert2.length();j<n;j++) {
                map2[i][j] = Character.toString(convert2.charAt(k++));
            }
        }

        for(int i=0;i<n;i++) {
            String str = "" ;
            for(int j=0;j<n;j++) {
                if(map1[i][j].equals("1") || map2[i][j].equals("1")) {
                    str+="#";
                }
                else{
                    str+=" ";
                }
            }
            answer[i] = str;
        }
        return answer;
    }
}
```

## 문제풀이
문자열을 charAt으로 쪼개어 바꾸어서 풀었습니다

해설을 보니 비트마스킹 문제라고 하는데 비트마스킹이 기억안나도 충분히 직관적으로 풀 수 있는 문제

Integer.toBinaryString : 10진수를 2진수로 바꿔줌 

문자열을 자유자재로 바꾸고 변환할 수 있도록 해야겠다