import java.util.Scanner;

class FeetToYardsAndMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int distanceInFeet;

        System.out.print("Enter distance in feet: ");
        distanceInFeet = input.nextInt();

        double yards = distanceInFeet / 3.0;
        double miles = yards / 1760.0;

        System.out.println("The distance in yards is " + yards +
                           " while the distance in miles is " + miles);
    }
}
