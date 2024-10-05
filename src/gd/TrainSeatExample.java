package gd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import net.miginfocom.swing.MigLayout;

public class TrainSeatExample {
    private static ArrayList<String> selectedSeats = new ArrayList<>(); // Danh sách ghế đã chọn

    public static void main(String[] args) {
        // Khởi tạo JFrame
        JFrame frame = new JFrame("Train Seats Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Tạo panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("wrap 1", "[]", "[]"));

        // Số toa tàu
        int numberOfCars = 8;
        // Số ghế cho từng toa
        int[] seatsPerCar = {5, 3, 4, 6, 2, 7, 5, 8}; // Mỗi toa có số ghế khác nhau

        // Tạo nút cho từng toa tàu
        for (int i = 0; i < numberOfCars; i++) {
            JButton carButton = new JButton("Toa " + (i + 1));
            carButton.setActionCommand("Toa " + (i + 1));
            carButton.addActionListener(new CarButtonListener(seatsPerCar[i], i + 1)); // Truyền số ghế và số toa
            mainPanel.add(carButton);
        }

        // Thêm panel chính vào JFrame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Lớp lắng nghe sự kiện nhấp vào toa tàu
    static class CarButtonListener implements ActionListener {
        private int seats; // Số ghế trong toa
        private int carNumber; // Số toa

        public CarButtonListener(int seats, int carNumber) {
            this.seats = seats;
            this.carNumber = carNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Hiện thị ghế cho toa được chọn
            JPanel seatPanel = new JPanel();
            seatPanel.setLayout(new MigLayout("wrap 4", "[][][][]", "[][]"));

            // Thêm các nút cho ghế vào panel
            for (int j = 1; j <= seats; j++) {
                JButton seatButton = new JButton("Ghế " + j);
                seatButton.setActionCommand("Toa " + carNumber + ", Ghế " + j);
                seatButton.addActionListener(new SeatButtonListener(seatButton)); // Truyền nút ghế
                seatPanel.add(seatButton);
            }

            // Hiện hộp thoại với ghế của toa đã chọn
            JOptionPane.showMessageDialog(null, seatPanel, "Ghế trong Toa " + carNumber, JOptionPane.PLAIN_MESSAGE);
        }
    }

    // Lớp lắng nghe sự kiện ghế
    static class SeatButtonListener implements ActionListener {
        private JButton seatButton; // Nút ghế

        public SeatButtonListener(JButton seatButton) {
            this.seatButton = seatButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            // Kiểm tra xem ghế đã được chọn chưa
            if (selectedSeats.contains(command)) {
                selectedSeats.remove(command); // Xóa ghế đã chọn
                seatButton.setBackground(null); // Đặt lại màu nền
            } else {
                selectedSeats.add(command); // Thêm ghế vào danh sách
                seatButton.setBackground(java.awt.Color.YELLOW); // Đánh dấu ghế đã chọn
            }

            // Hiển thị danh sách ghế đã chọn
            JOptionPane.showMessageDialog(null, "Ghế đã chọn: " + selectedSeats);
        }
    }
}
