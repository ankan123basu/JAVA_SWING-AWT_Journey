import java.awt.*;
import java.text.DateFormatSymbols;
import java.time.*;
import javax.swing.*;

public class MyCalendar extends JFrame {
    JComboBox<String> monthCombo;
    JComboBox<Integer> yearCombo;
    JPanel calendarPanel;

    public MyCalendar() {
        setTitle("My Calendar");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.CYAN);
        topPanel.setLayout(new FlowLayout());

        JLabel title = new JLabel("My Event Calendar");
        title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
        title.setForeground(Color.RED);

        String[] months = new DateFormatSymbols().getMonths();
        monthCombo = new JComboBox<>();
        for (int i = 0; i < 12; i++) monthCombo.addItem(months[i].toUpperCase());

        yearCombo = new JComboBox<>();
        for (int i = 1900; i <= 2100; i++) yearCombo.addItem(i);

        JButton viewBtn = new JButton("VIEW");
        viewBtn.addActionListener(e -> drawCalendar());

        JButton eventBtn = new JButton("Event Calendar");
        eventBtn.setBackground(Color.ORANGE);

        topPanel.add(title);
        topPanel.add(monthCombo);
        topPanel.add(yearCombo);
        topPanel.add(viewBtn);
        topPanel.add(eventBtn);

        // Calendar panel
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(7, 7, 5, 5));
        calendarPanel.setBackground(Color.CYAN);

        add(topPanel, BorderLayout.NORTH);
        add(calendarPanel, BorderLayout.CENTER);

        drawCalendar(); // initial view
        setVisible(true);
    }

    private void drawCalendar() {
        calendarPanel.removeAll();

        // Header days
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        for (String day : days) {
            JLabel lbl = new JLabel(day, SwingConstants.CENTER);
            lbl.setOpaque(true);
            lbl.setBackground(Color.ORANGE);
            calendarPanel.add(lbl);
        }

        int month = monthCombo.getSelectedIndex() + 1;
        int year = (int) yearCombo.getSelectedItem();
        LocalDate firstDay = LocalDate.of(year, month, 1);
        int start = firstDay.getDayOfWeek().getValue(); // Monday=1, Sunday=7
        int length = firstDay.lengthOfMonth();

        // Fill empty cells before 1st day
        for (int i = 1; i < start; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // Fill dates
        for (int day = 1; day <= length; day++) {
            LocalDate current = LocalDate.of(year, month, day);
            JLabel lbl = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            lbl.setOpaque(true);

            if (current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                lbl.setBackground(Color.RED);
                lbl.setForeground(Color.WHITE);
            } else {
                lbl.setBackground(Color.GREEN);
            }

            calendarPanel.add(lbl);
        }

        // Fill remaining cells to complete the grid
        int totalCells = start - 1 + length;
        for (int i = totalCells; i < 42; i++) {
            calendarPanel.add(new JLabel(""));
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyCalendar::new);
    }
}
