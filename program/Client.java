import java.util.Scanner;

public final class Client {

    public static void main(String[] args) {

        // setup inputs and outputs
        Scanner in = new Scanner(System.in);

        // game loop
        while(true) {
            // main menu
            System.out.print("\\/\\/BLACKJACK CONSOLE THING\\/\\/" +
                              "\n\t1. New game" +
                              "\n\t2. How to play"+
                              "\n\t3. Quit\n\n");
            switch(getInput(in,3)) {
                case 1:
                    // "New game"
                    break;
                case 2:
                    // "How to
                    break;
                case 3:

                    break;
                default:

                    // if maximum value wasn't assigned properly in getInput()
                    break;
            }
        }
    }


    /* Robust input method, doesn't throw uncaught exceptions! YAY! */
    public static int getInput(Scanner in, int max) {

        while(true) { // keep trying to get correct input

            System.out.print("Choice: "); // ask for a choice

            try { // attempt to get input

                int input = Integer.parseInt(in.nextLine()); // get input (exception can be thrown here)
                if(input > max) throw new NumberFormatException("Value isn't within the range.");
                // System.out.println(input + " Processing..."); // input is correct
                return input; // exit the while loop (stop trying to get input)

            } catch (NumberFormatException e) { // catch the number format exception (thrown by parseInt())

                System.out.println("That isn't an available option."); // invalid input
            }
        }
    }
}


class Card {

    enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() { return "CARD{"+rank+"_OF_"+suit+"}"; }
}


class Deck {

    private Card[] cards; // array of cards that exist in the deck

    public Deck() {

        /* Generates a 52 card deck with all four suits, 0 is an ace and 12 is a queen */

        Card.Suit[] suits = Card.Suit.values();

        cards = new Card[52];

        int count = 0;
        for(int m = 0; m < 4; m++) {
            for(int i = 0; i < 13; i++) {
                cards[count++] = new Card(suits[m], i);
            }
        }
    }

    public Card[] getCards() { return this.cards; } // getter

    public void print() {

        /* outputs the deck in a really gross format */

        for(Card c : cards) {
            System.out.println(c);
        }
    }
}
