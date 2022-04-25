package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BattleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_view);


        ImageView doroidonoma = (ImageView) findViewById(R.id.doroidonomabtn);
        doroidonoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(BattleView.this, Duringthebattle.class);
                intent.putExtra("sennseidannzyonn", "dorodann");
                    startActivity(intent);
            }
        });

        ImageView doroidonomasennsei = (ImageView) findViewById(R.id.doroidonomasennseibtn);
        doroidonomasennsei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(BattleView.this, Duringthebattle.class);
                    intent.putExtra("sennseidannzyonn", "senndann");
                    startActivity(intent);
            }
        });

        ImageView returnbeforethebattle = (ImageView) findViewById(R.id.returnbeforethebattlebtn);
        returnbeforethebattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BattleView.this, BeforethebattleView.class);
                startActivity(intent);
            }
        });
    }
}