package com.example.cubeslam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

public class StartScene extends Scene{
	
	private int time = 3000;
	private int past = 0;
	@Override
	public void init() {
		SceneObject logo = new SceneObject();
		Bitmap l = BitmapFactory.decodeResource(Factory.getFactory().getResources(), R.drawable.logo);
		logo.setImage(l);
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
		Log.e("logo", "show logo"); 
	}

	
	
	
	
}
