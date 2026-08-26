public class L03_P01_Printf { 
 public static void main(String[] args) { 
 char c = 'a'; 
 int num = 12345; 
 double deci = 123.1199; 
 String text = "My name is Kevin"; 
 // #1. Display c right aligned with 2 empty spaces on the leftside 
   System.out.printf("%3c\n", c);
 // #2. Display num left aligned with 1 empty space on the rightside 
   System.out.printf("%-1d\n", num);
 // #3. Display deci right aligned with 2 decimal places and 4 empty spaces on the left side and 
   System.out.printf("%4.2f\n", deci);
 // #4. Display text right aligned with 4 spaces on the leftside 
    System.out.printf("%4s\n", text);
 } 
}
