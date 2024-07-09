package 문자열과배열.키패드누르기;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int nowL = 10; // 현재 왼손위치 *
        int nowR = 12; // 현재 오른손 위치 #

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                nowL = num;
                answer.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                nowR = num;
                answer.append("R");
            } else {
                if (num == 0) num = 11;

                int leftDist = Math.abs(num - nowL) / 3 + Math.abs(num - nowL) % 3;
                int rightDist = Math.abs(num - nowR) / 3 + Math.abs(num - nowR) % 3;

                if (leftDist < rightDist) {
                    answer.append("L");
                    nowL = num;
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    nowR = num;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        nowL = num;
                    } else {
                        answer.append("R");
                        nowR = num;
                    }
                }
            }
        }
        return answer.toString();
    }
}