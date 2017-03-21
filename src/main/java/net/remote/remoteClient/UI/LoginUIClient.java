package net.remote.remoteClient.UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.remote.remoteClient.Constant.LoginProtocol;
import net.remote.remoteClient.Network.NetworkModule;
import net.remote.remoteClient.packetHandler.LoginPacket;

public class LoginUIClient extends JFrame implements ActionListener{
	
	JFrame frame = new JFrame("login");
	
	JPanel mainPanel = new JPanel();
	
	JPanel lebelGroup = new JPanel();
	JPanel textFieldGroup = new JPanel();	
	
	JButton loginBtn = new JButton("Login");
	JButton exitBtn	 = new JButton("EXIT");
	
	JLabel idLabel	= new JLabel("userId");
	JLabel pwLabel	= new JLabel("userPW");
	
	JTextField idTextField = new JTextField();
	JTextField pwTextField = new JTextField();
	
	public LoginUIClient(){
		
		lebelGroup.setLayout(new GridLayout(2,1));
		lebelGroup.add(idLabel);
		lebelGroup.add(pwLabel);
		
		textFieldGroup.setLayout(new GridLayout(2,1));
		textFieldGroup.add(idTextField);
		textFieldGroup.add(pwTextField);
		idTextField.setColumns(20);
		pwTextField.setColumns(20);
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		mainPanel.add(lebelGroup);
		mainPanel.add(textFieldGroup);
		mainPanel.add(loginBtn);
		
		loginBtn.addActionListener(this);
		
		frame.add(mainPanel);
		
		frame.setSize(400, 250);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("event");
		System.out.println(event);
		if (event.getActionCommand().equals("Login")) {
			String userId;
			String userPw;
			String api;
			api = LoginProtocol.REQ_USER_LOGIN;
			userId = idTextField.getText();
			userPw = pwTextField.getText();
			
			System.out.println("test");
			NetworkModule.sendMessage(api, new LoginPacket(api, userId, userPw));
		}
		
		
	}
}
