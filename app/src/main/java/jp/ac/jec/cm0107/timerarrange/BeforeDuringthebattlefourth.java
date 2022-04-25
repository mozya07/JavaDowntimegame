package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BeforeDuringthebattlefourth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_duringthebattlefourth);

        final Handler handler = new Handler();

        // ImageChange
        int[] extraChenge = { R.drawable.extrastage};

        ImageView extra = (ImageView)findViewById(R.id.monsterView);
        extra.setImageResource(extraChenge[0]);

        TextView hatena = (TextView)findViewById(R.id.charactername);
        hatena.setText("緊急事態！？緊急事態！？");

        TextView hatenas = (TextView)findViewById(R.id.zikkyoutxt);
        hatenas.setText("緊急事態！？緊急事態！？");

        Intent intent = getIntent();
        String senndannif = intent.getStringExtra("sennseidannzyonn");

        AnimationHelper.startAlphaAnimationsecond(extra);

        Runnable showMessageTask = new Runnable() {
            @Override
            public void run() {
                if (senndannif.equals("dorodann")) {
                    AnimationHelper.cancelAnimations(extra);
                    Intent intent = new Intent(BeforeDuringthebattlefourth.this, Duringthebattlefourth.class);
                    intent.putExtra("sennseidannzyonn", "dorodann");
                    startActivity(intent);
                } else if (senndannif.equals("senndann")) {
                    AnimationHelper.cancelAnimations(extra);
                    Intent intent = new Intent(BeforeDuringthebattlefourth.this, Duringthebattlefourth.class);
                    intent.putExtra("sennseidannzyonn", "senndann");
                    startActivity(intent);
                }



            }
        };

        AnimationHelper.startAlphaAnimationsecond(extra);
        handler.postDelayed(showMessageTask, 6000);

        ImageView attack = (ImageView)findViewById(R.id.attackbtn);
        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}