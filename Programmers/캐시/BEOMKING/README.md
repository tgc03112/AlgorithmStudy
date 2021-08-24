# 캐시

## 분류
> 구현
>
> 자료구조

## 문제풀이

ArrayDeque을 사용했습니다.

Deque에 새로 넣은 문자열이 있다면 for문을 이용해 찾아서 맨 마지막에 넣어주는 작업을 했는데 for문의 길이가 작아져서 제대로 수행하지 못하는 실수를 했습니다.

길이를 미리 선언하고 해결하거나 remove를 진행하고 add를 하면 간단히 해결됩니다.

## 코드

```java
package 구현.문자열;

import java.util.ArrayDeque;

public class Pro_캐시 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toUpperCase();

            if(deque.contains(city)){
                deque.remove(city);
                deque.addLast(city);
                answer++;
            }else{
                if(deque.size() >= cacheSize) deque.poll();
                deque.addLast(city);
                answer += 5;
            }
        }

        return answer;
    }
}
```
