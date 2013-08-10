package com.example.cubeslam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

public class StartScene extends Scene{
	
	private int time = 3000;
	private int past = 0;
	StaticObject logo;
	@Override
	public void init() {
		logo = new StaticObject();
		logo.setImage(Factory.getFactory().logo);
		logo.setX(Engine.getEngine().getDisplayMetrics().widthPixels/2-logo.getWidth()/2);
		logo.setY(Engine.getEngine().getDisplayMetrics().heightPixels/2-logo.getHeight()/2);
		
		this.createLayer();
		this.add(logo, 0);
		
	}


	public void updateBehaviour(long deltaTime){
		past += deltaTime;
		if(past >= time){
			Engine.getEngine().setScene(Factory.getFactory().getMenuScene());
		}
	}
	
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}


	@Override
	public void disposal() {
		super.disposal();

	}

	
	
	
	
	
	
}
