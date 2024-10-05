package gd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class GUI_TrangChinh extends JPanel implements FocusListener{
	private JTextField txtTim;
	private JButton btntim;
	private Font fp;

	public GUI_TrangChinh()
	{
		fp = new Font("Times new Roman", Font.PLAIN, 16);
		setLayout(new BorderLayout());
		JPanel pC = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Tạo màu gradient từ trắng đến xanh dương
                Color c2 = new Color(135, 206, 250); // Màu xanh dương nhạt (Light Sky Blue)
                GradientPaint gradient = new GradientPaint(0, 0, c2, 0, getHeight(), Color.WHITE);
                g2d.setPaint(gradient);

                // Vẽ hình chữ nhật với màu gradient
                g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
            }
        };

        pC.setLayout(null);
		 // Sử dụng null layout để tùy chỉnh vị trí thủ công

        JLabel icon = new JLabel();
        ImageIcon menuIcon = resizeIcon(
            new ImageIcon("icon//nen2.png"),
            350, 300
        );
        icon.setIcon(menuIcon);

        // Lấy kích thước màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Tính toán vị trí để icon nằm giữa
        int iconWidth = 350;
        int iconHeight = 300;
        int iconX = (screenWidth - iconWidth) / 2; // Tọa độ X của icon
        int iconY = (screenHeight - iconHeight) / 3; // Tọa độ Y của icon

        icon.setBounds(iconX, 0, iconWidth, iconHeight);
        pC.add(icon);
        //
        String[] options = {"Nhà ga", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        int comboBoxWidth = 150;
        int comboBoxHeight = 50;
        int comboBoxX = (screenWidth - (comboBoxWidth + 200 + 100 + 20)) / 2; // Căn giữa ComboBox, TextField và Button
        int comboBoxY = 0 + iconHeight + 20; // Đặt ComboBox cách icon 20 pixels

        comboBox.setBounds(comboBoxX-140, comboBoxY, comboBoxWidth, comboBoxHeight);
//        pC.add(comboBox);

        // Thêm JTextField txtTim
        JTextField txtTim = new JTextField(20);
        txtTim.setFont(fp);
        txtTim.setText("Nhập ga cần đến...");
       
        txtTim.setForeground(Color.GRAY);
        int txtTimWidth = 600;
        int txtTimHeight = 50;
        int txtTimX = comboBoxX + comboBoxWidth + 10; // Đặt TextField kế bên ComboBox, cách 10 pixels
        int txtTimY = comboBoxY;

        txtTim.setBounds(txtTimX-250, txtTimY, txtTimWidth, txtTimHeight);
        pC.add(txtTim);

        // Thêm nút tìm kiếm kế bên JTextField
        JButton btntim = new JButton("", new FlatSVGIcon("icon/search.svg", 0.35f));
        int btnTimWidth = 50;
        int btnTimHeight = 50;
        int btnTimX = txtTimX + txtTimWidth + 10; // Đặt nút tìm kiếm kế bên TextField, cách 10 pixels
        int btnTimY = txtTimY;

        btntim.setBounds(btnTimX-250, btnTimY, btnTimWidth, btnTimHeight);
        pC.add(btntim);
        add(pC,BorderLayout.CENTER);
        txtTim.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTim.getText().equals("Nhập ga cần đến...")) {
                    txtTim.setText("");
                    txtTim.setForeground(Color.BLACK); // Trả lại màu chữ bình thường
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTim.getText().isEmpty()) {
                    txtTim.setText("Nhập ga cần đến...");
                    txtTim.setForeground(Color.GRAY); // Đặt lại màu chữ ẩn
                }
            }
        });
	}
	
	private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImg);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
