package com.example.cubeslam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;


public class StaticObject extends SceneObject{
	
	protected Paint paint;
	public StaticObject(){
		super();
	}
	
	@Override
	public void draw(Canvas canvas) {
		
		if(paint != null)
			canvas.drawBitmap(image, getX(), getY(), paint);
		else
			canvas.drawBitmap(image, getX(), getY(), null);
	}

	
	

	
	
	
	
}
