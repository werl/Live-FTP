package com.werlsoft.liveftp.start;

import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class LiveFTP {
	
	public static String hostName = "ftp.werl.me";
	private static String password = "";
	public static String username = "";
	public static int ftpPort = 21;	

	public static void main(String[] args) throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException {
		FTPClient client = new FTPClient();
		client.connect(hostName);
		client.login(username, password);
		String[] files = client.listNames();
		for (String s: files){
			System.out.println(s);
		}
		client.disconnect(true);
	}
}
