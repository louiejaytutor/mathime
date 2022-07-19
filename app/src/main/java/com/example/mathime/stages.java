package com.example.mathime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class stages extends AppCompatActivity {

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("users");
    DatabaseReference score = db.getReference().child("scores");

    LinearLayout ll;
    TextView stage, problem, canswer, yanswer, points, time, correct, wrong;
    EditText answer;
    Button enter, logs, home, next;
    int countdown = 0, s = 1, correct_answer;
    int point = 0;
    int n1, n2, n3, n4, n5, rand;
    long secs, nextstagecountdown;
    String dec;
    String log1, log2, log3, log4, log5, log6, log7, log8, log9, log10, log11, log12, log13, log14, log15, log16, log17, log18, log19, log20;
    String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20;
    CountDownTimer cdt, cdt5;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages);

        ll = findViewById(R.id.linear);
        stage = findViewById(R.id.stage);
        problem = findViewById(R.id.problem);
        canswer = findViewById(R.id.correct_answer);
        yanswer = findViewById(R.id.your_answer);
        points = findViewById(R.id.points);
        time = findViewById(R.id.time);
        correct = findViewById(R.id.correct);
        wrong = findViewById(R.id.wrong);
        answer = findViewById(R.id.answer);
        enter = findViewById(R.id.enter);
        next = findViewById(R.id.next);
        logs = findViewById(R.id.logs);
        home = findViewById(R.id.home);
        random = new Random();

        if (s == 1) {
            nextStage();
        }

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useranswer = answer.getText().toString();
                if (useranswer.equals("")) {
                    Toast.makeText(stages.this, "Please enter answer", Toast.LENGTH_SHORT).show();
                }
                else {
                    cdt.cancel();
                    answer.setVisibility(View.GONE);
                    canswer.setVisibility(View.VISIBLE);
                    enter.setVisibility(View.GONE);
                    next.setVisibility(View.VISIBLE);

                    int ans = Integer.parseInt(useranswer);
                    if (ans == correct_answer) {
                        time.setText("⏰: " + countdown);
                        point = point + countdown;
                        points.setText("Points: " + point);
                        dec = "correct";
                        Toast.makeText(stages.this, "+" + countdown + " points", Toast.LENGTH_SHORT).show();
                        yanswer.setTextColor(Color.parseColor("#92d050"));
                        correct.setVisibility(View.VISIBLE);
                    }
                    else {
                        dec = "wrong";
                        wrong.setVisibility(View.VISIBLE);
                        yanswer.setTextColor(Color.parseColor("#e35045"));
                    }
                    canswer.setVisibility(View.VISIBLE);
                    canswer.setText("Correct Answer: " + correct_answer);
                    yanswer.setVisibility(View.VISIBLE);
                    yanswer.setText("Your Answer: " + ans);

                    cdt5();
                    extra();
                }
            }
        });

        logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stages.this, logs.class);
                intent.putExtra("log1", log1);
                intent.putExtra("log2", log2);
                intent.putExtra("log3", log3);
                intent.putExtra("log4", log4);
                intent.putExtra("log5", log5);
                intent.putExtra("log6", log6);
                intent.putExtra("log7", log7);
                intent.putExtra("log8", log8);
                intent.putExtra("log9", log9);
                intent.putExtra("log10", log10);
                intent.putExtra("log11", log11);
                intent.putExtra("log12", log12);
                intent.putExtra("log13", log13);
                intent.putExtra("log14", log14);
                intent.putExtra("log15", log15);
                intent.putExtra("log16", log16);
                intent.putExtra("log17", log17);
                intent.putExtra("log18", log18);
                intent.putExtra("log19", log19);
                intent.putExtra("log20", log20);

                intent.putExtra("q1", q1);
                intent.putExtra("q2", q2);
                intent.putExtra("q3", q3);
                intent.putExtra("q4", q4);
                intent.putExtra("q5", q5);
                intent.putExtra("q6", q6);
                intent.putExtra("q7", q7);
                intent.putExtra("q8", q8);
                intent.putExtra("q9", q9);
                intent.putExtra("q10", q10);
                intent.putExtra("q11", q11);
                intent.putExtra("q12", q12);
                intent.putExtra("q13", q13);
                intent.putExtra("q14", q14);
                intent.putExtra("q15", q15);
                intent.putExtra("q16", q16);
                intent.putExtra("q17", q17);
                intent.putExtra("q18", q18);
                intent.putExtra("q19", q19);
                intent.putExtra("q20", q20);

                intent.putExtra("s1", s1);
                intent.putExtra("s2", s2);
                intent.putExtra("s3", s3);
                intent.putExtra("s4", s4);
                intent.putExtra("s5", s5);
                intent.putExtra("s6", s6);
                intent.putExtra("s7", s7);
                intent.putExtra("s8", s8);
                intent.putExtra("s9", s9);
                intent.putExtra("s10", s10);
                intent.putExtra("s11", s11);
                intent.putExtra("s12", s12);
                intent.putExtra("s13", s13);
                intent.putExtra("s14", s14);
                intent.putExtra("s15", s15);
                intent.putExtra("s16", s16);
                intent.putExtra("s17", s17);
                intent.putExtra("s18", s18);
                intent.putExtra("s19", s19);
                intent.putExtra("s20", s20);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stages.this, "Stages has been reset since returned to home.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(stages.this, startmenu.class);
                startActivity(intent);
            }
        });
    }

    private void nextStage() {
        canswer.setVisibility(View.GONE);
        yanswer.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        correct.setVisibility(View.GONE);
        wrong.setVisibility(View.GONE);
        enter.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        answer.setText("");
        time.setTextColor(Color.parseColor("#3a3a3a"));
        time.setBackgroundResource(R.drawable.green);

        if (s >= 1 && s <= 5) {
            stage.setText("Stage " + s + ": Easy");
            random();
            if (rand == 1) {
                correct_answer = n1 + n2;
                problem.setText(n1 + " + " + n2);
            }
            else if (rand == 2) {
                correct_answer = n1 - n2;
                problem.setText(n1 + " - " + n2);
            }
            else if (rand == 3) {
                correct_answer = n1 * n2;
                problem.setText(n1 + " × " + n2);
            }
            else {
                correct_answer = n1 / n2;
                problem.setText(n1 + " ÷ " + n2);
            }
        }
        else if (s >= 6 && s <= 10) {
            stage.setText("Stage " + s + ": Medium");
            random();
            if (rand == 1) {
                correct_answer = n1 + n2 - n3;
                problem.setText(n1 + " + " + n2 + " - " + n3);
            }
            else if (rand == 2) {
                correct_answer = n1 - n2 * n3;
                problem.setText(n1 + " - (" + n2 + " × " + n3 + ")");
            }
            else if (rand == 3) {
                correct_answer = n1 * n2 / n3;
                problem.setText("(" + n1 + " × " + n2 + ") ÷ " + n3);
            }
            else {
                correct_answer = n1 / n2 + n3;
                problem.setText("(" + n1 + " ÷ " + n2 + ") + " + n3);
            }
        }
        else if (s >= 11 && s <= 15) {
            stage.setText("Stage " + s + ": Hard");
            random();
            if (rand == 1) {
                correct_answer = n1 + n2 - n3 * n4;
                problem.setText(n1 + " + " + n2 + " - (" + n3 + " × " + n4 + ")");
            }
            else if (rand == 2) {
                correct_answer = n1 - n2 * n3 / n4;
                problem.setText(n1 + " - ((" + n2 + " × " + n3 + ") ÷ " + n4 + ")");
            }
            else if (rand == 3) {
                correct_answer = n1 * n2 / n3 + n4;
                problem.setText("((" + n1 + " × " + n2 + ") ÷ " + n3 + ") + " + n4);
            }
            else {
                correct_answer = n1 / n2 + n3 - n4;
                problem.setText("(" + n1 + " ÷ " + n2 + ") + " + n3 + " - " + n4);
            }
        }
        else if (s >= 16 && s <= 20) {
            stage.setText("Stage " + s + ": Extreme");
            random();
            if (rand == 1) {
                correct_answer = n1 + n2 - n3 * n4 / n5;
                problem.setText(n1 + " + " + n2 + " - ((" + n3 + " * " + n4 + ") ÷ " + n5 + ")");
            }
            else if (rand == 2) {
                correct_answer = n1 - n2 * n3 / n4 + n5;
                problem.setText(n1 + " - ((" + n2 + " × " + n3 + ") ÷ " + n4 + ") + " + n5);
            }
            else if (rand == 3) {
                correct_answer = n1 * n2 / n3 + n4 - n5;
                problem.setText("((" + n1 + " × " + n2 + ") ÷ " + n3 + ") + " + n4 + " - " + n5);
            }
            else {
                correct_answer = n1 / n2 + n3 - n4 * n5;
                problem.setText("(" + n1 + " ÷ " + n2 + ") + " + n3 + " - (" + n4 + " × " + n5 + ")");
            }
        }
        cdt();
    }

    private void updateScore() {
        score.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String uid = user.getUid();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String userscore = snapshot.child(uid).child("highscore").getValue().toString();
                    int highscore = Integer.parseInt(userscore);
                    if (point > highscore) {
                        score.child(uid).child("highscore").setValue(String.valueOf(point));
                        Toast.makeText(stages.this, "CONGRATULATIONS! You have set your new record", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(stages.this, "CONGRATULATIONS! You have finished the game", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void cdt() {
        cdt = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secs = millisUntilFinished / 1000;
                countdown = (int)secs;
                if (secs > 10) {
                    time.setText("⏰: " + secs);
                }
                else {
                    time.setText("⏰: " + secs);
                    time.setTextColor(Color.parseColor("#ffffff"));
                    time.setBackgroundResource(R.drawable.red);
                }
            }

            @Override
            public void onFinish() {
                countdown = 0;
                answer.setText("none");
                answer.setVisibility(View.GONE);
                canswer.setVisibility(View.VISIBLE);
                enter.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                yanswer.setTextColor(Color.parseColor("#e35045"));
                canswer.setText("Correct Answer: " + correct_answer);
                yanswer.setVisibility(View.VISIBLE);
                yanswer.setText("Time's up!");
                wrong.setVisibility(View.VISIBLE);
                dec = "wrong";

                extra();
                cdt5();
            }
        }.start();
    }

    private void cdt5() {
        cdt5 = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                nextstagecountdown = l / 1000;
                int ns = (int)nextstagecountdown;
                next.setText("Next stage in " + ns);
            }
            @Override
            public void onFinish() {
                s = s + 1;
                if (s <= 20) {
                    nextStage();
                }
                else {
                    logs.setVisibility(View.VISIBLE);
                    enter.setVisibility(View.GONE);
                    next.setVisibility(View.GONE);

                    updateScore();
                }
            }
        }.start();
    }

    private void random() {
        n1 = random.nextInt(21 - 1) + 1;
        n2 = random.nextInt(21 - 1) + 1;
        n3 = random.nextInt(21 - 1) + 1;
        n4 = random.nextInt(21 - 1) + 1;
        n5 = random.nextInt(21 - 1) + 1;
        rand = random.nextInt(5 - 1) + 1;
    }

    private void extra() {
        int t = 30 - countdown;
        String prob = problem.getText().toString();
        String question = prob.replace(" ", "");
        if (s == 1) {
            log1 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q1 = dec;
            s1 = String.valueOf(secs);
        }
        else if (s == 2) {
            log2 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q2 = dec;
            s2 = String.valueOf(secs);
        }
        else if (s == 3) {
            log3 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q3 = dec;
            s3 = String.valueOf(secs);
        }
        else if (s == 4) {
            log4 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q4 = dec;
            s4 = String.valueOf(secs);
        }
        else if (s == 5) {
            log5 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q5 = dec;
            s5 = String.valueOf(secs);
        }
        else if (s == 6) {
            log6 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q6 = dec;
            s6 = String.valueOf(secs);
        }
        else if (s == 7) {
            log7 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q7= dec;
            s7 = String.valueOf(secs);
        }
        else if (s == 8) {
            log8 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q8 = dec;
            s8 = String.valueOf(secs);
        }
        else if (s == 9) {
            log9 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q9 = dec;
            s9 = String.valueOf(secs);
        }
        else if (s == 10) {
            log10 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q10 = dec;
            s10 = String.valueOf(secs);
        }
        else if (s == 11) {
            log11 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q11 = dec;
            s11 = String.valueOf(secs);
        }
        else if (s == 12) {
            log12 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q12 = dec;
            s12 = String.valueOf(secs);
        }
        else if (s == 13) {
            log13 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q13 = dec;
            s13 = String.valueOf(secs);
        }
        else if (s == 14) {
            log14 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q14 = dec;
            s14 = String.valueOf(secs);
        }
        else if (s == 15) {
            log15 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q15 = dec;
            s15 = String.valueOf(secs);
        }
        else if (s == 16) {
            log16 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q16 = dec;
            s16 = String.valueOf(secs);
        }
        else if (s == 17) {
            log17 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q17 = dec;
            s17 = String.valueOf(secs);
        }
        else if (s == 18) {
            log18 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q18 = dec;
            s18 = String.valueOf(secs);
        }
        else if (s == 19) {
            log19 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q19 = dec;
            s19 = String.valueOf(secs);
        }
        else {
            log20 = "Stage " + s + ": " + question + "\nYour answer: " + answer.getText().toString() + "\nCorrect answer: " + correct_answer + "\nCurrent Points: " + point + "\nAnswered in " + t + " seconds";
            q20 = dec;
            s20 = String.valueOf(secs);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null) {
            Intent intent = new Intent(stages.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
    }
}