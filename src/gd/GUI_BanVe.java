package gd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.toedter.calendar.JDateChooser;

import gd.TrainSeatExample.SeatButtonListener;
import net.miginfocom.swing.MigLayout;

public class GUI_BanVe extends JPanel {
	private JScrollPane scroll;
	private Container pWEST;
	private JTextField txtDi;
	private JTextField txtDen;
	private JRadioButton radMotChieu;
	private static Font fp;
	private JRadioButton radKhuHoi;
	private JDateChooser dateChooserDi;
	private JDateChooser dateChooserVe;
	private JButton btnTimVe;
	private Font fp1;

	public GUI_BanVe()
	{
			fp=new Font("Times new Roman", Font.PLAIN, 17);
			fp1=new Font("Times new Roman", Font.BOLD, 20);
			setLayout(new BorderLayout());
	        // Tạo JScrollPane và JPanel
	        JScrollPane scroll = new JScrollPane();
	        JPanel pW = new JPanel();  // Panel chứa cả pWEST1, pWEST_2 và pWEST_3
	        pW.setLayout(new BoxLayout(pW, BoxLayout.Y_AXIS)); // Sử dụng BoxLayout cho pW


	        JPanel pWEST1 = new JPanel();
	        pWEST1.setBorder(BorderFactory.createCompoundBorder(
	                new LineBorder(Color.gray, 1), // Border màu đen, độ dày 2px
	                new EmptyBorder(10, 10, 10, 10) // Đệm 5 pixel ở tất cả các cạnh
	        ));
	        pWEST1.setLayout(new BorderLayout());

	        Box b=Box.createVerticalBox();
	        Box b1=Box.createHorizontalBox();
	        Box b2=Box.createHorizontalBox();
	        Box b3=Box.createHorizontalBox();
	        Box b4=Box.createHorizontalBox();
	        Box b5=Box.createHorizontalBox();
	        Box b6=Box.createHorizontalBox();
	        Box b7=Box.createHorizontalBox();
	        Box b8=Box.createHorizontalBox();
	        Box b9=Box.createHorizontalBox();
	        Box b10=Box.createHorizontalBox();
	        
	        
	        JLabel lblGadi= new JLabel("Ga đi"); 
	        lblGadi.setFont(fp);
	        b1.add(lblGadi);b1.add(Box.createHorizontalGlue());

	        txtDi = new JTextField(20);	
	        b2.add(txtDi);
	        JLabel lblGaden= new JLabel("Ga đến"); 
	        lblGaden.setFont(fp);
	        b3.add(lblGaden);b3.add(Box.createHorizontalGlue());
	        txtDen = new JTextField(20);
	        b4.add(txtDen);
	        ///
	        ButtonGroup grpChieu = new ButtonGroup();
			radMotChieu = new JRadioButton("Một chiều");
			radMotChieu.setFont(fp);
			grpChieu.add(radMotChieu);
			radMotChieu.setSelected(true);
			radKhuHoi = new JRadioButton("Khứ hồi");
			radKhuHoi.setFont(fp);
			grpChieu.add(radKhuHoi);
			b5.add(radMotChieu);b5.add(radKhuHoi);
			///
			JLabel lblngayDi = new JLabel("Ngày đi          ");
			lblngayDi.setFont(fp);
			b6.add(lblngayDi);b6.add(Box.createHorizontalGlue());
			dateChooserDi = new JDateChooser();
			dateChooserDi.setDateFormatString("yyyy-MM-dd");
			b7.add(dateChooserDi);
			////
			JLabel lblngayVe = new JLabel("Ngày về");
			lblngayVe.setFont(fp);lblngayVe.add(Box.createHorizontalGlue());
			b8.add(lblngayVe);b8.add(Box.createHorizontalGlue());
			dateChooserVe = new JDateChooser();
			dateChooserVe.setDateFormatString("yyyy-MM-dd");
			b9.add(dateChooserVe);
			////
			btnTimVe= new JButton("Tìm kiếm");
			btnTimVe.setFont(fp);
			b10.add(Box.createHorizontalGlue());
			b10.add(btnTimVe);b10.add(Box.createHorizontalGlue());
			////
	        b.add(b1);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b2);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b3);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b4);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b5);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b6);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b7);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b8);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b9);b.add(Box.createRigidArea(new Dimension(10,5)));
	        b.add(b10);b.add(Box.createRigidArea(new Dimension(10,5)));
	        pWEST1.add(b,BorderLayout.CENTER); 
	        
	        
