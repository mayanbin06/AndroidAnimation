package com.myb.nimation;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.AccelerateDecelerateInterpolator;

public class ViewAnimation extends Activity {

    private TextView translation;
    private TextView rotate;
    private TextView scale;
    private TextView alpha;
    private Button button;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        translation = (TextView) findViewById(R.id.translation);
        rotate = (TextView) findViewById(R.id.rotate);
        scale = (TextView) findViewById(R.id.scale);
        alpha = (TextView) findViewById(R.id.alpha);
        button = (Button) findViewById(R.id.fire);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // 1&2: 确定起始状态，结束状态
                TranslateAnimation tAnim = new TranslateAnimation(0, 400, 0, 0);//横向位移400个单位
                RotateAnimation rAnima = new RotateAnimation(0, 70);//顺时针旋转70度
                ScaleAnimation sAnima = new ScaleAnimation(0, 5, 0, 5);//横向放大5倍，纵向放大5倍
                AlphaAnimation aAnima = new AlphaAnimation(1.0f, 0.0f);//从全不透明变为全透明
                // 3: 确定持续时间
                tAnim.setDuration(2000);
                rAnima.setDuration(2000);
                sAnima.setDuration(2000);
                aAnima.setDuration(2000);

                // 4: 确定Interpolator
                tAnim.setInterpolator(new AccelerateDecelerateInterpolator());

                // 启动动画
                translation.startAnimation(tAnim);
                rotate.startAnimation(rAnima);
                scale.startAnimation(sAnima);
                alpha.startAnimation(aAnima);
            }
        });

    }
}
