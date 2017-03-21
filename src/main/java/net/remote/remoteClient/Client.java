package net.remote.remoteClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.remote.remoteClient.Network.NetworkModule;
import net.remote.remoteClient.UI.LoginUIClient;

public class Client {
	Logger logger = LoggerFactory.getLogger(getClass());
	LoginUIClient loginUI = null;
	NetworkModule netModule = null;
	
	public Client(){
		loginUI = new LoginUIClient();
		netModule = new NetworkModule();
		netModule.startReceiver();
	}
	public static void main(String[] args) {
		new Client();
		
	}

}
