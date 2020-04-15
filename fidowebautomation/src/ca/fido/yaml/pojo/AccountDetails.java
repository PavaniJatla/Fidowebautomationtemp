package ca.fido.yaml.pojo;

import java.util.Map;




public class AccountDetails {
	
	private String type;
	private String ban;
	private String ctn;
	private String postalCode;
	private String email;
	private String password;
	private String phoneNumber;
	private String newPassword;
	private String recoveryNumber;
	private Map<String, String> address;
	private String emailAddress; 
	private String mobilePhone;
	private String homePhone;
	private String businessPhone;
	private String simCardNumber;
	private String language;
	private String voicemailPassword;
	private String upgradePlan;
	private String downgradePlan;
	private String upgradeBundle;
	private String downgradeBundle;
	private String payment;
	private String upgradePlanCost;
	private String downgradePlanCost;
	private String upgradeDataPlan;
	private String downgradeDataPlan;
	private String modem;
	private String newModem;
	
	public AccountDetails() {
		
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param SwapoutChannel the SwapoutChannel to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the address
	 */
    public Map<String, String> getAddress() {
        return address;
    }
    
	/**
	 * @param address the address to set
	 */
    public void setAddress(Map<String, String> address) {
        this.address = address;
    }
	/**
	 * @param upgradeDataPlan the upgradeDataPlan to set
	 */
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * @return the recoveryNumber
	 */
	public String getRecoveryNumber() {
		return recoveryNumber;
	}
	/**
	 * @param recoveryNumber the recoveryNumber to set
	 */
	public void setRecoveryNumber(String recoveryNumber) {
		this.recoveryNumber = recoveryNumber;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @return the businessPhone
	 */
	public String getBusinessPhone() {
		return businessPhone;
	}
	/**
	 * @param businessPhone the businessPhone to set
	 */
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the simCardNumber
	 */
	public String getSimCardNumber() {
		return simCardNumber;
	}
	/**
	 * @param simCardNumber the simCardNumber to set
	 */
	public void setSimCardNumber(String simCardNumber) {
		this.simCardNumber = simCardNumber;
	}
	/**
	 * @return the ban
	 */
	public String getBan() {
		return ban;
	}
	/**
	 * @param ban the ban to set
	 */
	public void setBan(String ban) {
		this.ban = ban;
	}
	/**
	 * @return the ctn
	 */
	public String getCtn() {
		return ctn;
	}
	/**
	 * @param ctn the ctn to set
	 */
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}
	/**
	 * @return the voicemailPassword
	 */
	public String getVoicemailPassword() {
		return voicemailPassword;
	}
	/**
	 * @param voicemailPassword the voicemailPassword to set
	 */
	public void setVoicemailPassword(String voicemailPassword) {
		this.voicemailPassword = voicemailPassword;
	}
	
	/**
	 * @return the modem
	 */
	public String getModem() {
		return modem;
	}
	/**
	 * @param modem the type to set
	 */
	public void setModem(String modem) {
		this.modem = modem;
	}
	
	/**
	 * @return the new modem
	 */
	public String getNewModem() {
		return newModem;
	}
	/**
	 * @param new modem the type to set
	 */
	public void setNewModem(String newModem) {
		this.newModem = newModem;
	}

	/**
	 * @return the upgradePlan
	 */
	public String getUpgradePlan() {
		return upgradePlan;
	}
	/**
	 * @param upgradePlan the upgradePlan to set
	 */
	public void setUpgradePlan(String upgradePlan) {
		this.upgradePlan = upgradePlan;
	}
	/**
	 * @return the upgradePlan
	 */
	public String getUpgradeBundle() {
		return upgradeBundle;
	}
	/**
	 * @param upgradePlan the upgradePlan to set
	 */
	public void setUpgradeBundle(String upgradeBundle) {
		this.upgradeBundle = upgradeBundle;
	}
	/**
	 * @return the downgradePlan
	 */
	public String getDowngradePlan() {
		return downgradePlan;
	}
	/**
	 * @param downgradePlan the downgradePlan to set
	 */
	public void setDowngradePlan(String downgradePlan) {
		this.downgradePlan = downgradePlan;
	}
	/**
	 * @return the downgradePlan
	 */
	public String getDowngradeBundle() {
		return downgradeBundle;
	}
	/**
	 * @param downgradePlan the downgradePlan to set
	 */
	public void setDowngradeBundle(String downgradeBundle) {
		this.downgradeBundle = downgradeBundle;
	}

	/**
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param SwapoutChannel the SwapoutChannel to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * @return the planCost
	 */
	public String getUpgradePlanCost() {
		return upgradePlanCost;
	}
	/**
	 * @param planCostToBeUpgrade
	 */
	public void setUpgradePlanCost(String upgradePlanCost) {
		this.upgradePlanCost = upgradePlanCost;
	}
	/**
	 * @return the planCost
	 */
	public String getDowngradePlanCost() {
		return downgradePlanCost;
	}
	/**
	 * @param planCostToBeDowngrade 
	 */
	public void setDowngradePlanCost(String downgradePlanCost) {
		this.downgradePlanCost = downgradePlanCost;
	}
	/**
	 * @param upgradeDataPlan the upgradeDataPlan to set
	 */
	public void setUpgradeDataPlan(String upgradeDataPlan) {
		this.upgradeDataPlan = upgradeDataPlan;
	}
	/**
	 * @return the upgradeDataPlan
	 */
	public String getUpgradeDataPlan() {
		return upgradeDataPlan;
	}
	/**
	 * @param downgradeDataPlan the downgradeDataPlan to set
	 */
	public void setDowngradeDataPlan(String downgradeDataPlan) {
		this.downgradeDataPlan = downgradeDataPlan;
	}
	/**
	 * @return the downgradeDataPlan
	 */
	public String getDowngradeDataPlan() {
		return downgradeDataPlan;
	}

}
