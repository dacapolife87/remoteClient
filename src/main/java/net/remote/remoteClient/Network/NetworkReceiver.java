package net.remote.remoteClient.Network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkReceiver implements Runnable{
	Socket socket = null;
	DataInputStream dis = null;
	
	public NetworkReceiver(Socket socket){
		this.socket = socket;
		makeInputStream();
	}
	public void makeInputStream(){
		try {
			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		readPacket();
	}
	public void readPacket(){
		String msg = null;
		try {
			while (!Thread.interrupted()) {
			msg = dis.readUTF();
			}
			
		} catch (IOException e){
			// TODO Auto-generated catch block
			System.out.println("exception : "+e);
			e.printStackTrace();
			
		}
		
	}
}
