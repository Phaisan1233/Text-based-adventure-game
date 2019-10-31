package valuables;

import pickups.Valuable;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * This class represents a mobile phone
 * 
 * @author phaisan 17967479
 * 
 */
public class Mobile extends Valuable {
	private Twitter twitter;

	/**
	 * Constructor Create a new mobile Set API to connect with Twitter(read and
	 * write)
	 * 
	 * @param description
	 *            the description of this valuable
	 * @param value
	 *            the value of the valuable
	 */
	public Mobile(String description, int value) {
		super(description, value);
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("Consumer key").setOAuthConsumerSecret("Consumer secret")
				.setOAuthAccessToken("Access token").setOAuthAccessTokenSecret("Access token secret");

		TwitterFactory tf = new TwitterFactory(cb.build());
		this.twitter = tf.getInstance();
	}

	/**
	 * Find the latest update and print it.
	 * 
	 * @param user
	 *            Twitter id
	 * @return latest Tweets from user
	 */
	public String showLatestTweetFrom(String user) {
		try {
			return twitter.showUser(user).getStatus().getText();
		} catch (TwitterException e) {

			e.printStackTrace();
			return "ERROR";
		}
	}

}
