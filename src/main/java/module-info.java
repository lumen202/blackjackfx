module lumen.blackjackfx {
    requires transitive javafx.controls;
    requires javafx.fxml;

    requires core.fx;
    requires javafx.graphics;

    opens dev.lumen to javafx.fxml;
    opens dev.lumen.app.root to javafx.fxml;
    opens dev.lumen.app.board to javfx.fxml;


    exports dev.lumen;
    exports dev.lumen.app.root;
    exports dev.lumen.app.board;
}
