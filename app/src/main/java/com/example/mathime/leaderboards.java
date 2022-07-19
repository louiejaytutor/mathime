package com.example.mathime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class leaderboards extends AppCompatActivity {

    Button home;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("users");
    DatabaseReference score = db.getReference().child("scores");
    FirebaseUser user = auth.getCurrentUser();

    ListView listview;
    ListView listview1;
    ListView rank;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList1 = new ArrayList<>();
    ArrayList<Integer> arrayList2 = new ArrayList<>();

    String username, highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        home = findViewById(R.id.home);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(leaderboards.this, android.R.layout.simple_list_item_1, arrayList);
        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(leaderboards.this, android.R.layout.simple_list_item_1, arrayList1);
        final ArrayAdapter<Integer> arrayAdapter2 = new ArrayAdapter<Integer>(leaderboards.this, android.R.layout.simple_list_item_1, arrayList2);

        listview = findViewById(R.id.listview);
        listview1 = findViewById(R.id.listview1);
        rank = findViewById(R.id.rank);
        listview.setAdapter(arrayAdapter);
        listview1.setAdapter(arrayAdapter1);
        rank.setAdapter(arrayAdapter2);

        score.orderByChild("highscore").limitToLast(5).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                username = snapshot.child("username").getValue().toString();
                highscore = snapshot.child("highscore").getValue().toString();

                arrayList.add(username);
                arrayList1.add(highscore);
                arrayList2.add(arrayList.size());

                if (arrayList.size() == 5) {
                    Collections.reverse(arrayList);
                    Collections.reverse(arrayList1);
                }

                arrayAdapter.notifyDataSetChanged();
                arrayAdapter1.notifyDataSetChanged();
                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                arrayAdapter.notifyDataSetChanged();
                arrayAdapter1.notifyDataSetChanged();
                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user == null) {
                    Intent intent = new Intent(leaderboards.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(leaderboards.this, startmenu.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}