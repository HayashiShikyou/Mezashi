package app.jlpt.mezashi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InputTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage st) throws Exception {
        FXMLLoader root = new FXMLLoader(InputTest.class.getResource("InputTest.fxml"));
        Scene sc = new Scene(root.load());
        st.setScene(sc);
        st.setTitle("TextInput");
        st.show();
    }
}
