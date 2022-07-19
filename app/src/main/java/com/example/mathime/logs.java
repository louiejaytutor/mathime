package com.example.mathime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class logs extends AppCompatActivity {

    TextView log1, log2, log3, log4, log5, log6, log7, log8, log9, log10, log11, log12, log13, log14, log15, log16, log17, log18, log19, log20;
    TextView logsstat, canswers, wanswers, score, easystage, mediumstage, hardstage, extremestage, points, easypoints, mediumpoints, hardpoints, extremepoints, ttime, tpstage;
    String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;
    int s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20;
    int pe = 0, pm = 0, ph = 0, pex = 0;
    int easy = 0, medium = 0, hard = 0, extreme = 0;
    int ca = 0;
    Button stats, logs, leaderboards;
    LinearLayout ll, ll1;
    ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        logsstat = findViewById(R.id.logsstat);
        stats = findViewById(R.id.stats);
        logs = findViewById(R.id.logs);
        leaderboards = findViewById(R.id.leaderboards);
        ll = findViewById(R.id.linearlayout);
        ll1 = findViewById(R.id.linearlayout1);
        sv = findViewById(R.id.sv1);
        canswers = findViewById(R.id.canswers);
        wanswers = findViewById(R.id.wanswers);
        score = findViewById(R.id.score);
        easystage = findViewById(R.id.easystage);
        mediumstage = findViewById(R.id.mediumstage);
        hardstage = findViewById(R.id.hardstage);
        extremestage = findViewById(R.id.extremestage);
        points = findViewById(R.id.points);
        easypoints = findViewById(R.id.easypoints);
        mediumpoints = findViewById(R.id.mediumpoints);
        hardpoints = findViewById(R.id.hardpoints);
        extremepoints = findViewById(R.id.extremepoints);
        ttime = findViewById(R.id.ttime);
        tpstage = findViewById(R.id.tpstage);
        log1 = findViewById(R.id.log1);
        log2 = findViewById(R.id.log2);
        log3 = findViewById(R.id.log3);
        log4 = findViewById(R.id.log4);
        log5 = findViewById(R.id.log5);
        log6 = findViewById(R.id.log6);
        log7 = findViewById(R.id.log7);
        log8 = findViewById(R.id.log8);
        log9 = findViewById(R.id.log9);
        log10 = findViewById(R.id.log10);
        log11 = findViewById(R.id.log11);
        log12 = findViewById(R.id.log12);
        log13 = findViewById(R.id.log13);
        log14 = findViewById(R.id.log14);
        log15 = findViewById(R.id.log15);
        log16 = findViewById(R.id.log16);
        log17 = findViewById(R.id.log17);
        log18 = findViewById(R.id.log18);
        log19 = findViewById(R.id.log19);
        log20 = findViewById(R.id.log20);

        log1.setText("" + getIntent().getStringExtra("log1"));
        log2.setText("" + getIntent().getStringExtra("log2"));
        log3.setText("" + getIntent().getStringExtra("log3"));
        log4.setText("" + getIntent().getStringExtra("log4"));
        log5.setText("" + getIntent().getStringExtra("log5"));
        log6.setText("" + getIntent().getStringExtra("log6"));
        log7.setText("" + getIntent().getStringExtra("log7"));
        log8.setText("" + getIntent().getStringExtra("log8"));
        log9.setText("" + getIntent().getStringExtra("log9"));
        log10.setText("" + getIntent().getStringExtra("log10"));
        log11.setText("" + getIntent().getStringExtra("log11"));
        log12.setText("" + getIntent().getStringExtra("log12"));
        log13.setText("" + getIntent().getStringExtra("log13"));
        log14.setText("" + getIntent().getStringExtra("log14"));
        log15.setText("" + getIntent().getStringExtra("log15"));
        log16.setText("" + getIntent().getStringExtra("log16"));
        log17.setText("" + getIntent().getStringExtra("log17"));
        log18.setText("" + getIntent().getStringExtra("log18"));
        log19.setText("" + getIntent().getStringExtra("log19"));
        log20.setText("" + getIntent().getStringExtra("log20"));

        q1 = getIntent().getStringExtra("q1");
        q2 = getIntent().getStringExtra("q2");
        q3 = getIntent().getStringExtra("q3");
        q4 = getIntent().getStringExtra("q4");
        q5 = getIntent().getStringExtra("q5");
        q6 = getIntent().getStringExtra("q6");
        q7 = getIntent().getStringExtra("q7");
        q8 = getIntent().getStringExtra("q8");
        q9 = getIntent().getStringExtra("q9");
        q10 = getIntent().getStringExtra("q10");
        q11 = getIntent().getStringExtra("q11");
        q12 = getIntent().getStringExtra("q12");
        q13 = getIntent().getStringExtra("q13");
        q14 = getIntent().getStringExtra("q14");
        q15 = getIntent().getStringExtra("q15");
        q16 = getIntent().getStringExtra("q16");
        q17 = getIntent().getStringExtra("q17");
        q18 = getIntent().getStringExtra("q18");
        q19 = getIntent().getStringExtra("q19");
        q20 = getIntent().getStringExtra("q20");

        s1 = Integer.parseInt(getIntent().getStringExtra("s1"));
        s2 = Integer.parseInt(getIntent().getStringExtra("s2"));
        s3 = Integer.parseInt(getIntent().getStringExtra("s3"));
        s4 = Integer.parseInt(getIntent().getStringExtra("s4"));
        s5 = Integer.parseInt(getIntent().getStringExtra("s5"));
        s6 = Integer.parseInt(getIntent().getStringExtra("s6"));
        s7 = Integer.parseInt(getIntent().getStringExtra("s7"));
        s8 = Integer.parseInt(getIntent().getStringExtra("s8"));
        s9 = Integer.parseInt(getIntent().getStringExtra("s9"));
        s10 = Integer.parseInt(getIntent().getStringExtra("s10"));
        s11 = Integer.parseInt(getIntent().getStringExtra("s11"));
        s12 = Integer.parseInt(getIntent().getStringExtra("s12"));
        s13 = Integer.parseInt(getIntent().getStringExtra("s13"));
        s14 = Integer.parseInt(getIntent().getStringExtra("s14"));
        s15 = Integer.parseInt(getIntent().getStringExtra("s15"));
        s16 = Integer.parseInt(getIntent().getStringExtra("s16"));
        s17 = Integer.parseInt(getIntent().getStringExtra("s17"));
        s18 = Integer.parseInt(getIntent().getStringExtra("s18"));
        s19 = Integer.parseInt(getIntent().getStringExtra("s19"));
        s20 = Integer.parseInt(getIntent().getStringExtra("s20"));

        int ss1 = 30 - s1;
        int ss2 = 30 - s2;
        int ss3 = 30 - s3;
        int ss4 = 30 - s4;
        int ss5 = 30 - s5;
        int ss6 = 30 - s6;
        int ss7 = 30 - s7;
        int ss8 = 30 - s8;
        int ss9 = 30 - s9;
        int ss10 = 30 - s10;
        int ss11 = 30 - s11;
        int ss12 = 30 - s12;
        int ss13 = 30 - s13;
        int ss14 = 30 - s14;
        int ss15 = 30 - s15;
        int ss16 = 30 - s16;
        int ss17 = 30 - s17;
        int ss18 = 30 - s18;
        int ss19 = 30 - s19;
        int ss20 = 30 - s20;

        if (q1.equals("correct")) {
            ca = ca + 1;
            pe = pe + s1;
            easy = easy + 1;
        }
        if (q2.equals("correct")) {
            ca = ca + 1;
            pe = pe + s2;
            easy = easy + 1;
        }
        if (q3.equals("correct")) {
            ca = ca + 1;
            pe = pe + s3;
            easy = easy + 1;
        }
        if (q4.equals("correct")) {
            ca = ca + 1;
            pe = pe + s4;
            easy = easy + 1;
        }
        if (q5.equals("correct")) {
            ca = ca + 1;
            pe = pe + s5;
            easy = easy + 1;
        }
        if (q6.equals("correct")) {
            ca = ca + 1;
            pm = pm + s6;
            medium = medium + 1;
        }
        if (q7.equals("correct")) {
            ca = ca + 1;
            pm = pm + s7;
            medium = medium + 1;
        }
        if (q8.equals("correct")) {
            ca = ca + 1;
            pm = pm + s8;
            medium = medium + 1;
        }
        if (q9.equals("correct")) {
            ca = ca + 1;
            pm = pm + s9;
            medium = medium + 1;
        }
        if (q10.equals("correct")) {
            ca = ca + 1;
            pm = pm + s10;
            medium = medium + 1;
        }
        if (q11.equals("correct")) {
            ca = ca + 1;
            ph = ph + s11;
            hard = hard + 1;
        }
        if (q12.equals("correct")) {
            ca = ca + 1;
            ph = ph + s12;
            hard = hard + 1;
        }
        if (q13.equals("correct")) {
            ca = ca + 1;
            ph = ph + s13;
            hard = hard + 1;
        }
        if (q14.equals("correct")) {
            ca = ca + 1;
            ph = ph + s14;
            hard = hard + 1;
        }
        if (q15.equals("correct")) {
            ca = ca + 1;
            ph = ph + s15;
            hard = hard + 1;
        }
        if (q16.equals("correct")) {
            ca = ca + 1;
            pex = pex + s16;
            extreme = extreme + 1;
        }
        if (q17.equals("correct")) {
            ca = ca + 1;
            pex = pex + s17;
            extreme = extreme + 1;
        }
        if (q18.equals("correct")) {
            ca = ca + 1;
            pex = pex + s18;
            extreme = extreme + 1;
        }
        if (q19.equals("correct")) {
            ca = ca + 1;
            pex = pex + s19;
            extreme = extreme + 1;
        }
        if (q20.equals("correct")) {
            ca = ca + 1;
            pex = pex + s20;
            extreme = extreme + 1;
        }

        int wa = 20 - ca;
        int ts = (ss1 + ss2 + ss3 + ss4 + ss5 + ss6 + ss7 + ss8 + ss9 + ss10 + ss11 + ss12 + ss13 + ss14 + ss15 + ss16 + ss17 + ss18 + ss19 + ss20);
        double sps = (ts / 20);
        int min = ts / 60;
        int sec = ts % 60;
        int tp = (pe + pm + ph + pex);
        double pct = (ca / 20);
        double fpct = pct * 100;

        canswers.setText("Correct answers: " + ca);
        wanswers.setText("Wrong answers: " + wa);
        score.setText("Total Score: " + ca + "/20 (" + fpct + "%)");
        easystage.setText("Easy stage score: " + easy + "/5");
        mediumstage.setText("Medium stage score: " + medium + "/5");
        hardstage.setText("Hard stage score: " + hard + "/5");
        extremestage.setText("Extreme stage score: " + extreme + "/5");
        points.setText("Total points: " + tp);
        easypoints.setText("Easy stage points: " + pe);
        mediumpoints.setText("Medium stage points: " + pm);
        hardpoints.setText("Hard stage points: " + ph);
        extremepoints.setText("Extreme stage points: " + pex);
        ttime.setText("Total time spent: " + min + "min " + sec + "sec");
        tpstage.setText("Seconds per stage: " + sps);

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setVisibility(View.GONE);
                ll1.setVisibility(View.VISIBLE);
                logsstat.setText("STATISTICS");
            }
        });

        logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.GONE);
                logsstat.setText("LOGS");
            }
        });

        leaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(logs.this, leaderboards.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}