package Generic_Libraries;
import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility
{
	public String getPropertyFileKeyandValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./propertyfile/dataa.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

}
