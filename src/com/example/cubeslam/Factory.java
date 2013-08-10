package com.example.cubeslam;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Factory {
	private static Factory factory = new Factory();
	private Resources resources;
	
	public Bitmap logo;
	
	public static Factory getFactory(){
		return factory;
	}
	
	public void load(){
		logo = BitmapFactory.decodeResource(resources, R.drawable.logo);
	}
	
	
	public MenuScene getMenuScene(){
		return new MenuScene();
	}
	public StartScene getStartScene(){
		return new StartScene();
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}
	public Resources getResources(){
		return resources;
	}
	
}
