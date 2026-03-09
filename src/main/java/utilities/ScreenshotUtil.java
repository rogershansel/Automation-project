package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver,String name){

        try {

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + name + ".png";

            FileUtils.copyFile(src,new File(path));

            return path;

        } catch (Exception e){
            return null;
        }
    }

    public static String captureScreenshotAsBase64(WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            return null;
        }
    }
}
