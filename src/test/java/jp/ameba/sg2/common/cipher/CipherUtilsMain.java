package jp.ameba.sg2.common.cipher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jp.ameba.sg2.common.cipher.CipherUtils;

public class CipherUtilsMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// You have to set the 16 words. "k!j(=O=BDs9O"pH)"
		// ("01", "2", "1", "2");
		String key = "TlzWd$sj9qLdUjs0";

		CipherUtils cipherUtils = new CipherUtils(key);

		try {
			ExecutorService es = Executors.newFixedThreadPool(200);

			for (int i=0; i < 5000; i++) {

				TestThread epoll = new TestThread(cipherUtils);
				es.submit(epoll);

			}

			es.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}