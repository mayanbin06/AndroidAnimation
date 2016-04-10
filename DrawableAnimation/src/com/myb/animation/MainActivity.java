package com.myb.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.drawable.AnimationDrawable;


import android.widget.ImageView;

public class MainActivity extends Activity
{
    private ImageView mImageView;
    private AnimationDrawable anim;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mImageView = (ImageView)findViewById(R.id.image_view);
        mImageView.setBackgroundResource(R.drawable.drawable_anim);

        anim = (AnimationDrawable)mImageView.getBackground();
    }

    public boolean onTouchEvent(MotionEvent event) {
        
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            anim.stop();
            anim.start();
            return true;
        }

        return super.onTouchEvent(event);
    }
}
