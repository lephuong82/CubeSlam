package com.example.cubeslam;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public abstract class Scene {

	private View view;
	protected List<Layer> layerList;
	private Bitmap background;
	private Integer backgroundColor;
	
	public Scene(){
		layerList = new ArrayList<Layer>();
		layerList.add(new Layer());
		
	}
	
	public void draw(Canvas canvas){
		if(getPaint()!= null){
			canvas.drawPaint(getPaint());
		}
		else if(background != null){
			canvas.drawBitmap(background, 0, 0, null);	
		}else if (backgroundColor != null){
			canvas.drawColor(backgroundColor);
		}
		
		
		for(Layer layer:layerList){
			layer.draw(canvas);
		}
		
	}
	
	public Paint getPaint() {
		return null;
	}

	public void update(long deltaTime){
		updateBehaviour(deltaTime);
		if(layerList != null) {
			 for (Layer layer : layerList) {
				 layer.update(deltaTime);
			 }
		}
		
	}
	
	public abstract void updateBehaviour(long deltaTime); 
	
	public void setView(View view){
		this.view = view;
	}
	
	public View getView(){
		return view;
	}
	
	public abstract void init();
	
	public void disposal(){
		view = null;
		for(Layer layer:layerList){
			layer.disposal();
		}
		layerList = null;
		background = null;
	}
	
	public void createLayer() {
		layerList.add(new Layer());
	}
	
	public void add(SceneObject actor, int layer) {
		
		Layer layerInst = layerList.get(layer);
		layerInst.add(actor);
	}

	public Bitmap getBackground() {
		return background;
	}

	public void setBackground(Bitmap background) {
		this.background = background;
	}

	public Integer getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Integer backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public abstract boolean onTouchEvent(MotionEvent event);// {
//		return false;
//	}
	
}
