package gd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.extras.FlatSVGIcon;


public class KhachHang_GUI extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JRadioButton radNam;
	private JButton btntim;
	private JTextField txtnhap;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private DefaultTableModel modelKhachHang;
	private JTable tblKhachHang;
	private JScrollPane sctable;
	private JButton btnHien;
	private Color c1;
	private Color c3;
	private Color c4;

	private String maKHUpdate;
	private JPanel pS;
	private Go pgo;


	public KhachHang_GUI() {
		// Khởi tạo kết nối

		setVisible(true);
		setLayout(new BorderLayout());
		c1 = new Color(252, 255, 171);// mau tieu de
		c3 = new Color(0, 110, 220);// khug
//		c2= new Color(155, 195, 238);
		c4 = Color.magenta;

		// đầu
		JPanel pnorth = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				GradientPaint gradient = new GradientPaint(0, 0, c3, 0, getHeight(), Color.cyan);
				g2d.setPaint(gradient);
				g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
			}
		};
		JLabel lbltieude = new JLabel("THÔNG TIN KHÁCH HÀNG");
		Font fp = new Font("Times new Roman", Font.BOLD, 25);
		Font fp1 = new Font("Times new Roman", Font.BOLD, 20);
		Font fp2 = new Font("Times new Roman", Font.PLAIN, 17);
		lbltieude.setFont(fp);
		lbltieude.setForeground(c1);
		pnorth.add(lbltieude);

		Box b = Box.createVerticalBox();
