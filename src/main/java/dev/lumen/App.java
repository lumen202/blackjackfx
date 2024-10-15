package dev.lumen;

import dev.lumen.app.models.cards.Deck;
import dev.lumen.app.root.RootLoader;
import dev.sol.app.FXApplication;
import dev.sol.core.view.FXLoader;
import dev.sol.theme.FXSkin;

public class App extends FXApplication {

    @Override
    public void initialize() throws Exception {
        // TODO : set application params
        applicationStage.setTitle("Blackjack-FX");
        applicationScene.getStylesheets().add(FXSkin.NORD_LIGHT.getResource().toExternalForm());
        applicationStage.setResizable(false);

        _initialize_root();

    }

    private void _initialize_root() {
        RootLoader loader = (RootLoader) FXLoader
                .createInstance(RootLoader.class, App.class.getResource("/dev/lumen/app/root/ROOT.fxml"))
                .initialize();
        loader.load(applicationScene);

    }

    public static void main(String[] args) {
        launch(args);
        Deck deck = new Deck();
        deck.getCards().forEach(card -> {
            System.out.println(card.display());
        });

    }

}