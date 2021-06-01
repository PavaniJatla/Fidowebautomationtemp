package com.rogers.testdatamanagement;

import com.rogers.yaml.pojo.*;
import org.testng.ITestNGMethod;

import java.io.FileNotFoundException;
import java.util.List;

public class TestDataHandler {	
	public static Config ssConfig;
	public static PaymentDetails paymentInfo;
	public static Config bfaConfig;
	public static PaymentDetails bfaPaymentInfo;
	public static PaymentDetails chPaymentInfo;	
	public static AccountData tc013132;
	public static AccountData tc0224;
	public static AccountData tc041139;
	public static AccountData tc060809;
	public static AccountData tc1314;
	public static AccountData tc161825;
	public static AccountData tc1920;
	public static AccountData tc2751;
	public static AccountData tc36;
	public static AccountData tc495271;
	public static AccountData tc5074;
	public static AccountData tc54;
	public static AccountData tc55;
	public static AccountData tc56;
	public static AccountData tc57;
	public static AccountData tc58;
	public static AccountData tc59;
	public static AccountData tc6269;
	public static AccountData tc63;
	public static AccountData tc64;
	public static AccountData tc6577;
	public static AccountData tc727375;
	public static AccountData tc02;
	public static AccountData tc07;
	public static AccountData tc61;
	public static AccountData tc67;	
	public static AccountData tc78;
	public static AccountData tc7681;
	public static AccountData tc82;
	public static AccountData tc80;
	public static AccountData tc43_44_digitalTVAccount;
	public static AccountData tc16_17_18_19_SolarisInternetAccount;
	public static AccountData tc01_02_03_IgniteTVAccount;
	public static AccountData tc05_IgniteTV4Plus1Account;
	public static AccountData tc41IgniteTVAccount;
	public static AccountData tc04_07_SolarisTVAccount;
	public static AccountData tc22_StandaloneInternetAccountWithUsage;
	public static AccountData tc48_legacyRHP;
	public static AccountData tc42_igniteRHP;
	public static AccountData tc27_28_RogersSHM;
	public static AccountData tc15_SolarisInternetAccountWithUsage;
	public static AccountData tc42SolarisInternetAccountWithUsage;
	public static AccountData tc20_SolarisInternetAccountForUpgrade;
	public static AccountData tc09_SolarisTVAccountForUpgrade;
	public static AccountData tcm05_SolarisTVAccountForUpgrade;
	public static AccountData tc14_solarisTVAccountStarterPackage;
	public static AccountData tc14_SolarisTVAccountFlex5Package;
	public static AccountData tc14_solarisTVAccountPopularPackage;
	public static AccountData tc10_SolarisTVAccountForUpgradeON;
	public static AccountData tc12_SolarisTVAccountForUpgradeNL;
	public static AccountData tc11_SolarisTVAccountForUpgradeNB;
	public static AccountData tc37_internetAccountUpgrade;
	public static AccountData tc45_digitalTVAccountUpgradePackage;
	public static AccountData tc54_iginteTVWirelessCRMaddressMismatchWithSGI;
	public static AccountData tc55_rCISandECIDLowRiskMediumRiskAddressRetry;
	public static AccountData tc61_SHMSignedInInternetBuyDiffAddress;
	public static AccountData tc56_WirelessSignedInInternetBuyBasement;
	public static AccountData tc46_legacyInternetAccount;
	public static AccountData tcm04_SolarisInternetAccount;
	public static AccountData tcm06_IgniteTVAccount;
	public static AccountData tc39_40_SolarisPortinFlows;
	public static AccountData tc38_DigitalTVUpgradeToIgnite;
	public static AccountData tc21_SolarisInternetOldConstructor;
	public static AccountData tc08_SolarisTVOldConstructor;
	public static AccountData tc34_NoPortInAbondoneFlows;
	public static AccountData solarisInternetPackageChange;
	public static AccountData solarisTVAccountPackageUpgrade;
	public static AccountData solarisMultipleSubscriptions;
	public static AccountData tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack;
	public static AccountData tc06_2_SolarisChangeTVManageChannels;
	public static AccountData tc06_1_SolarisChangeTVManageThemePacks;
	public static AccountData tc35_CRMaddressMismatchWithSGI;
	public static AccountData tc62_wirelessSignedInInternetBuy;
	public static AccountData tc60_WirelessSignedInInternetBuyDiffAddress;
	public static AccountData tc63_ShmSignedInInternetBuyBasement;
	public static AccountData tc65_IgniteSmartStreamNL;
	public static AccountData tc73_IgniteTVAccountMultipleSwap;
	public static AccountData tc74_SaiBaseLineHomeAddress;
	public static AccountData tc75_IgniteTVBaseLineHomeAddress;
	public static AccountData tc76_Legact2Pto3PIgniteBasementHousePortinHot;
	public static AccountData tc82_Legacy1PtoIgnite2P;
	public static AccountData tc83_Legacy2PtoIgnite2P;
	public static AccountData tc57_sHMSignedInInternetBuy;
	public static AccountData tc51_igniteSmartStream;
	public static AccountData tc31_SolarisInternetAccountWithUsageAndPackageUpgrade;
	public static AccountData tc23_24_standaloneInternetAccountforUpgrade;
	public static AccountData solarisConsumerNoPortinCartAbandon;
	public static AccountData solarisConsumerPortInCartAbandon;
	public static AccountData tc58_saiAccountForIgniteBundleBuy;
	public static AccountData tc59_saiforIgniteBundle;
	public static AccountData solarisConsumerGWPDigitalTV;
	public static AccountData solarisConsumerGWPInternetDTV;
	public static AccountData solarisConsumerGWPRhpDtv ;
	public static AccountData solarisConsumerGWPShmDtv;
	public static AccountData solarisConsumerGWPDtvWireless;
	public static AccountData solarisConsumerGWPLegacyInternet;
	public static AccountData solarisConsumerGWPInternetandRHP;
	public static AccountData solarisConsumerGWPInternetSHM;
	public static AccountData solarisConsumerGWPRhp;
	public static AccountData solarisConsumerGWPRhpShm;
	public static AccountData solarisHTOMigrationSignIn;
	public static RedesignRpotgData tc01NACTermNpotgSS;
	public static RedesignRpotgData tc02NACNoTermStandardShipping;
	public static RedesignRpotgData tc03NACTermPotgShipping;
	public static RedesignRpotgData tc04NACTermBopis;
	public static RedesignRpotgData tc05NACByodSS;
	public static RedesignRpotgData tc06NACByodTermBopis;
	public static AALData tc07AAL;
	public static PPCData tc08PPC;
	public static HUPData tc09HupPpcPotgSharedML;
	public static HUPData tc10HUPAdditionalLine;
	public static HUPData tc11HUPNpotgML;
	public static HUPData tc12HUPNonShareNoTermSL;
	public static HUPData tc13HUPShareNoTermSL;
	public static HUPData tc14HUPShareKeepCurrentPlanTermML;
	public static HUPData tc15HUPNonShareKeepCurrentPlanSL;
	public static HUPData tc16HUPShareTermBopisML;
	public static AALData tc17AALShareTermBopis;
	public static AALData tc18AALFinPlanPotgShipping;
	public static AALData tc19AALNoTermStandardShipping;
	public static AALData tc20AALTermTablet;
	public static AALData tc21AALBYODBopisShipping;
	public static AALData tc22AALBYODStandardShipping;
	public static HUPData buyFlowsOVtestCase01;
	public static HUPData buyFlowsOVtestCase02;
	public static HUPData buyFlowsOVtestCase05;
	public static HUPData buyFlowsOVtestCase06;
	public static PPCData buyFlowsOVtestCase03;
	public static PPCData buyFlowsOVtestCase04;
	public static PPCData buyFlowsOVtestCase07;
	public static AALOVData buyFlowsOVtestCase08;
	public static AALOVData buyFlowsOVtestCase09;
	public static AALOVData buyFlowsOVtestCase10;
	public static SauceSettings sauceSettings;
	public static AccountData igniteTVParentalcontrols;
	public static AccountData solarisAccount;
	public static AccountData solarisTV;
	public static ContactData anonymousData;
	public static MigrationData migrationData;
	public static PaymentDetails ovPaymentInfo;
	public static AccountData tc60;
	public static RedesignConfig redesignConfig;
	public static AccountData tc40SHMAccount;
	public static AccountData tc47TupeloAccount;
	public static AccountData tc43IgniteRHP;
	public static AccountData tc44DigitalTVAccount;
	public static AccountData tc45LegacyInternetAccount;
	public static AccountData tc46LegacyRHP;
	public static AccountData tc53_iHPAccount;
	public static AccountData shmAccount;
	public static AccountData tupeloAccount;
	public static Config bfaOneViewConfig;
	public static PaymentDetails bfaOneViewPaymentInfo;
	public static AccountData tc0610;
	public static Config rogersConfig;
	public static AccountData tc01030405;
	public static AccountData tc92;
	public static AccountData tc95;
	public static AccountData tc90;
	public static AccountData tc5398;
	public static AccountData tc94;
	public static AccountData tc101;
	public static AccountData tc102;
	public static AccountData tc103;
	public static AccountData tc100;
	public static AccountData tc99;
	public static Config searchCBSConfig;
	public static AccountData tc104;
	public static AccountData tc22;
	public static AccountData tc23;
	public static AccountData tc111;
	public static AccountData tc112;
	public static AccountData tc01FinanceNotPaidOff_ON;
	public static AccountData tc37_NoBills;
	public static  AccountData tc118;
	public static AccountData tc124;
	public static AccountData tc126;
	
