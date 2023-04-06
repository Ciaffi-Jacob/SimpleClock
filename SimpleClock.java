//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
        JButton twelveTwentyFour;
        JButton timeZone;


        boolean timeFlag = false;
        boolean zoneFlag = false;
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;


        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(350, 220);
            this.setResizable(false);
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));
            twelveTwentyFour = new JButton("12/24");
            twelveTwentyFour.addActionListener(this::changeHour);
            timeZone = new JButton("local/GMT");
            timeZone.addActionListener(this::changeZone);

    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.add(timeZone);
            this.add(twelveTwentyFour);
            this.setVisible(true);
    
            setTimer();
        }

    private void changeZone(ActionEvent actionEvent) {
            if(zoneFlag){
                timeFormat.setTimeZone(TimeZone.getDefault());
                zoneFlag = false;
            } else {
                timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                zoneFlag = true;
            }
    }

    private void changeHour(ActionEvent actionEvent) {
        if (timeFlag) {
            timeFormat = new SimpleDateFormat("HH:mm:ss");
            timeFlag = false;
        } else {
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            timeFlag = true;
        }
    }

    public void setTimer() {
            while (true) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new SimpleClock();
        }
    }
