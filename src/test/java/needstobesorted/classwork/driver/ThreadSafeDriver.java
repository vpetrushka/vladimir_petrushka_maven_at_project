package needstobesorted.classwork.driver;

import org.openqa.selenium.WebDriver;


public class ThreadSafeDriver extends AbstractDriver {

        private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

        private ThreadSafeDriver(){
        }

        public static WebDriver getDriver() {
            if (null == driverLocal.get()) {
                driverLocal.set(DriverManager.getDriver(config));
            }
            return driverLocal.get();
        }

        public static void destroy(){
            driverLocal.get().quit();
            driverLocal.set(null);
        }
}