	public static void dataInit (List<ITestNGMethod> lstTestMethodName) throws FileNotFoundException {
 		sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/SauceSettings.yml");

		String strTestMethodName = lstTestMethodName.toString();
		boolean match = false;
		if(strTestMethodName.contains("connectedhome.") || strTestMethodName.contains("solarisconsumer.")) {
			//HSI Fido Data files
			connectedHomeDataInit();
			match = true;
		}
		if(strTestMethodName.contains("selfserve.")) {
			//Self-Service Data files
			selfserveDataInit();
			match = true;
		}
		if(strTestMethodName.contains("buyflows.")) {
			//Buy-Flows Data files
			buyFlowsDataInit();
			match = true;
		}
		if(strTestMethodName.contains("buyflowsoneview.")) {
			//Buy-Flows Data files
			buyFlowsOneViewDataInit();
			match = true;
		}
		if(strTestMethodName.contains("choneview.")) {
			//Buy-Flows Data files
			chOneViewDataInit();
			match = true;
		}
		if(strTestMethodName.contains("search.")||strTestMethodName.contains("serviceability.")) {
			//No yaml data files to initialize
			match = true;
		}
		if (!match) {
			//All Data files
			connectedHomeDataInit();
			selfserveDataInit();
			buyFlowsDataInit();
			chOneViewDataInit();
			buyFlowsOneViewDataInit();
		}
	}
	
