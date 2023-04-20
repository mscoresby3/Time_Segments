import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;

	public JTextField daysField;
	public JTextField hoursField;
	public JTextField minutesField;
	public JTextField secondsField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		System.out.println("System Starting");
		initialize();
		System.out.println("System Started");
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblHeading = new JLabel("Time Segments");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeading.setBounds(110, 11, 215, 40);
		frame.getContentPane().add(lblHeading);

		daysField = new JTextField();
		daysField.setBounds(7, 80, 100, 25);
		frame.getContentPane().add(daysField);
		daysField.setColumns(10);

		JLabel lblDays = new JLabel("Days");
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setBounds(daysField.getBounds().x, daysField.getBounds().y - daysField.getBounds().height,
				daysField.getBounds().width, daysField.getBounds().height);
		frame.getContentPane().add(lblDays);

		hoursField = new JTextField();
		hoursField.setBounds(114, daysField.getBounds().y, daysField.getBounds().width, daysField.getBounds().height);
		frame.getContentPane().add(hoursField);
		hoursField.setColumns(10);

		JLabel lblHours = new JLabel("Hours");
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setBounds(hoursField.getBounds().x, hoursField.getBounds().y - hoursField.getBounds().height,
				hoursField.getBounds().width, hoursField.getBounds().height);
		frame.getContentPane().add(lblHours);

		minutesField = new JTextField();
		minutesField.setBounds(221, daysField.getBounds().y, daysField.getBounds().width, daysField.getBounds().height);
		frame.getContentPane().add(minutesField);
		minutesField.setColumns(10);

		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setBounds(minutesField.getBounds().x, minutesField.getBounds().y - minutesField.getBounds().height,
				minutesField.getBounds().width, minutesField.getBounds().height);
		frame.getContentPane().add(lblMinutes);

		secondsField = new JTextField();
		secondsField.setBounds(328, daysField.getBounds().y, daysField.getBounds().width, daysField.getBounds().height);
		frame.getContentPane().add(secondsField);
		secondsField.setColumns(10);

		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeconds.setBounds(secondsField.getBounds().x, secondsField.getBounds().y - secondsField.getBounds().height,
				secondsField.getBounds().width, secondsField.getBounds().height);
		frame.getContentPane().add(lblSeconds);

		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int days = Integer.parseInt(daysField.getText());
					int hours = Integer.parseInt(hoursField.getText());
					int mintues = Integer.parseInt(minutesField.getText());
					double seconds = Double.parseDouble(secondsField.getText());
					if (days < 0 || hours < 0 || mintues < 0 || seconds < 0) {
						JOptionPane.showMessageDialog(frame, "Values Must Be Greater than or Equal to Zero");
					} else {
						Time user = new Time(days, hours, mintues, seconds);
						user.allMax();
						daysField.setText(user.getDays() + "");
						hoursField.setText(user.getHours() + "");
						minutesField.setText(user.getMinutes() + "");
						if (user.getSeconds() % 1 == 0) {
							secondsField.setText((user.getSeconds() + "").substring(0, (user.getSeconds() + "").length() - 2));
						} else {
							secondsField.setText(user.getSeconds() + "");
						}
						if (user.getSeconds() % 1 > 0) {
							JOptionPane.showMessageDialog(frame, user.toString());
						} else {
							JOptionPane.showMessageDialog(frame,
									user.toString().substring(0, user.toString().length() - 2));
						}
					}
				} catch (Exception E) {
					JOptionPane.showMessageDialog(frame,
							"Not A Vaild Input\nAll Inputs must be Postive Intergers Except seconds which must be a postive number");
				}
			}
		});
		btnConvert.setBounds(163, 150, 125, 30);
		frame.getContentPane().add(btnConvert);
	}
}
