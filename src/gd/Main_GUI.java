package gd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Rectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;



public class Main_GUI extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;

	private JMenuItem exitItem;
	private JMenu fileMenu1;

	private JPanel pCen;
	private JMenuItem openItem;

	private JMenuItem quanly;

	private JMenuItem banhang;
	private int seconds = 0;
	private Thread timerThread;
	private final int SAVE_INTERVAL = 1;
	private Font fp;
	private JMenu fileMenu2;
	private Color c2;


	private JMenuItem doiMK;

	private Go anotherInterface5;

	private Font fp1;

	private Color c1;

	public Main_GUI() {
	
		setTitle("DVTH");
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLayout(new BorderLayout());
		fp = new Font("Times new Roman", Font.BOLD, 16);
		fp1 = new Font("Times new Roman", Font.PLAIN, 20);
		c1 = new Color(36, 104, 155);
		c2 = Color.gray;
		Color c3 = new Color(135, 206, 250);
		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.Y_AXIS));
		Box bMenu = Box.createHorizontalBox();
		JPanel pMenu = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				// Tạo màu gradient từ đỏ đến xanh dương
				GradientPaint gradient = new GradientPaint(0, 0, c1, 0, getHeight(), Color.white);
				g2d.setPaint(gradient);

				// Vẽ hình chữ nhật với màu gradient
				g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
			}
		};
		pMenu.setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("Trang chủ");
		fileMenu.setFont(fp);
		fileMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		fileMenu1 = new JMenu("  Quản lý");
		
		fileMenu1.setFont(fp);
		fileMenu1.setAlignmentX(Component.LEFT_ALIGNMENT);
		fileMenu2 = new JMenu(" Bán vé");
		fileMenu2.setBackground(c3);
		fileMenu2.setOpaque(true);
		fileMenu2.setFont(fp);
		fileMenu2.setAlignmentX(Component.LEFT_ALIGNMENT);
		JMenu fileMenu3 = new JMenu("Thống kê"); //Phần quản lý tài khoản
	
		fileMenu3.setFont(fp);
		fileMenu3.setAlignmentX(Component.LEFT_ALIGNMENT);
		JMenu fileMenu4 = new JMenu(" Tra cứu");
		fileMenu4.setFont(fp);
		fileMenu4.setAlignmentX(Component.LEFT_ALIGNMENT);
		JMenu fileMenu5 = new JMenu("        Hỗ trợ");
		fileMenu5.setFont(fp);
		fileMenu5.setAlignmentX(Component.LEFT_ALIGNMENT);
		JMenu fileMenu6 = new JMenu("      Giới thiệu");
		fileMenu6.setFont(fp);
		fileMenu6.setAlignmentX(Component.LEFT_ALIGNMENT);

		fileMenu.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu.setPreferredSize(new Dimension(120, 40));
		fileMenu1.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu1.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu1.setPreferredSize(new Dimension(120, 30));
		fileMenu2.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu2.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu2.setPreferredSize(new Dimension(120, 30));
		fileMenu3.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu3.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu3.setPreferredSize(new Dimension(125, 30));
		fileMenu4.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu4.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu4.setPreferredSize(new Dimension(120, 30));
		fileMenu5.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu5.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu5.setPreferredSize(new Dimension(120, 30));
		fileMenu6.setBorder(BorderFactory.createLoweredBevelBorder());
		fileMenu6.setBorder(BorderFactory.createLineBorder(c2));
		fileMenu6.setPreferredSize(new Dimension(120, 30));
		openItem = new JMenuItem("Trang chính");
		doiMK = new JMenuItem("Đổi mật khẩu");
		exitItem = new JMenuItem("Đăng xuất");
		ImageIcon menuIcon = resizeIcon(
				new ImageIcon("icon//whiteboard_presentation_seminar_school_teacher_lecture_icon-icons.com_55994.png"),
				20, 20);
		fileMenu.add(openItem);
		fileMenu3.add(doiMK);
		fileMenu3.add(exitItem);
