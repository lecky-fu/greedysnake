package com.fupeng.control;

import java.awt.event.MouseAdapter;

public class StartControl extends MouseAdapter {
	private GameControl gameControl;
	public StartControl(GameControl gameControl){
		this.gameControl=gameControl;
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		super.mouseClicked(e);
		//将start状态设置成true
		this.gameControl.getCoreService().getGameDto().setStart(true);
		//开始初始化食物生成
		this.gameControl.getCoreService().initFood();
	}
}
