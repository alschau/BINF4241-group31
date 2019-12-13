import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import src.*;

import java.util.ArrayList;

// game Class Test

public class UnoGameTest {

    private int nrOfPlayers;
    private int scoreToWin;
    private player testplayer1;
    private player testplayer2;
    private String[] playerNames;
    private game game;

    @BeforeEach
    public void setup() {
        nrOfPlayers = 2;
        playerNames = new String[nrOfPlayers];
        playerNames[1] = "playertest1";
        playerNames[2] = "playertest2";
        scoreToWin = 20;
        game = new game(nrOfPlayers, playerNames, scoreToWin);
        testplayer1 = new player("Player1");
        testplayer2 = new player("Player2");

    }

    // Test if checkUno method works

    @Test
    public void testCheckUno() {
        card card = new NumberCard("b", 1);
        testplayer1.add_to_hand(card);
        Assert.assertTrue(game.checkUno(testplayer1));
        card card2 = new NumberCard("b", 2);
        testplayer1.add_to_hand(card);
        Assert.assertFalse(game.checkUno(testplayer1));
    }


    // Test if we can make a legal turn

    @Test
    public void testPlayCardIfLegal(){

        card card = new NumberCard("b", 1);
        //check if adding works since a random card is a top at beginning if its not blue that wouldn't always work
        game.add_middlestack(card);
        //check same color and player hasn't got card , different hight and if card got added to playedCards
        Assert.assertFalse(game.checklegalrun("Blue1", testplayer1));
        //check same color and player has card
        card card2 = new NumberCard("b", 2);
        testplayer1.add_to_hand(card2);
        Assert.assertTrue(game.checklegalrun("Blue1", testplayer1));
        //check if Card got played and is therefor not in his hand anymore
        Assert.assertEquals(0, testplayer1.getnr());
        //Different color same height
        card card3 = new NumberCard("r", 2);
        testplayer1.add_to_hand(card3);
        Assert.assertTrue(game.checklegalrun("Red2", testplayer1));
        //Wildcard can be played on anyCard
        card card4 = new WildCard("r", 4);
        testplayer1.add_to_hand(card4);
        Assert.assertTrue(game.checklegalrun("BlackWildDraw4Green", testplayer1));
        //check if testplayer2 draws 4 cards
        Assert.assertEquals(4, testplayer2.getnr());
        //Check wrong color, hight
        card card5 = new NumberCard("r", 2);
        testplayer1.add_to_hand(card5);
        Assert.assertFalse(game.checklegalrun("Red2", testplayer1));

    }

    // Testing if player shouted uno (with checklegalrun)

    @Test
    public void TestPlayerShoutedUno(){
        //check if shouting uno Works correct, and if the player gets added to the shoutedUno list
        card card = new NumberCard("g", 2);
        game.add_middlestack(card);
        testplayer1.add_to_hand(card);
        testplayer1.add_to_hand(card);
        //player didn't shout uno yet
        Assert.assertFalse(game.playerShoutedUno(testplayer1));
        //shouts uno then check if it got stored that he shouted uno
        Assert.assertTrue(game.checklegalrun("Green2Uno", testplayer1));
        Assert.assertTrue(game.playerShoutedUno(testplayer1));
        //player 2, trys to shout uno to early
        game.add_middlestack(card);
        testplayer2.add_to_hand(card);
        testplayer2.add_to_hand(card);
        testplayer2.add_to_hand(card);
        Assert.assertFalse(game.checklegalrun("Green2Uno", testplayer2));
        Assert.assertFalse(game.playerShoutedUno(testplayer2));
    }


    // Testing if we can shuffle card of the middlestack correctly

    @Test
    public void testShufflePlayedToDraw(){

        card card = new NumberCard("b", 1);
        int beforeShuffle = game.drawstack.getsize();
        game.add_middlestack(card);
        game.add_middlestack(card);
        game.shuffle_and_renew();
        int afterShuffle = game.drawstack.getsize();
        Assert.assertEquals(beforeShuffle + 2, afterShuffle);

    }


