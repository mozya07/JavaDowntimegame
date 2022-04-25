package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameOverFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_first);

        TextView gameoverfirst = (TextView)findViewById(R.id.charactername);
        gameoverfirst.setText("You are a Lose");

        Intent intent = getIntent();
        String doroidomessage = intent.getStringExtra("doroidoHPmessage");
        ProgressBar bar = (ProgressBar)findViewById(R.id.progressBar1);
        bar.setMax(100);

        if (doroidomessage.equals("100")) {
            bar.setProgress(100);
        } else if (doroidomessage.equals("80")) {
            bar.setProgress(80);
        } else if (doroidomessage.equals("60")) {
            bar.setProgress(60);
        } else if (doroidomessage.equals("40")) {
            bar.setProgress(40);
        } else if (doroidomessage.equals("20")) {
            bar.setProgress(20);
        }


        ProgressBar bars = (ProgressBar)findViewById(R.id.progressBar2);
        bars.setMax(100);
        bars.setProgress(0);




        Runnable showMessageTask = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GameOverFirst.this, BattleView.class);
                startActivity(intent);

            }
        };

        final Handler handler = new Handler();
        handler.postDelayed(showMessageTask, 5000);


    }
}