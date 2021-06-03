package com.rogers.yaml.pojo;

public class SauceSettings {
		
	private String sauceUser;
	private String sauceKey;
	private String browserName;
	private String browserVersion;
	private SauceOptions sauceOptions;
	private MutableCapabilities mutableFireFoxCapabilities;
	private MutableCapabilities mutableChromeCapabilities;
	private MutableCapabilities mutableEdgeCapabilities;
	private AndroidCapabilities androidChromeCapabilities;
	private MutableCapabilities mutableSafariCapabilities;

	/**
	 * @return the sauceUser
	 */
	public String getSauceUser() {
		return sauceUser;
	}
	/**
	 * @param sauceUser the sauceUser to set
	 */
	public void setSauceUser(String sauceUser) {
		this.sauceUser = sauceUser;
	}
	/**
	 * @return the browserVersion
	 */
	public String getBrowserVersion() {
		return browserVersion;
	}
	/**
	 * @param browserVersion the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	/**
	 * @return the sauceKey
	 */
	public String getSauceKey() {
		return sauceKey;
	}
	/**
	 * @param sauceKey the sauceKey to set
	 */
	public void setSauceKey(String sauceKey) {
		this.sauceKey = sauceKey;
	}
	/**
	 * @return the browserName
	 */
	public String getBrowserName() {
		return browserName;
	}
	/**
	 * @param browserName the browserName to set
	 */
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	/**
	 * @return the sauceOptions
	 */
	public SauceOptions getSauceOptions() {
		return sauceOptions;
	}
	/**
	 * @param sauceOptions the sauceOptions to set
	 */
	public void setSauceOptions(SauceOptions sauceOptions) {
		this.sauceOptions = sauceOptions;
	}
	/**
	 * @return the mutableFireFoxCapabilities
	 */
	public MutableCapabilities getMutableFireFoxCapabilities() {
		return mutableFireFoxCapabilities;
	}
	/**
	 * @param mutableFireFoxCapabilities the mutableFireFoxCapabilities to set
	 */
	public void setMutableFireFoxCapabilities(MutableCapabilities mutableFireFoxCapabilities) {
		this.mutableFireFoxCapabilities = mutableFireFoxCapabilities;
	}
	/**
	 * @return the mutableChromeCapabilities
	 */
	public MutableCapabilities getMutableChromeCapabilities() {
		return mutableChromeCapabilities;
	}
	/**
	 * @param mutableChromeCapabilities the mutableChromeCapabilities to set
	 */
	public void setMutableChromeCapabilities(MutableCapabilities mutableChromeCapabilities) {
		this.mutableChromeCapabilities = mutableChromeCapabilities;
	}
	/**
	 * @return the mutableEdgeCapabilities
	 */
	public MutableCapabilities getMutableEdgeCapabilities() {
		return mutableEdgeCapabilities;
	}
	/**
	 * @param mutableEdgeCapabilities the mutableEdgeCapabilities to set
	 */
	public void setMutableEdgeCapabilities(MutableCapabilities mutableEdgeCapabilities) {
		this.mutableEdgeCapabilities = mutableEdgeCapabilities;
	}
	/**
	 * @return the androidChromeCapabilities
	 */
	public AndroidCapabilities getAndroidChromeCapabilities() {
		return androidChromeCapabilities;
	}
	/**
	 * @param androidChromeCapabilities the androidChromeCapabilities to set
	 */
	public void setAndroidChromeCapabilities(AndroidCapabilities androidChromeCapabilities) {
		this.androidChromeCapabilities = androidChromeCapabilities;
	}

	public MutableCapabilities getMutableSafariCapabilities() {
		return mutableSafariCapabilities;
	}

	public void setMutableSafariCapabilities(MutableCapabilities mutableSafariCapabilities) {
		this.mutableSafariCapabilities = mutableSafariCapabilities;
	}

}
