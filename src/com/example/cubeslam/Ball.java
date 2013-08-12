package com.example.cubeslam;


public class Ball extends MovableObject{
	
	private int speed_X = 1;
	private int speed_Y = 1;
	
	private long deltaX;
	private long deltaY;
	
	
	public void init(){
		
	}

	@Override
	public void updateBehaviour(long delay) {
		deltaY = (long )(delay * speed_Y)/5;
		setY(getY()+deltaY);
		
		deltaX = (long)(delay * speed_X)/5;
		setX(getX()+deltaX);
		
		
	}
	
	public void collision(SceneObject object){
		
		if(object instanceof Board){
			speed_Y = -speed_Y;
		}
		else{
			speed_X = -speed_X;
		}

	}
	
	public int getSpeed_X(){
		return speed_X;
	}
	
	public int getSpeed_Y(){
		return speed_Y;
	}
	
	
}
