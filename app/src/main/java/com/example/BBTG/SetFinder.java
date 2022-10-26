package com.example.BBTG;

import com.example.BBTG.model.CardModel;
import com.example.BBTG.model.Set;

import java.util.ArrayList;
import java.util.List;

public class SetFinder {
    public static List<Set> findSets(List<CardModel> cardModels) {
        List<Set> sets = new ArrayList<>();
        int setId = 0;

        for (CardModel cardModel1 : cardModels) {

            for (CardModel cardModel2 : cardModels) {
                if (cardModel1.equals(cardModel2)) continue;

                for (CardModel cardModel3 : cardModels) {
                    if (cardModel2.equals(cardModel3) || cardModel1.equals(cardModel3)) continue;

                    Set currentSET = createSet(cardModels, cardModel1, cardModel2, cardModel3);
                    if (currentSET.isSet() && !sets.contains(currentSET)) {
                        currentSET.setSetId(++setId);
                        sets.add(currentSET);
                    }
                }
            }
        }

        return sets;
    }

    private static Set createSet(List<CardModel> cardModels, CardModel cardModel1, CardModel cardModel2, CardModel cardModel3) {
        return new Set(cardModels.indexOf(cardModel1), cardModel1,
                cardModels.indexOf(cardModel2), cardModel2,
                cardModels.indexOf(cardModel3), cardModel3);
    }
}
