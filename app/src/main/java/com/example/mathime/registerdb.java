package com.example.mathime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class registerdb extends AppCompatActivity {

    Timer timer = new Timer();

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("users");
    DatabaseReference score = db.getReference().child("scores");
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerdb);

        registerDatabase();
        Toast.makeText(this, "Registration success", Toast.LENGTH_SHORT).show();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(registerdb.this, startmenu.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void registerDatabase() {
        String mail = user.getEmail();
        String uid = user.getUid();
        String username = getIntent().getStringExtra("username");
        String pass = getIntent().getStringExtra("password");

        root.child(uid).child("email").setValue(mail);
        root.child(uid).child("password").setValue(pass);
        root.child(uid).child("username").setValue(username);

        score.child(uid).child("username").setValue(username);
        score.child(uid).child("highscore").setValue("0");
    }

    @Override
    public void onBackPressed() {
    }
}