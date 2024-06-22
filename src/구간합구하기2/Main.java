package 구간합구하기2;

//백준 11660
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        int N = sc.nextInt(); // 2차원 배열의 크기
        int M = sc.nextInt(); // 구간 합 질의의 개수

        // 원본 배열과 누적 합 배열 선언
        int[][] arr = new int[N + 1][N + 1];
        int[][] sumArr = new int[N + 1][N + 1];

        // 원본 배열 입력받기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 누적 합 배열 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumArr[i][j] = arr[i][j] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
            }
        }

        // 질의 처리
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int result = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        // 결과 출력
        sc.close();
        System.out.print(sb);
    }
}