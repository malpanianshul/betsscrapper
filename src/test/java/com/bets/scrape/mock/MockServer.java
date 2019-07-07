package com.bets.scrape.mock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;

public abstract class MockServer {

	
	protected final static Pattern URL_PATTERN = Pattern.compile("^http:\\/\\/localhost:(\\d+)\\/([a-z\\-]+)$");
	
	protected String getBodyAsString(RecordedRequest request){
		Buffer requestBody = request.getBody();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) requestBody.size());
		try {
			requestBody.copyTo(byteArrayOutputStream);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		return byteArrayOutputStream.toString();
	}
}
