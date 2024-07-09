package 문자열과배열.대소문자바꿔서출력하기;

public class Solution {
    public String solution(String str){
        //문자열을 이어줄 StringBuilder 생성
        StringBuilder sb = new StringBuilder();

        //문자열이 끝날때 까지 반복문을 돌리면서
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) { //char c가 대문자라면
                sb.append(Character.toLowerCase(c)); //소문자로 바꿔서 더하기
            } else if (Character.isLowerCase(c)) {  //char c가 소문자라면
                sb.append(Character.toUpperCase(c)); //대문자로 바꿔서 더하기
            }
        }
        //return이 String형이니까 문자열로 바꿔서 보내기
        return sb.toString();
    }
}
