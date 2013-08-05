package com.example.cubeslam;

import android.content.res.Resources;

public class Factory {
	private static Factory factory = new Factory();
	private Resources resources;
	
	
	public static Factory getFactory(){
		return factory;
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
