package dev.lumen.app.board;

import dev.lumen.app.models.cards.Deck;
import dev.sol.core.controller.FXController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BoardController extends FXController {

    @FXML
    private StackPane deckContainer;

    @FXML
    private Button startButton;
    @FXML
    private VBox buttonContainer;

    private Deck deck;
    private BooleanProperty started;

    @Override

    protected void load_fields() {
        deck = new Deck(135);
        started = new SimpleBooleanProperty();
    }

    @FXML
    private void handleStart() {
        started.set(true);
    };

    @FXML
    private void handleHit() {
    };

    @FXML
    private void handleStand() {
    };

    @Override
    protected void load_bindings() {
        Bindings.bindContent(deckContainer.getChildren(), deck);
    }

    @Override
    protected void load_listeners() {
        startButton.disableProperty().bind(started);
        buttonContainer.disableProperty().bind(started.not());
    }

}
