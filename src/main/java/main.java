import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int number = (int)(Math.random() * 100) + 1;
        int guess = 0;

        System.out.println("Guess a number between 1 and 100!");

        while (guess != number)
        {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();

            if (guess > number)
            {
                System.out.println("Too high! Try again.");
            }
            else if (guess < number)
            {
                System.out.println("Too low! Try again.");
            }
            else
            {
                System.out.println("Correct! You win!");
            }
        }
    }
}