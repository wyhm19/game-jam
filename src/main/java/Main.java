
import zero.Color;
import zero.GameApp;
import zero.ui.Button;
import zero.ui.Column;
import zero.ui.Label;
import zero.ui.Row;

public class Main extends GameApp {

    private int number;
    private int guess = 0;
    private boolean done;
    private Label inputDisplay;
    private Label result;

    @Override public void settings() {
        padding(10);
        size(640, 460);
    }

    @Override public void setup() {
        Label title = new Label("NUMBER GUESSING GAME");
        Label question = new Label("Guess a number between 1 and 100!");

        inputDisplay = new Label("Enter your guess:");
        result = new Label("");

        Label hints = new Label(
            "HINTS: Guess between 1 and 100. Keep trying until you get it right!"
        );

        Button one = makeButton("1", 1);
        Button two = makeButton("2", 2);
        Button three = makeButton("3", 3);

        Button four = makeButton("4", 4);
        Button five = makeButton("5", 5);
        Button six = makeButton("6", 6);

        Button seven = makeButton("7", 7);
        Button eight = makeButton("8", 8);
        Button nine = makeButton("9", 9);

        Button zero = makeButton("0", 0);

        Button clear = new Button("Clear");
        clear.onClick(() -> {
            guess = 0;
            inputDisplay.setText("Enter your guess:");
        });

        Button submit = new Button("Submit Guess");
        submit.onClick(() -> {
            if (done) return;

            if (guess < 1 || guess > 100) {
                result.setText("Enter a number from 1 to 100!");
            }
            else if (guess > number) {
                result.setText("Too high! Try again.");
            }
            else if (guess < number) {
                result.setText("Too low! Try again.");
            }
            else {
                result.setText("Correct! You win!");
                done = true;
            }

            guess = 0;
            inputDisplay.setText("Enter your guess:");
        });

        Button restart = new Button("Restart Game");
        restart.onClick(() -> restart());

        controls(new Column(8,
            title,
            question,
            inputDisplay,
            new Row(8, one, two, three, four, five),
            new Row(8, six, seven, eight, nine, zero, clear),
            submit,
            restart,
            result,
            hints
        ));

        restart();
    }

    private Button makeButton(String text, int digit) {
        Button button = new Button(text);

        button.onClick(() -> {
            if (!done) {
                guess = guess * 10 + digit;
                inputDisplay.setText("Your guess: " + guess);
            }
        });

        return button;
    }

    public void restart() {
        number = (int) (Math.random() * 100) + 1;

        guess = 0;
        done = false;

        inputDisplay.setText("Enter your guess:");
        result.setText("");

        showGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
