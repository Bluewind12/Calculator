import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * GuiMain
 */
public class GuiMain extends Application {

    double alpha = 0;
    double beta = 0;
    String state = "";
    public static Text Anstext = new Text("");

    public void start(Stage stage) throws Exception {
        stage.setTitle("Five philosophers");
        stage.setWidth(750);
        stage.setHeight(500);
        VBox vBox = new VBox(10);
        GridPane gridpane = new GridPane();

        Button[] numbutton = { new Button("0"), new Button("1"), new Button("2"), new Button("3"), new Button("4"),
                new Button("5"), new Button("6"), new Button("7"), new Button("8"), new Button("9") };

        Button plusButton = new Button("+");
        plusButton.setPrefSize(50, 50);
        plusButton.setOnAction(event -> SetState("Puls"));
        GridPane.setConstraints(plusButton, 2, 3);

        Button minusButton = new Button("-");
        minusButton.setPrefSize(50, 50);
        minusButton.setOnAction(event -> SetState("Minus"));
        GridPane.setConstraints(minusButton, 3, 2);

        Button multiButton = new Button("~");
        multiButton.setPrefSize(50, 50);
        multiButton.setOnAction(event -> SetState("Mul"));
        GridPane.setConstraints(multiButton, 3, 1);

        Button divButton = new Button("€");
        divButton.setPrefSize(50, 50);
        divButton.setOnAction(event -> SetState("Div"));
        GridPane.setConstraints(divButton, 3, 0);

        Button equalButton = new Button("=");
        equalButton.setPrefSize(50, 50);
        equalButton.setOnAction(event -> SetState(""));
        GridPane.setConstraints(equalButton, 1, 3);

        Button cButton = new Button("C");
        cButton.setPrefSize(50, 50);
        cButton.setOnAction(event -> Cls());
        GridPane.setConstraints(cButton, 3, 3);

        for (int i = 0; i < numbutton.length; i++) {
            numbutton[i].setPrefSize(50, 50);
        }
        numbutton[0].setOnAction(event -> Push(beta, 0));
        GridPane.setConstraints(numbutton[0], 0, 3);

        numbutton[1].setOnAction(event -> Push(beta, 1));
        GridPane.setConstraints(numbutton[1], 0, 2);

        numbutton[2].setOnAction(event -> Push(beta, 2));
        GridPane.setConstraints(numbutton[2], 1, 2);

        numbutton[3].setOnAction(event -> Push(beta, 3));
        GridPane.setConstraints(numbutton[3], 2, 2);

        numbutton[4].setOnAction(event -> Push(beta, 4));
        GridPane.setConstraints(numbutton[4], 0, 1);

        numbutton[5].setOnAction(event -> Push(beta, 5));
        GridPane.setConstraints(numbutton[5], 1, 1);

        numbutton[6].setOnAction(event -> Push(beta, 6));
        GridPane.setConstraints(numbutton[6], 2, 1);

        numbutton[7].setOnAction(event -> Push(beta, 7));
        GridPane.setConstraints(numbutton[7], 0, 0);

        numbutton[8].setOnAction(event -> Push(beta, 8));
        GridPane.setConstraints(numbutton[8], 1, 0);

        numbutton[9].setOnAction(event -> Push(beta, 9));
        GridPane.setConstraints(numbutton[9], 2, 0);

        for (int i = 0; i < numbutton.length; i++) {
            gridpane.getChildren().add(numbutton[i]);
        }

        gridpane.getChildren().addAll(cButton, plusButton, minusButton, multiButton, divButton, equalButton);

        vBox.getChildren().addAll(Anstext, gridpane);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    void SetState(String s) {
        switch (state) {
        case "Puls":
            alpha = alpha + beta;
            break;

        case "Minus":
            alpha = alpha - beta;
            break;

        case "Mul":
            alpha = alpha * beta;
            break;

        case "Div":
            alpha = alpha / beta;
            break;

        case "":
            alpha = beta;
            break;
        }
        state = s;
        Anstext.setText(String.valueOf(alpha));
        beta = 0;
    }

    void Push(double ent, int num) {
        beta = ent * 10 + num;
        Anstext.setText(String.valueOf(beta));
    }

    void Cls() {
        Anstext.setText(String.valueOf(beta));
        alpha = 0.0;
        beta = 0.0;
        state = "";
    }
}