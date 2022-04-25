package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Duringthebattlethird extends AppCompatActivity {

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

        setContentView(R.layout.activity_duringthebattlethird);


//        traget.setBackgroundColor(Color.rgb(127, 127, 255));


        //  Button stopButton = findViewById(R.id.stop_button);

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));
        Log.d("debug", "attackcount: " + timerText);

        // インスタンス生成
        // CountDownTimer(long millisInFuture, long countDownInterval)
        final Duringthebattlethird.CountDown countDown = new Duringthebattlethird.CountDown(countNumber, interval);
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
        int[] doroidoragonnChenge = { R.drawable.doroidoragonn, R.drawable.doroidoragonn1,
                R.drawable.doroidoragonn2, R.drawable.doroidoragonn3,
                R.drawable.doroidoragonn4, R.drawable.doroidoragonn5,
        R.drawable.doroidoragonnsennsei};



        // tennmetu処理開始
        ImageView traget = findViewById(R.id.monsterView);
        View traget2 = findViewById(R.id.attackbtn);

        if (senndannif.equals("senndann")) {
            traget.setImageResource(doroidoragonnChenge[6]);
        }  else if (senndannif.equals("dorodann")) {
            traget.setImageResource(doroidoragonnChenge[0]);
        }

        Runnable showMessageTask = new Runnable() {
            @Override
            public void run() {

                AnimationHelper.cancelAnimation(traget);
                AnimationHelper.cancelAnimation(traget2);
            }
        };

        TextView chaname = (TextView)findViewById(R.id.charactername);
        chaname.setText("[ドロイドドラゴン]");
        TextView zikkyou = (TextView)findViewById(R.id.zikkyoutxt);
        zikkyou.setText("バトルスタート");


        ImageView attackstart = (ImageView)findViewById(R.id.attackbtn);
        attackstart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                attackcount++;
                if (attackcount == 20 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoragonnChenge[1]);
                    bar.setProgress(80);
                    zikkyou.setText("良いダメージ");
                } else if (attackcount == 20 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoragonnChenge[6]);
                    bar.setProgress(80);
                    zikkyou.setText("良いダメージ");
                } else if (attackcount == 40 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoragonnChenge[2]);
                    bar.setProgress(60);
                    zikkyou.setText("その調子");
                } else if (attackcount == 40 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoragonnChenge[6]);
                    bar.setProgress(60);
                    zikkyou.setText("その調子");
                } else if (attackcount == 60 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoragonnChenge[3]);
                    bar.setProgress(40);
                    zikkyou.setText("良い感じ");
                } else if (attackcount == 60 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoragonnChenge[6]);
                    bar.setProgress(40);
                    zikkyou.setText("良い感じ");
                } else if (attackcount == 80 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoragonnChenge[4]);
                    bar.setProgress(20);
                    zikkyou.setText("後少し！！");
                } else if (attackcount == 80 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoragonnChenge[6]);
                    bar.setProgress(20);
                    zikkyou.setText("後少し！！");
                } else if (attackcount == 100 && senndannif.equals("dorodann")) {
                    traget.setImageResource(doroidoragonnChenge[5]);
                    bar.setProgress(0);
                    Intent intent = new Intent(Duringthebattlethird.this, ClearFirst.class);
                    intent.putExtra("doroidostageclear", "doroidoragonnC");
                    intent.putExtra("sennseidannzyonn", "dorodann");
                    startActivity(intent);

                } else if (attackcount == 100 && senndannif.equals("senndann")) {
                    traget.setImageResource(doroidoragonnChenge[5]);
                    bar.setProgress(0);
                    Intent intent = new Intent(Duringthebattlethird.this, ClearFirst.class);
                    intent.putExtra("doroidostageclear", "doroidoragonnC");
                    intent.putExtra("sennseidannzyonn", "senndann");
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
            if (attackcount >= 0 &&  attackcount <= 19) {

                Intent intent = new Intent(Duringthebattlethird.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "100");
                startActivity(intent);
            } else if(attackcount >= 20 && attackcount <= 39) {
                Intent intent = new Intent(Duringthebattlethird.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "80");
                startActivity(intent);
            } else if(attackcount >= 40 && attackcount <= 59) {
                Intent intent = new Intent(Duringthebattlethird.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "60");
                startActivity(intent);
            } else if(attackcount >= 60 && attackcount <= 79) {
                Intent intent = new Intent(Duringthebattlethird.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "40");
                startActivity(intent);
            } else if(attackcount >= 80 && attackcount <= 99) {
                Intent intent = new Intent(Duringthebattlethird.this, GameOverFirst.class);
                intent.putExtra("doroidoHPmessage", "20");
                startActivity(intent);
            } else {
                timerText.setText(dataFormat.format(0));
                Intent intent = new Intent(Duringthebattlethird.this, GameOverFirst.class);
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