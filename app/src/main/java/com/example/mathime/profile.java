package com.example.mathime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    ProgressBar progressBar;
    LinearLayout linearLayout;
    TextView email, name, highest_score, change_password, delete_account, question;
    Button back, yes, no;
    String mail, uid;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("users");
    DatabaseReference score = db.getReference().child("scores");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressBar = findViewById(R.id.progressbar);
        linearLayout = findViewById(R.id.linearlayout);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        highest_score = findViewById(R.id.highest_score);
        change_password = findViewById(R.id.change_password);
        delete_account = findViewById(R.id.delete_account);
        question = findViewById(R.id.question);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        back = findViewById(R.id.back);
        mail = user.getEmail();
        uid = user.getUid();

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String username = snapshot.child(uid).child("username").getValue().toString();

                    email.setText("" + mail);
                    name.setText("" + username);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        score.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String highscore = snapshot.child(uid).child("highscore").getValue().toString();

                    highest_score.setText("" + highscore);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, changepassword.class);
                startActivity(intent);
            }
        });

        delete_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.setVisibility(View.VISIBLE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                change_password.setVisibility(View.GONE);
                delete_account.setVisibility(View.GONE);
                back.setVisibility(View.GONE);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            root.child(String.valueOf(uid)).removeValue();
                            score.child(String.valueOf(uid)).removeValue();
                            Toast.makeText(profile.this, "Account successfully deleted", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(profile.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(profile.this, "Error deleting an account", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.setVisibility(View.GONE);
                yes.setVisibility(View.GONE);
                no.setVisibility(View.GONE);
                change_password.setVisibility(View.VISIBLE);
                delete_account.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, startmenu.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null) {
            Intent intent = new Intent(profile.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
    }
}