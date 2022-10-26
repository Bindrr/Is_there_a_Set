package com.example.BBTG.archieve;

public class VariantArchieve {
}
/*
public class Variant {
    private int currentVariantIndex = 0;
    private final Context context = CardsInputActivity.getContext();

    private void loadNextVariant() {
        if (currentVariantIndex == 3) currentVariantIndex = 0;
        else currentVariantIndex++;
    }

    private void loadPreviousVariant() {
        if (currentVariantIndex == 0) currentVariantIndex = 2;
        else currentVariantIndex -= 2;
    }

    public String getNextVariantText() {
        loadNextVariant();
        return context.getResources().getStringArray(R.array.variant)[currentVariantIndex];
    }

    public String[] getNextVariants() {
        loadNextVariant();
        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.variants);
        int variantsArrayId = typedArray.getResourceId(currentVariantIndex, 0);
        typedArray.recycle();
        return context.getResources().getStringArray(variantsArrayId);
    }

    public String getPreviousVariantText() {
        loadPreviousVariant();
        return context.getResources().getStringArray(R.array.variant)[currentVariantIndex];
    }

    public String[] getPreviousVariants() {
        loadPreviousVariant();
        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.variants);
        int variantsArrayId = typedArray.getResourceId(currentVariantIndex, 0);
        typedArray.recycle();
        return context.getResources().getStringArray(variantsArrayId);
    }
}
*/
