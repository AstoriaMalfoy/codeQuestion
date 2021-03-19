package luoguoQuestion.Q1035;

<<<<<<< HEAD
=======

>>>>>>> 9de204fb1f4460be8c3acbb4beb97228375df97d
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
        int k = scanner.nextInt();
        double  sum = 0;
        int result = 1;
        while(sum < k){
            sum += 1L/(double)result;
            result++;
        }
        System.out.println(result-1);
=======
        int number = scanner.nextInt();
        double sum = 0;
        int result = 0;
        for(double i=1; sum <= number ; ++i){
            sum += 1D/i;
            result++;
        }
        System.out.println(result);

>>>>>>> 9de204fb1f4460be8c3acbb4beb97228375df97d
    }
}
