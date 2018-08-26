//This activity lets the user to register. The credentials are added to the FIREBASE
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText userName, passwd;
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        userName = findViewById(R.id.namesignUpId);
        passwd   = findViewById(R.id.passsignUpId);

        regBtn = findViewById(R.id.regSignId);
    }

    public void reg(View view){
        String user = userName.getText().toString();
        String pa   = passwd.getText().toString();

        if(user.isEmpty() || pa.isEmpty()){
            Toast.makeText(SignUpActivity.this, "Please complete fields", Toast.LENGTH_SHORT).show();
        } else {
            //This function checks if the user is already registered if not the credentials are added to the server
            mAuth.createUserWithEmailAndPassword(user,pa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        finish();
                        mAuth.signOut();
                        Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }else{
                        if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            Toast.makeText(SignUpActivity.this, "User already registered", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(SignUpActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
