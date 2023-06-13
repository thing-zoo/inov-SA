import java.util.ArrayList;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
//        1. 랜덤 숫자 만들기
        ArrayList<Integer> number = new ArrayList<>();
        boolean[] check = new boolean[10];
        int n;
        for (int i = 0; i < 3; i++) {
            do {
                n = (int)(Math.random()*10);
            } while(check[n]);
            check[n] = true;
            number.add(n);
        }

//        2. 한자리 숫자에 대해 볼, 스크라이크 판단 하는 부분 구현하기
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        Scanner sc = new Scanner(System.in);
        for (int i = 1;; i++) {
            System.out.print(i + "번째 시도: ");
            int guess = sc.nextInt();

            int s = 0, b = 0;
            for (int j = 2; j >= 0; j--) {
                int a = guess % 10;
                guess /= 10;

                if (number.get(j) == a) {
                    s++;
                } else if (number.contains(a)) {
                    b++;
                }
            }
            //        3. 볼, 스트라이크를 표현하는 부분 구현하기
            if (b == 3) {
                System.out.println("3B");
            } else if (s == 3) {
                //        4. 게임 종료하는 부분 구현하기
                System.out.println("3S");
                System.out.println((i - 1) + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println(b + "B" + s + "S");
            }
        }



    }
}
