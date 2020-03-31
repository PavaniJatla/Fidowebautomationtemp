package ca.fido.yaml.pojo;

public class BankDetails {
	
	private String transitCode;
	private String bankCode;
	private String accountNumber;
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	/**
	 * @return the transitCode
	 */
	public String getTransitCode() {
		return transitCode;
	}
	/**
	 * @param transitCode the transitCode to set
	 */
	public void setTransitCode(String transitCode) {
		this.transitCode = transitCode;
	}

}
