package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Realclear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realclear);

        TextView kannsyou = (TextView) findViewById(R.id.charactername);
        kannsyou.setText("完全勝利！！");

        //You are a great player

        TextView great = (TextView)findViewById(R.id.zikkyoutxt);
        great.setText("You are a great player");

        ImageView lastbtn = (ImageView)findViewById(R.id.attackbtn);
        lastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( Realclear.this, BeforethebattleView.class);
                startActivity(intent);
            }
        });


    }
}