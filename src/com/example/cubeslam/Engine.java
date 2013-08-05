package com.example.cubeslam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Engine extends Activity {
	
	Screen screen;
	int FRAMES_PER_SECOND = 25;
	
	private static Engine engine;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   		
		
        engine = this;
		
        screen = new Screen(getApplicationContext(),initScene());
		setContentView(screen);
		
		Factory.getFactory().setResources(getResources());
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
	
	
	

}