	private static void connectedHomeDataInit() throws FileNotFoundException {
      	chPaymentInfo = YamlHandler.getCablePaymentDetails();
		rogersConfig = YamlHandler.getBFAConfig();

      	//Digital TV test data
		tc51_igniteSmartStream = YamlHandler.getCableAccountData("TC51_IgniteSmartStream");
    	tc43_44_digitalTVAccount = YamlHandler.getCableAccountData("TC43_44_DigitalTVAccount");
    	tc38_DigitalTVUpgradeToIgnite = YamlHandler.getCableAccountData("TC38_DigitalTVUpgradeToIgnite");
    	tc45_digitalTVAccountUpgradePackage = YamlHandler.getCableAccountData("TC45_DigitalTVAccountUpgradePackage");
    	tc34_NoPortInAbondoneFlows = YamlHandler.getCableAccountData("TC34_NoPortInAbondoneFlows");
    	solarisConsumerNoPortinCartAbandon= YamlHandler.getCableAccountData("SolarisConsumerNoPortinCartAbandon");
		solarisConsumerPortInCartAbandon=YamlHandler.getCableAccountData("SolarisConsumerPortInCartAbandon");
		solarisConsumerGWPDigitalTV=YamlHandler.getCableAccountData("solarisConsumerGWPDigitalTV");
		solarisConsumerGWPInternetDTV=YamlHandler.getCableAccountData("solarisConsumerGWPInternetDTV");
		solarisConsumerGWPShmDtv = YamlHandler.getCableAccountData("solarisConsumerGWPDTVSHM");
		solarisConsumerGWPRhpDtv = YamlHandler.getCableAccountData("solarisConsumerGWPDTVRHP");
		solarisConsumerGWPDtvWireless = YamlHandler.getCableAccountData("solarisConsumerGWPDtvWireless");
		solarisConsumerGWPLegacyInternet = YamlHandler.getCableAccountData("solarisConsumerGWPLegacyInternet");
		solarisConsumerGWPInternetandRHP = YamlHandler.getCableAccountData("solarisConsumerGWPInternetandRHP");
		solarisConsumerGWPInternetSHM = YamlHandler.getCableAccountData("solarisConsumerGWPInternetSHM");
		solarisConsumerGWPRhp = YamlHandler.getCableAccountData("solarisConsumerGWPRhp");
		solarisConsumerGWPRhpShm = YamlHandler.getCableAccountData("solarisConsumerGWPRhpShm");
		
    	//Legacy Internet test data
		tc46_legacyInternetAccount = YamlHandler.getCableAccountData("TC46_LegacyInternetAccount");
		tc62_wirelessSignedInInternetBuy = YamlHandler.getCableAccountData("TC62_WirelessSignedInInternetBuy");
		tc57_sHMSignedInInternetBuy = YamlHandler.getCableAccountData("TC57_SHMSignedInInternetBuy");
		tc58_saiAccountForIgniteBundleBuy = YamlHandler.getCableAccountData("TC58_SaiAccountForIgniteBundleBuy");
		tc59_saiforIgniteBundle = YamlHandler.getCableAccountData("TC59_SAIforIgniteBundle");

		//RHP test data
		tc48_legacyRHP = YamlHandler.getCableAccountData("TC48_LegacyRHP");
    	tc42_igniteRHP = YamlHandler.getCableAccountData("TC42_IgniteRHP");
    	tc27_28_RogersSHM = YamlHandler.getCableAccountData("TC27_28_RogersSHM");
    	solarisMultipleSubscriptions = YamlHandler.getCableAccountData("SolarisMultipleSubscriptions");
		tc53_iHPAccount = YamlHandler.getCableAccountData("TC53_IHPAccount");
    	//Ignite Internet test data
		tcm06_IgniteTVAccount=YamlHandler.getCableAccountData("TCM06_IgniteTVAccount");
		tcm04_SolarisInternetAccount = YamlHandler.getCableAccountData("TCM04_SolarisInternetAccount");
    	tc16_17_18_19_SolarisInternetAccount = YamlHandler.getCableAccountData("TC16_17_18_19_SolarisInternetAccount");
    	tc37_internetAccountUpgrade   = YamlHandler.getCableAccountData("TC37_InternetAccountUpgrade");
		tc23_24_standaloneInternetAccountforUpgrade   = YamlHandler.getCableAccountData("TC23_24_StandaloneInternetAccountforUpgrade");
    	tc15_SolarisInternetAccountWithUsage = YamlHandler.getCableAccountData("TC15_SolarisInternetAccountWithUsage");
		tc20_SolarisInternetAccountForUpgrade = YamlHandler.getCableAccountData("TC20_SolarisInternetAccountForUpgrade");
    	tc22_StandaloneInternetAccountWithUsage = YamlHandler.getCableAccountData("TC22_StandaloneInternetAccountWithUsage");
		tc21_SolarisInternetOldConstructor = YamlHandler.getCableAccountData("TC21_SolarisInternetOldConstructor");
    	solarisInternetPackageChange = YamlHandler.getCableAccountData("SolarisInternetPackageChange");
    	tc31_SolarisInternetAccountWithUsageAndPackageUpgrade = YamlHandler.getCableAccountData("TC31_SolarisInternetAccountWithUsageAndPackageUpgrade");
		tc54_iginteTVWirelessCRMaddressMismatchWithSGI=YamlHandler.getCableAccountData("TC54_IginteTVWirelessCRMaddressMismatchWithSGI");
		tc55_rCISandECIDLowRiskMediumRiskAddressRetry=YamlHandler.getCableAccountData("TC55_RCISandECIDLowRiskMediumRiskAddressRetry");
		tc60_WirelessSignedInInternetBuyDiffAddress=YamlHandler.getCableAccountData("TC60_WirelessSignedInInternetBuyDiffAddress");
		tc61_SHMSignedInInternetBuyDiffAddress=YamlHandler.getCableAccountData("TC61_SHMSignedInInternetBuyDiffAddress");
		tc56_WirelessSignedInInternetBuyBasement=YamlHandler.getCableAccountData("TC56_WirelessSignedInInternetBuyBasement");
		tc63_ShmSignedInInternetBuyBasement=YamlHandler.getCableAccountData("TC63_ShmSignedInInternetBuyBasement");
		//Ignite TV test data
		tcm05_SolarisTVAccountForUpgrade  = YamlHandler.getCableAccountData("TCM05_SolarisTVAccountForUpgrade");
		tc35_CRMaddressMismatchWithSGI = YamlHandler.getCableAccountData("TC35_CRMaddressMismatchWithSGI");
		tc01_02_03_IgniteTVAccount = YamlHandler.getCableAccountData("TC01_02_03_IgniteTVAccount");
		tc05_IgniteTV4Plus1Account = YamlHandler.getCableAccountData("TC05_IgniteTV4Plus1Account");
    	tc04_07_SolarisTVAccount = YamlHandler.getCableAccountData("TC04_07_SolarisTVAccount");
    	tc39_40_SolarisPortinFlows = YamlHandler.getCableAccountData("TC39_40_SolarisPortinFlows");
    	tc14_solarisTVAccountStarterPackage = YamlHandler.getCableAccountData("TC14_SolarisTVAccountStarterPackage");
    	tc14_SolarisTVAccountFlex5Package = YamlHandler.getCableAccountData("TC14_SolarisTVAccountFlex5Package");
    	tc14_solarisTVAccountPopularPackage = YamlHandler.getCableAccountData("TC14_SolarisTVAccountPopularPackage");
    	tc09_SolarisTVAccountForUpgrade = YamlHandler.getCableAccountData("TC09_SolarisTVAccountForUpgrade");
    	tc10_SolarisTVAccountForUpgradeON = YamlHandler.getCableAccountData("TC10_SolarisTVAccountForUpgradeON");
    	tc12_SolarisTVAccountForUpgradeNL = YamlHandler.getCableAccountData("TC12_SolarisTVAccountForUpgradeNL");
    	tc11_SolarisTVAccountForUpgradeNB = YamlHandler.getCableAccountData("TC11_SolarisTVAccountForUpgradeNB");
    	tc08_SolarisTVOldConstructor = YamlHandler.getCableAccountData("TC08_SolarisTVOldConstructor");
    	solarisTVAccountPackageUpgrade = YamlHandler.getCableAccountData("SolarisTVPackageChange");
    	tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack = YamlHandler.getCableAccountData("TC13_SolarisChangeTVPackageAdd4KChannelsAndThemePack");
    	tc06_2_SolarisChangeTVManageChannels = YamlHandler.getCableAccountData("TC06_2_SolarisChangeTVManageChannels");
    	tc06_1_SolarisChangeTVManageThemePacks = YamlHandler.getCableAccountData("TC06_1_SolarisChangeTVManageThemePacks");
    	solarisHTOMigrationSignIn = YamlHandler.getCableAccountData("SolarisHTOMigrationSignIn");
		tc65_IgniteSmartStreamNL= YamlHandler.getCableAccountData("TC65_IgniteSmartStreamNL");
		tc73_IgniteTVAccountMultipleSwap= YamlHandler.getCableAccountData("TC73_IgniteTVAccountMultipleSwap");
		tc74_SaiBaseLineHomeAddress= YamlHandler.getCableAccountData("TC74_SaiBaseLineHomeAddress");
		tc75_IgniteTVBaseLineHomeAddress= YamlHandler.getCableAccountData("TC75_IgniteTVBaseLineHomeAddress");
		tc76_Legact2Pto3PIgniteBasementHousePortinHot= YamlHandler.getCableAccountData("TC76_Legact2Pto3PIgniteBasementHousePortinHot");
		tc82_Legacy1PtoIgnite2P= YamlHandler.getCableAccountData("TC82_Legacy1PtoIgnite2P");
		tc83_Legacy2PtoIgnite2P= YamlHandler.getCableAccountData("TC83_Legacy2PtoIgnite2P");
		}
	
