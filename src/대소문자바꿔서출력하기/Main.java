package 대소문자바꿔서출력하기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Solution s = new Solution();
        System.out.println(s.solution(str));

    }
}
