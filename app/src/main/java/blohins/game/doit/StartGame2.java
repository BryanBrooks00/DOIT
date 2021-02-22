package blohins.game.doit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class StartGame2 extends AppCompatActivity {
    long duration = 31000;
    final String TAG = "STATE";

    Context context;
    String score = "0";

    private InterstitialAd mInterstitialAd;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game2);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context = this;

        //ad
        //
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-2382402581294867/9159398435", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                mInterstitialAd = null;
            }
        });




        TextView player1 = (TextView)  findViewById(R.id.player1);
        TextView player2 = (TextView)  findViewById(R.id.player2);
        player1.setText(R.string.p1);
        player2.setText(R.string.p2);
        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView score2 = (TextView) findViewById(R.id.score2);
        score1.setText(score);
        score2.setText(score);
        score1.setTextColor(Color.WHITE);
        score2.setTextColor(Color.WHITE);

        //dialog2
        LayoutInflater abc2 = LayoutInflater.from(context);
        View promptsView2 = abc2.inflate(R.layout.prompt2, null);
        AlertDialog.Builder dialog2 = new AlertDialog.Builder(context);
        dialog2.setView(promptsView2);
        dialog2
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog2, int id) {
                                TextView player2 = findViewById(R.id.player2);
                                EditText input2 = promptsView2.findViewById(R.id.input2);
                                if (input2.getText().toString().equals("")){
                                    player2.setText(R.string.p2);
                                } else {
                                    String setText = input2.getText().toString();
                                    player2.setText(setText);
                                } player2.setTextColor(Color.WHITE);
                                //
                                setNameColor();
                                setTask();
                                setTimer();
                                //

                            }
                        });

        AlertDialog alertDialog2 = dialog2.create();
        alertDialog2.show();
        //dialog2

        //dialog1
        LayoutInflater abc1 = LayoutInflater.from(context);
        View promptsView1 = abc1.inflate(R.layout.prompt1, null);
        AlertDialog.Builder dialog1 = new AlertDialog.Builder(context);
        dialog1.setView(promptsView1);
        dialog1.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText input = promptsView1.findViewById(R.id.input);
                                TextView player1 =  findViewById(R.id.player1);
                                if (input.getText().toString().equals("")){
                                    player1.setText(R.string.p1);
                                } else {
                                    String setText = input.getText().toString();
                                    player1.setText(setText);
                                } player1.setTextColor(Color.WHITE);
                            }
                        });

        AlertDialog alertDialog = dialog1.create();
        alertDialog.show();
        //dialog1




        //button Back START
        Button buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(v -> {
            try {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(StartGame2.this);
                } else {
                    Intent intent = new Intent(StartGame2.this, MainActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(StartGame2.this, MainActivity.class);
                startActivity(intent);
            } catch (Exception e) {

            }
            //saveTask();
        });
        // Button Back END


    }

    public void setNameColor () {
        TextView player1 =  findViewById(R.id.player1);
        TextView player2 = findViewById(R.id.player2);
        player1.setTextColor(Color.WHITE);
        player2.setTextColor(Color.WHITE);
        TextView[] name = {player1, player2};
        Random random = new Random();
        int randomizer = random.nextInt(name.length);
       (name[randomizer]).setTextColor(Color.GREEN);
        //
    }

    public void setTask() {
        //
        TextView todo =  findViewById(R.id.todo);
        //Array
        String[] tasks = getResources().getStringArray(R.array.todo_list);
        // Calculate how many words are in the array
        int tasksLength = tasks.length;
        //Generate random
        int rand = (int) (Math.random() * tasksLength);
        //Set task
        String task = tasks[rand] + " ";
        todo.setText(task);
        //
    }



    public void setTimer() {
        CountDownTimer timer = new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long l) {
                TextView chronometer =  findViewById(R.id.chronometer);
                String duration = String.format(Locale.ENGLISH, "%02d : %02d", TimeUnit.MILLISECONDS.toMinutes(l), TimeUnit.MILLISECONDS.toSeconds(l));
                chronometer.setText(duration);
            }



            @Override
            public void onFinish() {
                setNameColor();
                setTask();
                setTimer();

            }
        };
        timer.start();
        //
            MediaPlayer sound_yes = MediaPlayer.create(context, R.raw.yes);
       MediaPlayer sound_no = MediaPlayer.create(context, R.raw.no);
            ImageView yes =  findViewById(R.id.yes);
            ImageView no =  findViewById(R.id.no);
            yes.setOnClickListener(v -> {
                sound_yes.start();
                        TextView score1 =  findViewById(R.id.score1);
                        TextView score2 =  findViewById(R.id.score2);
                        TextView player1 =  findViewById(R.id.player1);
                        TextView player2 = findViewById(R.id.player2);
                        if (player1.getCurrentTextColor() == Color.GREEN) {
                            int newScore =  Integer.parseInt(score1.getText().toString());
                            score1.setText(String.valueOf(newScore + 1));
                        } else {
                            int newScore = Integer.parseInt(score2.getText().toString());
                            score2.setText(String.valueOf(newScore + 1));
                        }
                player1.setTextColor(Color.WHITE);
                player2.setTextColor(Color.WHITE);
                        timer.cancel();
                        setNameColor();
                        setTask();
                        setTimer();
                    }
            );
            no.setOnClickListener(v -> {
                sound_no.start();
                        TextView player1 = findViewById(R.id.player1);
                        TextView player2 = findViewById(R.id.player2);
                player1.setTextColor(Color.WHITE);
                player2.setTextColor(Color.WHITE);
                        timer.cancel();
                        setNameColor();
                        setTask();
                        setTimer();

                    }
            );
        //
    }





//System button Back START
        @Override
        public void onBackPressed () {
            super.onBackPressed();

            try {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(StartGame2.this);
                } else {
                    Intent intent = new Intent(StartGame2.this, MainActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(StartGame2.this, MainActivity.class);
                startActivity(intent);
            } catch (Exception e) {

            }
        }
        //System button Back END



    @Override
    protected void onPause() {
        super.onPause();
       //saveTask();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //saveTask();
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       //saveTask();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }



}




