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
