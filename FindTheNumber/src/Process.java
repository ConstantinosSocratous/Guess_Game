import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Process {

	
	private JFrame frame = new JFrame("Find The Number game");
	private JPanel panel = new JPanel();
	private JLabel display,lblInfo, lblInfo1;
	
	private JButton ready,playAgain,yes,no;
	private int low,high,key,middle,que;
	
	public Process() {
		fillNums();
	}
	private void fillNums() {
		low=0;
		high=100;
		middle = (low+high)/2;
		que=0;
	}
	public void makeFrame() {
		
		panel.setLayout(null);
		int tempLow = low+1;
		//------------\\
		lblInfo = new JLabel("Think of a number between "+tempLow + "-"+high);
		lblInfo.setBounds(90, 10, 300,50);
		lblInfo.setFont(new Font("Arial", Font.PLAIN,20));
		panel.add(lblInfo);
		
		lblInfo1 = new JLabel();
		lblInfo1.setBounds(140, 120, 300,50);
		lblInfo1.setFont(new Font("Arial", Font.PLAIN,20));
		panel.add(lblInfo1);
		
		display = new JLabel();
		display.setBounds(160,180,200,30);
		display.setFont(new Font("Arial", Font.BOLD,16));
		panel.add(display);
		
		//-------------\\
		ready = new JButton("Ready?(Click me if yes)");
		ready.setBounds(140, 70, 200, 30);
		ready.setFont(new Font("Arial", Font.PLAIN,16));
		panel.add(ready);
		ready.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				ready();
			  } 
			} );
		
		playAgain = new JButton("Start again");
		playAgain.setBounds(140, 350, 200, 30);
		playAgain.setFont(new Font("Arial", Font.PLAIN,16));
		panel.add(playAgain);
		playAgain.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  playAgain();
			  } 
			} );	
		yes = new JButton("YES");
		yes.setBounds(140, 240, 80, 30);
		yes.setFont(new Font("Arial", Font.PLAIN,14));
		yes.setVisible(false);
		panel.add(yes);
		yes.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  yes();
			  } 
			} );	
		no = new JButton("NO");
		no.setBounds(240, 240, 80, 30);
		no.setFont(new Font("Arial", Font.PLAIN,14));
		no.setVisible(false);
		panel.add(no);
		no.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  no();
			  } 
			} );		
		
		
		//-----FRAME-----\\	
		frame.add(panel);		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setMinimumSize(new Dimension(500, 500));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
	}
	public void hideFrame() {
		frame.setVisible(false);
	}
	public void showFrame() {
		frame.setVisible(true);
	}
	private void ready() {
		ready.setVisible(false);
		playAgain.setVisible(true);
		yes.setVisible(true);
		no.setVisible(true);
		showQuest();
	}
	private void playAgain() {
		ready.setVisible(true);
		yes.setVisible(false);
		no.setVisible(false);
		setDisplay("");
		lblInfo1.setText("");
		fillNums();
	}
	private void yes() {
		key=1;
		que++;
		playing(key);
	}
	private void no() {
		key=0;
		que++;
		playing(key);
	}
	private void showQuest() {
	   setDisplay("Is your number > " + middle);
	}
	private void playing(int keyNum) {
	   if(key==1) {
		   low=middle;
	   }else if(key==0)
		   high=middle;
		
	   int ans=0;
	   
		if(high-low ==1) {
			if(key==1)
			{
				ans = high;
			}else ans = middle;
			
		   setDisplay("Your number is " + ans);
		   lblInfo1.setText("Questions needed: "+que); 
		   yes.setVisible(false);
		   no.setVisible(false);
		   return;
	   } 
		   
	
		middle=(low+high)/2;
		showQuest();
	}
	
	private void setDisplay(String str) {
		display.setText(str);
	}
	
}
