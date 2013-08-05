package com.example.cubeslam;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class Layer {
	
	private List<SceneObject> objectList = new ArrayList<SceneObject>();
	
	public void draw(Canvas canvas){
		for(SceneObject object : objectList){
			object.draw(canvas);
		}
	}
	
	public void add(SceneObject object){
		objectList.add(object);
	}
	
	
}
