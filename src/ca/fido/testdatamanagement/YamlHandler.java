package ca.fido.testdatamanagement;

import ca.fido.yaml.pojo.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class YamlHandler {

	public static void main(String[] args) throws FileNotFoundException {

		// System.out.println(getAccountData("ConnectedHomeTestData").accountDetails.getPlan());

	}

	public static AccountData getAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/test-data/fido/selfserve/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static Config getConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/selfserve/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static PaymentDetails getPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/selfserve/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	
	public static Config getHSIConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/connectedhome/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static AccountData getHSIAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/test-data/fido/connectedhome/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public static PaymentDetails getHSIPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/connectedhome/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static NACData getNACData(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(NACData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflows/" + dataFileName + ".yml"));
			NACData nacData = yaml.load(inputStream);
			return nacData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static AALData getAALData(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(AALData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflows/" + dataFileName + ".yml"));
			AALData aalData = yaml.load(inputStream);
			return aalData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static HUPData getHUPData(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(HUPData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflows/" + dataFileName + ".yml"));
			HUPData hupData = yaml.load(inputStream);
			return hupData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static PPCData getPPCData(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(PPCData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflows/" + dataFileName + ".yml"));
			PPCData ppcData = yaml.load(inputStream);
			return ppcData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Config getBFAConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflows/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static PaymentDetails getBFAPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflows/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static SauceSettings getSauceSettings(String strSauceSettingPath) {
		Yaml yaml = new Yaml(new Constructor(SauceSettings.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + strSauceSettingPath));
			SauceSettings sauceSettings = yaml.load(inputStream);
			return sauceSettings;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static AalOVData getAALOneViewData(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(AalOVData.class));
		InputStream inputStream;

		try {
		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/buyflowsoneview/" + dataFileName + ".yml"));
		return yaml.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}