	private static void selfserveDataInit() throws FileNotFoundException {
    	ssConfig =  YamlHandler.getSSConfig();
    	//sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/selfserve/SauceSettings.yml");
    	paymentInfo = YamlHandler.getSSPaymentDetails();
    	tc013132 = YamlHandler.getSSAccountData("tc01_31_32Postpaid");
    	tc0224 = YamlHandler.getSSAccountData("tc02_24PostpaidLostStolen");
    	tc041139 = YamlHandler.getSSAccountData("tc04_11_39PostpaidLinkAccount");
    	tc060809 = YamlHandler.getSSAccountData("tc06_08_09RecoveryBySMS");
    	tc1314 = YamlHandler.getSSAccountData("tc13_14PostPaidWithSIM");
    	tc161825 = YamlHandler.getSSAccountData("tc16_18_25PostpaidPayment");
    	tc1920 = YamlHandler.getSSAccountData("tc19_20PostpaidPayment");
    	tc2751 = YamlHandler.getSSAccountData("tc27_51PostpaidWithVoicemail");
    	tc36 = YamlHandler.getSSAccountData("tc36PostpaidWithBill");
    	tc495271 = YamlHandler.getSSAccountData("tc49_52_71NSE");
    	tc5074 = YamlHandler.getSSAccountData("tc50_74InfiniteSE(Demoline)");
    	tc54 = YamlHandler.getSSAccountData("tc54NSEwithUnlimitedTTOnlyPlan");
    	tc55 = YamlHandler.getSSAccountData("tc55NSEwithLimitedTTOnlyPlan");
    	tc56 = YamlHandler.getSSAccountData("tc56NSEwithDataOnlyPlan");
    	tc57 = YamlHandler.getSSAccountData("tc57NSEwDataUnlimitedTTPlan");
    	tc58 = YamlHandler.getSSAccountData("tc58NSEwDataLimitedTTPlan");
    	tc59 = YamlHandler.getSSAccountData("tc59NSEwDataUnlimitedTTPlanRunningLow");
    	tc61 = YamlHandler.getSSAccountData("tc61SEPlanRunningLow(Demoline)");
    	tc6269 = YamlHandler.getSSAccountData("tc62_69InfiniteSE(Demoline)");
    	tc63 = YamlHandler.getSSAccountData("tc63NSEindividualRunningLow");
    	tc64 = YamlHandler.getSSAccountData("tc64InfiniteNSEReducedSpeed");
    	tc6577 = YamlHandler.getSSAccountData("tc65_77InfiniteNSE");
    	tc727375 = YamlHandler.getSSAccountData("tc72_73_75NSE");
    	tc02 = YamlHandler.getSSAccountData("tc02_PreRegister");
    	tc07 = YamlHandler.getSSAccountData("tc07RecoverUsernameByEmail");
    	tc67 = YamlHandler.getSSAccountData("tc67InfiniteSEReducedSpeed(Demoline)");    
    	tc7681 = YamlHandler.getSSAccountData("tc76_81SEPlanWith6Ctns(Demoline)"); 
    	tc78 = YamlHandler.getSSAccountData("tc78NSESingleLine");    	    	
    	tc60 = YamlHandler.getSSAccountData("tc60SEMultipleCTN");
    	tc80 = YamlHandler.getSSAccountData("TC80NSEwOverage");
    	tc82 = YamlHandler.getSSAccountData("tc82InfiniteSE");
    	tc01030405 =  YamlHandler.getSSAccountData("tc01_03_04_05_FDMInfiniteSE");
    	tc92 = YamlHandler.getSSAccountData("tc92_CancelledInfiniteNSE");
    	tc94 = YamlHandler.getSSAccountData("tc94CreditLimitExceededAccountSEInfinite");
    	tc95 = YamlHandler.getSSAccountData("tc95NSESuspendedCTN");
    	tc90 = YamlHandler.getSSAccountData("tc90_SE_NSE_ResidentialServices");
    	tc5398 = YamlHandler.getSSAccountData("tc53_98PrepaidAccount");
    	tc99 = YamlHandler.getSSAccountData("tc99SohoMultipleAccounts");
    	tc100 = YamlHandler.getSSAccountData("tc100InfiniteNSESohoCustomer");
    	tc101 = YamlHandler.getSSAccountData("tc101InfiniteSESohoCustomer");
    	tc102 = YamlHandler.getSSAccountData("tc102NSEInfinite50Cancellation");
    	tc103 = YamlHandler.getSSAccountData("tc103Infinite20Redeem");
    	tc104 = YamlHandler.getSSAccountData("tc104Infinite10RedeemCancel");
    	tc22 = YamlHandler.getSSAccountData("tc22_PreRegister_Auto");
    	tc23 = YamlHandler.getSSAccountData("tc23_PreRegister_Auto");
		tc01FinanceNotPaidOff_ON = YamlHandler.getSSAccountData("tc01_FinanceNotPaidOff_ON");
    	tc124 = YamlHandler.getSSAccountData("tc124FinancePaidOffUpfrontEdgeNotPaidON");
    	//================ Connected home =========================
    	tc43IgniteRHP = YamlHandler.getSSAccountData("tc43IgniteRHP");
    	tc42SolarisInternetAccountWithUsage = YamlHandler.getSSAccountData("tc42SolarisInternetAccountWithUsage");
    	tc41IgniteTVAccount = YamlHandler.getSSAccountData("tc41IgniteTVAccount");
    	tc44DigitalTVAccount = YamlHandler.getSSAccountData("tc44DigitalTVAccount");
    	tc46LegacyRHP = YamlHandler.getSSAccountData("tc46LegacyRHP");
    	tc45LegacyInternetAccount = YamlHandler.getSSAccountData("tc45LegacyInternetAccount");
    	tc40SHMAccount = YamlHandler.getSSAccountData("tc40SHMAccount");
    	tc47TupeloAccount = YamlHandler.getSSAccountData("tc47TupeloAccount");
    	tc0610 = YamlHandler.getSSAccountData("tc06_10DemolineSEPlanMultiLine");
		tc111 = YamlHandler.getSSAccountData("tc111PTPdeliquent");
		tc112 = YamlHandler.getSSAccountData("tc112PTPdeliquent");
		tc37_NoBills =YamlHandler.getSSAccountData("tc37PostpaidWithNoBill");
		tc118 = YamlHandler.getSSAccountData("tc118SEInfinite50ImmediateCancel");
		tc126 = YamlHandler.getSSAccountData("tc126NSEPlanAddAccessories");
	}
	
