package com.fupeng.snake;

import java.util.LinkedList;
import java.util.Random;

import com.fupeng.dto.GameDto;
import com.fupeng.entity.Entity;


public class Snake {
	public  static Random random = new Random();
	
	private  LinkedList<Entity> snake ;
	
	private GameDto gameDto;
	
	public Snake(GameDto gameDto){
		this.gameDto=gameDto;
		snake = new LinkedList<Entity>();
		snakeHead();
	}
	
	/*
	 * 初始化状态蛇头包括三个实体，且出现位置为1<x<16
	 */
	private void snakeHead(){
		int y=random.nextInt(gameDto.getGameMap()[0].length-1);//0-19
		int x=random.nextInt(gameDto.getGameMap().length-15);//0-29
		for(int i=0;i<3;i++){
			Entity head = new Entity();
			int [] position = {x+2-i,y};
			head.setPosition(position);
			snake.add(head);
		}
	}

	public   LinkedList<Entity> getSnakeList() {
		return snake;
	}

}
