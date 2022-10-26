package com.example.BBTG.model;

import android.util.Log;

import com.example.BBTG.SetFinder;
import com.example.BBTG.controller.CardsInputController;
import com.example.BBTG.enums.Variant;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    private CardModel card = new CardModel();
    private final List<CardModel> cards = new ArrayList<>(CardsInputController.AMOUNT_OF_CARDS);

    public void fillCard(Variant currentVariant, int selectedChoice) {
        card.fillCard(currentVariant, selectedChoice);
    }

    public void removeLastCardParameter(Variant currentVariant) {
        card.removeLastParameter(currentVariant);
    }

    public void toPreviousCard(int currentCardNumber) {
        int currentCardIndex = currentCardNumber - 1;
        card = cards.get(currentCardIndex);
        cards.remove(card);
    }

    public void saveCurrentCard() {
        cards.add(card);
        card = new CardModel();
    }

    public boolean wasCardEnteredBefore() {
        return cards.contains(card);
    }

    public List<Set> getFoundSets() {
        Log.i("cards", cards.toString()); //debug
        List<Set> sets = SetFinder.findSets(cards);
        for (Set set : sets) Log.i("set", set.toLogString()); //debug

        return sets;
    }
}