    // Test if the distribute_cards method hands out 7 cards to each player

    @Test
    public void testDistributeCards(){
        ArrayList<player> players= game.getplayer();
        player gamePlayer1 = players.remove();
        player gamePlayer2 = players.remove();
        Assert.assertEquals(7, gamePlayer1.getnr());
        Assert.assertEquals(7, gamePlayer2.getnr());
    }


    // Test if we can change game direction

    @Test
    public void testSwitchDirection(){
        game.changeDirection(2);
        Assert.assertEquals(2, game.gamedirection());
    }


    // Test if (after all cards are played) score will be assigned and the round will be ended propperly

    @Test
    public void testGameRoundOver(){
        Assert.assertFalse(game.round_finished());
        ArrayList<player> players= game.getplayer();
        player gamePlayer1 = players.remove();
        ArrayList<card> cardsList= gamePlayer1.getcards();
        for (card card: cardsList) {
            gamePlayer1.playCard(card);
        }
        int scoreBeforeRoundOver = gamePlayer1.getpoints();
        //check if gameRound over
        Assert.assertTrue(game.round_finished());
        Assert.assertNotEquals(scoreBeforeRoundOver, gamePlayer1.getpoints());
    }


    // Test if the drawcard mehtod works

    @Test
    public void testDrawCards(){
        int nrOfCardsBefore = testplayer1.getnr();
        game.drawcard(1, testplayer1);
        Assert.assertEquals(1, (testplayer1.getnr()-nrOfCardsBefore));
        int nrOfCardsBefore2 = testplayer2.getnr();
        game.drawcard(4, testplayer2);
        Assert.assertEquals(4, (testplayer2.getnr()-nrOfCardsBefore2));
    }


    // Test if the game stops running if a player has a higher score than the score to win

    @Test
    public void testGameRunning(){
        Assert.assertTrue(game.gameRunning());
        ArrayList<player> players= game.getplayer();
        player gamePlayer1 = players.remove();
        gamePlayer1.updateScore(20);
        Assert.assertFalse(game.gameRunning());
    }


    // Test if player has the correct ArrayList of cards

    @Test
    public void testReturnHandCards() {

        card newCard1 = new NumberCard("r",5);
        card newCard2 = new NumberCard("b",4);
        card newCard3 = new NumberCard("g",3);

        ArrayList<card> newcards = new ArrayList<card>();
        newcards.add(newCard1);
        newcards.add(newCard2);
        newcards.add(newCard3);

        ArrayList<card> newcards2 = new ArrayList<card>();
        newcards.add(newCard1);
        newcards.add(newCard2);

        ArrayList<player> players = game.getplayer();
        player player2 = players.remove(1);
        player player1 =  players.remove(0);


        player1.add_to_hand(newCard1);
        player1.add_to_hand(newCard2);
        player1.add_to_hand(newCard3);

        player2.add_to_hand(newCard1);
        player2.add_to_hand(newCard2);

        Assert.assertEquals(newcards,game.getcards(player1));
        Assert.assertEquals(newcards2,game.getcards(player2));
        Assert.assertTrue(game.getcards(player1)instanceof ArrayList<card>);
    }

    // Test the getplayer method returns the correct arraylist of player

    @Test
    public void testReturnPlayers() {

        Assert.assertTrue(game.getplayer()instanceof ArrayList<player>);

        ArrayList<player> players = game.getplayer();
        String name1 = players.remove(0).getname();
        String name2 = players.remove(1).getname();

        Assert.assertEquals("playertest1",name1);
        Assert.assertEquals("playertest2",name2);
    }


    // Test if we can move a card from the Drawstack to the Middlestack

    @Test
    public void testCardDrawPileToPlayPile() {
        game.shuffle_and_renew();
        int initValue = game.drawstack.getsize();
        game.middlestack.addcard(drawstack.remove(0));
        Assert.assertEquals(initValue -1,game.drawstack.getsize());

        game.shuffle_and_renew();
        Assert.assertEquals(initValue,game.drawstack.getsize());
    }
}
