package com.fupeng.ui;

import java.awt.Graphics;

import com.fupeng.entity.Entity;

public class UiGame extends UiBase {

	public UiGame(int x, int y, int w, int h, int size) {
		super(x, y, w, h,size);
	}

	@Override
	public void point(Graphics g) {
		drawWindow(g);
		drawLine(g, gameDto.getGameMap()[0].length, gameDto.getGameMap().length, Entity.DIMENSION,size);
		drawSnake(g,gameDto.getGameMap());
	}

	private void drawSnake(Graphics g,boolean[][] gameMap) {
		for(int i=0;i<gameMap[0].length;i++){
			for(int j=0;j<gameMap.length;j++){
				if(gameMap[j][i]){
					g.drawImage(Entity.ENTITY, x+size+j*Entity.DIMENSION, y+size+i*Entity.DIMENSION, 
																x+size+(j+1)*Entity.DIMENSION, y+size+(i+1)*Entity.DIMENSION, 
										Entity.DIMENSION, 0, Entity.DIMENSION<<1, Entity.DIMENSION, null);
				}
			}
		}
		//将蛇头替换成绿色
		int[] head = gameDto.getSnake().getSnakeList().getFirst().getPosition();
		g.drawImage(Entity.ENTITY, x+size+head[0]*Entity.DIMENSION, y+size+head[1]*Entity.DIMENSION, 
													x+size+(head[0]+1)*Entity.DIMENSION, y+size+(head[1]+1)*Entity.DIMENSION, 
													4*Entity.DIMENSION, 0, 5*Entity.DIMENSION, Entity.DIMENSION, null);
	}

}
