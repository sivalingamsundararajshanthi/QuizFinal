//This activity is used to get the last score from the server and display it to the user
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HighScoreActivity extends AppCompatActivity {

    TextView high;
    FirebaseAuth auth;
    FirebaseDatabase database;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        back = findViewById(R.id.backBtnId);

        high = findViewById(R.id.highTvId);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = database.getReference(auth.getUid());

        //This gets the data from the FIREBASE server and displays the result to the user
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Score score = dataSnapshot.getValue(Score.class);
                if(score.getScore() == ""){
                    high.setText("The score from last game is 0");
                }else{
                    high.setText("The score from last game is " + score.getScore());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(HighScoreActivity.this, databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(HighScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
