package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClearFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_first);

        final Handler handler = new Handler();

        Intent intent = getIntent();
        String doroidostageclears = intent.getStringExtra("doroidostageclear");
        String senndannif = intent.getStringExtra("sennseidannzyonn");



        // HPバー開始
        ProgressBar bar = (ProgressBar)findViewById(R.id.progressBar1);
        bar.setMax(100);
        bar.setProgress(100);
        ProgressBar bars = (ProgressBar)findViewById(R.id.progressBar2);
        bars.setMax(100);
        bars.setProgress(100);
        // HBバー終了

        TextView stageclear = (TextView)findViewById(R.id.charactername);
        stageclear.setText("STAGECLEAR");

//        int[] ExterChenge = { R.drawable.doroido};

//        ImageView nisegameclear = (ImageView)findViewById(R.id.monsterView);
//        if (doroidostageclears.equals("doroidoragonnC")) {
//            nisegameclear.setImageResource(ExterChenge[0]);
//        }


        ImageView fbtn = (ImageView) findViewById(R.id.attackbtn);
        Runnable showMessageTask = new Runnable() {
            @Override
            public void run() {
                fbtn.setEnabled(true);

            }
        };

        // ImageChange
        int[] gameclearChenge = { R.drawable.defogameclear};

        ImageView gamecleardesu = (ImageView)findViewById(R.id.monsterView);

        if (doroidostageclears.equals("doroidoragonnC")) {
            gamecleardesu.setImageResource(gameclearChenge[0]);
            stageclear.setText("GAMECLEAR");
        }





        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doroidostageclears.equals("doroidoC") && senndannif.equals("dorodann")) {
                    Intent intent = new Intent(ClearFirst.this, Duringthebattlesecond.class);
                    intent.putExtra("sennseidannzyonn", "dorodann");
                    startActivity(intent);
                } else if (doroidostageclears.equals("doroidoC") && senndannif.equals("senndann")) {
                    Intent intent = new Intent(ClearFirst.this, Duringthebattlesecond.class);
                    intent.putExtra("sennseidannzyonn", "senndann");
                    startActivity(intent);
                } else if (doroidostageclears.equals("doroidogonnC") && senndannif.equals("dorodann")) {
                    Intent intent = new Intent(ClearFirst.this, Duringthebattlethird.class);
                    intent.putExtra("sennseidannzyonn", "dorodann");
                    startActivity(intent);
                } else if (doroidostageclears.equals("doroidogonnC") && senndannif.equals("senndann")) {
                    Intent intent = new Intent(ClearFirst.this, Duringthebattlethird.class);
                    intent.putExtra("sennseidannzyonn", "senndann");
                    startActivity(intent);
                } else if (doroidostageclears.equals("doroidoragonnC") && senndannif.equals("dorodann")) {
                    Intent intent = new Intent(ClearFirst.this, BeforeDuringthebattlefourth.class);
                    intent.putExtra("sennseidannzyonn", "dorodann");
                    startActivity(intent);
                } else if (doroidostageclears.equals("doroidoragonnC") && senndannif.equals("senndann")) {
                    Intent intent = new Intent(ClearFirst.this, BeforeDuringthebattlefourth.class);
                    intent.putExtra("sennseidannzyonn", "senndann");
                    startActivity(intent);
                }
            }
        });

        fbtn.setEnabled(false);
        handler.postDelayed(showMessageTask, 2000);
    }
}