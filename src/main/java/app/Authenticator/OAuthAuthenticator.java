package main.java.app.Authenticator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import main.java.app.model.Event;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OAuthAuthenticator implements IAuthenticator {

	private static final Logger logger = LoggerFactory
			.getLogger(OAuthAuthenticator.class);

	@Value("${oauth.key}")
	private String key;

	@Value("${oauth.secret}")
	private String secret;

	@Value("${oauth.signature_method}")
	private String signature_method;

	@Value("${oauth.version}")
	private String version;

	private static String HEADER_KEY = "oauth_consumer_key";
	private static String SIGNATURE_METHOD_KEY = "oauth_signature_method";
	private static String VERSION_KEY = "oauth_version";

	@Override
	public boolean validate(HttpHeaders headers) {

		logger.info("Authenticating request headers.");

		// Note, more validation than the key should be performed, this is just a proof of concept
		//TODO uncomment this out
//		if (key == headers.getFirst(HEADER_KEY)
//				&& signature_method == headers.getFirst(SIGNATURE_METHOD_KEY)
//				&& version == headers.getFirst(VERSION_KEY))
			return true;
//		else
//			return false;
	}

	public Event getDetails() {
		
		// Uses OAuth to sign an outgoing request:
		OAuthConsumer consumer = new DefaultOAuthConsumer(key, secret);
		URL url = null;
		try {
			//TODO set url
			url = new URL(
					"https://www.appdirect.com/AppDirect/rest/api/events/dummyChange");
			HttpURLConnection request;
			request = (HttpURLConnection) url.openConnection();
			consumer.sign(request);
			request.connect();
			
			if(request.getResponseCode() != HttpStatus.OK.value()) {
				logger.error("HTTP " + request.getResponseCode() + " response code received from AppDirect.");
				return null;
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((request.getInputStream())));
            String response = br.readLine();
            request.disconnect();
 
            JAXBContext jaxbContext = JAXBContext.newInstance(Event.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Event) jaxbUnmarshaller.unmarshal(new StringReader(response));
			
		} catch (MalformedURLException e) {
			logger.error("Invalid outgoing url, please check configuration.");
			return null;
			
		} catch (IOException e) {
			logger.error("Unexpected IO exception: " + e.getMessage());
			return null;
			
		} catch (OAuthException e) {
			logger.error("Unexpected OAuth exception: " + e.getMessage());
			return null;
			
		} catch (JAXBException e) {
			logger.error("Unexpected exception while unmarshalling response: " + e.getMessage());
			return null;
        }
	}

}
