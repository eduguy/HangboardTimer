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
    private int timeLeft;
    private JButton startButton;

    private JLabel welcomeLabel;
    private JLabel sets;
    private JLabel timeHang;
    private JLabel rest;


    public GUI (){
        super("Hang Timer");
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        welcomeLabel = new JLabel(" There will be a" +
                " 3 second delay to give you time to get ready.");
        add(welcomeLabel);

        setUpTimerSetup();
        setUpStartButton();
//        setUpTimeLeft();
        setVisible(true);


    }

//    private void setUpTimeLeft() {
//        timeLeftLabel = new JLabel("Time Left:" + timeLeft);
//        add(timeLeftLabel);
//
//    }

    private void setUpStartButton() {
        startButton = new JButton("Start");
        add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                timer = new Timer(repetitions.getSelectedIndex() + 1, timeOnHang.getSelectedIndex() + 1,
                    restTime.getSelectedIndex() + 1);

                timer.countDown();
                timeLeft=timeOnHang.getSelectedIndex() + 1;
            }
        });
    }

    private void setUpTimerSetup() {
        repetitions = new JComboBox<>(options);
        timeOnHang = new JComboBox<>(options);
        restTime = new JComboBox<>(options);
        sets = new JLabel("Sets");
        add(sets);
        add(repetitions);
        timeHang = new JLabel("Time Hanging");
        add(timeHang);
        add(timeOnHang);
        rest = new JLabel("Rest Time");
        add(rest);
        add(restTime);

    }

}
