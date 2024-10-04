module lumen.blackjackfx {
    requires transitive javafx.controls;
    requires javafx.fxml;

    requires core.fx;

    opens dev.lumen to javafx.fxml;
    exports dev.lumen;
}
