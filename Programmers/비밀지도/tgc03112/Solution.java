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
