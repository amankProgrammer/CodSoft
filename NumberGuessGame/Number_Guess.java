import java.util.Random;
import java.util.Scanner;

public interface Number_Guess {
    public static void main(String[] args) {
        Random r1 = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Welcome To Number Guess Game *****\nInstruction : 5 rounds game in each round you have 3 chances to guess a number right.");
        int count = 0;
        
        for(int i = 1; i<=5; i++){
            System.out.println("\n******** Round "+ i + " *********\n");
            int x = r1.nextInt(100);
            for(int j = 1; j<=3; j++){
                System.out.print("Guess a number between 1 to 100 : ");
                int guess = sc.nextInt();
                if(guess == x){
                    System.out.println("\n   Congratulation !!! Your Guess is Correct !!!");
                    count = count + 1;
                    break;
                }else if (x - guess <= 10 && x - guess > 0){
                    System.out.println("  Ooops !!! low but too close !!!");
                }else if (x-guess >= -10 && x-guess < 0) {
                    System.out.println("  Ooops !!! high but too close !!!");
                }else if(guess>x){
                    System.out.println("  Ooops !!! Too High !!!");
                }else{
                    System.out.println("  Ooops !!! Too Low !!!");
                }
                if(j<3){
                    System.out.println("\nPlease try again!!! Now you have " + (3-j) + " Chances left\n");
                }else{
                    System.out.println("----- Game Over ------");
                    System.out.println("\nThe correct number is : " + x);
                }              
            }
        }
        System.out.println("*************************************");
        System.out.println("*   Score : " + count + " times win out of 5.   *");
        System.out.println("\n*************************************");


        sc.close();
    }
}
