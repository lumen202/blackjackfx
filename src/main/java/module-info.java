module lumen.blackjackfx {
    requires transitive javafx.controls;
    requires javafx.fxml;

    requires core.fx;
    requires javafx.graphics;

    opens dev.lumen to javafx.fxml;

    exports dev.lumen;
    exports dev.lumen.app.root;
}
