package com.example.BBTG.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.BBTG.helper.Helper;

import java.util.Objects;

public class Set implements Parcelable {
    private int setId;
    private final int id1, id2, id3;
    private final CardModel cardModel1, cardModel2, cardModel3;

    public Set(int id1, CardModel cardModel1, int id2, CardModel cardModel2, int id3, CardModel cardModel3) {
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.cardModel1 = cardModel1;
        this.cardModel2 = cardModel2;
        this.cardModel3 = cardModel3;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public boolean isSet() {
        return CardModel.correctAmount(cardModel1, cardModel2, cardModel3) && CardModel.correctColor(cardModel1, cardModel2, cardModel3)
                && CardModel.correctShape(cardModel1, cardModel2, cardModel3) && CardModel.correctShading(cardModel1, cardModel2, cardModel3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Set)) return false;

        Set set = (Set) o;
        return (id1 == set.id1 || id1 == set.id2 || id1 == set.id3)
                && (id2 == set.id1 || id2 == set.id2 || id2 == set.id3)
                && (id3 == set.id1 || id3 == set.id2 || id3 == set.id3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2, id3);
    }

    @Override
    public String toString() {
        return String.format("Set %s:\n" + "%s(%s)\n%s(%s)\n%s(%s)",
                setId,
                Helper.cardNumberToText(id1), cardModel1,
                Helper.cardNumberToText(id2), cardModel2,
                Helper.cardNumberToText(id3), cardModel3);
    }

    public String toLogString() {
        return String.format("Set %s { %s(%s), %s(%s), %s(%s) }",
                setId,
                Helper.cardNumberToText(id1), cardModel1,
                Helper.cardNumberToText(id2), cardModel2,
                Helper.cardNumberToText(id3), cardModel3);
    }

    //for parsing;
    protected Set(Parcel in) {
        setId = in.readInt();
        id1 = in.readInt();
        cardModel1 = in.readParcelable(CardModel.class.getClassLoader());
        id2 = in.readInt();
        cardModel2 = in.readParcelable(CardModel.class.getClassLoader());
        id3 = in.readInt();
        cardModel3 = in.readParcelable(CardModel.class.getClassLoader());
    }

    public static final Creator<Set> CREATOR = new Creator<>() {
        @Override
        public Set createFromParcel(Parcel in) {
            return new Set(in);
        }

        @Override
        public Set[] newArray(int size) {
            return new Set[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(setId);
        dest.writeInt(id1);
        dest.writeParcelable(cardModel1, flags);
        dest.writeInt(id2);
        dest.writeParcelable(cardModel2, flags);
        dest.writeInt(id3);
        dest.writeParcelable(cardModel3, flags);
    }
}