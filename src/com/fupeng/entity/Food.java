package com.fupeng.entity;

import java.awt.Component;

import com.fupeng.dto.GameDto;
import com.fupeng.snake.Snake;

public class Food extends Component implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private GameDto gameDto;
	
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
					//修改小方块出现的时间time，出现时间跟level相关 time=f(level)
					Thread.sleep(timeFx(this.gameDto.level));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 小方块出现时间计算函数
	 * y=-40x+940  x<=20
	 * 		100			x>20
	 */
	private long timeFx(int level) {
		if(level<=20)
			return -40*level+940;
		else
			return 100;
	}
	
}
