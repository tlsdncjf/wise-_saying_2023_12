package com.ws;

import java.util.HashMap;
import java.util.Map;

public class Rq {
	private String actionCode;
	private Map<String, String> params;

	public Rq(String cmd) {
		String[] cmdBits = cmd.split("\\?", 2);

		actionCode = cmdBits[0];

		params = new HashMap<>();

		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);
			if (paramBits.length == 1) {
				continue;
			}
			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value);
		}
	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}
}