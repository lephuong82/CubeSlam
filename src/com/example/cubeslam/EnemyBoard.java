package com.example.cubeslam;

import android.os.Build;

public class EnemyBoard extends Board {

	@Override
	public void updateBehaviour(long delay) {
		Ball ball = GameScene.getGameScene().getBall();
		setX(ball.getX()-getWidth()/2);
	}
	
	
}
