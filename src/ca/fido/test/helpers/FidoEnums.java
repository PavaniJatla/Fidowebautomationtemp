package ca.fido.test.helpers;

public class FidoEnums {

	public enum OS {
        WIN, LIN, MAC
    };//
	
    public enum MakePayOptions {
	    Bank,
	    Creditcard,
	    Interac
	  };
	  
	public enum GroupName {
		connectedhome_anonymous,
		connectedhome_login,
		selfserve_login,
		selfserve,
		buyflows,
		connectedhome_ssp,
		buyflowsoneview
		  } ;
    
	public enum AddDataType {
			    MTT,
			    OTT,			   
			  };
			  
	public enum SauceCapabilities{
			    	seleniumVersion,
			    	maxDuration,
			    	commandTimeout,
			    	idleTimeout,
			    	build,
			    	browserVersion,
			    	platformName,
			    	platformVersion,
			    	appiumVersion,
			    	deviceName,
			    	deviceOrientation
			    };		  
}
