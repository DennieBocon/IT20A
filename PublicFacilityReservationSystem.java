import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class PublicFacilityReservationSystem {

    // Main Frame
    JFrame frame = new JFrame("Public Facility Reservation System");
    CardLayout card = new CardLayout();
    JPanel mainPanel = new JPanel(card);

    // Data structures
    List<String> facilityList = new ArrayList<>();
    Queue<String> reservationQueue = new LinkedList<>();
    Map<String, Integer> facilityMap = new HashMap<>();

    public static void main(String[] args) {
        new PublicFacilityReservationSystem();
    }

    public PublicFacilityReservationSystem() {

        // Sample data
        facilityList.add("Chairs");
        facilityList.add("Tables");
        facilityList.add("Sound System");
        facilityList.add("Court");

        for (String f : facilityList) facilityMap.put(f, 10); // Quantity

        // Pages
        mainPanel.add(createStartPage(), "Start");
        mainPanel.add(createLoginPage(), "Login");
        mainPanel.add(createSignInPage(), "SignIn");
        mainPanel.add(createHomePage(), "Home");
        mainPanel.add(createFacilityPage(), "Facilities");
        mainPanel.add(createAboutPage(), "About");

        frame.add(mainPanel);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // -------------------- Start Page --------------------
    private JPanel createStartPage() {
        JPanel panel = new JPanel(null);

        JLabel logo = new JLabel("PUBLIC FACILITY RESERVATION SYSTEM");
        logo.setBounds(150, 50, 600, 50);
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(logo);

        JButton loginBtn = new JButton("LOG IN");
        loginBtn.setBounds(350, 200, 200, 40);
        loginBtn.addActionListener(e -> card.show(mainPanel, "Login"));
        panel.add(loginBtn);

        JButton signInBtn = new JButton("SIGN IN");
        signInBtn.setBounds(350, 260, 200, 40);
        signInBtn.addActionListener(e -> card.show(mainPanel, "SignIn"));
        panel.add(signInBtn);

        return panel;
    }

    // -------------------- Login Page --------------------
    private JPanel createLoginPage() {
        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("Log In");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(380, 40, 200, 40);
        panel.add(title);

        JLabel emailLbl = new JLabel("Email:");
        emailLbl.setBounds(300, 130, 100, 25);
        panel.add(emailLbl);
        JTextField emailField = new JTextField();
        emailField.setBounds(380, 130, 200, 30);
        panel.add(emailField);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setBounds(300, 190, 100, 25);
        panel.add(passLbl);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(380, 190, 200, 30);
        panel.add(passField);

        JButton loginBtn = new JButton("LOG IN");
        loginBtn.setBounds(380, 260, 200, 40);
        loginBtn.addActionListener(e -> card.show(mainPanel, "Home"));
        panel.add(loginBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(30, 20, 80, 30);
        backBtn.addActionListener(e -> card.show(mainPanel, "Start"));
        panel.add(backBtn);

        return panel;
    }

    // -------------------- Sign In Page --------------------
    private JPanel createSignInPage() {
        JPanel panel = new JPanel(null);

        JLabel title = new JLabel("Sign In");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(380, 20, 200, 40);
        panel.add(title);

        JLabel nameLbl = new JLabel("Name:");
        nameLbl.setBounds(280, 100, 100, 25);
        panel.add(nameLbl);
        JTextField nameField = new JTextField();
        nameField.setBounds(350, 100, 230, 30);
        panel.add(nameField);

        JLabel emailLbl = new JLabel("Email:");
        emailLbl.setBounds(280, 150, 100, 25);
        panel.add(emailLbl);
        JTextField emailField = new JTextField();
        emailField.setBounds(350, 150, 230, 30);
        panel.add(emailField);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setBounds(280, 200, 100, 25);
        panel.add(passLbl);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(350, 200, 230, 30);
        panel.add(passField);

        JButton signInBtn = new JButton("SIGN IN");
        signInBtn.setBounds(350, 260, 230, 40);
        signInBtn.addActionListener(e -> card.show(mainPanel, "Home"));
        panel.add(signInBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(30, 20, 80, 30);
        backBtn.addActionListener(e -> card.show(mainPanel, "Start"));
        panel.add(backBtn);

        return panel;
    }

    // -------------------- Home Page --------------------
    private JPanel createHomePage() {
        JPanel panel = new JPanel(null);

        JPanel menu = new JPanel(null);
        menu.setBounds(0, 0, 200, 600);
        menu.setBackground(Color.LIGHT_GRAY);

        JButton facilitiesBtn = new JButton("Facilities");
        facilitiesBtn.setBounds(20, 80, 150, 40);
        facilitiesBtn.addActionListener(e -> card.show(mainPanel, "Facilities"));
        menu.add(facilitiesBtn);

        JButton reservationBtn = new JButton("Reservation Queue");
        reservationBtn.setBounds(20, 150, 150, 40);
        reservationBtn.addActionListener(e -> showQueue());
        menu.add(reservationBtn);

        JButton aboutBtn = new JButton("About");
        aboutBtn.setBounds(20, 220, 150, 40);
        aboutBtn.addActionListener(e -> card.show(mainPanel, "About"));
        menu.add(aboutBtn);

        panel.add(menu);

        JPanel content = new JPanel();
        content.setBounds(200, 0, 700, 600);
        content.setBackground(Color.WHITE);
        content.add(new JLabel("Welcome to the Public Facility Reservation System"));
        panel.add(content);

        return panel;
    }

    // -------------------- Facility Page --------------------
    private JPanel createFacilityPage() {
        JPanel panel = new JPanel(null);

        JLabel header = new JLabel("FACILITIES");
        header.setFont(new Font("Arial", Font.BOLD, 26));
        header.setBounds(300, 20, 400, 40);
        panel.add(header);

        JTextArea area = new JTextArea();
        area.setBounds(200, 100, 400, 300);
        updateFacilityArea(area);
        area.setEditable(false);
        panel.add(area);

        JButton reserveBtn = new JButton("Reserve First Facility");
        reserveBtn.setBounds(300, 420, 250, 40);
        reserveBtn.addActionListener(e -> reserveFacility(area));
        panel.add(reserveBtn);

        JButton sortBtn = new JButton("Sort Facilities Alphabetically");
        sortBtn.setBounds(300, 470, 250, 40);
        sortBtn.addActionListener(e -> {
            Collections.sort(facilityList);
            updateFacilityArea(area);
        });
        panel.add(sortBtn);

        JButton searchBtn = new JButton("Search Facility");
        searchBtn.setBounds(300, 520, 250, 40);
        searchBtn.addActionListener(e -> searchFacility(area));
        panel.add(searchBtn);

        JButton backBtn = new JButton("Back Home");
        backBtn.setBounds(30, 20, 120, 30);
        backBtn.addActionListener(e -> card.show(mainPanel, "Home"));
        panel.add(backBtn);

        return panel;
    }

    // -------------------- About Page --------------------
    private JPanel createAboutPage() {
        JPanel panel = new JPanel(null);

        JLabel header = new JLabel("ABOUT");
        header.setFont(new Font("Arial", Font.BOLD, 28));
        header.setBounds(380, 20, 200, 40);
        panel.add(header);

        JTextArea details = new JTextArea(
                "This is a sample Public Facility Reservation System.\n\n" +
                "It demonstrates:\n- GUI using JFrame\n- List, Queue, Map\n- Sorting and Searching examples."
        );
        details.setBounds(200, 120, 500, 300);
        details.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        details.setEditable(false);
        panel.add(details);

        JButton backHome = new JButton("Home");
        backHome.setBounds(30, 20, 80, 30);
        backHome.addActionListener(e -> card.show(mainPanel, "Home"));
        panel.add(backHome);

        return panel;
    }

    // -------------------- Utility Functions --------------------
    private void updateFacilityArea(JTextArea area) {
        StringBuilder sb = new StringBuilder("Available Facilities:\n");
        for (String f : facilityList) {
            sb.append(f).append(" - Quantity: ").append(facilityMap.get(f)).append("\n");
        }
        area.setText(sb.toString());
    }

    private void reserveFacility(JTextArea area) {
        if (!facilityList.isEmpty()) {
            String f = facilityList.get(0);
            reservationQueue.add(f);
            facilityMap.put(f, facilityMap.get(f) - 1);
            JOptionPane.showMessageDialog(frame, f + " reserved! Queue size: " + reservationQueue.size());
            updateFacilityArea(area);
        }
    }

    private void searchFacility(JTextArea area) {
        String name = JOptionPane.showInputDialog(frame, "Enter facility name to search:");
        if (name != null) {
            if (facilityList.contains(name)) {
                JOptionPane.showMessageDialog(frame, name + " is available! Quantity: " + facilityMap.get(name));
            } else {
                JOptionPane.showMessageDialog(frame, name + " not found.");
            }
        }
    }

    private void showQueue() {
        if (reservationQueue.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Reservation queue is empty.");
        } else {
            StringBuilder sb = new StringBuilder("Reservation Queue:\n");
            for (String f : reservationQueue) sb.append(f).append("\n");
            JOptionPane.showMessageDialog(frame, sb.toString());
        }
    }
}
