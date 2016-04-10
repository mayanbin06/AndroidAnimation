package com.myb.nimation;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.AccelerateDecelerateInterpolator;

public class XmlAnimationActivity extends Activity {

    private Button button;
    private ImageView image;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_main);

        button = (Button) findViewById(R.id.xml_button);
        image = (ImageView) findViewById(R.id.xml_anim_image);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(XmlAnimationActivity.this, R.anim.animation);
                image.startAnimation(anim);
            }
        });
    }
}
