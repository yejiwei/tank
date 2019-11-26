package com.yw.tank;

import java.awt.*;

/**
 * @author ：
 * @date ：Created in 2019/11/26 4:27 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED = 10;

	private boolean moving = false;

	private TankFrame tankFrame = null;

	public Tank() {
	}

	public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame = tankFrame;
	}

	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.yellow);
		g.fillRect(x,y,50,60);
		g.setColor(color);
		move();

	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private void move() {
		if (!moving) return;
		switch (dir){
			case LEFT:
				x-=SPEED;
				break;
			case UP:
				y-=SPEED;
				break;
			case RIGHT:
				x+=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
		}

	}


	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void fire() {
		tankFrame.bullets.add(new Bullet(this.x,this.y,this.dir,tankFrame));
	}
}
