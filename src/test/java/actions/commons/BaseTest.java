package actions.commons;

import commons.BrowserList;
import commons.urlList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    public String getUrlAccess(String accessUrlName) {
        String url = null;
        urlList urlName = urlList.valueOf(accessUrlName.toUpperCase());
        if (urlName == urlList.USER) {
            url = GlobalConstants.USER_URL;
        } else if (urlName == urlList.ADMIN) {
            url = GlobalConstants.ADMIN_URL;
        }
        return url;
    }

    public WebDriver getBrowserDriver(String browserName, String accessUrlName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                options.addExtensions(new File(GlobalConstants.ADBLOCK_EXTENSION_OF_CHROME));
                driver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                profile.addExtension(new File(GlobalConstants.ADBLOCK_EXTENSION_OF_FIREFOX));
                driver = new FirefoxDriver(firefoxoptions);
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case H_CHROME -> {
                WebDriverManager.chromedriver().setup();
                options.addArguments("--headless");
                options.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("This Browser Is Not Support");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getUrlAccess(accessUrlName));
        return driver;
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

    protected void quitDriver() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            //log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            //log.info("Driver instance name = " + osName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
