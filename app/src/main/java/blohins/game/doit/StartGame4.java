package blohins.game.doit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class StartGame4 extends AppCompatActivity {

    long duration = 31000;
    final String TAG = "STATE";

    Context context;
    String score = "0";


    private InterstitialAd mInterstitialAd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game4);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context = this;

        //ad

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
        //


        TextView score21 = findViewById(R.id.score21);
        TextView score22 =  findViewById(R.id.score22);
        TextView score23 = findViewById(R.id.score23);
        TextView score24 = findViewById(R.id.score24);
        TextView player21 =  findViewById(R.id.player21);
        TextView player22 =  findViewById(R.id.player22);
        TextView player23 =  findViewById(R.id.player23);
        TextView player24 =  findViewById(R.id.player24);

        player21.setText(R.string.p1);
        player22.setText(R.string.p2);
        player23.setText(R.string.p3);
        player24.setText(R.string.p4);

        score21.setText(score);
        score22.setText(score);
        score23.setText(score);
        score24.setText(score);
        score21.setTextColor(Color.WHITE);
        score22.setTextColor(Color.WHITE);
        score23.setTextColor(Color.WHITE);
        score24.setTextColor(Color.WHITE);


        //dialog4
        LayoutInflater abc4 = LayoutInflater.from(context);
        View promptsView4 = abc4.inflate(R.layout.prompt4, null);
        AlertDialog.Builder dialog4 = new AlertDialog.Builder(context);
        dialog4.setView(promptsView4);
        dialog4
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog4, int id) {
                                EditText input4 = promptsView4.findViewById(R.id.input4);
                                TextView player24 = findViewById(R.id.player24);
                                if (input4.getText().toString().equals("")){
                                    player24.setText(R.string.p4);
                                } else {
                                    String setText = input4.getText().toString();
                                    player24.setText(setText);
                                } player24.setTextColor(Color.WHITE);
                                //
                                setNameColor();
                                setTask();
                                setTimer();
                                //
                            }
                        });

        AlertDialog alertDialog4 = dialog4.create();
        alertDialog4.show();
        //dialog4



        //dialog3
        LayoutInflater abc3 = LayoutInflater.from(context);
        View promptsView3 = abc3.inflate(R.layout.prompt3, null);
        AlertDialog.Builder dialog3 = new AlertDialog.Builder(context);
        dialog3.setView(promptsView3);
        dialog3.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog3, int id) {
                                EditText input3 = promptsView3.findViewById(R.id.input3);
                                TextView player23 = findViewById(R.id.player23);
                                if (input3.getText().toString().equals("")){
                                    player23.setText(R.string.p3);
                                } else {
                                    String setText = input3.getText().toString();
                                    player23.setText(setText);
                                } player23.setTextColor(Color.WHITE);
                            }
                        });

        AlertDialog alertDialog3 = dialog3.create();
        alertDialog3.show();
        //dialog3

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
                                TextView player22 = findViewById(R.id.player22);
                                EditText input2 = promptsView2.findViewById(R.id.input2);
                                if (input2.getText().toString().equals("")){
                                    player22.setText(R.string.p2);
                                } else {
                                    String setText = input2.getText().toString();
                                    player22.setText(setText);
                                } player22.setTextColor(Color.WHITE);

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
                        TextView player21 = findViewById(R.id.player21);
                        if (input.getText().toString().equals("")){
                            player21.setText(R.string.p1);
                        } else {
                            String setText = input.getText().toString();
                            player21.setText(setText);
                        } player21.setTextColor(Color.WHITE);
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
                    mInterstitialAd.show(StartGame4.this);
                } else {
                    Intent intent = new Intent(StartGame4.this, MainActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(StartGame4.this, MainActivity.class);
                startActivity(intent);
            } catch (Exception e) {

            }
            //saveTask();
        });
        // Button Back END


    }

    public void setNameColor() {
        TextView player1 = findViewById(R.id.player21);
        TextView player2 = findViewById(R.id.player22);
        TextView player3 = findViewById(R.id.player23);
        TextView player4 = findViewById(R.id.player24);
        player1.setTextColor(Color.WHITE);
        player2.setTextColor(Color.WHITE);
        player3.setTextColor(Color.WHITE);
        player4.setTextColor(Color.WHITE);
        TextView[] name = {player1, player2, player3, player4};
        Random random = new Random();
        int randomizer = random.nextInt(name.length);
        (name[randomizer]).setTextColor(Color.GREEN);
        //
    }

    public void setTask() {
        //
        TextView todo = findViewById(R.id.todo);
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
                TextView chronometer = findViewById(R.id.chronometer);
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
        ImageView yes = findViewById(R.id.yes);
        ImageView no = findViewById(R.id.no);
        yes.setOnClickListener(v -> {
                    TextView score21 = findViewById(R.id.score21);
                    TextView score22 = findViewById(R.id.score22);
                    TextView score23 = findViewById(R.id.score23);
                    TextView score24 = findViewById(R.id.score24);
                    TextView player21 = findViewById(R.id.player21);
                    TextView player22 = findViewById(R.id.player22);
                    TextView player23 = findViewById(R.id.player23);
                    TextView player24 = findViewById(R.id.player24);
                    if (player21.getCurrentTextColor() == Color.GREEN) {
                        int newScore = Integer.parseInt(score21.getText().toString());
                        score21.setText(String.valueOf(newScore + 1));
                    } else if (player22.getCurrentTextColor() == Color.GREEN){
                        int newScore = Integer.parseInt(score22.getText().toString());
                        score22.setText(String.valueOf(newScore + 1));
                    } else if (player23.getCurrentTextColor() == Color.GREEN){
                        int newScore = Integer.parseInt(score23.getText().toString());
                        score23.setText(String.valueOf(newScore + 1));
                    } else {
                        int newScore = Integer.parseInt(score24.getText().toString());
                        score24.setText(String.valueOf(newScore + 1));
                    }
                    sound_yes.start();
                    player21.setTextColor(Color.WHITE);
                    player22.setTextColor(Color.WHITE);
                    player23.setTextColor(Color.WHITE);
                    player24.setTextColor(Color.WHITE);
                    timer.cancel();
                    setNameColor();
                    setTask();
                    setTimer();
                }
        );


        no.setOnClickListener(v -> {
                    TextView player21 = findViewById(R.id.player21);
                    TextView player22 = findViewById(R.id.player22);
                    TextView player23 = findViewById(R.id.player23);
                    TextView player24 = findViewById(R.id.player24);
                    sound_no.start();
                    player21.setTextColor(Color.WHITE);
                    player22.setTextColor(Color.WHITE);
                    player23.setTextColor(Color.WHITE);
                    player24.setTextColor(Color.WHITE);
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
    public void onBackPressed() {
        super.onBackPressed();

        try {
            if (mInterstitialAd != null) {
                mInterstitialAd.show(StartGame4.this);
            } else {
                Intent intent = new Intent(StartGame4.this, MainActivity.class);
                startActivity(intent);
            }
            Intent intent = new Intent(StartGame4.this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e) {

        }
    }
}
//System button Back END