# 캐시

## 분류
> 자료구조

## 코드
```java
class Solution {
    public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		if(cacheSize == 0) {
			answer = cities.length * 5;
			return answer;
		}
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i=0;i<cities.length;i++) {
			boolean ck = false;
			
			//list 에 해당되는 값이 있으면
			if(list.contains(cities[i].toUpperCase())) {
				list.remove(cities[i].toUpperCase());
				ck = true;
			}
			else {
				if(list.size() == cacheSize) {	//가득 찼으면
					list.poll();
				}
			}
			list.add(cities[i].toUpperCase());
			
			if(ck) answer++;
			else answer+=5;
		}
        return answer;
    }
}
```

## 문제풀이
문제를 보자마자 리스트를 써서 풀어야 한다는 아이디어는 바로 떠올랐습니다.

문제에서 대소문자를 구문하지 않는다고 했기 때문에 toUpperCase()) 를 사용해서 대문자로 모두 저장했습니다.

그리고 cities 배열에 있는 값이 cache 안에 있으면 비교를 하고 answer에 1을 더해주고 그 값을 다시 list 맨 앞으로 보내야 합니다.

캐시 교체 알고리즘 LRU(Least Recently Used)을 반영해야 하기 때문입니다. cache 안에서 비교만 하고 그 값을 다시 list앞으로 보내지 않아서 테스트케이스가 틀렸었습니다.

대소문자와 캐시 교체 알고리즘만 고려한다면 무난한 문제였습니다.