package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    EditText emailId, password, fullName;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFireBaseAuth;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFireBaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        emailId = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordET);
        btnSignUp = findViewById(R.id.button);
        tvSignIn = findViewById(R.id.textView);
        fullName = findViewById(R.id.fullnameET);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set to final so variables can be accessed within onComplete() function (line 65)
                final String email = emailId.getText().toString();
                final String pwd = password.getText().toString();
                final String name = fullName.getText().toString();

                if(email.isEmpty()){
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    emailId.requestFocus();
                }
                else if(email.isEmpty() || pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter email and password.", Toast.LENGTH_SHORT).show();
                }
                else if(!email.isEmpty() && !pwd.isEmpty()){
                    // check against the list of emails already registered
                    mFireBaseAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                            boolean check = !task.getResult().getSignInMethods().isEmpty();

                            if(check) {
                                Toast.makeText(MainActivity.this, "Account already exists. Go to 'Already have an account?", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                mFireBaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(!task.isSuccessful()){
                                            Toast.makeText(MainActivity.this,"Email or Password Incorrect.", Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this,"Registration Successful.", Toast.LENGTH_SHORT).show();
                                            // store the users name in the database.
                                            userID = mFireBaseAuth.getCurrentUser().getUid();
                                            DocumentReference documentReference = fStore.collection("users").document(userID);
                                            Map<String, Object> user = new HashMap<>();
                                            user.put("fullName", name);
                                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Log.d("Tag", "On success: user profile is created for " + userID);
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Log.d("Tag", "On failure: " + e.toString());
                                                }
                                            });
                                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(MainActivity.this,"Error Occurred.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
