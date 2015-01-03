package com.werlsoft.liveftp.start;

import java.awt.EventQueue;
import java.io.IOException;

import com.werlsoft.liveftp.gui.main.MainWindow;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class LiveFTP {
	
	public static String hostName = "";
	public static String userName = "";
	private static String password = "";
	public static int ftpPort = 21;	
	public static boolean gui = true;
	
	private static MainWindow frame;

	public static void main(String[] args) {
		if(args.length == 4) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new MainWindow();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
						gui = false;
					}
				}
			});
		}
		else if(args.length != 3) {
			System.out.println("you must input a hostname, username, password; in that order");
			gui = false;
			return;
		}
		else
			gui = false;
		
		hostName = args[0];
		userName = args[1];
		password = args[2];
		
		try {
			if(gui)
				loopGUI();
			else
				loop();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FTPIllegalReplyException e) {
			e.printStackTrace();
		} catch (FTPException e) {
			e.printStackTrace();
		} catch (FTPDataTransferException e) {
			e.printStackTrace();
		} catch (FTPAbortedException e) {
			e.printStackTrace();
		} catch (FTPListParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void loop() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException {
		FTPClient client = new FTPClient();
		client.connect(hostName);
		client.login(userName, password);
		String[] files = client.listNames();
		for (String s: files){
			System.out.println(s);
		}
		client.disconnect(true);
	}
	
	public static void loopGUI() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException {
		FTPClient client = new FTPClient ();
		client.connect(hostName);
		client.login(userName, password);
		String[] files = client.listNames();
		for (String s: files){
			frame.list.add(s);
		}
		client.disconnect(true);
	}
}
