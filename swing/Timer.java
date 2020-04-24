package packageid.d3ti.oopl.keenam.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Timer extends JFrame implements ActionListener, ChangeListener {
	JTextField txAngka;
	JButton b;
	JPanel panel1;
	JLabel lbAngka;
	JLabel transformasi;
	
	JMenuBar mb;
	JMenu m;
	public Timer() {
		super("Timer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		Panel p = new Panel();
		add(p);
		p.setLayout(new GridLayout(9,10));
		lbAngka = new JLabel("Start From :");
		transformasi = new JLabel ("start");
		txAngka = new JTextField();
		panel1 = new JPanel();
		p.add(lbAngka);
    	p.add(txAngka);
    	p.add(transformasi);
		mb = new JMenuBar();
		mb.add(m=new JMenu("exit"));
		m.addChangeListener((ChangeListener) this);;
		this.setJMenuBar(mb);
		
		cp.add(b = new JButton("Start"));
		this.setVisible(true); 
		b.addActionListener((ActionListener) this);
	}
	
public static void main (String[] args) {
	new Timer();
}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == b) {
			Integer angka=Integer.parseInt(txAngka.getText());
			System.out.println("Start From: "+angka);
			transformasi = new JLabel ("");
			for (int i=0;i<angka;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
