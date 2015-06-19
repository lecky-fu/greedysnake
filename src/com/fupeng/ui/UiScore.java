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
	 * ����ͼƬ�������
	 */
	private int deep = 2;
	
	/*
	 * socre���ڷ�Ϊ4��С���飬ÿ��С����ĸ߶�
	 */
	private int disision = (h-(size<<1))>>2;
	
	/*
	 *��ʼ��ť����ͣ��ťλ�Ʋ���
	 */
	private int moveX =(w-(size<<1)-point_w)>>1;
	private int moveY =(((h-(size<<1))>>2) -point_h)>>1;
	
	/*
	 *�����Լ��ȼ���ʾλ�Ʋ��� 
	 */
	public static int nmoveY = (((h-(size<<1))>>2) - num_h)>>1;
	
	public UiScore(int x, int y, int w, int h, int size) {
		super(x, y, w, h,size);
	}

	@Override
	public void point(Graphics g) {
		drawWindow(g);
		//����4���ֿ�
		drawLine(g, 5, 0, disision,size);
		//��������ʾ����
		drawPic(g, moveX, disision<<1, POINT_IMG);
		//���ȼ���ʾ����
		drawPic(g, moveX, disision*3, LEVEL_IMG);
		//��������ʾ������this.gameDto.score����ֵ������numͼƬ��ʾ����
		drawScore(g,this.gameDto.score,deep);
		//���ȼ���ʾ
		drawScore(g, this.gameDto.level, ++deep);
	}
	
	/*
	 * @param score ����
	 * @param deep�ڼ���������
	 * �����滭����
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
