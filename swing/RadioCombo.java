package packageid.d3ti.oopl.keenam.swing;

import java.awt.Container; 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RadioCombo extends JFrame implements ActionListener, ChangeListener {
	ButtonGroup bg;
	JRadioButton rb1, rb2;
	JComboBox cb;
	JButton b;
	final String[]jenis = {"Laki-laki", "Perempuan"};

	JMenuBar mb;
	JMenu m;
	public RadioCombo() {
		super("Radio Combo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		mb = new JMenuBar();
		m.addChangeListener((ChangeListener) this);
		this.setJMenuBar(mb);
		cp.add(rb1 = new JRadioButton("laki-laki"));
		cp.add(rb2 = new JRadioButton("Perempuan"));
		bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		cp.add(cb = new JComboBox(jenis));
		cp.add(b = new JButton("Simpan"));
		this.setVisible(true);
		b.addActionListener((ActionListener)this);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RadioCombo();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		EventObject arg0 = null;
		// TODO Auto-generated method stub
		if(arg0.getSource() == m) {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EventObject arg0 = null;
		// TODO Auto-generated method stub
		if(arg0.getSource() == b) {
			String radio = null;
			if(rb1.isSelected() == true) {
				radio = rb1.getText();
			}else {
				radio = rb2.getText();
			}
			System.out.println("Radio Button Memilih: "+radio);
			String combo = cb.getSelectedItem().toString();
			System.out.println("ComboBox Memilih: "+combo);
		}
	}
	

}
