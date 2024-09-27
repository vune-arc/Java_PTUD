package gd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import java.sql.SQLException;
import java.time.LocalTime;

import javax.swing.Box;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;


public class Login_GUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblUser;
	private JTextField txtUser;
	private JButton btnLogin;
	private JButton btnExit;
	private JLabel lblPass;
	private JPasswordField txtPass;
	private Color c2;
	private int show = 0;

	private JButton btnShowPass;


	public Login_GUI() {
		// Khởi tạo kết nối
	
		// Khởi tạo
		this.setTitle("Đăng nhập");

		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);

		Font fp = new Font("Times new roman", Font.BOLD, 15);
		c2 = new Color(134, 209, 241);
		JPanel pC = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				// Tạo màu gradient từ đỏ đến xanh dương
				GradientPaint gradient = new GradientPaint(0, 0, Color.white, 0, getHeight(), c2);
				g2d.setPaint(gradient);

				// Vẽ hình chữ nhật với màu gradient
				g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
			}
		};
//		add(pC,BorderLayout.CENTER);

		// Control
		JPanel pLogin = new JPanel();

		JPanel pLogin1 = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				// Tạo hình chữ nhật với các góc được bo tròn
				RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 60, 60);

				// Tạo một hình chữ nhật lớn hơn để cắt phần thừa ra ngoài
				RoundRectangle2D largeRectangle = new RoundRectangle2D.Float(-20, -20, getWidth() + 40,
						getHeight() + 40, 40, 40);

				// Tạo một Area từ hình chữ nhật lớn
				Area area = new Area(largeRectangle);

				// Loại bỏ phần bo tròn bên trong hình chữ nhật
				area.subtract(new Area(roundedRectangle));

				// Vẽ phần thừa ra ngoài với màu đỏ
				GradientPaint gradient = new GradientPaint(0, 0, new Color(217, 243, 255, 150), 0, getHeight(),
						new Color(134, 209, 241, 180));
				g2d.setPaint(gradient);
				g2d.fill(area);
				;

				g2d.setColor(c2);
				g2d.fill(roundedRectangle);
			}

		};
		pLogin1.setBorder(new EmptyBorder(10, 0, 10, 10));

		pLogin.setLayout(new BorderLayout());
		JPanel pNorth = new JPanel();
		JLabel lblql = new JLabel("<html><body style='color:white;'>ĐĂNG NHẬP</body></html>");
		lblql.setFont(new Font("Times new roman", Font.BOLD, 20));
		JLabel lblql1 = new JLabel("");
		pNorth.add(lblql);
		pNorth.add(lblql1);
		pNorth.setBackground(c2);
		
		pLogin.add(pNorth, BorderLayout.NORTH);
		//
		lblUser = new JLabel("USERNAME");
		lblUser.setFont(fp);
		lblUser.setForeground(Color.white);
		txtUser = new JTextField("",12);// 123
		txtUser.setFont(new Font("Times new Roman", Font.BOLD, 12));
		lblPass = new JLabel("PASSWORD");
		lblPass.setForeground(Color.white);
		ImageIcon icShowpass = new ImageIcon("icon//eye-crossed.png");
		btnShowPass = new JButton(icShowpass);
		lblPass.setFont(fp);
		txtPass = new JPasswordField("admin",12);// 123
		txtPass.setFont(new Font("", Font.BOLD, 12));
		;
		btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.white);
		btnLogin.setBackground(Color.gray);
		btnLogin.setFont(fp);
		btnExit = new JButton("Exit");
		btnExit.setForeground(Color.white);
		btnExit.setBackground(Color.gray);
		btnExit.setFont(fp);
		JPanel p = new JPanel();
		p.setBackground(c2);
		Box b, b1, b2;
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b1.add(lblUser);
		b1.add(Box.createRigidArea(new Dimension(20, 25)));
		b1.add(txtUser);
		b2.add(lblPass);
		b2.add(Box.createRigidArea(new Dimension(20, 25)));
		b2.add(txtPass);
//		b2.add(btnShowPass);

		b.add(b1);
		b.add(Box.createVerticalStrut(20));
		b.add(b2);
		p.add(b);
		b.add(Box.createVerticalStrut(10));
		pLogin.add(p, BorderLayout.CENTER);
		JPanel p3 = new JPanel();
		p3.setBackground(c2);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 2, 10, 10));
		p2.setBackground(c2);
		p2.add(btnLogin);
		p2.add(btnExit);
		p3.add(p2);
		
		pLogin.add(p3, BorderLayout.SOUTH);
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		btnShowPass.addActionListener(this);
		pLogin1.add(pLogin);
		pC.setLayout(null);
		pLogin1.setBounds(350, 80, 300, 200);
//
		JLabel icon=new JLabel();
		ImageIcon menuIcon = resizeIcon(
				new ImageIcon("icon//nen.png"),
				350, 300);
		JLabel icon1=new JLabel();
		JLabel icon2=new JLabel();
		ImageIcon menuIcon1 = resizeIcon(
				new ImageIcon("icon//nen1.png"),
				700, 350);
		ImageIcon menuIcon2 = resizeIcon(
				new ImageIcon("icon//nen.png"),
				700, 350);
		icon.setIcon(menuIcon);
		icon1.setIcon(menuIcon1);
		icon2.setIcon(menuIcon2);
		icon.setBounds(400, 70, 300, 400);
		icon2.setBounds(100, -20, 300, 400);
		icon1.setBounds(160, 0, 700, 500);
		pC.add(pLogin1);
		pC.add(icon1);
		pC.add(icon);
		pC.add(icon2);
		
		add(pC, BorderLayout.CENTER);
		txtUser.requestFocus();

		txtUser.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		txtPass.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});

	}
	public static void main(String args[]) {
		FlatRobotoFont.install();
		FlatLaf.registerCustomDefaultsSource("gui.theme");
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 16));
			FlatMacLightLaf.setup();	
		SwingUtilities.invokeLater(() -> new Login_GUI().setVisible(true));
	}


//user:123
//password:123
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		String tenDN = txtUser.getText();
		char[] chpass = txtPass.getPassword();
		String pass = new String(chpass);
		if (o.equals(btnExit)) {
			System.exit(0);
		}

		else if (o.equals(btnLogin)) {
			login();
		}
	}

	private void login() {

	
			dispose();
			openAnotherInterface();
		
	}

	private static void openAnotherInterface() {
		// Tạo một đối tượng của giao diện khác và hiển thị nó
		Main_GUI anotherInterface = new Main_GUI();
		anotherInterface.setVisible(true);
	}

	private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImg);
	}

	// Phương thức truyền thông tin


}
