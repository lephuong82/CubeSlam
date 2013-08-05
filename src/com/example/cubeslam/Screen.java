package com.example.cubeslam;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Screen extends SurfaceView{
	Scene scene;
	GameThread gameThread;
	Context context;
	SurfaceHolder surfaceHolder;
	
	public Screen(Context context,Scene scene){
		super(context);
		
		surfaceHolder = this.getHolder();
		
		this.context = context;
		scene.setView(this);
		scene.init();
		this.scene = scene;
		
		
	}
	
	public void setScene(Scene scene){
		scene.setView(this);
		scene.init();
		Scene oldScene = this.scene;
		this.scene = scene;
		oldScene.disposal();
		System.gc();
	}
	
	public Scene getScene(){
		return scene;
	}
	
	
	class GameThread extends Thread{
		
	}

	
	
	
	
}
