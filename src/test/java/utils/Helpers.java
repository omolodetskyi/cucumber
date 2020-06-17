package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
public class Helpers {

		public static String takeScreenshot(WebDriver driver, String fileName) throws IOException{
			TakesScreenshot ts=(TakesScreenshot) driver;
			String filePath="./screenshots/"+fileName+".png";
			File screenshot=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(filePath));
			return filePath;
		}

}
