package 문자열과배열.주사위게임3;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] count = new int[7]; // 1~6까지 인덱스 쓸거니까 크기를 7로(0은 안쓸거)

        // a, b, c, d를 인덱스로 생각하고 수를 더해서 개수를 세어줌
        count[a]++;
        count[b]++;
        count[c]++;
        count[d]++;

        int p = 0, q = 0, r = 0; // p, q, r 초기화

        //여기서는 수의 경우의 수를 나눠줌
        for(int i = 1; i < count.length; i++) { // 1부터 6까지 반복
            if(count[i] == 4) { // 같은 숫자가 4개라면
                return 1111 * i; // 1111 * 숫자
            } else if(count[i] == 3) { // 같은 숫자가 3개라면
                p = i; // p를 일단 그 숫자로 설정
            } else if(count[i] == 2) { // 같은 숫자가 2개인데
                if (p == 0) { // p가 아직 설정 되지 않았다면 (1번째 2개인 수)
                    p = i; // p를 그 숫자로 설정
                } else {
                    q = i; //p가 설정되어 있다면 q가 2개 똑같은 수임 (2번째 2개인 수)
                }
            } else if(count[i] == 1) { // 해당 숫자가 1개인데
                if (p == 0) { // p가 없다면
                    p = i; // p를 1개인 숫자로 설정
                } else if (q == 0) { //
                    q = i; // q를 그 숫자로 설정
                } else {
                    r = i; // r을 그 숫자로 설정
                } //이 반복문을 다 돌게 되면 각 숫자가 다 다른 것임.
            }
        }

        // 조건에 따른 점수 계산
        for(int i = 1; i < count.length; i++) { // 1부터 6까지 반복
            if(count[i] == 3) { // 같은 숫자가 3개인데
                for(int j = 1; j < count.length; j++) { // 다시 1부터 6까지 반복
                    if(count[j] == 1) { // 다른 숫자가 1개라면
                        return (int)Math.pow((10 * i + j), 2); // (10 * p + q)^2 계산
                    }
                }
            } else if(count[i] == 2) { // 같은 숫자가 2개인데
                for(int j = i + 1; j < count.length; j++) { // i 이후 숫자에서 찾기
                    if(count[j] == 2) { // 같은 숫자가 2개라면
                        return (i + j) * Math.abs(i - j); // (p + q) * |p - q| 계산
                    }
                }
                for(int j = 1; j < count.length; j++) { // 1부터 6까지 반복
                    if(count[j] == 1) { // 다른 숫자가 1개인데
                        for(int k = j + 1; k < count.length; k++) { // j 이후 숫자에서 찾기
                            if(count[k] == 1) { // 또 다른 숫자가 1개라면 (이미 위에서 걸러짐)
                                return j * k; // q * r 계산
                            }
                        }
                    }
                }
            }
        }

        // 네 주사위 수가 다 다르다면 가장 작은 수를 return하는 경우를 여기서 해줌
        for(int i = 1; i < count.length; i++) {
            if(count[i] == 1) {
                return i; // 가장 작은 숫자 반환
            }
        }

        return 0; //실행 X
    }
}