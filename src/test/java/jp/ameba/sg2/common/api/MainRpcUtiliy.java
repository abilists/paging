package jp.ameba.sg2.common.api;

import jp.ameba.sg2.common.api.RpcUtility;
import jp.ameba.sg2.common.utility.Utility;

public class MainRpcUtiliy {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// System.out.println("abcd>>>>1>>>>>" + DateUtility.getStartToday(2011, 05, 24, 11));

		RpcUtility rpc = new RpcUtility();
		String result = rpc.createRpcMessage("methodName", false, "params1", "params2");

		System.out.println(result);

	}

}
