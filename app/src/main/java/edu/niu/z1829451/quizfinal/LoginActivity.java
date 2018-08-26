//This activity is used to implement the login functionality using Firebase functionality
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mauth;
    EditText userEt, passEt;
    TextView forgotEt;
    Button login, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mauth = FirebaseAuth.getInstance();

        userEt = findViewById(R.id.userNameEtId);
        passEt = findViewById(R.id.passwordEtId);

        login = findViewById(R.id.logBtnId);
        signUp = findViewById(R.id.signBtnId);

        forgotEt = findViewById(R.id.forgotTvId);

        forgotEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userEt.getText().toString();
                String pass = passEt.getText().toString();

                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
                } else {
                    //This method is used to authenticate the user by using the FIREBASE authentication
                    mauth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                finish();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            } else {
                                //If there is some problem this toast message is displayed
                                Toast.makeText(LoginActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mauth.getCurrentUser() != null){
            finish();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        if(mauth.getCurrentUser() != null){
            finish();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if(mauth.getCurrentUser() != null){
            finish();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }*/
}
