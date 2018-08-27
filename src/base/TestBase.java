package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	protected FileInputStream fs;
	protected static Properties prop;
	
	public TestBase() throws IOException
	{
		fs = new FileInputStream("src\\files\\env.properties");
		prop = new Properties();
		prop.load(fs);
	}

}
