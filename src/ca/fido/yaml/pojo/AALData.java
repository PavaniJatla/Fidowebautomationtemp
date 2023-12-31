package ca.fido.yaml.pojo;

public class AALData {

	private String newDevice;
	private String newPlanCategory;
	private String username;
	private String password;
	private String ctnCity;
	private String ctn;
	private String newPlanType;
	private String deviceCostIndex;
	private String dataOptionIndex;
	private String cityName;
	private String shippingType;
	private String ban;
	private String promoCode;
	private String dpIMEI;
	private String dpDeviceStorage;
	private String dpDeviceColor;
	private String portInNumber;
	private String newShippingAddress;

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
	 * @return the newDevice
	 */
	public String getNewDevice() {
		return newDevice;
	}
	/**
	 * @param newDevice the newDevice to set
	 */
	public void setNewDevice(String newDevice) {
		this.newDevice = newDevice;
	}
	/**
	 * @return the newPlanCategory
	 */
	public String getNewPlanCategory() {
		return newPlanCategory;
	}
	/**
	 * @param newPlanCategory the newPlanCategory to set
	 */
	public void setNewPlanCategory(String newPlanCategory) {
		this.newPlanCategory = newPlanCategory;
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
	public String getCtn() {
		return ctn;
	}
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}
	public String getNewPlanType() {
		return newPlanType;
	}
	public void setNewPlanType(String newPlanType) {
		this.newPlanType = newPlanType;
	}
	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
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
	 * @return the CityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the CityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the ShippingType
	 */
	public String getShippingType() {
		return shippingType;
	}
	/**
	 * @param shippingType the ShippingType to set
	 */
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
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
	/**
	 * @return the PortIn Number from yaml
	 */
	public String getPortInNumber() {
		return portInNumber;
	}
	/**
	 * @param portInNumber PortIn Number to set
	 */
	public void setPortInNumber(String portInNumber) {
		this.portInNumber = portInNumber;
	}
	/**
	 * @return the new Shipping Address from yaml
	 */
	public String getNewShippingAddress() {
		return newShippingAddress;
	}
	/**
	 * @param newShippingAddress to set
	 */
	public void setNewShippingAddress(String newShippingAddress) {
		this.newShippingAddress = newShippingAddress;
	}
}
