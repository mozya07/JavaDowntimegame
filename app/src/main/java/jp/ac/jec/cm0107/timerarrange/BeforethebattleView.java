package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BeforethebattleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforethebattle_view);


        ImageView dungeonsettings = (ImageView) findViewById(R.id.dungeonsettingsbtn);
        dungeonsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(BeforethebattleView.this, BattleView.class);
                    startActivity(intent);
            }
        });

        ImageView charactersetting = (ImageView) findViewById(R.id.charactersettingbtn);
        charactersetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BeforethebattleView.this, CharactersettingView.class);
                startActivity(intent);
            }
        });


    }
}