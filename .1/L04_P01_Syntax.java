import java.util.Scanner; 
public class L04_P01_Syntax {
 public static void main(String[] args) { 
 Scanner input = new Scanner(System.in); 
 int age; 
 String name; 
 
 System.out.println("Enter Name"); 
 name = input.nextLine(); 
 
 System.out.print("Enter Age"); 
 age = input.nextInt(); 
 
 System.out.println("Hi " + name + ". You are " + age + " years old"); 
 } 
}