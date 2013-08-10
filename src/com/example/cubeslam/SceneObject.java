package com.example.cubeslam;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SceneObject {
	
	Scene scene;
	
	Bitmap image;
	private float x = 0;
	private float y = 0;
	
	private float height = 0;
	private float width = 0;
	
	
	
	public SceneObject(){
		
	}
	
	public void draw(Canvas canvas){
		
	}
	
	public void setImage(Bitmap image){
		this.image = image;
	}
	
	public void update(long deltaTime){
		updateBehaviour(deltaTime);
	}
	
	public void updateBehaviour(long delay){}
	
	public float getX(){
		return x;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float getWidth(){
		return width;
	}
	
	public void setWidth(float width){
		this.width = width;
	}
	
	public float getHight(){
		return height;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	
	
}
