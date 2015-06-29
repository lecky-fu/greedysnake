package com.fupeng.dto;

import com.fupeng.entity.Food;
import com.fupeng.snake.Snake;
import com.fupeng.ui.JPanelGame;

public class GameDto {
	private  boolean[][] gameMap;
	
	public static  int score = 0;
	
	public static int level = 0;
	
	public   JPanelGame jPanelGame = new JPanelGame();
	
	private Snake snake;
	
	private volatile boolean start;
	
	private Food foodEntity;
	
	public GameDto() {
		gameMap=new boolean[30][20];
		snake = new Snake(this);
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public Snake getSnake() {
		return snake;
	}
	public boolean[][] getGameMap() {
		return gameMap;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public Food getFoodEntity() {
		return foodEntity;
	}
	public void setFoodEntity(Food foodEntity) {
		this.foodEntity = foodEntity;
	}
	
}
