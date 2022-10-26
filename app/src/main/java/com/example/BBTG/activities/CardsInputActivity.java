package com.example.BBTG.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.BBTG.R;
import com.example.BBTG.controller.CardsInputController;
import com.example.BBTG.enums.Variant;
import com.example.BBTG.model.Set;

import java.util.ArrayList;
import java.util.List;

public class CardsInputActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView currentCardTextView, variantTextView;
    private Button ansAButton, ansBButton, ansCButton, backButton, restartButton;

    private CardsInputController controller;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_cards);
        context = getApplicationContext();

        setInfo();
        controller = new CardsInputController(this);
    }

    private void setInfo() {
        currentCardTextView = findViewById(R.id.current_card);
        variantTextView = findViewById(R.id.variant);

        ansAButton = findViewById(R.id.first_answer_button);
        ansBButton = findViewById(R.id.second_answer_button);
        ansCButton = findViewById(R.id.third_answer_button);
        ansAButton.setOnClickListener(this);
        ansBButton.setOnClickListener(this);
        ansCButton.setOnClickListener(this);

        backButton = findViewById(R.id.back_button);
        restartButton = findViewById(R.id.restart_button);
        backButton.setOnClickListener(v -> controller.back());
        restartButton.setOnClickListener(v -> controller.restart());
    }

    public void showVariant(Variant variant, int currentCardNumber) {
        currentCardTextView.setText(getString(R.string.current_card) + currentCardNumber);

        variantTextView.setText(getString(variant.getId()));
        ansAButton.setText(getString(variant.getFirstChoice()));
        ansBButton.setText(getString(variant.getSecondChoice()));
        ansCButton.setText(getString(variant.getThirdChoice()));

        setButtonsBackgroundColor(variant);
    }

    private void setButtonsBackgroundColor(Variant variant) {
        switch (variant) {
            case AMOUNT:
                ansAButton.setBackground(getDrawable(R.drawable.white_button));
                ansBButton.setBackground(getDrawable(R.drawable.white_button));
                ansCButton.setBackground(getDrawable(R.drawable.white_button));
                break;
            case COLOR:
                ansAButton.setBackground(getDrawable(R.drawable.red_button));
                ansBButton.setBackground(getDrawable(R.drawable.green_button));
                ansCButton.setBackground(getDrawable(R.drawable.purple_button));
                break;
            case SHAPE:
                ansAButton.setBackground(getDrawable(R.drawable.white_button));
                ansBButton.setBackground(getDrawable(R.drawable.white_button));
                ansCButton.setBackground(getDrawable(R.drawable.white_button));
                break;
            case SHADING:
                ansAButton.setBackground(getDrawable(R.drawable.white_button));
                ansBButton.setBackground(getDrawable(R.drawable.white_button));
                ansCButton.setBackground(getDrawable(R.drawable.white_button));
        }
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        int selectedChoice;

        if (ansAButton.equals(clickedButton)) selectedChoice = 1;
        else if (ansBButton.equals(clickedButton)) selectedChoice = 2;
        else if (ansCButton.equals(clickedButton)) selectedChoice = 3;
        else throw new IllegalArgumentException();

        controller.handleAnswer(selectedChoice);
    }

    //Alerts
    public void throwAlert(List<Set> sets, int totalSetsFound) {
        switch (totalSetsFound) {
            case 0:
                throw0SetsAlert();
                break;
            case 1:
                throw1SetAlert(sets);
                break;
            default:
                throwManySetsAlert(sets, totalSetsFound);
        }
    }

    public void throwDuplicateAlert() {
        new AlertDialog.Builder(this, R.style.AlertDialogFail)
                .setTitle(getString(R.string.duplicate_card))
                .setMessage(getString(R.string.duplicate_card_desc))
                .setPositiveButton(getString(R.string.restart_button), (dialogInterface, i) ->
                        controller.restart())
                .setNegativeButton(getString(R.string.back_button), (dialogInterface, i) ->
                        controller.backIfCardWasDuplicate())
                .setCancelable(false)
                .show();
    }

    private void throw0SetsAlert() {
        new AlertDialog.Builder(this, R.style.AlertDialogFail)
                .setTitle(getString(R.string.non_sets_found))
                .setMessage(getString(R.string.non_sets_found_desc))
                .setPositiveButton(getString(R.string.restart_button), (dialogInterface, i) ->
                        controller.restart())
                .setCancelable(false)
                .show();
    }

    private void throw1SetAlert(List<Set> sets) {
        new AlertDialog.Builder(this, R.style.AlertDialogSuccess)
                .setTitle(getString(R.string.one_set_found))
                .setMessage(getString(R.string.one_set_found_desc))
                .setPositiveButton(getString(R.string.reveal_button), (dialogInterface, i) ->
                        showFoundSETs(sets))
                .setNegativeButton(getString(R.string.restart_button), (dialogInterface, i) ->
                        controller.restart())
                .setCancelable(false)
                .show();
    }

    private void throwManySetsAlert(List<Set> sets, int totalSetsFound) {
        new AlertDialog.Builder(this, R.style.AlertDialogSuccess)
                .setTitle(getString(R.string.many_set_found) + totalSetsFound)
                .setMessage(getString(R.string.many_set_found_desc))
                .setPositiveButton(getString(R.string.reveal_button), (dialogInterface, i) ->
                        showFoundSETs(sets))
                .setNegativeButton(getString(R.string.back_button), (dialogInterface, i) -> controller.back())
                .setCancelable(false)
                .show();
    }


    private void showFoundSETs(List<Set> sets) {
        Intent intent = new Intent(this, FoundSetsActivity.class);
        intent.putParcelableArrayListExtra("sets", (ArrayList<Set>) sets);
        startActivity(intent);
    }
}