//		fileMenu4.add(exitItem);
		quanly = new JMenuItem("Quản lý");
		fileMenu.setIcon(menuIcon);
		fileMenu1.setIcon(menuIcon);
		fileMenu1.add(quanly);
		fileMenu2.setIcon(menuIcon);
		banhang = new JMenuItem("Bán vé");
		fileMenu2.add(banhang);
		fileMenu3.setIcon(menuIcon);
		fileMenu4.setIcon(menuIcon);
		menuBar.add(fileMenu);
		menuBar.add(fileMenu4);
		menuBar.add(fileMenu2);
		menuBar.add(fileMenu1);
		menuBar.add(fileMenu3);
		
		menuBar.add(fileMenu5);
		menuBar.add(fileMenu6);
		pMenu.add(menuBar, BorderLayout.WEST);
		//
		JPanel pProfile = new JPanel(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				// Tạo màu gradient từ đỏ đến xanh dương
				GradientPaint gradient = new GradientPaint(0, 0, c1, 0, getHeight(), Color.white);
				g2d.setPaint(gradient);

				// Vẽ hình chữ nhật với màu gradient
				g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
			}
		};
		JButton btnProfile = new JButton("", new FlatSVGIcon("icon/0.svg", 0.35f));
		pProfile.add(btnProfile);
		JLabel name=new JLabel("Nguyễn Quốc Vũ"+"    ");
		name.setFont(fp1);
		pProfile.add(name);
		pMenu.add(pProfile,BorderLayout.EAST);
		pMenu.setBorder(BorderFactory.createLineBorder(c2));
		b1.add(pMenu);
		
		b1.add(Box.createVerticalStrut(10));
		bMenu.add(b1);
		//
		
		add(bMenu, BorderLayout.NORTH);
		// south chính
		JPanel pS = new JPanel();
		pS.setPreferredSize(new Dimension(0, 5));
		add(pS, BorderLayout.SOUTH);
		// west chính
		JPanel pW1 = new JPanel();
		pS.setPreferredSize(new Dimension(0, 10));
		add(pW1, BorderLayout.WEST);
		// east chính
		JPanel pE = new JPanel();
		pS.setPreferredSize(new Dimension(0, 20));
		add(pE, BorderLayout.EAST);

//		fileMenu1.addMenuListener(this);
		quanly.addActionListener(this);
		pCen = new JPanel();

		add(pCen, BorderLayout.CENTER);

		openItem.addActionListener(this);

		exitItem.addActionListener(this);
		quanly.addActionListener(this);
		banhang.addActionListener(this);
		doiMK.addActionListener(this);
		addWindowListener(this);
//		//time
		timerThread = new Thread(() -> {
			try {
				while (true) {
					Thread.sleep(1000);
					seconds++;

					// Lưu thời gian vào tập tin sau mỗi SAVE_INTERVAL giây
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		timerThread.start();
		;
		openTC_GUI();
	}

	public static void main(String args[]) {
		FlatRobotoFont.install();
		FlatLaf.registerCustomDefaultsSource("gui.theme");
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 16));
		int now = LocalTime.now().getHour();
		FlatMacLightLaf.setup();
//		FlatMacDarkLaf.setup();
//		if (now >= 6 && now <= 18) {
//			FlatMacLightLaf.setup();
//		} else {
//			FlatMacDarkLaf.setup();
//		}
		SwingUtilities.invokeLater(() -> new Main_GUI().setVisible(true));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(exitItem)) {
			
			dispose();

			Login_GUI anotherInterface1 = new Login_GUI();
//			anotherInterface1.setDataListener(this);
			anotherInterface1.setVisible(true);
		}
		if (o.equals(openItem)) {
			pCen.removeAll();
			openTC_GUI();
			

			revalidate();
			repaint();

		}
		if (o.equals(quanly)) {
			pCen.removeAll();
			openBanHang_GUI();
			validate();
			repaint();
		}
		if (o.equals(banhang)) {
			pCen.removeAll();
			openGUI_BanVe();;
			validate();
			repaint();
		}
		//Đổi mật khẩu
		if(o.equals(doiMK)) {
			
		}
	}

	

	

	private void openBanHang_GUI() {
		pCen.setLayout(new BorderLayout());
		anotherInterface5 = new Go();
		anotherInterface5.setPreferredSize(pCen.getPreferredSize());
		pCen.add(anotherInterface5);;
		anotherInterface5.setVisible(true);
	}
	private void openTC_GUI() {
		pCen.setLayout(new BorderLayout());
		GUI_TrangChinh anotherInterface = new GUI_TrangChinh();
		anotherInterface.setPreferredSize(pCen.getPreferredSize());
		pCen.add(anotherInterface);
		anotherInterface.setVisible(true);
	}
	private void openGUI_BanVe() {
		pCen.setLayout(new BorderLayout());
		gd.GUI_BanVe gui_BanVe = new GUI_BanVe();
		gui_BanVe.setPreferredSize(pCen.getPreferredSize());
		pCen.add(gui_BanVe);
		gui_BanVe.setVisible(true);
	}
	

	private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImg);
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", "Xác nhận thoát",
				JOptionPane.YES_NO_OPTION);

		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
