import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ：
 * @date ：Created in 2019/11/26 1:12 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class T {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setTitle("tank war");
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setResizable(false);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
}
