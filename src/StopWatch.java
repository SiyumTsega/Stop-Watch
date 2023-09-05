import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch implements ActionListener{

	JFrame frame = new JFrame("My Stop Watch");
	JLabel timeLabel = new JLabel();;
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");;
	int elapsedTime = 0;
	int sec = 0;
	int min = 0;
	int hrs = 0;
	String secStr = String.format("%02d", sec);
	String minStr = String.format("%02d", min);
	String hrStr = String.format("%02d", hrs);
	
	boolean started;
	
	Timer timer = new Timer(1000, new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
		elapsedTime += 1000;
		sec = (elapsedTime / 1000) % 60;
		min = (elapsedTime / 60000) % 60;
		hrs = (elapsedTime / 3600000) % 60;
		secStr = String.format("%02d", sec);
		minStr = String.format("%02d", min);
		hrStr = String.format("%02d", hrs);
		timeLabel.setText(hrStr+":"+minStr+":"+secStr);	
		}
	});
	
	StopWatch(){
		
		timeLabel.setText(hrStr+":"+minStr+":"+secStr);
		timeLabel.setBounds(100, 100, 200, 100);
		timeLabel.setBackground(new Color(0x775B77));
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100,210,90,50);
		startButton.setBackground(new Color(0xED4E93));
		startButton.setBorder(new RoundedBorder(10));
		startButton.setFont(new Font("Ink Free", Font.BOLD, 20));;
		startButton.addActionListener(this);
		startButton.setFocusable(false);
		
		resetButton.setBounds(210,210,90,50);
		resetButton.setBackground(new Color(0xED4E93));
		resetButton.setBorder(new RoundedBorder(10));
		resetButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.getContentPane().setBackground(new Color(0xD8BFD8));
		frame.setLayout(null);
		frame.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			if(e.getSource() == startButton) {
				if(started == false) {
					started = true;
					startButton.setText("STOP");
					timer.start();
				}
				else {
					started = false;
					startButton.setText("START");
					timer.stop();
				}
			}
			if(e.getSource() == resetButton) {
				started = false;
				reset();
				startButton.setText("START");
				sec = 0;
				min = 0;
				hrs = 0;
				secStr = String.format("%02d", sec);
				minStr = String.format("%02d", min);
				hrStr = String.format("%02d", hrs);
				timeLabel.setText(hrStr+":"+minStr+":"+secStr);
			}
		
	}

	private void reset() {
		timer.stop();
	}	
}
