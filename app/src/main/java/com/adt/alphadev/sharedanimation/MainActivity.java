package com.adt.alphadev.sharedanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
{
    CircleImageView iv2;
    TextView name;
    LinearLayout lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv2 = findViewById(R.id.iv2);
        name = findViewById(R.id.name);
        lin = findViewById(R.id.lin);

        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharedIntent = new Intent(MainActivity.this, Main2Activity.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(iv2, "imageTransition");
                pairs[1] = new Pair<View, String>(name, "nameTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(sharedIntent, options.toBundle());
            }
        });
    }
}
