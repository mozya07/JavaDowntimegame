package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Duringthebattle extends AppCompatActivity {

    private TextView timerText;
    int attackcount = 0;

    private SimpleDateFormat dataFormat =
            new SimpleDateFormat("mm:ss.SSS", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        final Handler handler = new Handler();


        // Timer処理スタート
        // 3分= 3x60x1000 = 180000 msec
        long countNumber = 60000;
        // インターバル msec
        long interval = 10;

        setContentView(R.layout.activity_duringthebattle);


//        traget.setBackgroundColor(Color.rgb(127, 127, 255));


      //  Button stopButton = findViewById(R.id.stop_button);

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));
        Log.d("debug", "attackcount: " + timerText);

        // インスタンス生成
        // CountDownTimer(long millisInFuture, long countDownInterval)
        final CountDown countDown = new CountDown(countNumber, interval);
        countDown.start();


//        countDown.cancel();
//        timerText.setText(dataFormat.format(0));
//        stopButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // 中止
//                countDown.cancel();
//                timerText.setText(dataFormat.format(0));
//            }
//        });

        // HPバー開始
        ProgressBar bar = (ProgressBar)findViewById(R.id.progressBar1);
        bar.setMax(100);
        bar.setProgress(100);
        ProgressBar bars = (ProgressBar)findViewById(R.id.progressBar2);
        bars.setMax(100);
        bars.setProgress(100);
        // HBバー終了


        Intent intent = getIntent();
        String senndannif = intent.getStringExtra("sennseidannzyonn");

        // ImageChange
        int[] doroidoChenge = { R.drawable.doroido, R.drawable.doroido1,
                R.drawable.doroido2, R.drawable.doroido3,
                R.drawable.doroido4, R.drawable.doroido5,
                R.drawable.doroidosennsei};




        // tennmetu処理開始
        ImageView traget = findViewById(R.id.monsterView);
        View traget2 = findViewById(R.id.attackbtn);

        if (senndannif.equals("senndann")) {
            traget.setImageResource(doroidoChenge[6]);
        }  else if (senndannif.equals("dorodann")) {
            traget.setImageResource(doroidoChenge[0]);
        }

        Runnable showMessageTask = new Runnable() {
            @Override
            public void run() {

                AnimationHelper.cancelAnimation(traget);
                AnimationHelper.cancelAnimation(traget2);
            }
        };

        TextView chaname = (TextView)findViewById(R.id.charactername);
        chaname.setText("[ドロイド君]");
        TextView zikkyou = (TextView)findViewById(R.id.zikkyoutxt);
        zikkyou.setText("バトルスタート");


        ImageView attackstart = (ImageView)findViewById(R.id.attackbtn);
        attackstart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                attackcount++;
               if (attackcount == 5 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoChenge[1]);
                    bar.setProgress(80);
                    zikkyou.setText("良いダメージ");
                } else if (attackcount == 5 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoChenge[6]);
                    bar.setProgress(80);
                    zikkyou.setText("良いダメージ");
                } else if (attackcount == 10 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoChenge[2]);
                    bar.setProgress(60);
                    zikkyou.setText("その調子");
                } else if (attackcount == 10 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoChenge[6]);
                    bar.setProgress(60);
                    zikkyou.setText("その調子");
                } else if (attackcount == 15 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoChenge[3]);
                    bar.setProgress(40);
                    zikkyou.setText("良い感じ");
                } else if (attackcount == 15 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoChenge[6]);
                    bar.setProgress(40);
                    zikkyou.setText("良い感じ");
                } else if (attackcount == 20 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoChenge[4]);
                    bar.setProgress(20);
                    zikkyou.setText("後少し！！");
                } else if (attackcount == 20 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoChenge[6]);
                    bar.setProgress(20);
                    zikkyou.setText("後少し！！");
                } else if (attackcount == 25 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoChenge[5]);
                    bar.setProgress(0);
                        Intent intent = new Intent(Duringthebattle.this, ClearFirst.class);
                        intent.putExtra("doroidostageclear", "doroidoC");
                   intent.putExtra("sennseidannzyonn", "dorodann");
                   startActivity(intent);
                        startActivity(intent);
                } else if (attackcount == 25 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoChenge[5]);
                    bar.setProgress(0);
                    Intent intent = new Intent(Duringthebattle.this, ClearFirst.class);
                    intent.putExtra("doroidostageclear", "doroidoC");
                   intent.putExtra("sennseidannzyonn", "senndann");
                   startActivity(intent);
                    startActivity(intent);
                }
//                Log.d("debug", "attackcount: " + attackcount);

                AnimationHelper.startAlphaAnimation(traget);
                AnimationHelper.startAlphaAnimation(traget2);
                handler.postDelayed(showMessageTask, 125);
            }
        });
        // tennmetu処理終了




    }

    class CountDown extends CountDownTimer {


        CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            // 完了
            if (attackcount >= 0 &&  attackcount <= 4) {

                    Intent intent = new Intent(Duringthebattle.this, GameOverFirst.class);
                    intent.putExtra("doroidoHPmessage", "100");
                    startActivity(intent);
            } else if(attackcount >= 5 && attackcount <= 9) {
                Intent intent = new Intent(Duringthebattle.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "80");
                startActivity(intent);
            } else if(attackcount >= 10 && attackcount <= 14) {
                Intent intent = new Intent(Duringthebattle.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "60");
                startActivity(intent);
            } else if(attackcount >= 15 && attackcount <= 19) {
                Intent intent = new Intent(Duringthebattle.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "40");
                startActivity(intent);
            } else if(attackcount >= 20 && attackcount <= 24) {
                Intent intent = new Intent(Duringthebattle.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "20");
                startActivity(intent);
            } else {
                timerText.setText(dataFormat.format(0));
                Intent intent = new Intent(Duringthebattle.this, GameOverFirst.class);
                startActivity(intent);
            }
        }

        // インターバルで呼ばれる
        @Override
        public void onTick(long millisUntilFinished) {
            // 残り時間を分、秒、ミリ秒に分割
            //long mm = millisUntilFinished / 1000 / 60;
            //long ss = millisUntilFinished / 1000 % 60;
            //long ms = millisUntilFinished - ss * 1000 - mm * 1000 * 60;
            //timerText.setText(String.format("%1$02d:%2$02d.%3$03d", mm, ss, ms));

            timerText.setText(dataFormat.format(millisUntilFinished));

        }
    }
    // Timer処理ストップ

}