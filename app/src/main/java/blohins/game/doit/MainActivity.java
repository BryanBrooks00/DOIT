package blohins.game.doit;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    public static Toast backToast;
    final String TAG = "STATE";
    public static final String APP_PREFERENCES_COINS = "coins";
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


                        loadText();
        // button Start START
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            try {
                saveText();
                Intent intent = new Intent(MainActivity.this, StartGame2.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            try {
                saveText();
                Intent intent = new Intent(MainActivity.this, StartGame3.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            try {
                saveText();
                Intent intent = new Intent(MainActivity.this, StartGame4.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        });
        //Button Start END
    }


    //System button Back START
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
        saveText();
    }
    //System button Back END

    void saveText() {
        SharedPreferences save1 = MainActivity.this.getSharedPreferences("save1", MODE_PRIVATE);
        SharedPreferences.Editor editor = save1.edit();
        editor.apply();
    }

    void loadText() {
        SharedPreferences save1 = MainActivity.this.getSharedPreferences("save1", MODE_PRIVATE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveText();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveText();
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadText();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadText();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadText();
        Log.d(TAG, "onRestart");
    }
}


