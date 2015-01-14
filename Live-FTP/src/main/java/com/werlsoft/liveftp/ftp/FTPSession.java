package com.werlsoft.liveftp.ftp;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

import java.io.IOException;

import com.werlsoft.liveftp.gui.panel.BrowsePanel;
import com.werlsoft.liveftp.gui.panel.MainPanel;
import com.werlsoft.liveftp.start.LiveFTP;

public class FTPSession implements Runnable {

	private final String hostName;
	private final String username;
	private final int port;
	private char[] pass;

	private FTPClient client;
	
	private boolean run = false;
	private boolean connectWait = true;
	
	private final Thread thread = new Thread(this);

	public FTPSession(String host, int port, String user, char[] word) {
		this.hostName = host;
		this.username = user;
		this.port = port;
		this.pass = word;
		this.thread.start();
		
		if (LiveFTP.frame.contentPane instanceof MainPanel) {
			MainPanel panel = (MainPanel) LiveFTP.frame.contentPane;
			panel.tabPanel.addTab(this.hostName, new BrowsePanel(this));
		}
	}
	
	public boolean isConnected () {
		return this.client.isConnected();
	}
	
	public void connect () {
		this.connectWait = false;
	}
	
	public void dissconnect () {
		this.run = false;
	}
	
	public String[] listCurrentDirFiles() {
		try {
			return client.listNames();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPIllegalReplyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPDataTransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPAbortedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPListParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private boolean internalConnect() {
		this.client = new FTPClient();
		try {
			String def = "";
			for (char c : pass)
				def += c;
			client.connect(hostName, port);
			client.login(username, def);
			this.connectWait = false;
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} catch (FTPIllegalReplyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} catch (FTPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean internalDissconnect() {
		if (this.client.isConnected()) {
			try {
				this.client.disconnect(true);
				this.run = false;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (FTPIllegalReplyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (FTPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		while (this.connectWait) {
			
		}
		this.internalConnect();
		while (this.run) {
			
		}
		//this.internalDissconnect();
	}
}
