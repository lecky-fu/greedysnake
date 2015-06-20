package com.fupeng.ui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.fupeng.control.GameControl;
import com.fupeng.control.PauseControl;
import com.fupeng.control.StartControl;
import com.fupeng.control.PlayControl;
import com.fupeng.dto.GameDto;
import com.fupeng.layerconfig.FrameConfig;
import com.fupeng.layerconfig.GameConfig;
import com.fupeng.layerconfig.LayerConfig;


public class JPanelGame extends JPanel{
	private static final long serialVersionUID = 1L;
	public final static Icon START_ICON = new ImageIcon("image/start.png");
	public final static Icon PAUSE_ICON = new ImageIcon("image/pause.png");
	private GameDto gameDto;
	private GameControl gameControl;
	
	public JPanelGame(){
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		UiBase uiBackGround = new UiBackGround();
		uiBackGround.point(g);
		initLayer(g);
		this.requestFocus();
	}
	
	/*
	 * 暂时使用这种方式初始化layer属性
	 * 后续使用反射的方式来创建layer对象
	 */
	private void initLayer(Graphics g){
		List<LayerConfig> layerConfigs = GameConfig.getFRAME_CONFIG().getLayerConfig();
		//配置uiGame层配置
		LayerConfig layerGame = layerConfigs.get(0);
		UiBase uiGame =new UiGame(layerGame.getX(), 
				layerGame.getY(), 
				layerGame.getW(), 
				layerGame.getH(),
				layerGame.getSize());
		uiGame.setGameDto(gameDto);
		uiGame.point(g);
		
		//配置uiScore层属性
		LayerConfig layerScore = layerConfigs.get(1);
		UiBase uiScore =new UiScore(layerScore.getX(), 
				layerScore.getY(), 
				layerScore.getW(), 
				layerScore.getH(),
				layerScore.getSize());
		uiScore.point(g);
	}
	
	/*
	 * 鼠标监听按钮组件
	 */
	public void initComponet(){
		setLayout(null);
		
		JButton startButton = new JButton(START_ICON);
		startButton.setBounds(1066, 94, 64, 32);
		startButton.addMouseListener(new StartControl(this.gameControl));
		this.add(startButton);
		
		JButton pauseButton = new JButton(PAUSE_ICON);
		pauseButton.setBounds(1066, 254, 64, 32);
		pauseButton.addMouseListener(new PauseControl(this.gameControl));
		this.add(pauseButton);
	}
	
	/*
	 * 安装键盘事件监听器
	 */
	public  void setGameControl(GameControl gameControl){
		this.gameControl=gameControl;
		this.addKeyListener(new PlayControl(gameControl));
	}

	
	public void setGameDto(GameDto gameDto) {
		this.gameDto = gameDto;
	}
}
