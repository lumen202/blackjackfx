package dev.lumen.app.models.cards.hand.ruleset;

import dev.lumen.app.models.cards.hand.Hand;
import dev.lumen.app.models.cards.Card;

public class BlackjackRuleSet extends Hand {

    @Override
    protected int calculate() {
        int value = stream().mapToInt(card -> {
            int v = card.getValue().toInt();
            return v > 10 ? 10 : v;
        }).sum();

        boolean hasAce = stream().anyMatch(card -> card.getValue() == Card.Value.ACE);

        if (hasAce && ((value + 10) <= 21))
            value += 10;
        return value;
    }

}
