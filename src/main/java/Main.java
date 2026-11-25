
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    private int number = (int)(Math.random() * 100) + 1;

    public void start(Stage stage)
    {
        Label title = new Label("NUMBER GUESSING GAME");

        Label question = new Label("Guess a number between 1 and 100!");

        TextField input = new TextField();
        input.setPromptText("Enter your guess");

        Button submit = new Button("Submit Guess");

        Button restart = new Button("Restart Game");

        Label result = new Label("");

        Label hints = new Label(
            "HINTS:\n- The number is between 1 and 100.\n- Keep guessing until you get it right!"
        );

        submit.setOnAction(e ->
        {
            try
            {
                int guess = Integer.parseInt(input.getText());

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
                    submit.setDisable(true);
                }

                input.clear();
            }
            catch (NumberFormatException ex)
            {
                result.setText("Please enter a valid number!");
            }
        });

        restart.setOnAction(e ->
        {
            number = (int)(Math.random() * 100) + 1;

            input.clear();
            result.setText("");

            submit.setDisable(false);
        });

        VBox layout = new VBox(15);

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
            title,
            question,
            input,
            submit,
            restart,
            result,
            hints
        );

        Scene scene = new Scene(layout, 400, 450);

        stage.setTitle("Number Guessing Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
