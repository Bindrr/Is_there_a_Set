package com.example.BBTG.controller;

import com.example.BBTG.activities.CardsInputActivity;
import com.example.BBTG.enums.Variant;
import com.example.BBTG.helper.Helper;
import com.example.BBTG.model.MainModel;
import com.example.BBTG.model.Set;

import java.util.List;

public class CardsInputController {
    private final CardsInputActivity activity;
    private final MainModel model = new MainModel();

    public static final int AMOUNT_OF_CARDS = 12;

    private Variant variant = Variant.AMOUNT;
    private int currentCardNumber = 1;

    public CardsInputController(CardsInputActivity activity) {
        this.activity = activity;
        activity.showVariant(variant, currentCardNumber);
    }

    public void handleAnswer(int selectedChoice) {
        model.fillCard(variant, selectedChoice);

        if (isCardEntered()) {
            handleCard();
        } else {
            toNextVariant();
        }
    }

    private boolean isCardEntered() {
        return variant.equals(Variant.SHADING);
    }

    private void handleCard() {
        if (model.wasCardEnteredBefore()) {
            activity.throwDuplicateAlert();
            return;
        }

        model.saveCurrentCard();

        if (areAllCardsEntered()) {
            findSets();
        } else {
            currentCardNumber++;
            toNextVariant();
        }
    }

    private void findSets() {
        List<Set> sets = model.getFoundSets();
        activity.throwAlert(sets, sets.size());
    }

    private void toNextVariant() {
        switch (variant) {
            case AMOUNT:
                variant = Variant.COLOR;
                break;
            case COLOR:
                variant = Variant.SHAPE;
                break;
            case SHAPE:
                variant = Variant.SHADING;
                break;
            case SHADING:
                variant = Variant.AMOUNT;
        }

        activity.showVariant(variant, currentCardNumber);
    }

    private void toPreviousVariant() {
        switch (variant) {
            case SHADING:
                variant = Variant.SHAPE;
                break;
            case SHAPE:
                variant = Variant.COLOR;
                break;
            case COLOR:
                variant = Variant.AMOUNT;
                break;
            case AMOUNT:
                variant = Variant.SHADING;
        }

        activity.showVariant(variant, currentCardNumber);
    }

    private boolean areAllCardsEntered() {
        return currentCardNumber == 6; //has to be 12
    }

    public void back() {
        if (!isGoingBackAvailable()) return;

        if (variant.equals(Variant.AMOUNT)) {
            currentCardNumber--;
            model.toPreviousCard(currentCardNumber);
        } else {
            model.removeLastCardParameter(variant);
        }

        toPreviousVariant();
    }

    public void backIfCardWasDuplicate() {
        if (variant == Variant.AMOUNT) {
            System.out.println(1);
            currentCardNumber--;
            model.toPreviousCard(currentCardNumber);
        } else {
            System.out.println(2);
            model.removeLastCardParameter(variant);
        }
    }

    private boolean isGoingBackAvailable() {
        return currentCardNumber != 1 || !(variant == Variant.AMOUNT);
    }

    public void restart() {
        Helper.openActivity(activity, CardsInputActivity.class);
    }
}
