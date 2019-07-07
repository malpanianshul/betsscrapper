package com.bets.scrape.mock;

import java.io.IOException;
import java.util.regex.Matcher;

import org.springframework.util.Assert;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class BaseballMockServer extends MockServer {

	private final MockWebServer mockWebServer;

	public BaseballMockServer(int port, String webPath) throws IOException {
		mockWebServer = new MockWebServer();
		mockWebServer.setDispatcher(createDispatcher());
		mockWebServer.start(port);
		mockWebServer.url(webPath);
	}

	public static BaseballMockServer start(final String url) throws IOException {
		final Matcher matcher = URL_PATTERN.matcher(url);
		Assert.isTrue(matcher.matches(), "URL should be http://localhost:8080 and service name");
		return new BaseballMockServer(Integer.parseInt(matcher.group(1)), matcher.group(2));

	}

	public void shutDown() throws IOException {
		mockWebServer.shutdown();
	}

	private Dispatcher createDispatcher() {
		return new Dispatcher() {

			@Override
			public MockResponse dispatch(RecordedRequest requet) throws InterruptedException {
				HttpUrl requestUrl = requet.getRequestUrl();
				String responseJson = "something";
				return new MockResponse().setResponseCode(200).setHeader("Content-Type", "application/json")
						.setBody(responseJson);
			}
		};
	}
}
