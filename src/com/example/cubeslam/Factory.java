package com.example.cubeslam;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class Factory {
	private static Factory factory = new Factory();
	private Resources resources;
	
	public Bitmap logo;
	
	public Bitmap playButton;
	
	public Bitmap board;
	public Bitmap ball;
	
	public Factory() {
		// TODO Auto-generated constructor stub
	}
	public static Factory getFactory(){
		return factory;
	}
	
	public void load(){
		logo = BitmapFactory.decodeResource(resources, R.drawable.logo);
		playButton = BitmapFactory.decodeResource(resources, R.drawable.play_button);
		board = getBoard();
		
		
		ball = getBall();
	}
	
	private Bitmap getBoard(){
		Bitmap boardtmp = BitmapFactory.decodeResource(resources, R.drawable.board);
		int width = boardtmp.getWidth();
		int height = boardtmp.getHeight();
		int newWidth = 200;
		int newHeight = 50;
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
	    matrix.postScale(scaleWidth, scaleHeight);
	    Bitmap newbm = Bitmap.createBitmap(boardtmp, 0, 0, width, height, matrix,true);
	    return newbm;
	}
	
	private Bitmap getBall(){
		Bitmap boardtmp = BitmapFactory.decodeResource(resources, R.drawable.ball);
		int width = boardtmp.getWidth();
		int height = boardtmp.getHeight();
		int newWidth = 50;
		int newHeight = 50;
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
	    matrix.postScale(scaleWidth, scaleHeight);
	    Bitmap newbm = Bitmap.createBitmap(boardtmp, 0, 0, width, height, matrix,true);
	    return newbm;
	}
	
	
	
	
	public MenuScene getMenuScene(){
		return new MenuScene();
	}
	public StartScene getStartScene(){
		return new StartScene();
	}
	
	public GameScene getGameScene(){
		return new GameScene();
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}
	public Resources getResources(){
		return resources;
	}
	
}
