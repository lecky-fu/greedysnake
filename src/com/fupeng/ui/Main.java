package com.fupeng.ui;

import com.fupeng.control.GameControl;
import com.fupeng.dto.GameDto;
import com.fupeng.service.CoreService;

public class Main {

	public static void main(String[] args) {
		//��Ϸ��ݶ���,��װ��ʱ��ע��jpanelGameһ����Ҫͳһ�����еĶ�Ҫ��ͬһ������
		GameDto gameDto = new GameDto();
		CoreService coreService = new CoreService(gameDto);
		GameControl gameControl = new GameControl(coreService);
		gameDto.jPanelGame.setGameControl(gameControl);
		gameDto.jPanelGame.setGameDto(gameDto);
		gameDto.jPanelGame.initComponet();
		new JFrameGame(gameDto.jPanelGame);
		System.out.println("我的第一个github项目");
	}

}
