public class l12p1refvar {
    public static void main(String[] args) {
        Container blue = new Container(5);
        Container red = new Container(10);
        Container yellow = new Container(15);
        blue.data = 20;
        // red = blue;
        // yellow = red;
        yellow.data = 25;
        System.out.println(blue.data + " " + red.data + " " + yellow.data);
    }
}
