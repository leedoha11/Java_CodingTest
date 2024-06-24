package 연속된자연수의합구하기_2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; //N이 15일때 숫자 15만 뽑는 경우의 수를 미리 넣고 초기화
        int start_index = 1; //start와 end를 같이 시작함
        int end_index = 1;
        int sum = 1; //index가 숫자 1부터 시작하기 때문에

        while(end_index != N){ //end_index가 N 전일때까지 반복문 돌기
            if(sum == N){      //현재 연속 합이 N과 같은 경우
                count++;
                end_index++;
                sum = sum + end_index;
            } else if(sum > N) {    //sum이 더 크면 수를 하나 줄여야 하니까
                sum = sum - start_index;    //start_index를 추가
                start_index++;
            } else { //sum이 더 작으면
                end_index++; //수를 늘려야 하니까
                sum = sum + end_index;  //end_index를 추가
            }
        }
        System.out.println(count);
    }
}
