package com.fupeng.entity;

import java.awt.Component;

import com.fupeng.dto.GameDto;
import com.fupeng.snake.Snake;

public class Food extends Component implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private GameDto gameDto;
	
	private int time ;
	
	public Food(GameDto gameDto) {
		super();
		this.gameDto=gameDto;
	}
	
	@Override
	public void run() {
		while(true){
			int y=Snake.random.nextInt(gameDto.getGameMap()[0].length);//0-19
			int x=Snake.random.nextInt(gameDto.getGameMap().length);//0-29
			if(this.gameDto.isStart()){
				try {
					if(gameDto.getGameMap()[x][y])
						continue;
					gameDto.getGameMap()[x][y]=true;
					gameDto.jPanelGame.repaint();
					gameDto.jPanelGame.setVisible(true);
					time = Snake.random.nextInt(6)+1;
					Thread.sleep(time*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
