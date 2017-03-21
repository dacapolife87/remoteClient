package net.remote.remoteClient.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.ServerCloneException;

import javax.swing.SwingUtilities;

import net.remote.remoteClient.Constant.LoginProtocol;
import net.remote.remoteClient.Constant.NetworkConstant;
import net.remote.remoteClient.packetHandler.LoginPacket;

public class NetworkModule {
	private static NetworkModule instance = null;
	static DataOutputStream dos = null;
	Socket socket = null;
	Thread receiverThread;
	NetworkReceiver netReceiver;
	public NetworkModule(){
		connetServer();
		netReceiver = new NetworkReceiver(socket);
	}
	
	public static NetworkModule getInstance(){
		if(instance == null){
			instance = new NetworkModule();
		}
		return instance;
	}
	
	public void connetServer(){
		try {
			socket = new Socket(NetworkConstant.SERVERIP, NetworkConstant.PORT);
			OutputStream out = socket.getOutputStream();
            dos = new DataOutputStream(out);
            

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startReceiver(){
		receiverThread = new Thread(netReceiver);
		receiverThread.start();
	}
	public static void sendMessage(String api, Object obj){
		if(api.equals(LoginProtocol.REQ_USER_LOGIN)){
			LoginPacket packet = (LoginPacket) obj;
			try {
				dos.writeUTF(packet.toString());
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
