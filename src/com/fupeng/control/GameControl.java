package com.fupeng.control;

import com.fupeng.entity.Entity;
import com.fupeng.service.CoreService;

public class GameControl {
	private CoreService coreService;
	
	private Thread moveThread ;
	
	public GameControl(CoreService coreService){
		this.coreService = coreService;
		autoMove();
	}
	
	/*
	 * 自动前进处理函数
	 */
	private void autoMove(){
			moveThread = new Thread(){
				@Override
				public void run() {
					super.run();
					while(true){
						if(coreService.getGameDto().isStart()){
							move();
						}
						try {
							//修改这里可以将snake的自动移动变为函数曲线的方式
							//这里的移动速度需要根据等级来确定：speed=f(grade).
							//函数time=1750/(grade+1.5)
							Thread.sleep(timeFx(coreService.getGameDto().level));
						} catch (InterruptedException e) {
							e.printStackTrace();}
					}
				}
				/*
				 * 睡眠时间计算函数
				 */
				private long timeFx(int level) {
					return (long) (1750/(level+2.5));
				}
			};
			moveThread.start();
	}
	
	
	/*
	 * 自动移动函数
	 */
	private void move() {
		 //获取蛇头的坐标（x，y）
		 int[] headPosition = this.coreService.getGameDto().getSnake().getSnakeList().getFirst().getPosition();
		 int headX = headPosition[0];
		 int headY = headPosition[1];
		 //获取第二个元素的坐标（x，y）
		 int[] nextPosition  = this.coreService.getGameDto().getSnake().getSnakeList().get(1).getPosition();
		 int nextX = nextPosition[0];
		 int nextY = nextPosition[1];
		 //根据两个entity的坐标，判断蛇的移动方向
		 if (headX==nextX && headY<nextY) {
			action(38);
		}else if (headX==nextX && headY>nextY) {
			action(40);
		}else if (headY==nextY && headX<nextX) {
			action(37);
		}else{
			action(39);
		}
	}

	/*
	 * 根据监听到的键盘事件作出相应的动作
	 */
	public void action(int keyCode)  {
		if(!this.coreService.getGameDto().isStart())
			return;
		 //获取蛇头的坐标（x，y）
		try {
			 int[] headPosition = this.coreService.getGameDto().getSnake().getSnakeList().getFirst().getPosition();
			 int headX = headPosition[0];
			 int headY = headPosition[1];
			 Entity entity = new Entity();
			 entity.setPosition(new int[]{headX, headY});
			 //获取第二个元素的坐标（x，y）
			 int[] nextPosition  = this.coreService.getGameDto().getSnake().getSnakeList().get(1).getPosition();
			 int nextX = nextPosition[0];
			 int nextY = nextPosition[1];
			 //判断键盘控制事件以及可以移动的方向
			switch (keyCode) {
			case 38://上
				if(!(headX==nextX && headY>nextY)){
					if(this.coreService.getGameDto().getGameMap()[headX][headY-1]){
						coreService.eatFood(0, -1, entity);
						break;
					}
					coreService.move(entity,0 ,-1);
				}
				break;
			case 40://下
				if(!(headX==nextX && headY<nextY)){
					if (this.coreService.getGameDto().getGameMap()[headX][headY+1]) {
						coreService.eatFood(0, 1, entity);
						break;
					}
					coreService.move(entity,0, 1);
				}
				break;
			case 37://左
				if(!(headY==nextY && headX>nextX)){
					if (this.coreService.getGameDto().getGameMap()[headX-1][headY]) {
						coreService.eatFood(-1, 0, entity);
						break;
					}
					coreService.move(entity,-1, 0);
				}
				break;
			case 39://右
				if(!(headY==nextY && headX<nextX)){
					if (this.coreService.getGameDto().getGameMap()[headX+1][headY]) {
						coreService.eatFood(1, 0, entity);
						break;
					}
					coreService.move(entity,1, 0);
				}
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			this.coreService.getGameDto().setStart(false);
			System.exit(0);
		}
	}

	public CoreService getCoreService() {
		return coreService;
	}
	
	/*
	 * 蛇身数组越界判断函数
	 * 游戏结束判断函数
	 */
	private boolean isOver(int headX ,int headY){
		if (headX>0 && headX<this.coreService.getGameDto().getGameMap().length 
				&& headY>0 && headY<this.coreService.getGameDto().getGameMap()[0].length) {
			return false;
		}else
			return true;
	}
}
