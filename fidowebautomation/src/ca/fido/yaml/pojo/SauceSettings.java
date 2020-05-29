package ca.fido.yaml.pojo;


public class SauceSettings {

	private SauceOptions sauceOptions;
	private MutableCapabilities mutableFireFoxCapabilities;
	private MutableCapabilities mutableChromeCapabilities;
	private MutableCapabilities mutableEdgeCapabilities;
	private AndroidCapabilities androidChromeCapabilities;	
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
	
	
}
