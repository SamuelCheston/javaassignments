import java.util.Scanner; 
public class L04_P02_Runtime { 
 public static void main(String[] args) { 
 Scanner input = new Scanner(System.in); 
 String name; 
 int num, special; 
 
 System.out.print("Enter your name: "); 
 name = input.nextLine(); 
 
 System.out.print("Enter an integer number: "); 
 num = input.nextInt(); 
 
 special = num - 10; 
 System.out.printf("%5s\n%12d\n;13d\\%5d:\n", name, 9 / num, special); 
 System.out.printf("\n%" + (num % 3) + "f\n", 10.234); 
 } 
}
