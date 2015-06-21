package com.fupeng.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class UiScore extends UiBase {
	
	private final static Image POINT_IMG = new ImageIcon("image/point.png").getImage();
	private int point_w = POINT_IMG.getWidth(null);
	private  int point_h = POINT_IMG.getHeight(null);
	private final static Image LEVEL_IMG = new ImageIcon("image/level.png").getImage();
	
	private final static Image NUM_IMG = new ImageIcon("image/num.png").getImage();
	private final int nums = 10;
	private static int num_h = NUM_IMG.getHeight(null);
	private  int num_w = NUM_IMG.getWidth(null)/nums;
	
	/*
	 * 数字图片方框序号
	 */
	private int deep = 2;
	
	/*
	 * socre窗口分为4个小方块，每个小方块的高度
	 */
	private int disision = (h-(size<<1))>>2;
	
	/*
	 *开始按钮和暂停按钮位移参数
	 */
	private int moveX =(w-(size<<1)-point_w)>>1;
	private int moveY =(((h-(size<<1))>>2) -point_h)>>1;
	
	/*
	 *分数以及等级显示位移参数 
	 */
	public static int nmoveY = (((h-(size<<1))>>2) - num_h)>>1;
	
	public UiScore(int x, int y, int w, int h, int size) {
		super(x, y, w, h,size);
	}

	@Override
	public void point(Graphics g) {
		drawWindow(g);
		//画出4个分块
		drawLine(g, 5, 0, disision,size);
		//画分数显示标题
		drawPic(g, moveX, disision<<1, POINT_IMG);
		//话等级显示标题
		drawPic(g, moveX, disision*3, LEVEL_IMG);
		//画分数显示，根据this.gameDto.score变量值来控制num图片显示数字
		drawScore(g,this.gameDto.score,deep);
		//画等级显示
		drawScore(g, this.gameDto.level, ++deep);
	}
	
	/*
	 * @param score 分数
	 * @param deep第几个方框内
	 * 分数绘画方法
	 */
	private void drawScore(Graphics g,int score,int deep) {
		String scoreString = score+"";
		for(int i=0;i<scoreString.length();i++){
			int word = Integer.parseInt(scoreString.charAt(i)+"");
			g.drawImage(NUM_IMG, x+size+num_w*i, y+size+disision*deep+moveY, 
								x+size+num_w*(i+1), y+size+disision*deep+nmoveY+num_h, 
								num_w*word, 0, num_w*(word+1), num_h, null);
		}
	}

	/*
	 *draw the start view  
	 */
	private void drawPic(Graphics g,int moveX, int moveY,Image image) {
		g.drawImage(image, x+size+moveX, y+size+moveY, x+size+moveX+point_w, y+size+moveY+point_h, 
				0, 0, point_w, point_h, null);
	}
	
}
