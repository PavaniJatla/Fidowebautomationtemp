package ca.fido.testdatamanagement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import ca.fido.yaml.pojo.AALData;
import ca.fido.yaml.pojo.HUPData;
import ca.fido.yaml.pojo.NACData;
import ca.fido.yaml.pojo.PPCData;
import ca.fido.yaml.pojo.AccountData;
import ca.fido.yaml.pojo.Config;
import ca.fido.yaml.pojo.PaymentDetails;
import ca.fido.yaml.pojo.SauceSettings;

public class YamlHandler {

	public static void main(String[] args) throws FileNotFoundException {

		// System.out.println(getAccountData("ConnectedHomeTestData").accountDetails.getPlan());

	}

	public static AccountData getAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/data/selfserve/" + accountName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/selfserve/Config.yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/selfserve/PaymentInfo.yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/connectedhome/HSIConfig.yml"));
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
					new File(System.getProperty("user.dir") + "/data/connectedhome/" + accountName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/connectedhome/HSIPaymentInfo.yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/Config.yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static SauceSettings getSauceSettings() {
		Yaml yaml = new Yaml(new Constructor(SauceSettings.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/selfserve/SauceSettings.yml"));
			SauceSettings sauceSettings = yaml.load(inputStream);
			return sauceSettings;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	
}