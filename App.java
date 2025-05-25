import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        showHomeScreen(); // Hiển thị màn hình chính
    }

    public static void showHomeScreen() {
        // Tạo JFrame chính
        JFrame homeFrame = new JFrame("Boom Field");
        homeFrame.setSize(630, 700);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setResizable(false);

        // Tạo JPanel chính với GridBagLayout
        JPanel homePanel = new JPanel();
        homePanel.setBackground(new Color(232, 247, 227)); // Nền light green pastel
        homePanel.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn giữa

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các thành phần
        gbc.anchor = GridBagConstraints.CENTER; // Căn giữa các thành phần

        // Tạo JLabel để hiển thị biểu tượng 💣
        JLabel boomLabel = new JLabel("💣");
        boomLabel.setFont(new Font("Monospaced", Font.BOLD, 100)); // Cỡ chữ lớn cho biểu tượng 💣
        boomLabel.setForeground(new Color(204, 0, 102)); // Màu margaret?
        gbc.gridx = 0;
        gbc.gridy = 0; // Vị trí căn giữa
        homePanel.add(boomLabel, gbc);

        // Tiêu đề
        JLabel welcomeLabel = new JLabel("Enter the Boom Field!");
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
        welcomeLabel.setForeground(new Color(85, 85, 85)); // Màu xám
        gbc.gridy = 1; // Chuyển xuống phía dưới biểu tượng 💣
        homePanel.add(welcomeLabel, gbc);

        // Tạo JLabel hướng dẫn cách chơi
        JLabel instructionsLabel = new JLabel("<html>Click to explore, right-click to mark booms.<br>Beware of stepping on a boom!</html>");
        instructionsLabel.setFont(new Font("Monospaced", Font.ITALIC, 14)); // Đã sửa lỗi ở đây
        instructionsLabel.setForeground(new Color(139, 131, 134)); // Màu xám giống tiêu đề
        gbc.gridy = 2; // Chuyển xuống dưới tiêu đề
        homePanel.add(instructionsLabel, gbc);

        // Tạo nút Play Game với nền trắng và khung bo tròn
        JButton playButton = new JButton("<html> Play<br>now</html>");
        playButton.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Font giống Back Home
        playButton.setForeground(new Color(139, 131, 134)); // Màu chữ giống Back Home
        playButton.setPreferredSize(new Dimension(120, 40)); // Kích thước giống Back Home
        playButton.setFocusable(false); // Loại bỏ viền focus khi click
        playButton.setBackground(Color.WHITE); // Màu nền trắng
        playButton.setBorder(BorderFactory.createLineBorder(new Color(139, 131, 134), 1, true)); // Viền bo tròn (1px)
        playButton.setOpaque(true); // Đảm bảo nền được hiển thị

        // Sự kiện khi nhấn Play
        playButton.addActionListener((ActionEvent e) -> {
            homeFrame.dispose(); // Đóng màn hình chính
            showLevelScreen(); // Chuyển sang màn hình chọn cấp độ
        });

        // Thêm nút Play vào vị trí thích hợp
        gbc.gridy = 3; // Chuyển xuống dưới hướng dẫn
        homePanel.add(playButton, gbc);

        // Hiển thị giao diện
        homeFrame.add(homePanel);
        homeFrame.setVisible(true);
    }

    public static void showLevelScreen() {
        // Tạo JFrame mới cho màn hình chọn cấp độ
        JFrame levelFrame = new JFrame("Your Pick!");
        levelFrame.setSize(630, 700);
        levelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        levelFrame.setLocationRelativeTo(null);
        levelFrame.setResizable(false);

        // Tạo JPanel với GridBagLayout
        JPanel levelPanel = new JPanel();
        levelPanel.setBackground(new Color(232, 247, 227)); // Nền light green pastel
        levelPanel.setLayout(new GridBagLayout()); // Căn giữa các thành phần

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Tiêu đề
        JLabel levelLabel = new JLabel("Stay sharp or kaboom 💥!");
        levelLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
        levelLabel.setForeground(new Color(85, 85, 85)); // Màu xám
        gbc.gridy = 0;
        levelPanel.add(levelLabel, gbc);

        // Nút dễ
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
        easyButton.setForeground(new Color(139, 131, 134)); // Màu chữ giống Back Home
        easyButton.setPreferredSize(new Dimension(200, 40));
        easyButton.setFocusable(false);
        easyButton.setBackground(Color.WHITE);
        easyButton.setBorder(BorderFactory.createLineBorder(new Color(139, 131, 134), 1, true));
        easyButton.setOpaque(true);

        easyButton.addActionListener((ActionEvent e) -> {
            levelFrame.dispose();
            new Minesweeper(10); // 10 mines for Easy level
        });

        gbc.gridy = 1;
        levelPanel.add(easyButton, gbc);

        // Nút vừa
        JButton mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mediumButton.setForeground(new Color(139, 131, 134)); // Màu chữ giống Back Home
        mediumButton.setPreferredSize(new Dimension(200, 40));
        mediumButton.setFocusable(false);
        mediumButton.setBackground(Color.WHITE);
        mediumButton.setBorder(BorderFactory.createLineBorder(new Color(139, 131, 134), 1, true));
        mediumButton.setOpaque(true);

        mediumButton.addActionListener((ActionEvent e) -> {
            levelFrame.dispose();
            new Minesweeper(20); // 20 mines for Medium level
        });

        gbc.gridy = 2;
        levelPanel.add(mediumButton, gbc);

        // Nút khó
        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
        hardButton.setForeground(new Color(139, 131, 134)); // Màu chữ giống Back Home
        hardButton.setPreferredSize(new Dimension(200, 40));
        hardButton.setFocusable(false);
        hardButton.setBackground(Color.WHITE);
        hardButton.setBorder(BorderFactory.createLineBorder(new Color(139, 131, 134), 1, true));
        hardButton.setOpaque(true);

        hardButton.addActionListener((ActionEvent e) -> {
            levelFrame.dispose();
            new Minesweeper(30); // 30 mines for Hard level
        });

        gbc.gridy = 3;
        levelPanel.add(hardButton, gbc);

        levelFrame.add(levelPanel);
        levelFrame.setVisible(true);
    }
}
