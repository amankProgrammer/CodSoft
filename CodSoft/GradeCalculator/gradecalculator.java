import java.util.Scanner;
public class gradecalculator {

    static double averagePercent(double totalmarks , int n){
        double percentage = totalmarks / n ;
        return percentage;
    }

    static String grade(double percentage){
        if(percentage>=90){
            return "A+" ;        
        } else if (percentage>=80) {
            return "A";
        } else if (percentage>=70) {
            return "B";
        } else if (percentage>=60){
            return "C";
        } else if (percentage>=50){
            return "D";
        } else if (percentage>=33){
            return "E";
        } else {
            return "Fail";
        }
    }

    static void displayResults(int total_marks,double percentage,String grade){
        System.out.println("Total marks = " + total_marks);
        System.out.println("Average percentage = " + percentage + " % ");
        System.out.println("Grade = " + grade);
    }
    public static void main(String[] args) {
        int n, marks, total_marks = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of subjects : ");
        n = sc.nextInt();

        for(int i = 1;i<=n;i++){
        System.out.print("Enter the marks in subject " + i+ " : ");
        marks = sc.nextInt();
        total_marks += marks;
        }
        sc.close();

        double percentage = averagePercent((double)total_marks,n);
        String grade = grade(percentage);

        displayResults(total_marks,percentage,grade);

    }
}