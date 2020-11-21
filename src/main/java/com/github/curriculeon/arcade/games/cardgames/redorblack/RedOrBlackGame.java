package com.github.curriculeon.arcade.games.cardgames.redorblack;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;

import java.util.ArrayList;

public class RedOrBlackGame extends AbstractGame<RedOrBlackPlayer> {
    private Card visibleCard;

    @Override
    public void setup() {
        Deck deck = new Deck();
        deck.shuffle();
        this.visibleCard = deck.pop();
        this.winnerList = new ArrayList<>();
    }

    @Override
    public void run() {
        String userInput;
        for (RedOrBlackPlayer player : getPlayerList()) {
            userInput = player.play();
            boolean userInputIsRed = "red".equalsIgnoreCase(userInput);
            boolean userInputIsBlack = "black".equalsIgnoreCase(userInput);
            boolean cardIsRed = getVisibleCard().isRed();
            boolean userIsCorrectAboutRed = cardIsRed && userInputIsRed;
            boolean userIsCorrectAboutBlack = (!cardIsRed) && userInputIsBlack;
            boolean userIsCorrect = userIsCorrectAboutBlack || userIsCorrectAboutRed;

            if (userIsCorrect) {
                getWinnerList().add(player);
            }
        }
    }

    @Override
    public void tearDown() {
        getIOConsole().println("The value of the card was [ %s ]", getVisibleCard().toString());
        getIOConsole().println("The following is a list of the winners:\n[ %s ]", getWinnerList());
    }

    public Card getVisibleCard() {
        return visibleCard;
    }
}
