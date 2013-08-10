package com.example.cubeslam;

import android.graphics.Canvas;

public class MovableObject extends SceneObject {

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(getImage(),getX(),getY(),null);
		super.draw(canvas);
	}
	
	
	
	
}
