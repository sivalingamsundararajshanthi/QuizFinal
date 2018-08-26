//This method is used to let the user select a week and based on the week the set of questions is displayed
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mauth;
    Button logOutBtn;
    private Integer wk = 0;
    private RadioButton w1, w2, w3, w4, w5, w6;
    private TextView high;
    Button goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logOutBtn = findViewById(R.id.logOutBtnId);

        high = findViewById(R.id.clickTvId);

        mauth = FirebaseAuth.getInstance();

        w1  = findViewById(R.id.week1Id);
        w2  = findViewById(R.id.week2Id);
        w3  = findViewById(R.id.week3Id);
        w4  = findViewById(R.id.week4Id);
        w5  = findViewById(R.id.week5Id);
        w6  = findViewById(R.id.week6Id);

        goBtn = findViewById(R.id.goBtnId);

        //This takes us to the high score activity
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(intent);
            }
        });

        //This displays the various questions in a seperate activity
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(w1.isChecked()){
                    wk = 1;
                    finish();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("week",wk);
                    startActivity(intent);
                } else if(w2.isChecked()){
                    wk = 2;
                    finish();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("week",wk);
                    startActivity(intent);
                } else if(w3.isChecked()){
                    wk = 3;
                    finish();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("week",wk);
                    startActivity(intent);
                } else if(w4.isChecked()){
                    wk = 4;
                    finish();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("week",wk);
                    startActivity(intent);
                } else if(w5.isChecked()){
                    wk = 5;
                    finish();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("week",wk);
                    startActivity(intent);
                } else if(w6.isChecked()){
                    wk = 6;
                    finish();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("week",wk);
                    startActivity(intent);
                }
            }
        });

        //Logout button which signs out the user from the current session
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mauth.getCurrentUser() == null){
            finish();

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
