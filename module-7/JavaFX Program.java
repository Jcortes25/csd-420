import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create four circles
        Circle circle1 = new Circle(50);
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(50);
        Circle circle4 = new Circle(50);

        // Apply style class to circle1 and circle2
        circle1.getStyleClass().add("white-fill-black-stroke");
        circle2.getStyleClass().add("white-fill-black-stroke");

        // Apply style ID to circle3 and circle4
        circle3.setId("red-green");
        circle4.setId("red-green");

        // Add circles to layout
        HBox hbox = new HBox(20, circle1, circle2, circle3, circle4);
        hbox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: lightgray;");

        // Create a scene and attach stylesheet
        Scene scene = new Scene(hbox, 400, 150);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("JavaFX Circle Styling Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
