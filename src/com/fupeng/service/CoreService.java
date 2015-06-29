package com.fupeng.service;

import java.util.Iterator;

import com.fupeng.dto.GameDto;
import com.fupeng.entity.Entity;
import com.fupeng.entity.Food;

public class CoreService {
	private GameDto gameDto;
	private Food foodEntity = null;
	
	public CoreService(GameDto gameDto){
		this.foodEntity=new Food(gameDto);
		this.gameDto = gameDto;
		initSnakeHead();
	}
	
	/*
	 *把snake链表放到map地图中去
	 */
	private void initSnakeHead(){
		Iterator<Entity> iterator = this.gameDto.getSnake().getSnakeList().iterator();
		while( iterator.hasNext() ){
			int[] position=iterator.next().getPosition();
			int positionX=position[0];
			int positionY=position[1];
			gameDto.getGameMap()[positionX][positionY]=true;
		}
	}
	
	/*
	 *随机产生食物,多线程方法 
	 */
	public void initFood(){
		this.gameDto.setFoodEntity(foodEntity);
		Thread foodThread = new Thread(this.gameDto.getFoodEntity());
		foodThread.start();
	}
	
	/*
	 * snake移动函数
	 */
	public void move(Entity entity,int moveX ,int moveY){
		 //对entity实体添加控制位移量，添加到snake首部
		 entity.setPosition(new int[]{entity.getPosition()[0]+moveX, entity.getPosition()[1]+moveY});
		//首先需要删除snake链表的尾元素以及map地图中尾元素对应的坐标
		removeAction();
		//在蛇首添加新元素
		snakeMoveAddFirst(entity);
		//点击开始按钮之后，开始刷新画面，若不点击，则不开始
		this.gameDto.jPanelGame.repaint();
	}
   
	/*
	 * 删除函数
	 * 1，删除蛇链表的最后一个元素
	 * 2，删除map地图中蛇尾所在的坐标
	 */
	private void removeAction() {
		int[] lastPosition = this.gameDto.getSnake().getSnakeList().removeLast().getPosition();		
		this.gameDto.getGameMap()[lastPosition[0]][lastPosition[1]]=false;
	}
	/*
	 * 
	 * 蛇首元素添加方法
	 */
	private void snakeMoveAddFirst( Entity entity) {
		 this.gameDto.getSnake().getSnakeList().addFirst(entity);
		 initSnakeHead();
	}
	
	/*
	 * snake在前进的过程中碰到food的处理方法
	 */
	public void eatFood(int moveX,int moveY,Entity entity) {
		entity.setPosition(new int[]{entity.getPosition()[0]+moveX, entity.getPosition()[1]+moveY});
		//eatFood函数中要对游戏结束条件之一进行判断：snake head碰到蛇身。
		if(isGameOver(entity))
			//结束游戏
			System.exit(0);
		this.gameDto.getSnake().getSnakeList().addFirst(entity);
		//gameDto分数变量，吃一个食物加一分
		this.gameDto.score = this.gameDto.getSnake().getSnakeList().size()-3;
		//gameDto等级变量，10分加一级
		this.gameDto.level = (this.gameDto.score - this.gameDto.score % 10)/10;
		this.gameDto.jPanelGame.repaint();
	}
	 /*
     * 游戏结束判断，若snake head下一个坐标entity包含在snake list中，则返回true，否则返回false
     * @param return 包含，返回true，否则，返回false
     */
	public boolean isGameOver(Entity entity) {
		if(this.gameDto.getSnake().getSnakeList().contains(entity))
			return true;
		else 
			return false;
	}

	public GameDto getGameDto() {
		return gameDto;
	}
}
