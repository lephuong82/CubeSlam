package com.example.cubeslam;


public class Ball extends MovableObject{
	
	private int speed_X = 1;
	private int speed_Y = 1;
	
	private int deltaX;
	private int deltaY;
	
	
	public void init(){
		
	}

	@Override
	public void updateBehaviour(long delay) {
		long deltaY = (long )(delay * speed_Y)/5;
		setY(getY()+deltaY);
		
		long deltaX = (long)(delay * speed_X)/10;
		setX(getX()+deltaX);
		
		
	}
	
	public void collision(SceneObject object){
		
		if(object instanceof Board){
			//Board board = (Board)object;
			speed_Y = -speed_Y;
		}
		else{
			speed_X = -speed_X;
		}

	}
	
}
