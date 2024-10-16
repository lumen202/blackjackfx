package dev.lumen.app.board;


import dev.lumen.app.models.cards.Deck;
import dev.sol.core.controller.FXController;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class BoardController extends FXController {

    @FXML
    private StackPane deckContainer;

    private Deck deck;

    @Override

    protected void load_fields() {
        deck = new Deck(135);
    }

    @Override
    protected void load_bindings() {
        Bindings.bindContent(deckContainer.getChildren(), deck);
    }

    @Override
    protected void load_listeners() {
    }

}
