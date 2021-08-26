# [2020 KAKAO BLIND RECRUITMENT] 괄호 변환

## 분류
>시뮬레이션
>
>분할정복

## 문제풀이

분할 정복 문제입니다.

주어진 조건을 구현하면 되는 방식은 간단한 문제이지만 재귀를 위해 어떤 식으로 코드를 구현해야하는지 그림을 잘 그리고 접근해야 할 것 같습니다.

인자로 들어간 String이 "올바른 괄호 문자열"인지 확인하는 isCorrect 메소드를 만들어야합니다.

반복문을 돌리며 ')'이 나올때 stack이 비어있으면  "올바르지 않은 괄호 문자열"이므로 ret에 false를 대입합니다. 

left right 개수를 카운트하여 두 개수가 일치하면 "균형잡힌 괄호 문자열"이므로 ret을 return 해줍니다.

이 때 ret이 true 라면 조건에 맞게 return u + solution(v)를 해줍니다.

아니라면 다른 조건에 맞게 구현합니다.

## 코드

```java
package 정렬;

import java.util.Stack;

public class Pro_괄호변환 {
    int pos;

    public String solution(String p) {
        if (p.isEmpty()) return p;

        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos);

        if(correct) return u + solution(v);

        String answer = "(" + solution(v) + ")";
        for (int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') answer += ")";
            else answer += "(";
        }

        return answer;
    }

    boolean isCorrect(String str) {
        boolean ret = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;
                if (stack.isEmpty()) ret = false;
                else stack.pop();
            }

            if (left == right) {
                pos = i + 1;
                return ret;
            }
        }

        return true;
    }
}
```

