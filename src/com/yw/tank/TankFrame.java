package com.yw.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/11/26 1:33 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class TankFrame extends Frame {

	Tank tank = new Tank(200,200 ,Dir.DOWN,this);

	List<Bullet> bullets = new ArrayList<>();

	static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
	public TankFrame(){
		this.setTitle("tank war");
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setVisible(true);
		this.setResizable(false);

		this.addKeyListener(new MyKeyListener());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	@Override
	public void paint(Graphics g){
		Color color = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹数量:"+bullets.size(),10,60);
		g.setColor(color);
		tank.paint(g);
//		bullets.forEach(bullet -> bullet.paint(g));
		for (int i = 0; i<bullets.size();i++){
			bullets.get(i).paint(g);
		}

		bullets.removeIf(bullet -> !bullet.live);

	}

	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	class MyKeyListener extends KeyAdapter{

		boolean bl = false;
		boolean bu = false;
		boolean br = false;
		boolean bd = false;

		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			int key = e.getKeyCode();
			switch (key){
				case KeyEvent.VK_LEFT:
					bl=true;
					break;
				case KeyEvent.VK_UP:
					bu= true;
					break;
				case KeyEvent.VK_RIGHT:
					br=true;
					break;
				case KeyEvent.VK_DOWN:
					bd=true;
					break;
				default:
					break;
			}

			setMainTankDir();

		}

		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			int key = e.getKeyCode();
			switch (key){
				case KeyEvent.VK_LEFT:
					bl=false;
					break;
				case KeyEvent.VK_UP:
					bu= false;
					break;
				case KeyEvent.VK_RIGHT:
					br=false;
					break;
				case KeyEvent.VK_DOWN:
					bd=false;
					break;
				case KeyEvent.VK_CONTROL:
					tank.fire();
					break;
				default:
					break;
			}

			setMainTankDir();
		}

		private void setMainTankDir() {
			if (!bl && !bu && !bd && !br) tank.setMoving(false);
			else
				tank.setMoving(true);

			if (bl) tank.setDir(Dir.LEFT);
			if (bu) tank.setDir(Dir.UP);
			if (br) tank.setDir(Dir.RIGHT);
			if (bd) tank.setDir(Dir.DOWN);

		}
	}


}
