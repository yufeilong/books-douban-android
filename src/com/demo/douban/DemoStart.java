package com.demo.douban;

import com.demo.douban.ui.Main;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class DemoStart extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.start, null);
        setContentView(view);
        
        //设置渐变启动界面
		AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
		aa.setDuration(1500);
		view.startAnimation(aa);
		
		aa.setAnimationListener(new AnimationListener()
		{
			@Override
			public void onAnimationEnd(Animation arg0) 
			{
				redirectTo();
			}

			@Override
			public void onAnimationRepeat(Animation arg0) 
			{
			}

			@Override
			public void onAnimationStart(Animation animation)
			{
			}	
		});
    }
    
    /**
     * 从启动界面跳转到主界面
     */
    private void redirectTo()
    {        
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
        finish();
    }
}
