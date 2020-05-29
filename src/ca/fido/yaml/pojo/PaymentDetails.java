package ca.fido.yaml.pojo;

public class PaymentDetails {
	
	private CreditCardDetails creditCardDetails;
	private BankDetails bankDetails;
	private PaymentType paymentType;
	private InteracDetails interacDetails;
	/**
	 * @return the creditCardDetails
	 */
	public CreditCardDetails getCreditCardDetails() {
		return creditCardDetails;
	}
	/**
	 * @param creditCardDetails the creditCardDetails to set
	 */
	public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
	}
	/**
	 * @return the bankDetails
	 */
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	/**
	 * @param bankDetails the bankDetails to set
	 */
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	/**
	 * @return the paymentType
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the interacDetails
	 */
	public InteracDetails getInteracDetails() {
		return interacDetails;
	}
	/**
	 * @param interacDetails the interacDetails to set
	 */
	public void setInteracDetails(InteracDetails interacDetails) {
		this.interacDetails = interacDetails;
	}
	

}
