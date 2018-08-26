//This activity is used to display the score, number of question correct and number of questions wrong
//This activity also adds the final score to the FIREBASE database
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class resultActivity extends AppCompatActivity {

    TextView resTv, correct, incorrect;
    Button fin;
    FirebaseAuth mauth;
    private Questions questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resTv = findViewById(R.id.resultId);
        correct = findViewById(R.id.corTvId);
        incorrect = findViewById(R.id.incorTvId);
        fin   = findViewById(R.id.finBtnId);

        questions = new Questions();

        mauth = FirebaseAuth.getInstance();



        Integer sc = getIntent().getExtras().getInt("score");
        //Integer c = getIntent().getExtras().getInt("correct");
        final Integer in = getIntent().getExtras().getInt("incorrect");

        resTv.setText(String.valueOf(sc));
        correct.setText(String.valueOf(sc));
        incorrect.setText(String.valueOf(in));
        String val = String.valueOf(sc);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(mauth.getUid());
        Score score = new Score(val);
        myRef.setValue(score);

        //This button takes the user back to the mainactivity
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questions.setScore(0);
                questions.setWeek(0);
                questions.setCorrect(0);
                questions.setInCorrect(0);
                finish();
                Intent intent = new Intent(resultActivity.this,MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /*private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(mauth.getUid());
        myRef.setValue(sc);
    }*/
}
