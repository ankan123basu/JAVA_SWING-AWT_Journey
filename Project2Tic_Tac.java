import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project2Tic_Tac {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGame());
    }
}

class TicTacToeGame extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private boolean xTurn = true;
    private int moveCount = 0;

    public TicTacToeGame() {
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3, 10, 10));
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (!btn.getText().equals("")) return;
        btn.setText(xTurn ? "X" : "O");
        btn.setForeground(xTurn ? Color.BLUE : Color.RED);
        moveCount++;
        if (checkWin()) {
            showResult((xTurn ? "X" : "O") + " wins!");
        } else if (moveCount == 9) {
            showResult("It's a draw!");
        } else {
            xTurn = !xTurn;
        }
    }

    private boolean checkWin() {
        String player = xTurn ? "X" : "O";
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(player) &&
                buttons[i][1].getText().equals(player) &&
                buttons[i][2].getText().equals(player)) return true;
            if (buttons[0][i].getText().equals(player) &&
                buttons[1][i].getText().equals(player) &&
                buttons[2][i].getText().equals(player)) return true;
        }
        // Check diagonals
        if (buttons[0][0].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][2].getText().equals(player)) return true;
        if (buttons[0][2].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][0].getText().equals(player)) return true;
        return false;
    }

    private void showResult(String message) {
        int option = JOptionPane.showConfirmDialog(this, message + "\nPlay again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setForeground(Color.BLACK);
            }
        }
        xTurn = true;
        moveCount = 0;
    }
}