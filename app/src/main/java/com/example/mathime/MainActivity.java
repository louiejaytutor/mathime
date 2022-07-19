package com.example.mathime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    TextView leaderboards;
    Button login, register, exit;
    int attempt = 3;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference users = db.getReference().child("users");
    DatabaseReference scores = db.getReference().child("scores");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        leaderboards = findViewById(R.id.leaderboards);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        exit = findViewById(R.id.exit);

        if (user == null) {
            Toast.makeText(this, "Welcome to Mathime", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this, startmenu.class);
            startActivity(intent);
        }

        leaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, leaderboards.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void loginUser() {
        String mail = email.getText().toString();
        String pass = password.getText().toString();

        if (mail.equals("") || pass.equals("")) {
            Toast.makeText(MainActivity.this, "Don't leave a blank field", Toast.LENGTH_SHORT).show();
        }
        else {
            if (attempt != 0) {
                auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener((new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, startmenu.class);
                            startActivity(intent);
                        }
                        else {
                            attempt = attempt - 1;
                            Toast.makeText(MainActivity.this, "Incorrect email or password. Attempts left: " + attempt, Toast.LENGTH_SHORT).show();
                        }
                    }
                }));
            }
            else {
                Toast.makeText(MainActivity.this, "Login attempts exceeded, please register first", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
    }
}