package saimond.etienne.dao;


import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;


import javax.servlet.ServletContext;

public class D_Context {
	
	protected static String dbURL;
	protected static String dbLogin;
	protected static String dbPassword;
	protected static String host;

	public static void init(ServletContext context) {
		
		Properties props = new Properties();
		
		// for server
		//try (FileInputStream fis = new FileInputStream("/opt/tomcat-latest/webapps/blog/WEB-INF/conf/conf.properties")){
		
		// for local :
		try (FileInputStream fis = new FileInputStream("/util/workspace/blog/WebContent/WEB-INF/conf/conf.properties")){
			props.load( fis );
		}	catch (Exception exception) {
			System.err.println("/ ! \\ __________ ERROR : Properties file not found");
			// TODO Listener !!
			exception.printStackTrace();
		}

		try {
			Class.forName(props.getProperty("jdbc.driver.class"));
		} catch (ClassNotFoundException e) {
			System.err.println("/ ! \\ __________ ERROR : Driver failed to load");
			e.printStackTrace();
		}
		
		setDbURL(props.getProperty("jdbc.url"));
		setDbLogin(props.getProperty("jdbc.login"));
		setDbPassword(props.getProperty("jdbc.password"));
		setHost(props.getProperty("host"));
	}
	
	public static String hash(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        
        
		return generatedPassword;
    }
	
	public static String getHost() {
		return host;
	}

	protected static void setHost(String host) {
		D_Context.host = host;
	}

	protected static String getDbURL() {
		return dbURL;
	}

	protected static void setDbURL(String dbURL) {
		D_Context.dbURL = dbURL;
	}

	protected static String getDbLogin() {
		return dbLogin;
	}

	protected static void setDbLogin(String dbLogin) {
		D_Context.dbLogin = dbLogin;
	}

	protected static String getDbPassword() {
		return dbPassword;
	}

	protected static void setDbPassword(String dbPassword) {
		D_Context.dbPassword = dbPassword;
	}

}
