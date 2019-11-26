package com.yw.tank;

/**
 * @author ：
 * @date ：Created in 2019/11/26 1:12 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tankFream = new TankFrame();
		while (true){
			Thread.sleep(500);
			tankFream.repaint();
		}
	}
}
