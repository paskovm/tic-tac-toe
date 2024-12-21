import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class TicTacToe extends Frame implements ActionListener {

    private Button[] buttons = new Button[9];
    private Button newGameButton;

    private int oOrX = 0; // 0 or X
    private int valButton1 = 0, valButton2 = 0, valButton3 = 0, valButton4 = 0, valButton5 = 0, valButton6 = 0, valButton7 = 0, valButton8 = 0, calButton9 = 0;
    private int winningLocation = 70;
    private boolean hasWon = false;

    TicTacToe() {
        setLayout(null);
        setVisible(true);
        setSize(800, 600);
        setLocation(400, 100);
        setBackground(Color.white);
        setForeground(Color.black);

        // Create the 9 buttons
        int x = 8;
        int y = 28;
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[k] = new Button();
                buttons[k].setSize(100, 100);
                buttons[k].setLocation(x, y);
                buttons[k].setFont(new Font("", Font.BOLD, 40));

                add(buttons[k]);

                buttons[k].addActionListener(this);
                buttons[k].setBackground(new Color(255, 141, 28)); // Orange
                k++;
                x += 100;
            }
            x = 8;
            y += 100;
        }

        // create the new game button
        newGameButton = new Button("New Game");
        newGameButton.setSize(150, 40);
        newGameButton.setLocation(500, 300);
        newGameButton.setFont(new Font("", Font.BOLD, 20));
        newGameButton.setBackground(new Color(255, 141, 28));

        add(newGameButton);
        newGameButton.addActionListener(this);

        // in order for the window to be able to close after pressing x button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // for new game
        if (event.getSource() == newGameButton) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setLabel("");
            }
            valButton1 = 0;
            valButton2 = 0;
            valButton3 = 0;
            valButton4 = 0;
            valButton5 = 0;
            valButton6 = 0;
            valButton7 = 0;
            valButton8 = 0;
            calButton9 = 0;
            hasWon = false;
        }

        if (!hasWon) {
            // set label to the button of the game => O or X
            if (event.getSource() == buttons[0] && valButton1 == 0) {
                buttonPressed(0);
            }

            if (event.getSource() == buttons[1] && valButton2 == 0) {
                buttonPressed(1);
            }

            if (event.getSource() == buttons[2] && valButton3 == 0) {
                buttonPressed(2);
            }

            if (event.getSource() == buttons[3] && valButton4 == 0) {
                buttonPressed(3);
            }

            if (event.getSource() == buttons[4] && valButton5 == 0) {
                buttonPressed(4);
            }

            if (event.getSource() == buttons[5] && valButton6 == 0) {
                buttonPressed(5);
            }

            if (event.getSource() == buttons[6] && valButton7 == 0) {
                buttonPressed(6);
            }

            if (event.getSource() == buttons[7] && valButton8 == 0) {
                buttonPressed(7);
            }

            if (event.getSource() == buttons[8] && calButton9 == 0) {
                buttonPressed(8);
            }


            // winning conditions
            if (!buttons[0].getLabel().isEmpty() && Objects.equals(buttons[0].getLabel(), buttons[1].getLabel()) && Objects.equals(buttons[0].getLabel(), buttons[2].getLabel())) {
                userHasWon(0);

            } else if (!buttons[3].getLabel().isEmpty() && Objects.equals(buttons[3].getLabel(), buttons[4].getLabel()) && Objects.equals(buttons[3].getLabel(), buttons[5].getLabel())) {
                userHasWon(3);

            } else if (!buttons[6].getLabel().isEmpty() && Objects.equals(buttons[6].getLabel(), buttons[7].getLabel()) && Objects.equals(buttons[6].getLabel(), buttons[8].getLabel())) {
                userHasWon(6);

            } else if (!buttons[0].getLabel().isEmpty() && Objects.equals(buttons[0].getLabel(), buttons[4].getLabel()) && Objects.equals(buttons[0].getLabel(), buttons[8].getLabel())) {
                userHasWon(0);

            } else if (!buttons[2].getLabel().isEmpty() && Objects.equals(buttons[2].getLabel(), buttons[4].getLabel()) && Objects.equals(buttons[2].getLabel(), buttons[6].getLabel())) {
                userHasWon(2);

            } else if (!buttons[0].getLabel().isEmpty() && Objects.equals(buttons[0].getLabel(), buttons[3].getLabel()) && Objects.equals(buttons[0].getLabel(), buttons[6].getLabel())) {
                userHasWon(0);

            } else if (!buttons[1].getLabel().isEmpty() && Objects.equals(buttons[1].getLabel(), buttons[4].getLabel()) && Objects.equals(buttons[1].getLabel(), buttons[7].getLabel())) {
                userHasWon(1);

            } else if (!buttons[2].getLabel().isEmpty() && Objects.equals(buttons[2].getLabel(), buttons[5].getLabel()) && Objects.equals(buttons[2].getLabel(), buttons[8].getLabel())) {
                userHasWon(1);

            }
        }
    }

    private void buttonPressed(int buttonIndex) {
        if (oOrX % 2 == 0) {
            buttons[buttonIndex].setLabel("O");
        } else {
            buttons[buttonIndex].setLabel("X");
        }

        switch (buttonIndex) {
            case 0:
                valButton1++;
                break;
            case 1:
                valButton2++;
                break;
            case 2:
                valButton3++;
                break;
            case 3:
                valButton4++;
                break;
            case 4:
                valButton5++;
                break;
            case 5:
                valButton6++;
                break;
            case 6:
                valButton7++;
                break;
            case 7:
                valButton8++;
                break;
            case 8:
                calButton9++;
                break;
        }
        oOrX++;
    }

    private void userHasWon(int buttonIndex) {
        Font font = new Font("", Font.BOLD, 14);

        Label label = new Label();
        if (buttons[buttonIndex].getLabel() == "O") {
            label.setText("Player 1 wins");
        } else if (buttons[buttonIndex].getLabel() == "X") {
            label.setText("Player 2 wins");
        }
        label.setSize(150, 50);
        label.setLocation(320, winningLocation);
        label.setFont(font);
        add(label);
        winningLocation += 50;

        hasWon = true;
    }
}