	private static void buyFlowsDataInit() throws FileNotFoundException {
		rogersConfig = YamlHandler.getBFAConfig();
		bfaConfig =  YamlHandler.getBFAConfig();
		bfaPaymentInfo = YamlHandler.getBFAPaymentDetails();
		tc01NACTermNpotgSS=YamlHandler.getRedesignNACData("tc01NACTermNpotgSS");
		tc02NACNoTermStandardShipping=YamlHandler.getRedesignNACData("tc02NACNoTermStandardShipping");
		tc03NACTermPotgShipping = YamlHandler.getRedesignNACData("tc03NACTermPotgShipping");
		tc04NACTermBopis = YamlHandler.getRedesignNACData("tc04NACTermBopis");
		tc05NACByodSS = YamlHandler.getRedesignNACData("tc05NACByodSS");
		tc06NACByodTermBopis = YamlHandler.getRedesignNACData("tc06NACByodTermBopis");
		tc07AAL = YamlHandler.getAALdata("tc07AAL");
		tc08PPC = YamlHandler.getPPCdata("tc08PPC");
		tc09HupPpcPotgSharedML = YamlHandler.getHUPdata("tc09HupPpcPotgSharedML");
		tc10HUPAdditionalLine = YamlHandler.getHUPdata("tc10HUPAdditionalLine");
		tc11HUPNpotgML = YamlHandler.getHUPdata("tc11HUPNpotgML");
		tc12HUPNonShareNoTermSL = YamlHandler.getHUPdata("tc12HUPNonShareNoTermSL");
		tc13HUPShareNoTermSL = YamlHandler.getHUPdata("tc13HUPShareNoTermSL");
		tc14HUPShareKeepCurrentPlanTermML = YamlHandler.getHUPdata("tc14HUPShareKeepCurrentPlanTermML");
		tc15HUPNonShareKeepCurrentPlanSL = YamlHandler.getHUPdata("tc15HUPNonShareKeepCurrentPlanSL");
		tc16HUPShareTermBopisML = YamlHandler.getHUPdata("tc16HUPShareTermBopisML");
		tc17AALShareTermBopis = YamlHandler.getAALdata("tc17AALShareTermBopis");
		tc18AALFinPlanPotgShipping = YamlHandler.getAALdata("tc18AALFinPlanPOTGShipping");
		tc19AALNoTermStandardShipping = YamlHandler.getAALdata("tc19AALNoTermStandardShipping");
		tc20AALTermTablet = YamlHandler.getAALdata("tc20AALTabletDevice");
		tc21AALBYODBopisShipping = YamlHandler.getAALdata("tc21AALBYODBopis");
		tc22AALBYODStandardShipping = YamlHandler.getAALdata("tc22AALBYODStdShipping");
	}
	
