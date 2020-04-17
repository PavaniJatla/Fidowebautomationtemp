package ca.fido.yaml.pojo;


public class AccountData {
	public String name;
	public String username;
	public String password;
	private AccountDetails accountDetails;
	private String newUsername; 
	private String newPassword;
	private String email;
	public String usernamePay;
	public String usernameDowngrade;
	public String usernameUpgrade;
	public String usernameDowngradeSameSpeed;
	public String usernameMobile;
	private String dealerCode;
	private String environment;
	private String sspEnv;
	
	/**
	 * @return the accountDetails
	 */
	public AccountDetails getaccountDetails() {
		return accountDetails;
	}
	/**
	 * @param accountDetails the accountDetails to set
	 */
	public void setaccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {		
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {		
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the newUsername
	 */
	public String getNewUsername() {
		
		return newUsername;
	}
	/**
	 * @param newUsername the newUsername to set
	 */
	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the usernamePay
	 */
	public String getUsernamePay() {
		return usernamePay;
	}
	/**
	 * @param usernamePay the usernamePay to set
	 */
	public void setUsernamePay(String usernamePay) {
		this.usernamePay = usernamePay;
	}
	/**
	 * @return the usernameDowngrade
	 */
	public String getUsernameDowngrade() {
		return usernameDowngrade;
	}
	/**
	 * @param username the usernameDowngrade to set
	 */
	public void setUsernameDowngrade(String usernameDowngrade) {
		this.usernameDowngrade = usernameDowngrade;
	}
	/**
	 * @return the usernameUpgrade
	 */
	public String getUsernameUpgrade() {
		return usernameUpgrade;
	}
	/**
	 * @param username the usernameUpgrade to set
	 */
	public void setUsernameUpgrade(String usernameUpgrade) {
		this.usernameUpgrade = usernameUpgrade;
	}
	/**
	 * @return the usernameDowngradeSameSpeed
	 */
	public String getUsernameDowngradeSameSpeed() {
		return usernameDowngradeSameSpeed;
	}
	/**
	 * @param usernameDowngradeSameSpeed the usernameDowngradeSameSpeed to set
	 */
	public void setUsernameDowngradeSameSpeed(String usernameDowngradeSameSpeed) {
		this.usernameDowngradeSameSpeed = usernameDowngradeSameSpeed;
	}
	/**
	 * @return the usernameMobile
	 */
	public String getUsernameMobile() {
		return usernameMobile;
	}
	/**
	 * @param usernameMobile the usernameMobile to set
	 */
	public void setUsernameMobile(String usernameMobile) {
		this.usernameMobile = usernameMobile;
	}
	/**
	 * @return the dealerCode
	 */
	public String getDealercode() {
		return dealerCode;
	}
	/**
	 * @param dealerCode the dealerCode to set
	 */
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	
	/**
	 * @return the ssp environment
	 */
	public String getEnvironment() {
		return environment;
	}
	/**
	 * @param ssp environment the ssp environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	/**
	 * @return the sspEnv
	 */
	public String getSspEnv() {
		return sspEnv;
	}
	/**
	 * @param sspEnv the sspEnv to set
	 */
	public void setSspEnv(String sspEnv) {
		this.sspEnv = sspEnv;
	}
	
}
