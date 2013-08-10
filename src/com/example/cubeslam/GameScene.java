package com.example.cubeslam;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.Log;
import android.view.MotionEvent;

public class GameScene extends Scene{
	
	public Paint backPaint;
	public LinearGradient gradient;
	public Board myBoard;
	public Board enemyBoard;
	
	public Ball ball;
	
	public GameScene(){
		super();
	}
	
	
	@Override
	public void updateBehaviour(long deltaTime) {
		
		
	}

	@Override
	public void init() {
		float w = Engine.getEngine().getDisplay().getWidth();
		float h = Engine.getEngine().getDisplay().getHeight();
		gradient = new LinearGradient(w/2, 0, w/2, h, Color.rgb(42, 189, 100), Color.rgb(255, 255, 255), TileMode.REPEAT);
		backPaint = new Paint();
		backPaint.setShader(gradient);	
		createLayer();
		createLayer();
		createBoard();
		createBall();
	}

	public void createBoard(){
		myBoard = new MyBoard();
		myBoard.setImage(Factory.getFactory().board);
		enemyBoard = new EnemyBoard();
		enemyBoard.setImage(Factory.getFactory().board);
		myBoard.setX(Engine.getEngine().getDisplayMetrics().widthPixels/2 - myBoard.getWidth()/2);
		myBoard.setY(Engine.getEngine().getDisplayMetrics().heightPixels - myBoard.getHeight());
		Log.e("h", ""+Engine.getEngine().getDisplayMetrics().heightPixels+",,"+myBoard.getHeight());
		enemyBoard.setX(Engine.getEngine().getDisplayMetrics().widthPixels/2 - enemyBoard.getWidth()/2);
		enemyBoard.setY(0);
		add(myBoard, 0);
		add(enemyBoard, 0);
	}
	
	public void createBall(){
		ball = new Ball();
		ball.setImage(Factory.getFactory().ball);
		ball.setX(Engine.getEngine().getDisplayMetrics().widthPixels/2 - ball.getHeight()/2);
		ball.setY(Engine.getEngine().getDisplayMetrics().heightPixels/2 - ball.getWidth()/2);
		add(ball, 0);
	}
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		return false;
	}

	@Override
	public Paint getPaint() {
		
		return backPaint;
	}

	
}
