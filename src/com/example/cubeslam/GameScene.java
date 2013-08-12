package com.example.cubeslam;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.util.Log;
import android.view.MotionEvent;

public class GameScene extends Scene{
	
	public Paint backPaint;
	public LinearGradient gradient;
	public Board myBoard;
	public Board enemyBoard;
	
	public Ball ball;
	public static GameScene gameScene;
	public  static GameScene getGameScene(){
		return gameScene;
	}
	
	public GameScene(){
		gameScene = this;
	}
	
	private int temp = 0;
	private int MAX = 50;
	@Override
	public void updateBehaviour(long deltaTime) {
		temp++;
		Log.e("!",""+temp);
		ball.update(deltaTime);
		enemyBoard.update(deltaTime);
		if(temp > MAX){
			if(ball.getY() > myBoard.getY()-ball.getHeight()){
				if(ball.getX() > myBoard.getX()&&ball.getX() < myBoard.getX()+myBoard.getWidth()){
					ball.collision(myBoard);
					temp = 0;
				} 
				
			} 
			else if(ball.getY() > myBoard.getY()){
				if(ball.getX() > myBoard.getX()&&ball.getX() < myBoard.getX()+myBoard.getWidth()){
					ball.collision(new SceneObject());
					temp = 0;
				}
			}
			
			if(ball.getY() < ball.getHeight()){
				if(ball.getX() > enemyBoard.getX()&&ball.getX() < enemyBoard.getX()+enemyBoard.getWidth()){
					ball.collision(enemyBoard);
					temp = 0;
				}
			}
			else if(ball.getY() > myBoard.getY()){
				if(ball.getX() > myBoard.getX()&&ball.getX() < myBoard.getX()+myBoard.getWidth()){
					ball.collision(new SceneObject());
					temp = 0;
				}
			}
		}
		
		
		if(ball.getX() < 0 || ball.getX() > (Engine.getEngine().getDisplayMetrics().widthPixels-ball.getWidth())){
			ball.collision(new SceneObject());
		}
		
		if(ball.getY() > (Engine.getEngine().getDisplayMetrics().heightPixels)||
				ball.getY() < 0-ball.getHeight()){
			initBall();
		}
		
		
		
	}

	@Override
	public void init() {
		float w = Engine.getEngine().getDisplayMetrics().widthPixels;
		float h = Engine.getEngine().getDisplayMetrics().heightPixels;
		gradient = new LinearGradient(w/2, 0, w/2, h, Color.rgb(42, 189, 000), Color.YELLOW, TileMode.REPEAT);
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
		initBall();
		add(ball, 0);
	}
	
	public void initBall(){
		ball.setX(Engine.getEngine().getDisplayMetrics().widthPixels/2 - ball.getHeight()/2);
		ball.setY(Engine.getEngine().getDisplayMetrics().heightPixels/2 - ball.getWidth()/2);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		

		
		if(event.getAction() == MotionEvent.ACTION_MOVE){
			int x = (int)event.getX();
			int y = (int)event.getY();

			
			Rect rect = new Rect(
					(int)myBoard.getX(),
					(int)myBoard.getY(),
					(int)myBoard.getX()+(int)myBoard.getWidth(),
					(int)myBoard.getY()+(int)myBoard.getHeight()
					);
			if(rect.contains(x, y)){
				if(x >= myBoard.getWidth()/2 && x <= Engine.getEngine().getDisplay().getWidth()-myBoard.getWidth()/2){
					myBoard.setX(x-myBoard.getWidth()/2);
				}
				else if(x < myBoard.getWidth()/2){
					myBoard.setX(0);
				}
				else if(x > Engine.getEngine().getDisplay().getWidth()-myBoard.getWidth()/2){
					myBoard.setX(Engine.getEngine().getDisplay().getWidth()-myBoard.getWidth());
				}

			}
		}

		
		return true;
	}

	@Override
	public Paint getPaint() {
		
		return backPaint;
	}

	public Ball getBall(){
		return ball;
	}
	
}
