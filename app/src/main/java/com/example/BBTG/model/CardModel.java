package com.example.BBTG.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.BBTG.enums.Variant;

import java.util.Objects;

public class CardModel implements Parcelable {
    private String amount;
    private String color;
    private String shape;
    private String shading;

    public CardModel() {
    }

    private void setAmount(int selectedChoice) {
        amount = String.valueOf(selectedChoice);
    }

    private void setColor(int selectedChoice) {
        switch (selectedChoice) {
            case 1:
                color = "red"; break;
            case 2:
                color = "green"; break;
            case 3:
                color = "purple";
        }
    }

    private void setShape(int selectedChoice) {
        switch (selectedChoice) {
            case 1:
                shape = "curved"; break;
            case 2:
                shape = "romb"; break;
            case 3:
                shape = "oval";
        }
    }

    private void setShading(int selectedChoice) {
        switch (selectedChoice) {
            case 1:
                shading = "non"; break;
            case 2:
                shading = "half"; break;
            case 3:
                shading = "full";
        }
    }

    public void fillCard(Variant currentVariant, int selectedChoice) {
        switch (currentVariant) {
            case AMOUNT:
                setAmount(selectedChoice);
                break;
            case COLOR:
                setColor(selectedChoice);
                break;
            case SHAPE:
                setShape(selectedChoice);
                break;
            case SHADING:
                setShading(selectedChoice);
        }
    }

    public void removeLastParameter(Variant currentVariant) {
        switch (currentVariant) {
            case SHADING:
                shading = null;
                break;
            case SHAPE:
                shape = null;
                break;
            case COLOR:
                color = null;
                break;
            case AMOUNT:
                amount = null;
        }
    }

    public static boolean correctAmount(CardModel cardModel1, CardModel cardModel2, CardModel cardModel3) {
        return amountEquals(cardModel1, cardModel2) && amountEquals(cardModel2, cardModel3)
                || !amountEquals(cardModel1, cardModel2) && !amountEquals(cardModel2, cardModel3) && !amountEquals(cardModel1, cardModel3);
    }

    public static boolean correctColor(CardModel cardModel1, CardModel cardModel2, CardModel cardModel3) {
        return colorEquals(cardModel1, cardModel2) && colorEquals(cardModel2, cardModel3)
                || !colorEquals(cardModel1, cardModel2) && !colorEquals(cardModel2, cardModel3) && !colorEquals(cardModel1, cardModel3);
    }

    public static boolean correctShape(CardModel cardModel1, CardModel cardModel2, CardModel cardModel3) {
        return shapeEquals(cardModel1, cardModel2) && shapeEquals(cardModel2, cardModel3)
                || !shapeEquals(cardModel1, cardModel2) && !shapeEquals(cardModel2, cardModel3) && !shapeEquals(cardModel1, cardModel3);
    }

    public static boolean correctShading(CardModel cardModel1, CardModel cardModel2, CardModel cardModel3) {
        return shadingEquals(cardModel1, cardModel2) && shadingEquals(cardModel2, cardModel3)
                || !shadingEquals(cardModel1, cardModel2) && !shadingEquals(cardModel2, cardModel3) && !shadingEquals(cardModel1, cardModel3);
    }

    private static boolean amountEquals(CardModel cardModel1, CardModel cardModel2) {
        return cardModel1.amount.equals(cardModel2.amount);
    }

    private static boolean colorEquals(CardModel cardModel1, CardModel cardModel2) {
        return cardModel1.color.equals(cardModel2.color);
    }

    private static boolean shapeEquals(CardModel cardModel1, CardModel cardModel2) {
        return cardModel1.shape.equals(cardModel2.shape);
    }

    private static boolean shadingEquals(CardModel cardModel1, CardModel cardModel2) {
        return cardModel1.shading.equals(cardModel2.shading);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", amount, color, shape, shading);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof CardModel) {
            CardModel cardModel = (CardModel) o;
            return amount.equals(cardModel.amount) && color.equals(cardModel.color)
                    && shape.equals(cardModel.shape) && shading.equals(cardModel.shading);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, color, shape, shading);
    }


    //parsing
    protected CardModel(Parcel in) {
        amount = in.readString();
        color = in.readString();
        shape = in.readString();
        shading = in.readString();
    }

    public static final Creator<CardModel> CREATOR = new Creator<>() {
        @Override
        public CardModel createFromParcel(Parcel in) {
            return new CardModel(in);
        }

        @Override
        public CardModel[] newArray(int size) {
            return new CardModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(amount);
        dest.writeString(color);
        dest.writeString(shape);
        dest.writeString(shading);
    }
}