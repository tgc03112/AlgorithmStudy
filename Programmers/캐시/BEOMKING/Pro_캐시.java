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
