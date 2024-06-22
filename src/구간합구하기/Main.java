package 구간합구하기;

import java.util.Scanner;

//백준 11659
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //배열의 크기
        int M = sc.nextInt(); //질의 개수

        //합 배열을 구하기 위한 배열
        int[] sumArray = new int[N + 1];
        for (int i = 1; i <= N; i++) { //1~N 만큼 반복문을 돌면서
            sumArray[i] = sumArray[i - 1] + sc.nextInt(); //합 배열에 이전 값과 현재 입력 값을 더해서 저장
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) { //질의 개수 M만큼 반복문 돌리면서
            int i = sc.nextInt(); //구간 합의 시작 index : i
            int j = sc.nextInt(); //구간 합의 끝 index : j
            //구간 합 구해서 sb에 추가
            sb.append(sumArray[j] - sumArray[i - 1]).append("\n");
        }
        sc.close();
        System.out.print(sb);
    }
}