package ca.fido.yaml.pojo;

public class NACData {
	
	private String billingAddress;
	private String dlProvinceCode;
	private String ctnCity;
	private String deviceName;
	
	/**
	 * @return the name of the device
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	/**
	 * @param deviceName name of the device
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	/**
	 * @return the dlProvinceCode
	 */
	public String getDlProvinceCode() {
		return dlProvinceCode;
	}
	/**
	 * @param dlProvinceCode the dlProvinceCode to set
	 */
	public void setDlProvinceCode(String dlProvinceCode) {
		this.dlProvinceCode = dlProvinceCode;
	}
	/**
	 * @return the ctnCity
	 */
	public String getCtnCity() {
		return ctnCity;
	}
	/**
	 * @param ctnCity the ctnCity to set
	 */
	public void setCtnCity(String ctnCity) {
		this.ctnCity = ctnCity;
	}
	
}