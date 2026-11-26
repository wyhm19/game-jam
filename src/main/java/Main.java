
import zero.Color;
import zero.GameApp;
import zero.Key;
import zero.ui.Button;
import zero.ui.Column;
import zero.ui.Label;
import zero.ui.Row;

public class Main extends GameApp
{
    private int number = (int)(Math.random() * 100) + 1;
    private String guessText = "";

    private Label inputDisplay;
    private Label result;
    private Button submit;

    public void setup()
    {
        Label title = new Label("NUMBER GUESSING GAME");

        Label question = new Label("Guess a number between 1 and 100!");

        inputDisplay = new Label("Enter your guess:");

        submit = new Button("Submit Guess");

        Button restart = new Button("Restart Game");

        result = new Label("");

        Label hints = new Label(
            "HINTS:\n- The number is between 1 and 100.\n- Keep guessing until you get it right!"
        );

        // Number buttons
        Button one = makeButton("1");
        Button two = makeButton("2");
        Button three = makeButton("3");

        Button four = makeButton("4");
        Button five = makeButton("5");
        Button six = makeButton("6");

        Button seven = makeButton("7");
        Button eight = makeButton("8");
        Button nine = makeButton("9");

        Button zero = makeButton("0");

        Button clear = new Button("Clear");

        clear.onClick(() ->
        {
            guessText = "";
            inputDisplay.setText("Enter your guess:");
        });

        submit.onClick(() ->
        {
            try
            {
                int guess = Integer.parseInt(guessText);

                if (guess > number)
                {
                    result.setText("Too high! Try again.");
                }
                else if (guess < number)
                {
                    result.setText("Too low! Try again.");
                }
                else
                {
                    result.setText("Correct! You win!");
                    submit.setEnabled(false);
                }

                guessText = "";
                inputDisplay.setText("Enter your guess:");
            }
            catch (NumberFormatException ex)
            {
                result.setText("Please enter a valid number!");
            }
        });

        restart.onClick(() ->
        {
            number = (int)(Math.random() * 100) + 1;

            guessText = "";
            inputDisplay.setText("Enter your guess:");

            result.setText("");
            submit.setEnabled(true);
        });

        Column layout = new Column(15,
            title,
            question,
            inputDisplay,

            new Row(10, one, two, three),
            new Row(10, four, five, six),
            new Row(10, seven, eight, nine),
            new Row(10, zero, clear),

            submit,
            restart,
            result,
            hints
        );

        show(layout);
    }

    private Button makeButton(String digit)
    {
        Button button = new Button(digit);

        button.onClick(() ->
        {
            guessText += digit;
            inputDisplay.setText(guessText);
        });

        return button;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
