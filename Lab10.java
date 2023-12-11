//import java.util.Random;
import java.util.Scanner;

public class Lab10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() 
    {
        while (true)
        {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) 
            {
                return;
            }

            if (input.equals("square")) 
            {
                double s; //changed variable name from a to s for Square.
                System.out.println("Enter the length of side a: ");
                s = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the square is: " + s * 4);
                System.out.println("The area of the square is: " + s * s);

            } else if (input.equals("rectangle")) 
            {
                double rl, rw; //changed variable name from a to rl for Rectangle Length. and b to rw for Rectangle Width.
                System.out.println("Enter the length of the rectangle: "); //changed text to say length of rectangle
                rl = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the width of the rectangle: ");//changed text to say width of rectangle
                rw = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the rectangle is: " + (2 * rl + 2 * rw));
                System.out.println("The area of the rectangle is: " + (rl * rw));
            } 
            else if (input.equals("circle")) 
            {//moved this final else if on its own line to make the code more readable
                double c; //changed variable name from r to c for Circle.
                System.out.println("Enter the radius: ");
                c = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the circle is: " + (Math.PI * c * 2));
                System.out.println("The area of the circle is: " + (Math.PI * c * c));
            }
        }
    }
public static void Q2() {
        System.out.println("Q2: Enter the current day (1-31): ");
        int num = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the current month: (1-12)");
        int num2 = Integer.parseInt(scan.nextLine());

        if (num == 1)
            System.out.print("You selected 1st of ");
        else if (num == 2)
            System.out.print("You selected 2nd of ");
        else if (num == 3)
            System.out.print("You selected 3rd of ");
        else if (num >=4 && num >=20)
            System.out.print("You selected " + num + "th of "); //condenced all numbers that have th in one else if statement
        else if (num == 21)
            System.out.print("You selected 21st of ");
        else if (num == 22)
            System.out.print("You selected 22nd of ");
        else if (num == 23)
            System.out.print("You selected 23rd of ");
        else if (num >=24 && num >=30)
            System.out.print("You selected " + num +"th of "); //condenced all numbers that have th in one else if statement
        else if (num == 31)
            System.out.print("You selected 31st of ");
        else {
            System.out.println("Invalid day");
        }


        switch(num2) //changed all if and if else into a switch
        {
            case 1:System.out.println("January");break;
            case 2:System.out.println("February");break;
            case 3:System.out.println("March");break;
            case 4:System.out.println("April");break;
            case 5:System.out.println("May");break;
            case 6:System.out.println("June");break;
            case 7:System.out.println("July");break;
            case 8:System.out.println("Augst");break;
            case 9:System.out.println("September");break;
            case 10:System.out.println("October");break;
            case 11:System.out.println("November");break;
            case 12:System.out.println("December");break;
            default: System.out.println("Invalid month");
        }
    }

public static void Q3() {
    System.out.println("Q3: Enter how many numbers you want to check for primality: ");
    int n = Integer.parseInt(scan.nextLine());
    int counter = 0;
    for (int i = 0; i < n; i++) 
    {
    //removed if (i < 2)
    //continue;
    //boolean check = true;

    for (int j = 2; j * j <= i; j++) 
    {
        if (i % j == 0) 
        {
            check = false;
            break;
        } 
        //removed empty else statement and cleaned up tabing of under the for statement
    }
        if (check == true) 
        {
            counter++;
        } 
        //removed empty else statement
    }

        System.out.println("There are: " + counter + " primes between 0 and " + n);
    }

    public static void Q4() {
        Random rng = new Random();

        String next;
        System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
        System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int turns = 0; //changed variable name from a to turns

        boolean check = false;
        while (true) {

            boolean doAttack = false;
            boolean check2 = false;
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        check = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;
                }
            }

            if (doAttack) {
                turns++;
                int attackRoll = rng.nextInt(20) + 1;
                int damage = 0;
                System.out.print("You rolled: " + attackRoll);
                if(check) {
                    attackRoll += 5;
                    System.out.print(" + 5 (buff active)\n");
                } else {
                    System.out.println();
                }
                if (attackRoll >= 12) {
                    // removed damage = rng.nextInt(8) + 1; as next line does the same
                    damage += rng.nextInt(8) + 1;
                    if(check) {
                        damage += 5;
                    }
                    if (attackRoll == 20 || (check && attackRoll == 20 + 5)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.print("You dealt " + damage + " damage");
                    if(check) {
                        System.out.print(" (buffed attack)");
                    }
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));

                } else {
                    System.out.println("Miss");
                }

                check = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + turns + " turns");
                    scan.close();
                    return;
                }
            }

        }
    }
}


