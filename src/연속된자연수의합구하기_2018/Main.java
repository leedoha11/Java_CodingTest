package 연속된자연수의합구하기_2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index != N){
            if(sum == N){
                count++;
                end_index++;
            }
        }
    }
}
