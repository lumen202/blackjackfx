package dev.lumen.app.board;

import dev.lumen.app.models.cards.Deck;
import dev.sol.core.controller.FXController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class BoardController extends FXController {

    @FXML
    private StackPane deckContainer;

    private Deck deck;

    @Override

    protected void load_fields() {
        deck = new Deck();
    }

    @Override
    protected void load_bindings() {
    }

    @Override
    protected void load_listeners() {
    }

}
