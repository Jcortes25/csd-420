import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplayApp extends Application {

    private static final int NUM_CARDS = 52;
    private static final int CARDS_TO_DISPLAY = 4;
    private static final String CARD_DIR = "cards";

    private HBox cardBox = new HBox(10);

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        cardBox.setSpacing(10);

        // Refresh button
        Button refreshButton = new Button("Refresh");

        // Lambda expression for refresh button action
        refreshButton.setOnAction(e -> showRandomCards());

        // Initial display
        showRandomCards();

        root.getChildren().addAll(cardBox, refreshButton);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showRandomCards() {
        cardBox.getChildren().clear();

        // Create a list of card numbers from 1 to 52
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            cardNumbers.add(i);
        }

        // Shuffle and select the first four
        Collections.shuffle(cardNumbers);
        List<Integer> selectedCards = cardNumbers.subList(0, CARDS_TO_DISPLAY);

        // Load and display images
        for (int cardNum : selectedCards) {
            File imageFile = new File(CARD_DIR + "/" + cardNum + ".png");
            Image image = new Image(imageFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);
            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
