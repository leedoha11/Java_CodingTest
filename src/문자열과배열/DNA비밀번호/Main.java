package 문자열과배열.DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[];  //각 문자가 필요한 최소 개수를 저장하는 배열
    static int myArr[];     //현재 부분 문자열에서 각 문자의 개수를 저장하는 배열
    static int checkSecret; //필요한 개수를 만족하는 문자의 개수를 저장하는 변수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());   //전체 문자열 크기
        int P = Integer.parseInt(st.nextToken());   //부분 문자열의 크기
        int Result = 0; //조건에 충족하는 비밀번호 개수 (DNA 비밀번호)

        char A[] = new char[5];
        checkArr = new int[4];  //조건 A, C, G, T의 개수
        myArr = new int[4]; //현재 A C G T 의 개수
        checkSecret = 0;

        A = bf.readLine().toCharArray();    //DNA 문자열을 입력받아서 'A'배열에 저장
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); //각 문자의 최소 개수를 저장
            if(checkArr[i] == 0)    //만약 최소 개수가 0이면
                checkSecret++;      //checkSecret 증가 (이건 이미 확인한거라 안해도 되니까)
        }

        for(int i = 0; i < P; i++){    //초기 부분 문자열의 첫 'P' 문자를 Add 메서드로 처리
            Add(A[i]);                 //P의 길이만큼 각 문자열 요소가 조건에 맞는지 판별?
        }
        if(checkSecret == 4)    //checkSecret 값이 4라면 모든 조건을 만족하는 경우니까 Result++
            Result++;   //처음 문자열에서 조건 맞는지 확인하는 것.

        for(int i = P; i < S; i++){ //슬라이딩 윈도우 : 이전 문자를 제거하고(Remove) 새로운 문자를 추가(Add)
            int j = i - P; //현재 문자열에서 가장 앞 char
            Add(A[i]); //뒤 문자 추가
            Remove(A[j]);   //앞 문자 제거
            if(checkSecret == 4) //4이면 모든 조건을 만족하는 경우니까 Result++
                Result++;
        }
        System.out.println(Result);
        bf.close();
    }

    //문자 더하기 함수
    private static void Add(char c){ //새로운 문자를 myArr에 추가하고, 해당 문자의 개수가 checkArr에 저장된 개수와
        switch (c) {                //같아지면 checkSecret 값을 증가
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    //문자 빼기 함수
    private static void Remove(char c) { //제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
