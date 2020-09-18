package ca.fido.testdatamanagement;

import ca.fido.yaml.pojo.*;

public class TestDataHandler {
	
	public static Config config;
	public static Config bfaConfig;
	public static PaymentDetails paymentInfo;
	public static PaymentDetails chPaymentInfo;
	public static PaymentDetails bfaPaymentInfo;
	public static AccountData tc00101056;
	public static AccountData tc0203;
	public static AccountData tc0405;
	public static AccountData tc121315;
	public static AccountData tc1417;
	public static AccountData tc16;
	public static AccountData tc18;
	public static AccountData tc23;
	public static AccountData tc25;
	public static AccountData tc2732;
	public static AccountData tc28;
	public static AccountData tc31;
	public static AccountData tc33;
	public static AccountData tc34;
	public static AccountData tc4246;
	public static AccountData tc104447;
	public static AccountData tc4557;
	public static AccountData tc48;
	public static AccountData tc49;
	public static AccountData tc5055;
	public static AccountData tc54;
	public static AccountData tc1122;
	public static AccountData tc006009;
	public static AccountData tc5859;
	public static AccountData tc0301;
	public static AccountData tc41;
	public static AccountData tc43;
	public static AccountData tc04To09;
	public static AccountData tc39;
	public static AccountData tc40;
	public static AccountData tc02PreRegister;
	public static AccountData fidoHSIAccount;
	public static AccountData fidoHSIAccountwithUnwiredAddress;
	public static AccountData fidoSspHSIAccount;
	public static AccountData fidoHSIAnotherProvinceAddress;
	public static AccountData fidoHSIUnavailableAddress;
	public static NACData testCase01;
	public static NACData testCase02;
	public static HUPData testCase03;
	public static HUPData testCase04;
	public static HUPData testCase05;
	public static PPCData testCase06;
	public static PPCData testCase07;
	public static PPCData testCase08;
	public static AccountData tc6062;
	public static AccountData tc002003;
	public static AccountData tc61;
	public static AccountData tc53;
	public static SauceSettings sauceSettings;
	public static AccountData tc65;
	public static AccountData tc66;

	public static void dataInit (String strApplicationType) {	    	
	    	if(strApplicationType.toUpperCase().trim().endsWith("CH")) {	    	
	    		//HSI Fido Data files
	    		connectedHomeDataInit();            
	    	} else if(strApplicationType.toUpperCase().trim().endsWith("SS")
	    			||strApplicationType.toUpperCase().trim().endsWith("SS]")) {
		    	//Self-Service Data files
	    		selfserveDataInit();
	    	} else if(strApplicationType.toUpperCase().trim().endsWith("BFA")) {
	    		//Buy-Flows Data files
	    		buyFlowsDataInit();
	    	} else {
	    		//All Data files
	    		connectedHomeDataInit(); 
	    		selfserveDataInit();
	    		buyFlowsDataInit();
	    	}
    	
	}
	private static void connectedHomeDataInit() {
		sauceSettings = YamlHandler.getSauceSettings("/test-data/fido/connectedhome/SauceSettings.yml");
        fidoHSIAccount = YamlHandler.getHSIAccountData("HSIAccount");
    	fidoHSIAccountwithUnwiredAddress=YamlHandler.getHSIAccountData("HSIAccountwithUnwiredAddress");
        fidoSspHSIAccount = YamlHandler.getHSIAccountData("HSISspAccount");
        fidoHSIAnotherProvinceAddress=YamlHandler.getHSIAccountData("HSIAnotherProvinceAddress");
        fidoHSIUnavailableAddress=YamlHandler.getHSIAccountData("HSIUnavailableAddress");
        chPaymentInfo = YamlHandler.getHSIPaymentDetails();	
	}
	