	private static void buyFlowsOneViewDataInit() throws FileNotFoundException {
		bfaOneViewConfig =  YamlHandler.getBFAOneViewConfig();
		//sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/buyflows/SauceSettings.yml");
		bfaOneViewPaymentInfo = YamlHandler.getBFAOneViewPaymentDetails();
		buyFlowsOVtestCase01 = YamlHandler.getHUPdataOneView("tc01OVHUPWithPPCMultilineAccount");
		buyFlowsOVtestCase02 = YamlHandler.getHUPdataOneView("tc02OVHUPExistingPlanMultilineAccount");
		buyFlowsOVtestCase03 = YamlHandler.getPPCdataOneView("tc03OVPPCMultilineAccountForBothLines");
		buyFlowsOVtestCase04 = YamlHandler.getPPCdataOneView("tc04OVPPCMultilineAccount");
		buyFlowsOVtestCase05 = YamlHandler.getHUPdataOneView("tc05OVHUPWithPPCSinglelineAccount");
		buyFlowsOVtestCase06 = YamlHandler.getHUPdataOneView("tc06OVHUPExistingPlanSinglelineAccount");
		buyFlowsOVtestCase07 = YamlHandler.getPPCdataOneView("tc07OVPPCSinglelineAccount");
		buyFlowsOVtestCase08 = YamlHandler.getAALdataOneView("tc08OVAALSinglelineBopisShippingAccount");
		buyFlowsOVtestCase09 = YamlHandler.getAALdataOneView("tc09OVAALSinglelinePOTGShippingAccount");
		buyFlowsOVtestCase10 = YamlHandler.getAALdataOneView("tc10OVAALNonShareNoTermQCStandardShippingAccount");
	}
	
	private static void chOneViewDataInit() throws FileNotFoundException {
		ovPaymentInfo = YamlHandler.getOVPaymentDetails();
		igniteTVParentalcontrols = YamlHandler.getOVAccountData("IgniteTVParentalcontrols");
		solarisAccount = YamlHandler.getOVAccountData("SolarisAccount");
		solarisTV = YamlHandler.getOVAccountData("SolarisTV");
		anonymousData = YamlHandler.getContactData("AnonymousData");
		migrationData = YamlHandler.getMigrationData("MigrationData");
	}
}
