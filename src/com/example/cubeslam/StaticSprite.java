package com.example.cubeslam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;


public class StaticSprite extends SceneObject{
	
	protected Paint paint;
	public StaticSprite(){
		super();
	}
	private  Bitmap image ;
	@Override
	public void draw(Canvas canvas) {
		
		if(paint != null)
			canvas.drawBitmap(image, getX(), getY(), paint);
		else
			canvas.drawBitmap(image, getX(), getY(), null);
	}
	
	public void setImage(Bitmap image){
		this.image = image;
		setWidth(image.getWidth());
		setHeight(image.getHeight());
	}
	
	public Bitmap getImage(){
		return image;
	}
	
	
	
}
