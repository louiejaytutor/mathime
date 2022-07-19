package com.example.mathime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class changepassword extends AppCompatActivity {

    EditText current_password, new_password, confirm_password;
    Button change_password, back;
    String password;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("users");
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        current_password = findViewById(R.id.current_password);
        new_password = findViewById(R.id.new_password);
        confirm_password = findViewById(R.id.confirm_password);
        change_password = findViewById(R.id.change_password);
        back = findViewById(R.id.back);

        String uid = user.getUid();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    password = snapshot.child(uid).child("password").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curpass = current_password.getText().toString();
                String newpass = new_password.getText().toString();
                String conpass = confirm_password.getText().toString();

                if (curpass.equals(password)) {
                    if (curpass.equals(newpass)) {
                        Toast.makeText(changepassword.this, "Your new password cannot be the same as your current password", Toast.LENGTH_SHORT).show();
                    }
                    else if (newpass.equals(conpass)) {
                        user.updatePassword(newpass).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    root.child(uid).child("password").setValue(newpass);
                                    auth.signOut();

                                    Toast.makeText(changepassword.this, "Password successfully changed. Please login again", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(changepassword.this, MainActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(changepassword.this, "Password must be 6 characters or longer", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else {
                        Toast.makeText(changepassword.this, "New password and confirm password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(changepassword.this, "Incorrect current password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(changepassword.this, profile.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null) {
            Intent intent = new Intent(changepassword.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
    }
}