//		pnorth.setBorder(BorderFactory.createEtchedBorder());
//		add(pnorth, BorderLayout.NORTH);

		modelKhachHang = new DefaultTableModel();
		modelKhachHang.addColumn("MÃ KHÁCH HÀNG");
		modelKhachHang.addColumn("TÊN KHÁCH HÀNG");
		modelKhachHang.addColumn("GIỚI TÍNH");
		modelKhachHang.addColumn("NGÀY SINH");
		modelKhachHang.addColumn("ĐỊA CHỈ");
		modelKhachHang.addColumn("SỐ ĐIỆN THOẠI");

		tblKhachHang = new JTable(modelKhachHang);
		tblKhachHang.setFont(fp2);
		tblKhachHang.setBorder(BorderFactory.createEmptyBorder());
		tblKhachHang.setShowGrid(false); 

		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(Color.white);
		headerRenderer.setForeground(Color.black);
		headerRenderer.setFont(fp1);
		headerRenderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// Màu chữ mong muốn
		tblKhachHang.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
		tblKhachHang.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
		tblKhachHang.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
		tblKhachHang.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(headerRenderer);
		tblKhachHang.getTableHeader().getColumnModel().getColumn(4).setHeaderRenderer(headerRenderer);
		tblKhachHang.getTableHeader().getColumnModel().getColumn(5).setHeaderRenderer(headerRenderer);

		int[] columnWidths = { 150, 150, 60, 100, 200, 100 }; // Độ rộng mong muốn cho mỗi cột
		for (int i = 0; i < columnWidths.length; i++) {
			tblKhachHang.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}
		sctable = new JScrollPane(tblKhachHang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sctable.setBorder(BorderFactory.createEmptyBorder());  // Xóa đường viền của JScrollPane
		sctable.setViewportBorder(BorderFactory.createEmptyBorder());
		sctable.setPreferredSize(new Dimension(0, 350));
		b.add(sctable);
		add(b, BorderLayout.CENTER);
		Object[] row1 = {"KH001", "Nguyễn Văn A", "Nam", "01/01/1990", "Hà Nội", "0123456789"};
		Object[] row2 = {"KH002", "Trần Thị B", "Nữ", "15/02/1992", "TP HCM", "0987654321"};

		// Thêm các hàng vào model của JTable
		modelKhachHang.addRow(row1);
		modelKhachHang.addRow(row2);
		// Thêm hàng dữ liệu vào bảng

		// Cập nhật lại model của bảng
		tblKhachHang.setModel(modelKhachHang);
		// cuoi
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		Box b7 = Box.createHorizontalBox();
		Box b8 = Box.createVerticalBox();
		JLabel lblnhap = new JLabel("Nhập mã số cần tìm:   ");
		lblnhap.setFont(fp1);
		txtnhap = new JTextField();
		btntim = new JButton("Tìm kiếm",new FlatSVGIcon("icon/search.svg",0.35f));
		btntim.setFont(fp1);

		b5.add(lblnhap);
		b5.add(txtnhap);
		b5.add(btntim);
//		b5.setBorder(BorderFactory.createEtchedBorder());
		b7.add(b5);

		btnThem = new JButton("Thêm",new FlatSVGIcon("icon/add.svg",0.35f));
		btnThem.setFont(fp1);
		btnXoa = new JButton("Xóa",new FlatSVGIcon("icon/delete.svg",0.35f));
		btnXoa.setFont(fp1);
		btnSua = new JButton("Sửa",new FlatSVGIcon("icon/edit.svg",0.35f));
		btnSua.setFont(fp1);

		b6.add(Box.createRigidArea(new Dimension(20, 10)));
		b6.add(btnThem);
		b6.add(btnSua);
		b6.add(btnXoa);
		b6.add(Box.createRigidArea(new Dimension(20, 10)));
//		b6.setBorder(BorderFactory.createEtchedBorder());
		b7.add(Box.createRigidArea(new Dimension(20, 10)));
		b7.add(b6);
		b8.add(b7);
		b8.add(Box.createRigidArea(new Dimension(20, 10)));
		b8.add(pnorth);
		add(b8, BorderLayout.NORTH);
		pS=new JPanel();
		add(pS,BorderLayout.SOUTH);
		
		// sự kiện
		btnThem.addActionListener(this);
		btntim.addActionListener(this);
//		btnXoa.addActionListener(this);
//		btnSua.addActionListener(this);
//		tblKhachHang.addMouseListener(this);
		//
		

		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		Object o = e.getSource();
//
//		if (o.equals(btnThem)) {
////			
//			openAnotherInterface();
////			HienDuLieu();
//		} else if (o.equals(btnSua)) {
//			int row=tblKhachHang.getSelectedRow();
//			if(row<0)
//			{
//				JOptionPane.showMessageDialog(this, "Chọn khách hàng cần cập nhật");
//			}
//			else {
//				maKHUpdate=modelKhachHang.getValueAt(row, 0).toString();
//				openUpdateKHGUI();
//			}
//			
//		} else if (o.equals(btnXoa)) {
//			int row=tblKhachHang.getSelectedRow();
//			if(row<0)
//			{
//				JOptionPane.showMessageDialog(this, "Chọn khách hàng cần xóa");
//			}
//			else {
//				String maKHdelete = modelKhachHang.getValueAt(row, 0).toString();
//				if (JOptionPane.showConfirmDialog(this, "Xóa dòng này chứ", "Chú ý",
//						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//					if(khDAO.deleteKH(maKHdelete))
//					{
//						modelKhachHang.setRowCount(0);
//						JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công");
////						HienDuLieu();
//					}
//			}
//				
//			}
//		} else if (o.equals(btntim)) {
//			if(txtnhap.getText().length() <= 0 ) {
//				HienDuLieu();
//			}else {
//				timTheomakh();
//			}
//		} 
//
//	}
	
//	private void timTheomakh() {
//		String ma = txtnhap.getText();
//		modelKhachHang.setRowCount(0);
//		KhachHang kh = khDAO.getKhahHangTheoMaKH(ma);
//		if( kh ==null) {
//			JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng !");
//		}else {
//			for (KhachHang k : khDAO.getDSKhachHang()) {
//				if(k.getMaKH().equalsIgnoreCase(kh.getMaKH())) {
//					modelKhachHang.addRow(new Object[] { k.getMaKH(), k.getTenKH(), k.isGiotinh() ? "Nam" : "Nữ",
//							k.getNgaySinh().toString(), k.getDiaChi(), k.getSoDT()});
//				}
//			}
//		}
//	}
//
//	private void HienDuLieu() {
//
//		XoaDuLieuBang();
//		for (KhachHang kh : khDAO.getDSKhachHang()) {
//			modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.isGiotinh() ? "Nam" : "Nữ",
//					kh.getNgaySinh().toString(), kh.getDiaChi(), kh.getSoDT() });
//		}
//		for (int i = 0; i< modelKhachHang.getRowCount(); i++) {
//			if(modelKhachHang.getValueAt(i, 0).toString().equals("MD0000")) {
//				modelKhachHang.removeRow(i);
//			}
//		}
//
//	}
//
//	private void timTheomanv() {
//		// TODO Auto-generated method stub
//		String txt = txtnhap.getText();
//		if (txt != null && txt.trim().length() > 0) {
//
//		} else {
//			HienDuLieu();
//
//		}
//	}


	private void XoaDuLieuBang() {
		DefaultTableModel tb = (DefaultTableModel) tblKhachHang.getModel();
		tb.getDataVector().removeAllElements();
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object o = e.getSource();
//	boolean flagThem = false;
	if (o.equals(btnThem)) {
//		if(!flagThem)
		{
			pS.removeAll();
			pS.setLayout(new BorderLayout());
			KhachHangPopup khpu=new KhachHangPopup();
			pS.add(khpu);
			pS.revalidate();
			pS.repaint();

		}
		
		
//		HienDuLieu();
	}else if (o.equals(btntim)) {
		pS.removeAll();
		validate();
	}
} 
}


//	private void openAnotherInterface() {
//		KhachHangPopup anotherInterface = new KhachHangPopup();
//		anotherInterface.setDataListener(this);
//		anotherInterface.setVisible(true);
//	}
//	private void openUpdateKHGUI() {
//		KhachHangUpdatePopup anotherInterface = new KhachHangUpdatePopup(maKHUpdate);
//		anotherInterface.setDataListener(this);
//		anotherInterface.setVisible(true);
//	}
//
//	@Override
//	public void onDataReceived(Object data) {

//		modelKhachHang.setRowCount(0);
//		for (KhachHang kh : (List<KhachHang>)data) {
//			modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.isGiotinh() ? "Nam" : "Nu",
//					kh.getNgaySinh().toString(), kh.getDiaChi(), kh.getSoDT() });
//		}
//		for (int i = 0; i< modelKhachHang.getRowCount(); i++) {
//			if(modelKhachHang.getValueAt(i, 0).toString().equals("MD0000")) {
//				modelKhachHang.removeRow(i);
//			}
//		}







