//This activity is used to send the password reset link
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    EditText email;
    Button reset;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.passEtId);
        reset = findViewById(R.id.passwordBtnId);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();

                if(mail.isEmpty()){
                    Toast.makeText(ForgotActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else {
                    //This method is used to send the email reset link to the entered email id
                    auth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotActivity.this, "Email sent!!!", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent intent = new Intent(ForgotActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ForgotActivity.this, "Email not registered!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
