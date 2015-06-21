package com.fupeng.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayControl extends KeyAdapter{
	private GameControl gameControl;
	public PlayControl(GameControl gameControl){
		this.gameControl =gameControl;
	}
	public void keyPressed(KeyEvent e) {
		//上38，下40，左37，右39
		gameControl.action(e.getKeyCode());
	}
}
