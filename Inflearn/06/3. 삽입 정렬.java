import java.util.Scanner;

public class Main3 {

    public static int[] solution(int n, int[] arr) {

        int[] answer;
        for(int i=1; i<n; i++) {
            int tmp = arr[i];
            int j;
            for(j=i-1; j>=0; j--) {
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j];  // 한칸 뒤로 밀림
                } else break;
            }
            arr[j+1] = tmp;
        }

        answer = arr;

        return answer;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();


        for(int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

}