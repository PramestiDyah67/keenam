package packageid.d3ti.oopl.keenam.swing;
import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;

public class JavaTimer extends JFrame {

	JLabel Label, timerLabel;
	int counter;
	JTextField tf;
	JButton button;
	Timer timer;
	
	public JavaTimer() {
		setLayout(new GridLayout(2, 2, 5, 5));
		
		Label = new JLabel("Masukan waktu:", SwingConstants.CENTER);
		add(Label);
		
		tf = new JTextField(5);
		add(tf);
		
		button = new JButton("Start");
		add(button);
		
		timerLabel = new JLabel("start", SwingConstants.CENTER);
		add(timerLabel);
		
		//saat klik button code akan dijalankan
		event e = new event();
		button.addActionListener(e);
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int count = (int)(Double.parseDouble(tf.getText()));
			timerLabel.setText("00:" + count);
			
			TimeClass tc = new TimeClass(count);
			timer= new Timer(1000, tc);
			timer.start();
			
		}
		
	}

	
	public class TimeClass implements ActionListener{
		int counter;
		
		public TimeClass (int counter) {
			this.counter = counter;
		}
		
		public void actionPerformed(ActionEvent tc) {
			counter--;
			
			if (counter >=1) {
				timerLabel.setText("00:" + counter);
			}else {
				timer.stop();
				timerLabel.setText("00:00");
				Toolkit.getDefaultToolkit().beep();
				}
		}
	}
	
	public static void main(String args[]) {
		JavaTimer a = new JavaTimer();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(250,100);
		a.setTitle("PBO TIMER");
		a.setVisible(true);
	}
	
}

