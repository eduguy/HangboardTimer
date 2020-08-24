import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;

    Timer timer;
    private JComboBox<Integer> repetitions;
    private JComboBox<Integer> timeOnHang;
    private JComboBox<Integer> restTime;
    private Integer[] options = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
    private JLabel timeLeftLabel;
    private String timeLeft;
    private JButton startButton;

    private JLabel welcomeLabel;


    public GUI (){
        super("Hang Timer");
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        welcomeLabel = new JLabel(" There will be a" +
                " 3 second delay to give you time to get ready.");
        add(welcomeLabel);

        setUpJComboBox();
        setUpStartButton();
        setUpTimeLeft();
        setVisible(true);


    }

    private void setUpTimeLeft() {
        timeLeftLabel = new JLabel(timeLeft);
        add(timeLeftLabel);

    }

    private void setUpStartButton() {
        startButton = new JButton("Start");
        add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                timer = new Timer(repetitions.getSelectedIndex() + 1, timeOnHang.getSelectedIndex() + 1,
                    restTime.getSelectedIndex() + 1);

                timer.countDown();
            }
        });
    }

    private void setUpJComboBox() {
        repetitions = new JComboBox<>(options);
        timeOnHang = new JComboBox<>(options);
        restTime = new JComboBox<>(options);
        add(repetitions);
        add(timeOnHang);
        add(restTime);

    }

}
