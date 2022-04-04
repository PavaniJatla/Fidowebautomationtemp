package ca.fido.yaml.pojo;

public class NACData {
	
	private String billingAddress;
	private String dlProvinceCode;
	private String ctnCity;
	private String deviceName;
	private String identificationType;
	private String contactNumber;
	private String username;
	private String deviceCostIndex;
	private String dataOptionIndex;
	private String promoCode;
	private String dpIMEI;
	private String dpDeviceStorage;
	private String dpDeviceColor;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

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
	
	/**
	 * @return the identificationType
	 */
	public String getIdentificationType() {
		return identificationType;
	}

	/**
	 * @param identificationType the identificationType to set
	 */
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * @return the DeviceCostIndex
	 */
	public String getDeviceCostIndex() {
		return deviceCostIndex;
	}
	/**
	 * @param deviceCostIndex the DeviceCostIndex to set
	 */
	public void setDeviceCostIndex(String deviceCostIndex) {
		this.deviceCostIndex = deviceCostIndex;
	}
	/**
	 * @return the DataOptionIndex
	 */
	public String getDataOptionIndex() {
		return dataOptionIndex;
	}
	/**
	 * @param dataOptionIndex the DataOptionIndex to set
	 */
	public void setDataOptionIndex(String dataOptionIndex) {
		this.dataOptionIndex = dataOptionIndex;
	}

	/**
	 * @return the Promo Code
	 */
	public String getPromoCode() {return promoCode;}
	/**
	 * @param promoCode Promocode to set
	 */
	public void setPromoCode(String promoCode){
		this.promoCode = promoCode;
	}
	/**
	 * @return the DP IMEI from yaml
	 */
	public String getDpIMEI() {
		return dpIMEI;
	}
	/**
	 * @param dpIMEI DP IMEI to set
	 */
	public void setDpIMEI(String dpIMEI) {
		this.dpIMEI = dpIMEI;
	}
	/**
	 * @return the DP Device Storage from yaml
	 */
	public String getDpDeviceStorage() {
		return dpDeviceStorage;
	}
	/**
	 * @param dpDeviceStorage DP IMEI to set
	 */
	public void setDpDeviceStorage(String dpDeviceStorage) {
		this.dpDeviceStorage = dpDeviceStorage;
	}
	/**
	 * @return the DP Device Color from yaml
	 */
	public String getDpDeviceColor() {
		return dpDeviceColor;
	}
	/**
	 * @param dpDeviceColor DP IMEI to set
	 */
	public void setDpDeviceColor(String dpDeviceColor) {
		this.dpDeviceColor = dpDeviceColor;
	}

}