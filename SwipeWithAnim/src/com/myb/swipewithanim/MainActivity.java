package com.myb.swipewithanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private View menu;
	private final static int SHOW_MENU = 1;
	private final static int HIDE_MENU = -1;
	private int swipe_tag = SHOW_MENU;
	private int max_menu_margin = 0;
	private int min_menu_margin;
	private float beginX;
	private float latestX;
	private float diffX;
	private float latestMargin;

	private FrameLayout.LayoutParams lp;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		menu = findViewById(R.id.menu);
		lp = (FrameLayout.LayoutParams) menu.getLayoutParams();
		min_menu_margin = lp.leftMargin;

		menu.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int action = event.getActionMasked();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					beginX = event.getX();
					break;
				case MotionEvent.ACTION_MOVE:
					latestX = event.getX();
					diffX = latestX - beginX;
					swipe_tag = diffX > 0 ? SHOW_MENU : HIDE_MENU;
					latestMargin = lp.leftMargin + diffX;

					if (latestMargin > min_menu_margin
							&& latestMargin < max_menu_margin) {
						lp.leftMargin = (int) (latestMargin);
						menu.setLayoutParams(lp);
					}

					break;
				case MotionEvent.ACTION_UP:
					TranslateAnimation tAnim;
					if (swipe_tag == SHOW_MENU) {
						tAnim = new TranslateAnimation(0, max_menu_margin
								- latestMargin, 0, 0);
						tAnim.setInterpolator(new DecelerateInterpolator());
						tAnim.setDuration(800);
						menu.startAnimation(tAnim);
					} else {
						tAnim = new TranslateAnimation(0, min_menu_margin
								- latestMargin, 0, 0);
						tAnim.setDuration(800);
						menu.startAnimation(tAnim);
					}
					tAnim.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationRepeat(Animation animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							// TODO Auto-generated method stub
							if (swipe_tag == SHOW_MENU) {
								lp.leftMargin = max_menu_margin;
								menu.setLayoutParams(lp);
							} else {
								lp.leftMargin = min_menu_margin;
								menu.setLayoutParams(lp);
							}
							menu.clearAnimation();
						}
					});

					break;
				}
				return true;
			}
		});
	}
}
