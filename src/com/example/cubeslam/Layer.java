package com.example.cubeslam;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.util.Log;

public class Layer {
	
	private List<SceneObject> objectList = new ArrayList<SceneObject>();
	
	public void draw(Canvas canvas){
		for(SceneObject object : objectList){
			object.draw(canvas);
		}
		//Log.e("draw","layer");
	}
	
	public void add(SceneObject object){
		objectList.add(object);
	}

	public void update(long deltaTime) {
		Scene scene = Engine.getEngine().getScene();
		for(SceneObject object:objectList){
			//to be done;
		}
		
	}
	
	
}
