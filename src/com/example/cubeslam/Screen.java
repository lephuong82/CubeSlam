package com.example.cubeslam;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Screen extends SurfaceView implements SurfaceHolder.Callback {
	Scene scene;
	GameThread gameThread;
	Context context;
	SurfaceHolder surfaceHolder;
	
	public Screen(Context context,Scene scene){
		super(context);
		
		surfaceHolder = this.getHolder();
		surfaceHolder.addCallback(this);
		
		scene.setView(this);
		scene.init();
		this.scene = scene;
		
		gameThread = new GameThread(surfaceHolder, context);
		
	}
	
	public void setScene(Scene scene){
		scene.setView(this);
		scene.init();
		Scene oldScene = this.scene;
		this.scene = scene;
		oldScene.disposal();
		//Log.e("ddddd","ddddd");
		System.gc();
	}
	
	public Scene getScene(){
		return scene;
	}
	
	
	class GameThread extends Thread{
		
		/** Handle to the surface manager object we interact with */
		SurfaceHolder mSurfaceHolder;
		Context context;
		
		int FRAMES_PER_SECOND = 25;
		int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
		boolean game_is_running = true;
		
		
		public GameThread(SurfaceHolder mSurfaceHolder,Context context){
			this.mSurfaceHolder = mSurfaceHolder;
			this.context = context;
		}
		@Override
		public void run() {
			while(game_is_running){
				Canvas canvas = mSurfaceHolder.lockCanvas();
				synchronized (mSurfaceHolder) {
            		scene.update(SKIP_TICKS);
            		scene.draw(canvas);
				}
				//Engine.getEngine().
				//TODO
				mSurfaceHolder.unlockCanvasAndPost(canvas);
			}
			
		}
		
		public Boolean isRunning(){
			return game_is_running;
		}
		
		public void setRunning(Boolean running){
			this.game_is_running = running;
		}
		
		
		
		
	}


	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		if(!gameThread.isRunning()){
			gameThread = new GameThread(holder, context);
		}
		gameThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
