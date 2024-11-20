module app.jlpt.mezashi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens app.jlpt.mezashi to javafx.fxml;
    exports app.jlpt.mezashi;
    exports app.jlpt.mezashi.controller;
    opens app.jlpt.mezashi.controller to javafx.fxml;
}