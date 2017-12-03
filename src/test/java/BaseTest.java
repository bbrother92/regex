import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class BaseTest {
	protected Logger logger;
	
	@BeforeSuite
	public void setUp() {
		logger = LoggerFactory.getLogger(BaseTest.class);
	}
	
	@BeforeMethod
	public void testMethodName(Method method)
	{
		logger.info("STARTING TEST: " + method.getName().toString());
	}
}
