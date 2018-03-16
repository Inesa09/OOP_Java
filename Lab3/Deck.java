package com.inesonjka;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        int numRank1 = 0, numSuit1 = 0, numRank2 = 0, numSuit2 = 0, sum1, sum2;
        Rank rank1 = card1.getRank();
        Rank rank2 = card2.getRank();
        Suit suit1 = card1.getSuit();
        Suit suit2 = card2.getSuit();
        for (int i = 0; i < Rank.values.length; i++) {
            if (rank1.equals(Rank.values[i]))
                numRank1 = i;
            if (rank2.equals(Rank.values[i]))
                numRank2 = i;
        }
        for (int i = 0; i < Suit.values.length; i++) {
            if (suit1.equals(Suit.values[i]))
                numSuit1 = i;
            if (suit2.equals(Suit.values[i]))
                numSuit2 = i;
        }
        sum1 = numSuit1 * 10 + numRank1;
        sum2 = numSuit2 * 10 + numRank2;
        if (sum1 < sum2)
            return -1;
        else
            return 1;
    }
}

public class Deck {
    Card deck[] = new Card[36];

    public Deck() {
        int k=0;
        for (int i = 0; i < Rank.values.length; i++) {
            for (int j = 0; j < Suit.values.length; j++) {
                deck[k] = new Card(Rank.values[i], Suit.values[j]);
                k++;
            }
        }
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Random random = new Random();
        int j = random.nextInt(36);
        Card deckAdd [] = new Card[36];
        for (int i=0; i <deck.length; i++, j++) {
            if (j == 36)
                j = 0;
            deckAdd[i] = deck[j];
        }
        for (int i=0; i <deck.length; i++) {
            deck[i]=deckAdd[i];
        }
    }

    /* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
        CardComparator comparator = new CardComparator();
        Arrays.sort(deck, comparator);
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        if (deck[0] != null)
            return true;
        else
            return false;
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        int i = 35;
        if (!hasNext())
            return null;
        while (deck[i] == null) {
            i--;
        }
        Card temp = deck[i];
        deck[i] = null;
        return temp;
    }

//    public static void main (String[] args) {
//        Deck deck = new Deck();
//        deck.shuffle();
//        deck.order();
//        for (int i=0;i<deck.deck.length;i++)
//            System.out.println(deck.deck[i].getRank().getName());
//    }
}

class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}

class Rank {
    public static final Rank ACE = new Rank("Ace");
    public static final Rank KING = new Rank("King");
    public static final Rank QUEEN = new Rank("Queen");
    public static final Rank JACK = new Rank("Jack");
    public static final Rank TEN = new Rank("10");
    public static final Rank NINE = new Rank("9");
    public static final Rank EIGHT = new Rank("8");
    public static final Rank SEVEN = new Rank("7");
    public static final Rank SIX = new Rank("6");

    public static Rank[] values = {ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX};

    private String name;

    Rank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Suit {
    public static final Suit HEARTS = new Suit("HEARTS");
    public static final Suit DIAMONDS = new Suit("DIAMONDS");
    public static final Suit CLUBS = new Suit("CLUBS");
    public static final Suit SPADES = new Suit("SPADES");

    public static Suit[] values = {HEARTS, DIAMONDS, CLUBS, SPADES};

    private String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