	private static void selfserveDataInit() {
		config =  YamlHandler.getConfig();		
		sauceSettings = YamlHandler.getSauceSettings("/test-data/fido/selfserve/SauceSettings.yml");
    	paymentInfo = YamlHandler.getPaymentDetails();
    	tc00101056 = YamlHandler.getAccountData("tc001_010_56Prepaid");
    	tc0203 = YamlHandler.getAccountData("tc02_03Prepaid");
    	tc0301 = YamlHandler.getAccountData("tc03_01PreRegisterMultiLine");
    	tc31 = YamlHandler.getAccountData("tc31PreRegisterPrepaid");
    	tc0405 = YamlHandler.getAccountData("tc04_05Prepaid");
    	tc04To09 = YamlHandler.getAccountData("tc04-09Recovery");
    	tc006009 = YamlHandler.getAccountData("tc006_009Prepaid");	
    	tc1122 = YamlHandler.getAccountData("tc11_22Postpaid");	    	
    	tc121315 = YamlHandler.getAccountData("tc12_13_15PostPaid");
    	tc1417 = YamlHandler.getAccountData("tc14_17PostPaidWithAddressNProfileDetails");
    	tc16 = YamlHandler.getAccountData("tc16PostPaidWithBill");
    	tc18 = YamlHandler.getAccountData("tc18PostPaidWithSim");
    	tc23 = YamlHandler.getAccountData("tc23CancelledCTN");
    	tc25 = YamlHandler.getAccountData("tc25PostPaidLostStolen");
    	tc2732 = YamlHandler.getAccountData("tc27_32PostPaidWithVoiceMail");
    	tc28 = YamlHandler.getAccountData("tc28PostPaidSuspendedCTN");
    	tc33 = YamlHandler.getAccountData("tc33PostPaidToChangeUsername");
    	tc34 = YamlHandler.getAccountData("tc34PostPaidToChangePassword");
    	tc39 = YamlHandler.getAccountData("tc39PreRegisterCancelledBan");
    	tc40 = YamlHandler.getAccountData("tc40PreRegisterSuspendedBan");
    	tc41 = YamlHandler.getAccountData("tc41PreRegisterSingleLine");
    	tc43 = YamlHandler.getAccountData("tc43PreRegisterHsi");
    	tc4246 = YamlHandler.getAccountData("tc42_46HSI");
    	tc104447 = YamlHandler.getAccountData("tc10_44_47PostPaid");
    	tc4557 = YamlHandler.getAccountData("tc45_57Subscriber");
    	tc48 = YamlHandler.getAccountData("tc48PostPaidUnlimitedTalkTextOnly");
    	tc49 = YamlHandler.getAccountData("tc49PostPaidDataOnly");
    	tc5055 = YamlHandler.getAccountData("tc50_55PostPaidWithDataTalkText");
    	tc54 = YamlHandler.getAccountData("tc54PostPaidLimitedTalkTextOnly");
    	tc5859 = YamlHandler.getAccountData("tc58_59PostPaidDemoline");	    		    	    	  	    		    		    		    	  	    	    
    	tc6062 = YamlHandler.getAccountData("tc60_62PostPaidDemoline");
    	tc61 = YamlHandler.getAccountData("tc61PostPaidDemolineOTT");
    	tc53 = YamlHandler.getAccountData("tc53PostPaidDemolineRunningLow");
    	tc65 = YamlHandler.getAccountData("tc65PostPaidWithVoiceAndDataRunningLow");
    	tc66 = YamlHandler.getAccountData("tc66PostPaidWithVoiceAndDataOverage");
    	
	}
	
	private static void buyFlowsDataInit() {
		sauceSettings = YamlHandler.getSauceSettings("/test-data/fido/buyflows/SauceSettings.yml");
		bfaConfig = YamlHandler.getBFAConfig();
		bfaConfig = YamlHandler.getBFAConfig();
		bfaPaymentInfo = YamlHandler.getBFAPaymentDetails();
    	testCase01 = YamlHandler.getNACData("tc01NAC");
    	testCase02 = YamlHandler.getNACData("tc02NAC");
    	testCase03 = YamlHandler.getHUPData("tc03HUP");
    	testCase04 = YamlHandler.getHUPData("tc04HUP");
    	testCase05 = YamlHandler.getHUPData("tc05HUP");
    	testCase06 = YamlHandler.getPPCData("tc06PPC");
    	testCase07 = YamlHandler.getPPCData("tc07AAL");
    	testCase08 = YamlHandler.getPPCData("tc08AALTerm");
	}

}
