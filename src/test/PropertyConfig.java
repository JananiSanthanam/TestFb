package test;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class PropertyConfig {
		private String username, passwd;
		private FileInputStream file = null;
		private Properties p; 
		
		public PropertyConfig() {
			readFile();
		}
		public String getUsername(){
			return username;
		}
		public String getPassword(){
			return passwd;
		}		
		public void readFile() {

			try{
				System.out.println("i am here");
			file = new FileInputStream("src/test/facebook.properties");	
			p = new Properties();
			p.load(file);

			setUser(p.getProperty("username"));
			setPassword(p.getProperty("password"));
	
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				if (file != null) {
					try {
						file.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
		public void setPassword(String pw){
			passwd = pw;
		}
		public void setUser(String u){
			username = u;
		}

}
