package gd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.toedter.calendar.JDateChooser;



public class KhachHangPopup extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnCapNhat;
	private JButton btnHuy;
	private JTextField txtTenTK;
	private JTextField txtTen;
	private JTextField chucvu;
	private JTextField txtDiaChi;


	private JTextField txtgioitinh;
	private JDateChooser dateChooser;
	private JTextField txtMaKH;


	private ButtonGroup grpPhai;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private Font fp;
	private Font fp1;

	public KhachHangPopup() {

		setLayout(new BorderLayout());

		// trên
		JPanel pNorth = new JPanel();
		fp=new Font("Times new Roman", Font.PLAIN, 17);
		fp1=new Font("Times new Roman", Font.BOLD, 17);
		JLabel lblTieuDe = new JLabel("Thêm khách hàng");

		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
//		pNorth.add(lblTieuDe);
//		add(pNorth, BorderLayout.NORTH);
		// thân
		Box b = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b7 = Box.createVerticalBox();
		Box b8 = Box.createVerticalBox();
		Box b9 = Box.createVerticalBox();
		JLabel lblMaKH = new JLabel("Mã khách hàng:  ");
		lblMaKH.setFont(fp);
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setFont(fp);
		b1.add(lblMaKH);
		b1.add(Box.createRigidArea(new Dimension(12, 0)));
		b1.add(txtMaKH);

		JLabel lblTen = new JLabel("Tên khách hàng:");
		lblTen.setFont(fp);
		txtTen = new JTextField();
		txtTen.setFont(fp);
		b2.add(lblTen);
		b2.add(Box.createRigidArea(new Dimension(20, 0)));
		b2.add(txtTen);

		JLabel lblgioiTinh = new JLabel("Giới tính:            ");
		lblgioiTinh.setFont(fp);
		grpPhai = new ButtonGroup();
		radNam = new JRadioButton("Nam");
		radNam.setFont(fp);
		grpPhai.add(radNam);
		radNam.setSelected(true);
		radNu = new JRadioButton("Nữ");
		radNu.setFont(fp);
		grpPhai.add(radNu);
		Box bgt = Box.createHorizontalBox();
		bgt.add(lblgioiTinh);
		bgt.add(Box.createRigidArea(new Dimension(22, 0)));
		Box bgt1 = Box.createHorizontalBox();
		JPanel pgt= new JPanel();
//		bgt.add(Box.createHorizontalGlue());
		bgt.add(radNam);
		bgt.add(radNu);
		bgt.add(Box.createHorizontalGlue());
//		bgt.add(bgt1);
		
//		bgt.add(Box.createRigidArea(new Dimension(800, 0)));
		JLabel lblngaySinh = new JLabel("Ngày sinh:           ");
		lblngaySinh.setFont(fp);
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		b3.add(lblngaySinh);
		b3.add(Box.createRigidArea(new Dimension(12, 0)));
//		b3.add(txtMatKhau);
		b3.add(dateChooser);
		
		Box bPhai = Box.createHorizontalBox();
		JLabel lblDiaChi = new JLabel("Địa chỉ:                  ");
		lblDiaChi.setFont(fp);
		lblDiaChi.setAlignmentX(Component.LEFT_ALIGNMENT);
		bPhai.add(lblDiaChi);
		txtDiaChi = new JTextField();
		bPhai.add(txtDiaChi);
		b4.add(bPhai);

		JLabel lblSDT = new JLabel("Số điện thoại:         ");
		lblSDT.setFont(fp);
		chucvu = new JTextField();
		b5.add(lblSDT);
		b5.add(chucvu);

		
		b7.add(b1);
		b7.add(Box.createRigidArea(new Dimension(50,10)));
		b7.add(b3);b7.add(Box.createRigidArea(new Dimension(50,10)));
		b7.add(b4);
		
		b8.add(b2);b8.add(Box.createRigidArea(new Dimension(50,10)));
		b8.add(bgt,LEFT_ALIGNMENT);
		
		b8.add(Box.createRigidArea(new Dimension(50,10)));
		b8.add(b5);
		

		
		
		 TitledBorder titledBorder = BorderFactory.createTitledBorder("Thêm khách hàng");
		 titledBorder.setTitleFont(fp);
	        titledBorder.setTitleJustification(TitledBorder.LEFT); // Căn giữa tiêu đề (LEFT, RIGHT, hoặc CENTER)
	        titledBorder.setTitlePosition(TitledBorder.TOP);
		setBorder(titledBorder);
		b.add(Box.createRigidArea(new Dimension(0, 20)));
		b.add(b7);b.add(Box.createRigidArea(new Dimension(30,50)));
		b.add(b8);
		b.add(Box.createRigidArea(new Dimension(0, 20)));
		add(b, BorderLayout.CENTER);

		Box bS = Box.createHorizontalBox();
		btnCapNhat = new JButton("Thêm",new FlatSVGIcon("icon/add.svg",0.35f));
		btnCapNhat.setFont(fp1);
		btnHuy = new JButton("Hủy",new FlatSVGIcon("icon/delete.svg",0.35f));
		btnHuy.setFont(fp1);
		 bS.add(Box.createHorizontalGlue());
	        bS.add(btnCapNhat);
	        bS.add(Box.createRigidArea(new Dimension(20, 50))); // Tạo khoảng cách giữa hai nút
	        bS.add(btnHuy);
	        bS.add(Box.createHorizontalGlue());
		add(bS, BorderLayout.SOUTH);

		//
		JPanel pW1 = new JPanel();
		pW1.setPreferredSize(new Dimension(50, 50));
		add(pW1, BorderLayout.WEST);
		// east chính
		JPanel pE = new JPanel();
		pE.setPreferredSize(new Dimension(50, 50));
		add(pE, BorderLayout.EAST);


	}


