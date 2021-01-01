package com.example.darts501;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    /*
    ZU TUN:
        wichtig:
        Avg dauerhaft anzeigen lassen
        am ende fragen wieviele würfe zum beenden benötigt wurden
        Checkouts verändern

        unwichtiger:
        Menü am Anfang, Spielerzahl bestimmen
        Runden mit legs etc.
     */

    int cnt = 0;
    int player = 1;
    int sieger = 1;
    boolean isLegit = true;
    boolean worked = true; // damit man add bei der List benutzen kann
    Stack<Integer> History; // eine Liste, nur mit Integern, die die alle Würfe mit aufnimmt.
    CharSequence initializedScore = "501";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Player2Pfeil = (TextView) findViewById(R.id.Pfeil2);
        TextView Player1Pfeil = (TextView) findViewById(R.id.Pfeil1);

        TextView Player1EditScore = (TextView) findViewById(R.id.Player1Left);
        TextView Player2EditScore = (TextView) findViewById(R.id.Player2Left);

        //Buttons
        Button button_score0 = (Button) findViewById(R.id.button_score_0);
        Button button_score1 = (Button) findViewById(R.id.button_score_1);
        Button button_score2 = (Button) findViewById(R.id.button_score_2);
        Button button_score3 = (Button) findViewById(R.id.button_score_3);
        Button button_score4 = (Button) findViewById(R.id.button_score_4);
        Button button_score5 = (Button) findViewById(R.id.button_score_5);
        Button button_score6 = (Button) findViewById(R.id.button_score_6);
        Button button_score7 = (Button) findViewById(R.id.button_score_7);
        Button button_score8 = (Button) findViewById(R.id.button_score_8);
        Button button_score9 = (Button) findViewById(R.id.button_score_9);
        Button button_rck = (Button) findViewById(R.id.button_rck);
        Button button_clear = (Button) findViewById(R.id.button_clear);
        Button button_washing = (Button) findViewById(R.id.button_washing);
        final Button button_ok = (Button) findViewById(R.id.button_OK);
        // Initialisieren
        Player1EditScore.setText(initializedScore.toString());
        Player2EditScore.setText(initializedScore.toString());
        Player1Pfeil.setVisibility(View.VISIBLE);
        Player2Pfeil.setVisibility(View.INVISIBLE);
        History = new Stack<>();

        button_score0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 18) {
                    cnt = cnt * 10 + 0;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 1;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 2;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 3;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 4;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 5;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 6;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 7;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 8;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });
        button_score9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                if (cnt <= 17) {
                    cnt = cnt * 10 + 9;
                }
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });

        button_washing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                cnt = 26;
                PerformClickOk();
            }
        });

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformClickOk();
            }
        });
        // setzt den CurrenScore auf 0 zurück
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
                cnt = 0;
                CurrentScoreEdit.setText(Integer.toString(cnt));
            }
        });

        //letzten Schritt rükgängig machen
        button_rck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!History.isEmpty()) {
                    // get TextViews
                    TextView Player1EditScore = (TextView) findViewById(R.id.Player1Left);
                    TextView Player2EditScore = (TextView) findViewById(R.id.Player2Left);
                    TextView Player2Pfeil = (TextView) findViewById(R.id.Pfeil2);
                    TextView Player1Pfeil = (TextView) findViewById(R.id.Pfeil1);
                    TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);

                    // Spielerwechsel
                    if (player == 1) { // für Spieler 1, letzten Wurf wieder drauf rechnen
                        player = 2;
                        Player1Pfeil.setVisibility(View.INVISIBLE);
                        Player2Pfeil.setVisibility(View.VISIBLE);

                        int Score = Integer.parseInt(Player2EditScore.getText().toString());
                        Score += History.pop();
                        Player2EditScore.setText(Integer.toString(Score));
                    } else {
                        player = 1;
                        Player2Pfeil.setVisibility(View.INVISIBLE);
                        Player1Pfeil.setVisibility(View.VISIBLE);

                        int Score = Integer.parseInt(Player1EditScore.getText().toString());
                        Score += History.pop();
                        Player1EditScore.setText(Integer.toString(Score));
                    }
                }
            }
        });
    }
    // geht zu den stats über
    private void SwitchScreen(){
        // Average und Anzahl Darts
        int Player1Avg = 0;
        int Player2Avg = 0;
        int Player1Darts = 0;
        int Player2Darts = 0;
        player = sieger;

        //Fülle die Daten mit der History
        while(!History.isEmpty()) {
            if (player == 1) {
                Player1Avg += History.pop();
                Player1Darts += 3;
                player = 2;
            } else {
                Player2Avg += History.pop();
                Player2Darts += 3;
                player = 1;
            }
        }

        //tatsächlichen AVG berechnen
        double AVG1 =  ((double) Player1Avg*3/ (double) Player1Darts);
        double AVG2 =  ((double) Player2Avg*3/ (double) Player2Darts);
        AVG1 = Math.round(AVG1*100.0)/100.0;
        AVG2 = Math.round(AVG2*100.0)/100.0;

        //wichtige Daten übergeben
        Intent statsIntent = new Intent(getApplicationContext(), Stats.class);
        statsIntent.putExtra("AverageSpieler1", AVG1);
        statsIntent.putExtra("AverageSpieler2", AVG2);
        statsIntent.putExtra("DartsSpieler1", Player1Darts);
        statsIntent.putExtra("DartsSpieler2", Player2Darts);
        statsIntent.putExtra("player", player);
        statsIntent.putExtra("sieger", sieger);

        //auf Activity Screen wechseln
        startActivity(statsIntent);
    }
    // wird 2x benutzt, bei ok und bei washing, deshalb eigene methode
    private void PerformClickOk(){
        // get TextViews
        TextView Player1EditScore = (TextView) findViewById(R.id.Player1Left);
        TextView Player2EditScore = (TextView) findViewById(R.id.Player2Left);
        TextView Player2Pfeil = (TextView) findViewById(R.id.Pfeil2);
        TextView Player1Pfeil = (TextView) findViewById(R.id.Pfeil1);
        TextView CurrentScoreEdit = (TextView) findViewById(R.id.CurrentScore);
        MediaPlayer mediaPlayer;
        //Spielerwechsel && update
        if (player == 1){ // alles für Spieler 1
            int Score = Integer.parseInt(Player1EditScore.getText().toString());
            Score -= cnt;

            if (Score == 1 || Score < 0) { // Überworfen - Sound, Rückgängig machen, näcshter Spieler dran, merken
                Playsound((int) -1, Score);

                Score+= cnt;

                Player1EditScore.setText(Integer.toString(Score));
                player = 2;
                Player1Pfeil.setVisibility(View.INVISIBLE);
                Player2Pfeil.setVisibility(View.VISIBLE);

                cnt = History.push((int) 0); // cnt = cnt, bloß, dass 0 gepusht wird
            } else if (Score == 0) { // Gewonnen - Gewinner wird angezeigt, merken und
                sieger = 1;
                cnt = History.push(cnt); // cnt = cnt, bloß, dass cnt gepusht wird
                SwitchScreen();
            } else { // passt - Sound, Spielerwechseln, merken
                Playsound(cnt, Score);
                Player1EditScore.setText(Integer.toString(Score));
                player = 2;
                Player1Pfeil.setVisibility(View.INVISIBLE);
                Player2Pfeil.setVisibility(View.VISIBLE);
                cnt = History.push(cnt); // cnt = cnt, bloß, dass cnt gepusht wird
            }

        } else { // alles für spieler 2
            int Score = Integer.parseInt(Player2EditScore.getText().toString());
            Score -= cnt;

            if (Score == 1 || Score < 0) { //überworfen - Sound, Score drauf, Spielerwechsel, History push
                Playsound((int) -1, Score);
                Score+= cnt;
                Player2EditScore.setText(Integer.toString(Score));
                player = 1;
                Player1Pfeil.setVisibility(View.VISIBLE);
                Player2Pfeil.setVisibility(View.INVISIBLE);
                cnt = History.push((int) 0); // cnt = cnt, bloß, dass cnt gepusht wird
            }else if (Score == 0) {
                sieger = 2;
                //Player2EditScore.setText(Integer.toString(Score));
                cnt = History.push(cnt);
                SwitchScreen();
            } else {
                Playsound(cnt, Score);
                Player2EditScore.setText(Integer.toString(Score));
                player = 1;
                Player1Pfeil.setVisibility(View.VISIBLE);
                Player2Pfeil.setVisibility(View.INVISIBLE);
                cnt = History.push(cnt);
            }
        }
        //zurücksetzen
        CurrentScoreEdit.setText("0");
        cnt = 0;
    }
    //-1:       für überworfen
    //default:  Zahl 1-180
    private void Playsound(final int cnt, final int Score) {
        MediaPlayer mediaPlayer;
        try {
            String nameofmp3 = "sound"+ Integer.toString(cnt);
            int resID=getResources().getIdentifier(nameofmp3, "raw", getPackageName());
            mediaPlayer = MediaPlayer.create(getApplicationContext(), resID);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if(cnt >= 100 && Score == 0) {
                            String nameofmp3 = "nobetterdarts";
                            Context context = getApplicationContext();
                            int resID=getResources().getIdentifier(nameofmp3, "raw", getPackageName());
                            MediaPlayer mediaPlayer = MediaPlayer.create(context, resID);
                            mediaPlayer.start();
                        } else if(Score == 0) {
                            String nameofmp3 = "finish";
                            Context context = getApplicationContext();
                            int resID=getResources().getIdentifier(nameofmp3, "raw", getPackageName());
                            MediaPlayer mediaPlayer = MediaPlayer.create(context, resID);
                            mediaPlayer.start();
                        } else if(Score == 40) {
                            String nameofmp3 = "fortops";
                            Context context = getApplicationContext();
                            int resID=getResources().getIdentifier(nameofmp3, "raw", getPackageName());
                            MediaPlayer mediaPlayer = MediaPlayer.create(context, resID);
                            mediaPlayer.start();
                        } else if(cnt >= 120) {
                            String nameofmp3 = "beautiful";
                            Context context = getApplicationContext();
                            int resID=getResources().getIdentifier(nameofmp3, "raw", getPackageName());
                            MediaPlayer mediaPlayer = MediaPlayer.create(context, resID);
                            mediaPlayer.start();
                        }

                    }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

