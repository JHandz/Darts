package com.example.darts501;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stats extends AppCompatActivity {

    int player = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Button button_Rematch = (Button) findViewById(R.id.button_Rematch);

        if (getIntent().hasExtra("AverageSpieler1")) {
            TextView Average1_Text = (TextView) findViewById(R.id.Spieler1Avg);
            double Average1 = getIntent().getExtras().getDouble("AverageSpieler1");
            String Average1_String = Double.toString(Average1);
            Average1_Text.setText(Average1_String);
        }

        if (getIntent().hasExtra("AverageSpieler2")) {
            TextView Average2_Text = (TextView) findViewById(R.id.Spieler2Avg);
            double Average2 = getIntent().getExtras().getDouble("AverageSpieler2");
            String Average2_String = Double.toString(Average2);
            Average2_Text.setText(Average2_String);
        }

        if (getIntent().hasExtra("DartsSpieler1")) {
            TextView Darts1_Text = (TextView) findViewById(R.id.Spieler1Darts);
            int Darts1 = getIntent().getExtras().getInt("DartsSpieler1");
            Darts1_Text.setText(Integer.toString(Darts1));
        }

        if (getIntent().hasExtra("DartsSpieler2")) {
            TextView Darts2_Text = (TextView) findViewById(R.id.Spieler2Darts);
            int Darts2 = getIntent().getExtras().getInt("DartsSpieler2");
            Darts2_Text.setText(Integer.toString(Darts2));
        }

        if (getIntent().hasExtra("player")) {
            int player = getIntent().getExtras().getInt("player");
        }

        if (getIntent().hasExtra("sieger")) {
            int sieger = getIntent().getExtras().getInt("sieger");
            TextView Gewinner1_Text = (TextView) findViewById(R.id.Gewinner1);
            TextView Gewinner2_Text = (TextView) findViewById(R.id.Gewinner2);
            if (sieger == 1) {
                Gewinner1_Text.setVisibility(View.VISIBLE);
                Gewinner2_Text.setVisibility(View.INVISIBLE);
            } else {
                Gewinner1_Text.setVisibility(View.INVISIBLE);
                Gewinner2_Text.setVisibility(View.VISIBLE);
            }
        }


        button_Rematch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);

                Intent MainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainIntent);

            }
        });

    }
}
