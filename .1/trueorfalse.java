public class trueorfalse {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 2;
        boolean isGreater = num1 > num2;
        System.out.println("Is " + num1 + " greater than " + num2 + "? " + isGreater);
        int num3 = 11;
        int num4 = 9;
        int num5 = 1;
        int num6 = 2;
        boolean isGreater2 = num3 < num4;
        boolean isGreater3 = num5 < num6;
        boolean onetrue = isGreater2 || isGreater3;
        System.out.println("Is " + num3 + " less than " + num4 + "? " + isGreater2);
    }
}