//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if (o.equals(btnCapNhat)) {
//
//			if (ktrNhap()) {
//				String maKH = txtMaKH.getText().trim();
//				String tenKH = txtTen.getText().trim();
//				boolean gioiTinh = radNam.isSelected() ? true : false;
//				SimpleDateFormat formatNS = new SimpleDateFormat("yyyy-MM-dd");
//				String ngay = formatNS.format(dateChooser.getDate());
//				LocalDate ngaySinh = LocalDate.parse(ngay);
//				String diaChi = txtDiaChi.getText();
//				String sdt = chucvu.getText().trim();
//
//				KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, diaChi, sdt);
//
//				khDAO.themKhachHang(kh);
//				Object dataToSend = (Object) khDAO.getDSKhachHang(); // Lấy dữ liệu cần gửi đi
//				if (dataListener != null) {
//					dataListener.onDataReceived(dataToSend); // Gửi dữ liệu tới JFrame cha
//				}
//			}
//		}
//
//		if (o.equals(btnHuy)) {
//
//			dispose();
////			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		}
//
//	}

	private boolean ktrNhap() {
		String tenKH = txtTen.getText().trim();
		SimpleDateFormat formatNS = new SimpleDateFormat("yyyy-MM-dd");
//		String ngay = formatNS.format(dateChooser.getDate());
		String diaChi = txtDiaChi.getText();
		String sdt = chucvu.getText().trim();
		
		//Kiểm tra rỗng
		if(tenKH.equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để trống tên khách hàng");
			txtTen.requestFocus();
			return false;
		}
		if(dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Không được để trống ngày sinh khách hàng");
			dateChooser.requestFocus();
			return false;
		}
		if(diaChi.equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để trống địa chỉ khách hàng");
			txtDiaChi.requestFocus();
			return false;
		}
		if(sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để trống số điện thoại khách hàng");
			chucvu.requestFocus();
			return false;
		}
		
		//Kiểm tra dữ liệu phù hợp
		if(!tenKH.matches("([A-Z][a-z]*\s)*([A-Z][a-z]*)")) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng phải viết hoa chữ cái đầu");
			txtTen.requestFocus();
			return false;
		}
		
		if(!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 chữ số");
			chucvu.requestFocus();
			return false;
		}
		
		return true;
	}


}
