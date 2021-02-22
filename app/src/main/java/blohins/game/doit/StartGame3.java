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


public class StartGame3 extends AppCompatActivity {

    long duration = 31000;
    final String TAG = "STATE";

    Context context;
    String score = "0";
    private InterstitialAd mInterstitialAd;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game3);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context = this;


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


        TextView score11 = findViewById(R.id.score11);
        TextView score12 =  findViewById(R.id.score12);
        TextView score13 = findViewById(R.id.score13);
        TextView player11 =  findViewById(R.id.player11);
        TextView player12 =  findViewById(R.id.player12);
        TextView player13 =  findViewById(R.id.player13);

        player11.setText(R.string.p1);
        player12.setText(R.string.p2);
        player13.setText(R.string.p3);

        score11.setText(score);
        score12.setText(score);
        score13.setText(score);
        score11.setTextColor(Color.WHITE);
        score12.setTextColor(Color.WHITE);
        score13.setTextColor(Color.WHITE);



        //dialog3
        LayoutInflater abc3 = LayoutInflater.from(context);
        View promptsView3 = abc3.inflate(R.layout.prompt3, null);
        AlertDialog.Builder dialog3 = new AlertDialog.Builder(context);
        dialog3.setView(promptsView3);
        dialog3.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog3, int id) {
                                EditText input = promptsView3.findViewById(R.id.input3);
                                TextView player13 = findViewById(R.id.player13);
                                if (input.getText().toString().equals("")){
                                    player13.setText(R.string.p3);
                                } else {
                                    String setText = input.getText().toString();
                                    player13.setText(setText);
                                } player13.setTextColor(Color.WHITE);
                                //
                                setNameColor();
                                setTask();
                                setTimer();
                                //
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
                                EditText input = promptsView2.findViewById(R.id.input2);
                                if (input.getText().toString().equals("")){
                                    player12.setText(R.string.p2);
                                } else {
                                    String setText = input.getText().toString();
                                    player12.setText(setText);
                                } player12.setTextColor(Color.WHITE);
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
                        if (input.getText().toString().equals("")){
                            player11.setText(R.string.p1);
                        } else {
                            String setText = input.getText().toString();
                            player11.setText(setText);
                        } player11.setTextColor(Color.WHITE);
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
                    mInterstitialAd.show(StartGame3.this);
                } else {
                    Intent intent = new Intent(StartGame3.this, MainActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(StartGame3.this, MainActivity.class);
                startActivity(intent);
            } catch (Exception e) {

            }
            //saveTask();
        });
        // Button Back END


    }

    public void setNameColor() {
        TextView player11 = findViewById(R.id.player11);
        TextView player12 = findViewById(R.id.player12);
        TextView player13 = findViewById(R.id.player13);
        player11.setTextColor(Color.WHITE);
        player12.setTextColor(Color.WHITE);
        player13.setTextColor(Color.WHITE);
        TextView[] name = {player11, player12, player13};
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
                    TextView score11 = findViewById(R.id.score11);
                    TextView score12 = findViewById(R.id.score12);
                    TextView score13 = findViewById(R.id.score13);
                    TextView player11 = findViewById(R.id.player11);
                    TextView player12 = findViewById(R.id.player12);
                    TextView player13 = findViewById(R.id.player13);
                    if (player11.getCurrentTextColor() == Color.GREEN) {
                        int newScore = Integer.parseInt(score11.getText().toString());
                        score11.setText(String.valueOf(newScore + 1));
                    } else if (player12.getCurrentTextColor() == Color.GREEN){
                        int newScore = Integer.parseInt(score12.getText().toString());
                        score12.setText(String.valueOf(newScore + 1));
                    } else {
                        int newScore = Integer.parseInt(score13.getText().toString());
                        score13.setText(String.valueOf(newScore + 1));
                    }
                    sound_yes.start();
                    player11.setTextColor(Color.WHITE);
                    player12.setTextColor(Color.WHITE);
                    player13.setTextColor(Color.WHITE);
                    timer.cancel();
                    setNameColor();
                    setTask();
                    setTimer();
                }
        );

        no.setOnClickListener(v -> {
                    TextView player11 = findViewById(R.id.player11);
                    TextView player12 = findViewById(R.id.player12);
                    TextView player13 = findViewById(R.id.player13);
                    sound_no.start();
            player11.setTextColor(Color.WHITE);
            player12.setTextColor(Color.WHITE);
            player13.setTextColor(Color.WHITE);
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
                mInterstitialAd.show(StartGame3.this);
            } else {
                Intent intent = new Intent(StartGame3.this, MainActivity.class);
                startActivity(intent);
            }
            Intent intent = new Intent(StartGame3.this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e) {

        }
    }
}
//System button Back END