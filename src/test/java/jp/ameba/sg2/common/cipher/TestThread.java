package jp.ameba.sg2.common.cipher;

import java.io.IOException;

import jp.ameba.sg2.common.cipher.CipherUtils;

import org.apache.log4j.Logger;

public class TestThread implements Runnable {
	private static Logger log = Logger.getLogger(TestThread.class);
	
	private int i;
	CipherUtils cipherUtils;
	
	public TestThread(CipherUtils cipherUtils) throws IOException {
		this.cipherUtils = cipherUtils;
	}

	public void run() {
//		String key = "TlzWd$sj9qLdUjs0";
//		CipherUtils cipherUtils = new CipherUtils(key);

		String encrypted;
		try {
			encrypted = cipherUtils.encrypt("5,0");
			System.out.println("encrypted >>> " + encrypted);
			System.out.println("cipher >>> " + encrypted.length());
			String decrypted = cipherUtils.decrypt("xgX+LtvOm8pScaZ72icTcA==");
			System.out.println("decrypted >>> " + decrypted + " >>> " + i);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