///////////////dưới giỏ vé
	        // Tạo panel pWEST_2 cho các nút
	        JPanel pWEST_2 = new JPanel();
	        pWEST_2.setLayout(new BoxLayout(pWEST_2, BoxLayout.Y_AXIS));
	        pWEST_2.setBorder(BorderFactory.createCompoundBorder(
	                new LineBorder(Color.gray, 1), // Border màu đen, độ dày 2px
	                new EmptyBorder(10, 10, 10, 10) // Đệm 5 pixel ở tất cả các cạnh
	        ));
	        // Thêm các nút vào pWEST_2 để kích hoạt thanh cuộn
	        for (int i = 0; i < 40; i++) {
	            JButton button = new JButton("Nút " + i);
	            button.setPreferredSize(new Dimension(280, 30)); // Thiết lập kích thước cho nút
	            button.setFont(fp);
	            pWEST_2.add(button);
	        }

	        // Thêm pWEST_2 vào JScrollPane
	        scroll.setViewportView(pWEST_2);

	        // Tạo panel pWEST_3 cho thông tin bổ sung
	        JPanel pWEST_3 = new JPanel()
	        {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g;

					// Tạo màu gradient từ đỏ đến xanh dương
					GradientPaint gradient = new GradientPaint(0, 0, Color.gray, 0, getHeight(), Color.white);
					g2d.setPaint(gradient);

					// Vẽ hình chữ nhật với màu gradient
					g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
				}
			};
	        JLabel nhan1=new JLabel("Thông tin hành trình");
	        nhan1.setFont(fp1);nhan1.setForeground(Color.BLUE);
	        pWEST_3.add(nhan1);
