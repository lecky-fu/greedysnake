package com.fupeng.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;




public class JFrameGame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int width ;
	private int height ;
	private int move ;
	
	public JFrameGame(JPanelGame panelGame){
		width = 1200;
		height = 730;
		move = 15;
		this.setTitle("Ì°³ÔÉß");
		this.setSize(width, height);
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setLocation((screen.width-width)>>1, ((screen.height-height)>>1)-move);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelGame);
		this.setVisible(true);
	}
}
