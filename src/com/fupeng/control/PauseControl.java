package com.fupeng.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PauseControl extends MouseAdapter {
	private GameControl gameControl;
	public PauseControl(GameControl gameControl) {
		this.gameControl=gameControl;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		this.gameControl.getCoreService().getGameDto().setStart(false);
		}
}
