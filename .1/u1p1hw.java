import java.util.Scanner;

public class u1p1hw {
  public static void main(String[] args) {
      System.out.println("I am a CIMP student");

      double height = 12;
      double width = 7.25;
      Math.pow(height, width);
      System.out.println("The area of the rectangle is: " + (height * width));

      double radius = 5.5;
      double circleArea = 3.14159 * Math.pow(radius, 2);

      radius = 5.5;
      double circleCircumference = 2 * 3.14159 * radius;
      System.out.println("The circumference of the circle is: " + circleCircumference);

      System.out.println("Type your age: ");
      Scanner ageInput = new Scanner(System.in);
      int age = ageInput.nextInt();
      System.out.println("You are " + age + " years old.");

      System.out.println("Type your current age: ");
        Scanner currentAgeInput = new Scanner(System.in);
        int currentAge = currentAgeInput.nextInt();
        int nextyearage = currentAge + 1;
        System.out.println("Next year you will be " + nextyearage + " years old.");

        int howmanyyearsfrom2077 = 2077 - 2026;
        int agein2077 = currentAge + howmanyyearsfrom2077;
        System.out.println("In 2077 you will be " + agein2077 + " years old.");

        System.out.println(240 / 8);
        System.out.println(19 / 3);
        System.out.println(188 % 9);
        System.out.println(9 % 9);
        System.out.println(5 + 8.0 / 3.0);
        System.out.println(3 + (4 * (2 + 2)) % 6 );
        System.out.println(4 - 5 * 2 % 4 / 1 );
        System.out.println(4 / (-9));
        System.out.println(3 % 4);

  }
}
