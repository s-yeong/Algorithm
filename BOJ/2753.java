import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc =new Scanner(System.in);

        int x = sc.nextInt();

        if(x % 4 == 0 && x% 100 != 0) {
            System.out.println(1);
        } else if (x % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}