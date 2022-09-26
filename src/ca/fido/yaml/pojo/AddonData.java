package ca.fido.yaml.pojo;

public class AddonData {
    private String addonName;
    private String username;
    private String password;
    private String ctn;
    private String ban;
    private String dpIMEI;
    private String dpDeviceStorage;
    private String dpDeviceColor;

    /**
     * @return the newAddon
     */
    public String getAddonName() {
        return addonName;
    }
    /**
     * @param addonName the newAddon to set
     */
    public void setAddonName(String addonName) {
        this.addonName = addonName;
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
    public String getCtn() {
        return ctn;
    }
    public void setCtn(String ctn) {
        this.ctn = ctn;
    }
    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
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
