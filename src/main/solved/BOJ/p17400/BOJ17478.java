import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static String recurTap = "";
    public static void recursive(int n) {
        // 처음에는 여백이 없음.
        String tap = recurTap;

        // 0이 되면 출력하고 재귀 종료
        if(n == 0) {
            System.out.println(tap + "\"재귀함수가 뭔가요?\"");
            System.out.println(tap +"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(tap + "라고 답변하였지.");
            return;
        }
        // 0이 되기 전까지는 재귀 반복
        System.out.println(tap + "\"재귀함수가 뭔가요?\"");
        System.out.println(tap + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(tap + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(tap + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        // 재귀를 들어가기 전에 빈칸 사이즈를 늘려준다.
        recurTap += "____";
        recursive(n - 1);
        // 재귀에서 빠져나오면서 탭이 큰 순서(여백이 많은) 순서 부터 출력된다.
        System.out.println(tap + "라고 답변하였지.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(n);
    }
}