//
	        JPanel pWEST_4 = new JPanel()
	        {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g;

					// Tạo màu gradient từ đỏ đến xanh dương
					GradientPaint gradient = new GradientPaint(0, 0, Color.white, 0, getHeight(), Color.gray);
					g2d.setPaint(gradient);

					// Vẽ hình chữ nhật với màu gradient
					g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
				}
			};
			JLabel nhan2=new JLabel("Giỏ vé");
			nhan2.setFont(fp1);nhan2.setForeground(Color.BLUE);
			pWEST_4.add(nhan2);
			///
	        pW.add(pWEST_3);
	       
	        pW.add(pWEST1);
	        pW.add(pWEST_4);
	        // pWEST1 nằm ở phía trên của pW
	        pW.add(scroll);  // JScrollPane chứa pWEST_2 nằm ở phía giữa
	         // pWEST_3 nằm ở dưới cùng của pW

	        // Cài đặt các thuộc tính tùy chọn cho JScrollPane
	        scroll.putClientProperty(FlatClientProperties.STYLE, "border:5,5,5,5; background:$Menu.background");
	        scroll.putClientProperty(FlatClientProperties.STYLE, "border:null");

	        JScrollBar vscroll = scroll.getVerticalScrollBar();
	        vscroll.setUnitIncrement(10);
	        vscroll.putClientProperty(FlatClientProperties.STYLE,
	            "width:$Menu.scroll.width; trackInsets:$Menu.scroll.trackInsets;" +
	            "thumbInsets:$Menu.scroll.thumbInsets; background:$Menu.ScrollBar.background;" +
	            "thumb:$Menu.ScrollBar.thumb");

	        // Thêm pW vào BorderLayout.WEST
	        add(pW, BorderLayout.WEST);
	        ////
	        JPanel pCenChinh=new JPanel();
	        JPanel pC=vungCenter(10);
	        JPanel pN=vungNorth(6);
	        pCenChinh.add(pN,BorderLayout.NORTH);
	        pCenChinh.add(pC,BorderLayout.CENTER);
	        add(pCenChinh,BorderLayout.CENTER);
	        
	}
	//////
	private JButton selectedButton = null;
	public JPanel vungCenter(int soToa)
	{
		JPanel pCen=new JPanel();
		JPanel pTong= new JPanel();
		pTong.setLayout(new BorderLayout());
		JPanel pCen_North = new JPanel();
	      StringBuilder chuoi = new StringBuilder(); 
	      int[] seatsPerCar = {48,48 ,48, 48, 48, 48, 48, 48,48,48};
	      int[][] selectedSeats;
	      selectedSeats = new int[soToa][];
	        for (int i = 0; i < soToa; i++) {
	            selectedSeats[i] = new int[seatsPerCar[i]]; // 0: chưa chọn, 1: đã chọn
	        }
	        // Vòng lặp để thêm "[]" vào StringBuilder
	        for (int i = 0; i < soToa; i++) {
	            chuoi.append("[]"); // Thêm "[]" vào StringBuilder
	        }

	        // Chuyển đổi StringBuilder thành String
	        String columns = chuoi.toString();

	        // Thiết lập MigLayout với các tham số
	        List<JLabel> carLabels = new ArrayList<>();
	        for (int i = 0; i < soToa; i++) {
	        	if(i<soToa-1)
	        	{
	        	     // Tạo JPanel để chứa cả JButton và JLabel
		            JPanel carPanel = new JPanel();
		            carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS)); // Sử dụng BoxLayout theo trục Y

		            // Tạo JButton
		            JButton carButton = new JButton("", new FlatSVGIcon("icon/train-body.svg", 0.1f));
		            carButton.setBorder(null);
		            carButton.setActionCommand("Toa " + (i + 1));
		            carButton.addActionListener(new CarButtonListener(seatsPerCar[i], i + 1, pCen, selectedSeats)); // Truyền số ghế và số toa

		            // Tạo JLabel với văn bản tương ứng
		            JLabel carLabel = new JLabel("       Toa " + (soToa-1-i ));
		            carLabel.setFont(fp);
		            carLabel.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa văn bản trong JLabel 
		            // Thêm JButton và JLabel vào JPanel
		            carPanel.add(carButton);
		            carPanel.add(carLabel);

		            // Thêm JPanel vào pCen_North
		            pCen_North.add(carPanel);
		            carLabels.add(carLabel);

		            // Thiết lập ActionListener cho JButton
		            carButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    // Đổi màu JLabel tương ứng
		                    changeLabelColor(carLabel, Color.RED); // Đổi màu JLabel sang đỏ
		                    
		                    // Nếu cần, có thể khôi phục màu cho các JLabel khác
		                    for (JLabel label : carLabels) {
		                        if (label != carLabel) {
		                            changeLabelColor(label, Color.BLACK); // Đặt màu mặc định cho các JLabel khác
		                        }
		                    }
		                }
		            });
	        	}
	        	else {
	        		 JPanel carPanel = new JPanel();
			         carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS)); // Sử dụng BoxLayout theo trục Y

			            // Tạo JButton
			         JLabel lblHinhToa = new JLabel(new FlatSVGIcon("icon/train-head2.svg", 0.1f));
			         JLabel carLabel = new JLabel("  Tàu 1");
			         carLabel.setForeground(Color.red);
			            carLabel.setFont(fp);
			            carLabel.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa văn bản trong JLabel

			            // Thêm JButton và JLabel vào JPanel
			            carPanel.add(lblHinhToa);
			            carPanel.add(carLabel);

			            // Thêm JPanel vào pCen_North
			            pCen_North.add(carPanel);
				}
	       
	        }
	       
		
		
		pTong.add(pCen_North,BorderLayout.NORTH);
		pTong.add(pCen,BorderLayout.CENTER);
		return pTong;
	}
	////
	   static class CarButtonListener implements ActionListener {
	        private int seats; // Số ghế trong toa
	        private int carNumber; // Số toa
	        private JPanel mainPanel; // Panel chính
	        private int[][] selectedSeats;
	        public CarButtonListener(int seats, int carNumber, JPanel mainPanel, int[][] selectedSeats) {
	            this.seats = seats;
	            this.carNumber = carNumber;
	            this.mainPanel = mainPanel; // Lưu lại panel chính
	            this.selectedSeats = selectedSeats; // Lưu trạng thái ghế đã chọn
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Hiện thị ghế cho toa được chọn
	            mainPanel.removeAll(); // Xóa panel ghế cũ nếu có
	            
	            JPanel pCen_Cen = new JPanel(); // Tạo mới panel cho ghế
//	            pCen_Cen.setPreferredSize(new Dimension(1200, 600));
	            pCen_Cen.setLayout(new MigLayout("fill, wrap, insets 0", "[][][][][][][][][][][][]", "[align top]"));
	            pCen_Cen.setBorder(BorderFactory.createCompoundBorder(
		                new LineBorder(Color.gray, 1), // Border màu đen, độ dày 2px
		                new EmptyBorder(10, 10, 10, 10))) ;
	            // Thêm các nút cho ghế vào panel
	            for (int j = 0; j < seats; j++) {
	                JButton seatButton = new JButton("" + (j + 1)); // Chỉ hiển thị số ghế
	                seatButton.setPreferredSize(new Dimension(20,20));
	                seatButton.setMinimumSize(new Dimension(70,40)); // Kích thước tối thiểu
	                seatButton.setMaximumSize(new Dimension(70,40)); // Kích thước tối đa
	                seatButton.setFont(fp);
	                seatButton.setActionCommand("Toa " + carNumber + ", Ghế " + (j + 1));

	                // Thay đổi màu sắc nút nếu ghế đã được chọn
	                if (selectedSeats[carNumber - 1][j] == 1) {
	                    seatButton.setBackground(Color.pink); // Ghế đã chọn
	                } else {
	                    seatButton.setBackground(null); // Ghế chưa chọn
	                }

	                seatButton.addActionListener(new SeatButtonListener(seatButton, carNumber, j, selectedSeats)); // Truyền nút ghế
	                pCen_Cen.add(seatButton);
	            }

	            mainPanel.add(pCen_Cen, BorderLayout.CENTER); // Thêm panel ghế mới vào panel chính
	            mainPanel.revalidate(); // Cập nhật lại giao diện
	            mainPanel.repaint(); // Vẽ lại giao diện
	        }
	    }

	    static class SeatButtonListener implements ActionListener {
	        private JButton seatButton;
	        private int carNumber; // Số toa
	        private int seatNumber; // Số ghế
	        private int[][] selectedSeats; // Danh sách lưu trữ ghế đã chọn

	        public SeatButtonListener(JButton seatButton, int carNumber, int seatNumber, int[][] selectedSeats) {
	            this.seatButton = seatButton;
	            this.carNumber = carNumber;
	            this.seatNumber = seatNumber;
	            this.selectedSeats = selectedSeats; // Lưu trạng thái ghế đã chọn
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Thay đổi trạng thái ghế
	            if (selectedSeats[carNumber - 1][seatNumber] == 0) {
	                selectedSeats[carNumber - 1][seatNumber] = 1; // Đánh dấu là đã chọn
	                seatButton.setBackground(Color.pink); // Thay đổi màu ghế đã chọn
	            } else {
	                selectedSeats[carNumber - 1][seatNumber] = 0; // Đánh dấu là chưa chọn
	                seatButton.setBackground(null); // Thay đổi màu ghế chưa chọn
	            }
	            
	        }
	    }
	//////
	public JPanel vungNorth(int soTau) {
	        JPanel pN = new JPanel();
	        pN.setLayout(new BoxLayout(pN, BoxLayout.X_AXIS)); // Tạo BoxLayout theo trục Y cho pN

	        for (int i = 0; i < soTau; i++) {
	            // Tạo JPanel để chứa cả JButton và JLabel
	            JPanel carPanel = new JPanel();
	            carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS)); // Sử dụng BoxLayout theo trục Y
	            //
	            JLabel carLabel1 = new JLabel("    Tàu " + (i+1));
	            carLabel1.setFont(fp);
	            carLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa văn bản trong JLabel

	            // Thêm JButton và JLabel vào JPanel
	            
	            carPanel.add(carLabel1);
	            // Tạo JButton
	            JButton carButton = new JButton("", new FlatSVGIcon("icon/trains-icon.svg", 0.08f));
	            carButton.setBorder(null);
	            carButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
