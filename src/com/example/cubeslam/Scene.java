package com.example.cubeslam;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import android.view.View;

public abstract class Scene {

	private View view;
	private List<Layer> layerList;
	private Bitmap background;
	private Integer backgroundColor;
	
	
	public Scene(){
		layerList = new ArrayList<Layer>();
		layerList.add(new Layer());
	}
	
	public void draw(Canvas canvas){
		if(background!=null){
			canvas.drawBitmap(background, 0, 0, null);	
		}else{
			canvas.drawColor(backgroundColor);
		}
		
		for(Layer layer:layerList){
			layer.draw(canvas);
		}
	}

	public void setView(View view){
		this.view = view;
	}
	
	public View getView(){
		return view;
	}
	
	public abstract void init();
	
	public void disposal(){
		view = null;
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
}
