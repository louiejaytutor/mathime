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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    EditText email, username, password, confirm_password;
    Button register, login;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createUser() {
        String mail = email.getText().toString();
        String un = username.getText().toString();
        String pass = password.getText().toString();
        String cpass = confirm_password.getText().toString();

        if (pass.equals(cpass)) {
            if (pass.equals("")) {
                Toast.makeText(register.this, "Don't leave a blank field", Toast.LENGTH_SHORT).show();
            }
            else {
                auth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(register.this, registerdb.class);
                            intent.putExtra("username", un);
                            intent.putExtra("password", pass);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(register.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
        else if (mail.equals("") || un.equals("") || pass.equals("") || cpass.equals("")) {
            Toast.makeText(register.this, "Don't leave a blank field", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
    }
}