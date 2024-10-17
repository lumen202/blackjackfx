package dev.lumen.app.board;

import dev.lumen.app.models.cards.Card;
import dev.lumen.app.models.cards.Deck;
import dev.lumen.app.models.cards.Card.Face;
import dev.lumen.app.models.cards.hand.Hand;
import dev.lumen.app.models.cards.hand.ruleset.BlackjackRuleSet;
import dev.sol.base.collections.FXObservableMappedList;
import dev.sol.core.controller.FXController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BoardController extends FXController {

    @FXML
    private StackPane deckContainer;

    @FXML
    private Button startButton;
    @FXML
    private VBox buttonContainer;

    @FXML
    private VBox playerHandInfoContainer;

    @FXML
    private VBox bankerHandInfoContainer;

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

    private Deck deck;
    private Hand player;
    private Hand banker;
    private BooleanProperty started;

    FXObservableMappedList<Card, Node> playerHandInfoDisplay;

    FXObservableMappedList<Card, Node> bankerHandInfoDisplay;

    @Override
    protected void load_fields() {
        deck = new Deck(135);
        deck.shuffle();

        player = new BlackjackRuleSet();
        player.add(deck.deal(Face.UP));
        player.add(deck.deal(Face.UP));


        banker = new BlackjackRuleSet();
        banker.add(deck.deal(Face.UP));
        banker.addAll(deck.deal());

        playerHandInfoDisplay = new FXObservableMappedList<>(player, card -> {
            Label label = card.labelDisplay();

            StackPane pane = new StackPane(label);
            StackPane.setAlignment(label, Pos.CENTER_RIGHT);

            return pane;
        });

        bankerHandInfoDisplay = new FXObservableMappedList<>(banker, card -> {
            Label label = card.labelDisplay();

            StackPane pane = new StackPane(label);
            StackPane.setAlignment(label, Pos.CENTER_RIGHT);

            return pane;
        });

        started = new SimpleBooleanProperty();
    }

    @Override
    protected void load_bindings() {
        Bindings.bindContent(deckContainer.getChildren(), deck);
        Bindings.bindContent(playerHandInfoContainer.getChildren(), playerHandInfoDisplay);
        Bindings.bindContent(bankerHandInfoContainer.getChildren(), bankerHandInfoDisplay);
    }

    @Override
    protected void load_listeners() {
        startButton.disableProperty().bind(started);
        buttonContainer.disableProperty().bind(started.not());

    }

}
