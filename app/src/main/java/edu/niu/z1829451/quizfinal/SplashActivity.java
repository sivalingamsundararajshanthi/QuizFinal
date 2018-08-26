//This activity is used to display the splash screen for a certain period of time
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 5000);  //The splash screen will be displayed for 5000ms
    }
}