//	            carPanel.add(carButton,CENTER_ALIGNMENT);
	            // Tạo JLabel với văn bản tương ứng
	            JLabel carLabel = new JLabel("   SG-HN" );
	            carLabel.setFont(fp);
	            carLabel.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa văn bản trong JLabel

	            
	            JLabel carLabe2 = new JLabel("  17h-20h" );
	            carLabe2.setFont(fp);
	            carLabe2.setHorizontalAlignment(SwingConstants.CENTER);
	            // Thêm JButton và JLabel vào JPanel
	            carPanel.add(carButton);
	            carPanel.add(carLabel);
	            carPanel.add(carLabe2);
	            // Thêm JPanel vào pN
	            pN.add(carPanel);
	            
	            // Thêm khoảng cách giữa các button
	            pN.add(Box.createRigidArea(new Dimension(100, 200))); // Khoảng cách theo trục Y (10px)
	        }
	        pN.add(Box.createHorizontalGlue());
	        
	        return pN;
	    }
	    //
	 // Hàm đổi màu SVG icon
	    public void changeLabelColor(JLabel label, Color color) {
	        if (label != null) {
	            label.setForeground(color); // Đổi màu chữ của JLabel
	            label.repaint(); // Vẽ lại JLabel để áp dụng màu mới
	        } else {
	            System.out.println("JLabel không hợp lệ!");
	        }
	    }


	}
