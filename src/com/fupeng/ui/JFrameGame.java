package com.fupeng.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.fupeng.layerconfig.FrameConfig;
import com.fupeng.layerconfig.GameConfig;




public class JFrameGame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private int width ;
	private int height ;
	private int move ;
	
	public JFrameGame(JPanelGame panelGame){
		FrameConfig frameConfig = GameConfig.getFRAME_CONFIG();
		width = frameConfig.getWidth();
		height = frameConfig.getHeight();
		move = frameConfig.getMove();
		this.setTitle(frameConfig.getTitle());
		this.setSize(width, height);
		this.setResizable(frameConfig.isResizable());
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setLocation((screen.width-width)>>1, ((screen.height-height)>>1)-move);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelGame);
		this.setVisible(frameConfig.isVisible());
	}
}
