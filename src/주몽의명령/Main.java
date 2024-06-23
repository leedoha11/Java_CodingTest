package 주몽의명령;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //재료의 개수
        int M = sc.nextInt(); //갑옷이 완성되는 번호의 값

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt(); //재료들
        }

        //값을 정렬하면 더욱 쉽게 풀 수 있다 => 오름차순으로 가면서 비교할 수 있음
        Arrays.sort(arr);

        int i = 0; //시작하는 인덱스
        int j = N - 1;  //끝부터 오는 인덱스
        int count = 0; //만들어지는 갑옷의 개수
        while(i < j){
            if(arr[i] + arr[j] < M){
                i++; //수를 늘리자
            } else if(arr[i] + arr[j] > M){
                j--; //수를 줄이자
            } else { //만약 같다면
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
