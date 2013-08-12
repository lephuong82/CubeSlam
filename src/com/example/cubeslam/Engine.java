package com.example.cubeslam;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class Engine extends Activity {
	
	Screen screen;
	public int FRAMES_PER_SECOND = 25;
	
	private static Engine engine;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   		
        
        engine = this;
		
        Factory.getFactory().setResources(getResources());
        Factory.getFactory().load();
        
        screen = new Screen(getApplicationContext(),initScene());
        

		setContentView(screen);
		screen.setFocusable(true);
		screen.setFocusableInTouchMode(true);
		screen.requestFocus();
		
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	
	
	
	public static Engine getEngine(){
		return engine;
	}
	
	public static Scene initScene(){
		return Factory.getFactory().getStartScene();
	}
	
	public void setScene(Scene scene){
		screen.setScene(scene);
	}
	
	public Scene getScene(){
		return screen.getScene();
	}
	
	public Screen getScreen(){
		Log.e("get screen", "get screen");
		return screen;
	}
	
	public DisplayMetrics getDisplayMetrics(){
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getDisplay().getMetrics(displayMetrics);
		return displayMetrics;
	}
	
	public Display getDisplay(){
		return getWindowManager().getDefaultDisplay();
	}

}
