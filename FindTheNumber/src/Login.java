import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login {

	private JFrame frame;
	public Login() {
		
	}
	public void makeFrame() {
	    frame = new JFrame("Login");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		 
		//--------------\\
		JPasswordField txtPass = new JPasswordField();
		txtPass.setBounds(55,90,180,30);
		txtPass.setFont(new Font("Arial",Font.PLAIN,14));
		panel.add(txtPass);
		//--------------\\ 
		
		JButton login = new JButton("Login");
		login.setBounds(55, 160, 80, 30);
		login.setFont(new Font("Arial", Font.PLAIN,14));
		panel.add(login);
		login.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  login(txtPass);
			  } 
			} );		
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(155, 160, 80, 30);
		cancel.setFont(new Font("Arial", Font.PLAIN,14));
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  cancel();
			  } 
			} );		
		//--------------\\
		JLabel pass = new JLabel("Insert password");
		pass.setBounds(55,40,180,30);
		pass.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(pass);
		
		//------FRAME------\\
		frame.add(panel);		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(300,300);
		frame.setMinimumSize(new Dimension(300, 300));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
	}
	private void cancel() {
		System.exit(0);
	}
	@SuppressWarnings("deprecation")
	private void login(JPasswordField txt) {
		if(txt.getText().equals("1234")) {
			hideFrame();
			Process process = new Process();
		    process.makeFrame();
		}
		else
		{
			JOptionPane.showMessageDialog(frame,
				    "Password incorrect",
				    "Login",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	public void showFrame() {
		frame.setVisible(true);
	}
	public void hideFrame() {
		frame.setVisible(false);
	}
}
