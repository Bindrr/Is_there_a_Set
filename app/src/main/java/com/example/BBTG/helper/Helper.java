package com.example.BBTG.helper;

import android.content.Context;
import android.content.Intent;

public class Helper {

    public static void openActivity(Context activityFromOpen, Class<?> activityToOpen){
        activityFromOpen.startActivity(new Intent(activityFromOpen, activityToOpen));
    }

    public static String numberToTextDefault(int number){
        switch (number){
            case 1: return "first";
            case 2: return "second";
            case 3: return "third";
            case 4: return "fourth";
            case 5: return "fifth";
            case 6: return "sixth";
            case 7: return "seventh";
            case 8: return "eighth";
            case 9: return "ninth";
            case 10: return "tenth";
            case 11: return "eleventh";
            case 12: return "twelfth";
            case 13: return "thirteenth";
            case 14: return "fourteenth";
            case 15: return "fifteenth";
            case 16: return "sixteenth";
            case 17: return "seventeenth";
            case 18: return "eighteenth";
            case 19: return "nineteenth";
            case 20: return "twentieth";
            default: throw new IllegalArgumentException(number + "is impossible to handle here");
        }
    }

    public static String numberToTextFirstCap(int number){
        switch (number){
            case 1: return "First";
            case 2: return "Second";
            case 3: return "Third";
            case 4: return "Fourth";
            case 5: return "Fifth";
            case 6: return "Sixth";
            case 7: return "Seventh";
            case 8: return "Eighth";
            case 9: return "Ninth";
            case 10: return "Tenth";
            case 11: return "Eleventh";
            case 12: return "Twelfth";
            case 13: return "Thirteenth";
            case 14: return "Fourteenth";
            case 15: return "Fifteenth";
            case 16: return "Sixteenth";
            case 17: return "Seventeenth";
            case 18: return "Eighteenth";
            case 19: return "Nineteenth";
            case 20: return "Twentieth";
            default: throw new IllegalArgumentException(number + " is impossible to handle here");
        }
    }

    public static String cardNumberToText(int cardNumber) {
        switch (++cardNumber){
            case 1: return "first";
            case 2: return "second";
            case 3: return "third";
            case 4: return "fourth";
            case 5: return "fifth";
            case 6: return "sixth";
            case 7: return "seventh";
            case 8: return "eighth";
            case 9: return "ninth";
            case 10: return "tenth";
            case 11: return "eleventh";
            case 12: return "twelfth";
            default: throw new IllegalArgumentException(--cardNumber + "is impossible to handle here");
        }
    }
}