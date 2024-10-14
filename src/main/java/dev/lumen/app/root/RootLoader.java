package dev.lumen.app.root;

import java.io.IOException;

import dev.sol.core.view.FXView;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RootLoader extends FXView {
    public void load(Scene scene) {
        try {
            Parent root = loader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
