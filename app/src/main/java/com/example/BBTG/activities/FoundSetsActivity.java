package com.example.BBTG.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.BBTG.R;
import com.example.BBTG.adapter.SetAdapter;
import com.example.BBTG.helper.Helper;
import com.example.BBTG.model.Set;

import java.util.List;

public class FoundSetsActivity extends AppCompatActivity {
    TextView totalSETsFound;
    Button restartButton;
    RecyclerView listOfSets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_sets);
        
        setInfo();
        showSETs();
        
        restartButton.setOnClickListener(v -> Helper.openActivity(this, CardsInputActivity.class));
    }

    private void showSETs() {
        Intent intent = this.getIntent();

        List<Set> sets = intent.getParcelableArrayListExtra("sets");
        int totalSetsFound = sets.size();

        setText(totalSetsFound, sets);
    }

    private void setInfo() {
        totalSETsFound = findViewById(R.id.totalSETsFoundNumber);
        restartButton = findViewById(R.id.restart_button);
        listOfSets = findViewById(R.id.listOfSets);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setText(int totalSetsFound, List<Set> sets) {
        totalSETsFound.setText(String.valueOf(totalSetsFound));
        totalSETsFound.setBackground(getDrawable(R.drawable.white_button));

        listOfSets.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        listOfSets.setAdapter(new SetAdapter(this, sets));
    }
}