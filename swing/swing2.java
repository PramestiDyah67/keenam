package packageid.d3ti.oopl.keenam.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

	public class swing2 extends JFrame implements ActionListener,ChangeListener{
		ButtonGroup bg;
		JRadioButton rb1,rb2;
		JComboBox cb;
		JButton b;
		final String[] jenis = {"Laptop","PC","Monitor"};
		JMenuBar mb;
		JMenu m;
		double diskon;
		JTextField txAngka;
		JLabel lbAngka;
		JPanel panel1;
		JFrame frame;
		int harga;
		double total;
		
		public swing2(){
		
			super("Pilih Barang");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container cp = this.getContentPane();
			cp.setLayout(new FlowLayout());
			Panel p = new Panel();
			add(p);
			p.setLayout(new GridLayout(9,10));
			cp.add(cb =new JComboBox(jenis));
			lbAngka = new JLabel("Jumlah Pembelian :");
			txAngka = new JTextField();
			panel1 = new JPanel();
			p.add(lbAngka);
        	p.add(txAngka);
			mb = new JMenuBar();
			mb.add(m=new JMenu("exit"));
			m.addChangeListener((ChangeListener) this);;
			this.setJMenuBar(mb);
			p.add(rb1 = new JRadioButton("member"));
			p.add(rb2 = new JRadioButton("non member"));
			bg = new ButtonGroup();
			bg.add(rb1);
			bg.add(rb2);
			
			
			cp.add(b = new JButton("Kalkulasi"));
			this.setVisible(true); 
			b.addActionListener((ActionListener) this);
		}

		public static void main(String args[]){
			new swing2();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource() == b){
				String radio=null;
				
				if(rb1.isSelected() == true){
					radio = rb1.getText();
					diskon=0.01;
				}
				else {
					radio = rb2.getText();
					diskon=0;
				}
				if(cb.getSelectedItem().equals("Laptop")){
					harga=5000000;
					
				}
				if(cb.getSelectedItem().equals("PC")){
					harga=2000000;
					
				}
				if(cb.getSelectedItem().equals("Monitor")){
					harga=900000;
					
				}
				
				JFrame frame = new JFrame();
				frame.setTitle("Data Pembelian");
				//	Menentukan ukuran Frame
		frame.setSize(400, 300);
		
				Integer angka=Integer.parseInt(txAngka.getText());
				total=(angka*harga)-(angka*diskon*harga);
				String combo = cb.getSelectedItem().toString();
				System.out.println("Pilih Barang: "+combo);
				System.out.println("Jenis Pembelian: "+radio);
				System.out.println("jumlah: "+angka);
				System.out.println("Harga: "+angka*harga);
				System.out.println("Diskon: "+diskon);
				System.out.println("Total: "+(total));

		//	Membuat letak Frame berada di tengat ketika program dijalankan
		frame.setLocationRelativeTo(null);
		JLabel label2 = new JLabel("Nama Barang = "+combo);
		JLabel label = new JLabel("Member = "+radio);
		JLabel label3 = new JLabel("Jumlah Barang= "+angka);
		JLabel label4 = new JLabel("Harga Awal= "+angka*harga);
		JLabel label5 = new JLabel("Diskon= "+angka*harga*diskon);
		JLabel label6 = new JLabel("Total= "+total);
		
		//	Menentukan layout Frame
		frame.setLayout(null);
		
		//	Memasukkan Label ke dalam Frame
		frame.add(label);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		//	Menentukan posisi label di dalam Frame. Menentukan Width dan Height
		label.setBounds(20, 20, 150, 30);
		label2.setBounds(20, 40, 150, 30);
		label3.setBounds(20, 60, 150, 30);
		label4.setBounds(20, 80, 150, 30);
		label5.setBounds(20, 100, 150, 30);
		label6.setBounds(20, 120, 150, 30);
		
		//	Mengaktifkan event agar ketika frame di close maka, program akan berhenti
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//	[Optional] Untuk menonaktifkan button maximize di Frame
		frame.setResizable(false);
		
		//	Aktifkan Visible Frame
		frame.setVisible(true);





				
				
			
			}
		}
	
		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource() == m){
				System.exit(0);
			}
		}
	}
