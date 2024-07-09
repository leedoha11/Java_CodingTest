package 문자열과배열.다트게임;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 3번의 기회에 대한 점수 저장
        int idx = -1; // 현재 기회 인덱스 초기화

        //String을 char[]로 만들기
        char[] ch = dartResult.toCharArray();

        //문자배열 ch[]를 다 돌면서 숫자와 문자를 나눠서 생각한다.
        for(int i = 0; i < ch.length; i++) {
            //1. 만약 숫자 라면
            if ('0' <= ch[i] && ch[i] <= '9') {
                idx++; //idx = 0;
                if (ch[i] == '1' && ch[i + 1] == '0') { //1. 만약 숫자 이면서 10점 이라면
                    scores[idx] = 10;
                    i++; // 10은 두자리를 차지하기 때문에 i를 ++ 해준다.
                } else {
                    scores[idx] = ch[i] - '0'; //1. 만약 숫자 이면서 0~9점 이라면 숫자로 치환해 넣어준다.
                }
            }
            //2. 만약 문자라면
            else {
                switch (ch[i]) {
                    case 'S': // 'S'일 때는 아무 작업도 하지 않는다.
                        break;
                    case 'D': // 'D'일 때는 현재 숫자를 제곱근
                        scores[idx] = (int) Math.pow(scores[idx], 2);
                        break;
                    case 'T': // 'T'일 때는 현재 숫자를 세 제곱근
                        scores[idx] = (int) Math.pow(scores[idx], 3);
                        break;
                    case '*': // '*'일 때는 현재 숫자에 2를 곱하고
                        scores[idx] *= 2;
                        if (idx > 0) { //현재 보다 앞 라운드가 있을 때만
                            scores[idx - 1] *= 2; //앞 라운드 점수도 2를 곱한다.
                        }
                        break;
                    case '#': // '#' 일때는
                        scores[idx] *= -1; //현재 점수를 음수로 만든다.
                        break;
                }
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}