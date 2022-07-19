package com.example.mathime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class startmenu extends AppCompatActivity {

    LinearLayout ll1, rules1, rules2;
    TextView username;
    Button leaderboards, profile, logout, play, next, previous;
    ProgressBar progressbar;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("users");
    FirebaseUser user = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startmenu);

        ll1 = findViewById(R.id.ll1);
        rules1 = findViewById(R.id.rules1);
        rules2 = findViewById(R.id.rules2);
        leaderboards = findViewById(R.id.leaderboards);
        profile = findViewById(R.id.profile);
        username = findViewById(R.id.username);
        logout = findViewById(R.id.logout);
        play = findViewById(R.id.play);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        progressbar = findViewById(R.id.progressbar);

        getIntent().removeExtra("username");
        getIntent().removeExtra("password");

        getIntent().removeExtra("log1");
        getIntent().removeExtra("log2");
        getIntent().removeExtra("log3");
        getIntent().removeExtra("log4");
        getIntent().removeExtra("log5");
        getIntent().removeExtra("log6");
        getIntent().removeExtra("log7");
        getIntent().removeExtra("log8");
        getIntent().removeExtra("log9");
        getIntent().removeExtra("log10");
        getIntent().removeExtra("log11");
        getIntent().removeExtra("log12");
        getIntent().removeExtra("log13");
        getIntent().removeExtra("log14");
        getIntent().removeExtra("log15");
        getIntent().removeExtra("log16");
        getIntent().removeExtra("log17");
        getIntent().removeExtra("log18");
        getIntent().removeExtra("log19");
        getIntent().removeExtra("log20");

        getIntent().removeExtra("q1");
        getIntent().removeExtra("q2");
        getIntent().removeExtra("q3");
        getIntent().removeExtra("q4");
        getIntent().removeExtra("q5");
        getIntent().removeExtra("q6");
        getIntent().removeExtra("q7");
        getIntent().removeExtra("q8");
        getIntent().removeExtra("q9");
        getIntent().removeExtra("q10");
        getIntent().removeExtra("q11");
        getIntent().removeExtra("q12");
        getIntent().removeExtra("q13");
        getIntent().removeExtra("q14");
        getIntent().removeExtra("q15");
        getIntent().removeExtra("q16");
        getIntent().removeExtra("q17");
        getIntent().removeExtra("q18");
        getIntent().removeExtra("q19");
        getIntent().removeExtra("q20");

        getIntent().removeExtra("s1");
        getIntent().removeExtra("s2");
        getIntent().removeExtra("s3");
        getIntent().removeExtra("s4");
        getIntent().removeExtra("s5");
        getIntent().removeExtra("s6");
        getIntent().removeExtra("s7");
        getIntent().removeExtra("s8");
        getIntent().removeExtra("s9");
        getIntent().removeExtra("s10");
        getIntent().removeExtra("s11");
        getIntent().removeExtra("s12");
        getIntent().removeExtra("s13");
        getIntent().removeExtra("s14");
        getIntent().removeExtra("s15");
        getIntent().removeExtra("s16");
        getIntent().removeExtra("s17");
        getIntent().removeExtra("s18");
        getIntent().removeExtra("s19");
        getIntent().removeExtra("s20");

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                rules1.setVisibility(View.VISIBLE);
                rules2.setVisibility(View.GONE);
                String uid = user.getUid();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String name = snapshot.child(uid).child("username").getValue().toString();
                    progressbar.setVisibility(View.GONE);
                    ll1.setVisibility(View.VISIBLE);
                    username.setText("Welcome " + name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        leaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(startmenu.this, leaderboards.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(startmenu.this, profile.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(startmenu.this, "Logout successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(startmenu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(startmenu.this, stages.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rules1.setVisibility(View.GONE);
                rules2.setVisibility(View.VISIBLE);
                previous.setEnabled(true);
                play.setVisibility(View.VISIBLE);
                next.setVisibility(View.GONE);
                previous.setBackgroundColor(Color.parseColor("#D6F458"));
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rules1.setVisibility(View.VISIBLE);
                rules2.setVisibility(View.GONE);
                play.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                previous.setEnabled(false);
                previous.setBackgroundColor(Color.parseColor("#808080"));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null) {
            Intent intent = new Intent(startmenu.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
    }
}