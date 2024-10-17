module lumen.blackjackfx {
    requires transitive javafx.controls;

    requires javafx.base;
    requires javafx.fxml;
    requires core.fx;
    requires javafx.graphics;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires org.kordamp.ikonli.materialdesign;
    requires atlantafx.base;

    opens dev.lumen to javafx.fxml;
    opens dev.lumen.app.root to javafx.fxml;
    opens dev.lumen.app.board to javafx.fxml;

    exports dev.lumen;
    exports dev.lumen.app.root;
    exports dev.lumen.app.board;
}
