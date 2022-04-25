package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CharactersettingView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charactersetting_view);

        ImageView chibidora = (ImageView)findViewById(R.id.chibidoraView);
        chibidora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CharactersettingView.this, BeforethebattleView.class);
                startActivity(intent);
            }
        });

        ImageView ryuu = (ImageView)findViewById(R.id.ryuuView);
        ryuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CharactersettingView.this, BeforethebattleView.class);
                startActivity(intent);
            }
        });

    }
}