package com.example.cubeslam;

import android.graphics.Rect;
import android.view.MotionEvent;

public class MenuScene extends Scene{


	StaticObject playButton;
	
	@Override
	public void init() {
		
		playButton = new StaticObject();
		playButton.setImage(Factory.getFactory().playButton);
		playButton.setX(Engine.getEngine().getDisplayMetrics().widthPixels/2-playButton.getWidth()/2);
		playButton.setY(Engine.getEngine().getDisplayMetrics().heightPixels/2-playButton.getHeight()/2);
		this.createLayer();
		this.add(playButton, 0);
	}

	@Override
	public void updateBehaviour(long deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getAction() == MotionEvent.ACTION_UP){
			int x = (int)event.getX();
			int y = (int)event.getY();
			Rect rect = new Rect(
					(int)playButton.getX(),
					(int)playButton.getY(),
					(int)playButton.getX()+(int)playButton.getWidth(),
					(int)playButton.getY()+(int)playButton.getHeight()
					);
			if(rect.contains(x, y)){
				Engine.getEngine().setScene(Factory.getFactory().getGameScene());
			}
	
		}
		else if(event.getAction() == MotionEvent.ACTION_DOWN){
			//TODO
		}
		return true;
	}
	
	
}
