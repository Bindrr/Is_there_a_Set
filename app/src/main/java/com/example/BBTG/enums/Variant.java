package com.example.BBTG.enums;

import com.example.BBTG.R;

public enum Variant {
    AMOUNT(R.string.amount, R.string.amount_1, R.string.amount_2, R.string.amount_3),
    COLOR(R.string.color, R.string.color_red, R.string.color_green, R.string.color_purple),
    SHAPE(R.string.shape, R.string.shape_curved, R.string.shape_romb, R.string.shape_oval),
    SHADING(R.string.shading, R.string.shading_non, R.string.shading_half, R.string.shading_full);

    private final int id;
    private final int firstChoice;
    private final int secondChoice;
    private final int thirdChoice;

    Variant(int id, int firstChoice, int secondChoice, int thirdChoice) {
        this.id = id;
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        this.thirdChoice = thirdChoice;
    }

    public int getId() {
        return id;
    }

    public int getFirstChoice() {
        return firstChoice;
    }

    public int getSecondChoice() {
        return secondChoice;
    }

    public int getThirdChoice() {
        return thirdChoice;
    }

//    public int getChoiceByNumber(int choiceNumber) {
//        switch (choiceNumber) {
//            case 1: return firstChoice;
//            case 2: return secondChoice;
//            case 3: return thirdChoice;
//            default:
//                throw new IllegalArgumentException("ChoiceNumber " + choiceNumber + " is impossible to handle");
//        }
//    }
}
