package jp.ac.jec.cm0107.timerarrange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         View topstart = findViewById(R.id.topstartbtn);
       // AnimationHelper.startAlphaAnimation(topstart);
        topstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // AnimationHelper.cancelAnimation(topstart);
                Intent intent = new Intent(MainActivity.this, BeforethebattleView.class);
                startActivity(intent);
            }
        });

    }


    }
