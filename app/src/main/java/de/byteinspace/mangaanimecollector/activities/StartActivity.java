package de.byteinspace.mangaanimecollector.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import de.byteinspace.mangaanimecollector.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Handler handler = new Handler();
        handler.postDelayed(getNewRunnable(), 4000);




    }

    protected void showNextScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private Runnable getNewRunnable() {
        return  new Runnable() {

            @Override
            public void run() {
                showNextScreen();


            }
        };
    }
}