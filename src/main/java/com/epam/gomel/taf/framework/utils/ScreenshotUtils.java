package com.epam.gomel.taf.framework.utils;

import com.epam.gomel.taf.framework.factory.BrowserFactory;
import com.epam.gomel.taf.report_portal.pages.AbstractPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static com.epam.gomel.taf.framework.logger.Log.debug;
import static com.epam.gomel.taf.framework.logger.Log.error;

public class ScreenshotUtils {
    public static final File TESTNG_DIRECTORY = new File("target/surefire-reports");
    private final int scrollTimeout = 1000;

    public void takeScreenshot() {
        try {
            if (!TESTNG_DIRECTORY.exists()) {
                TESTNG_DIRECTORY.mkdirs();
            }
            File file = File.createTempFile("screenshot", ".png", TESTNG_DIRECTORY);
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(scrollTimeout))
                    .takeScreenshot(BrowserFactory.getBrowser());
            ImageIO.write(screenshot.getImage(), "png", file);
            debug(
                    String.format(
                            "<a href='%s'><img src='%s' height='25%%' width='25%%'/></a>",
                            file.getCanonicalPath(), file.getCanonicalPath()));
            saveScreenShot(screenshot);
            debug("Saved screenshot is attached:\n" + file);
        } catch (IOException e) {
            error("Unable to save screenshot:\n" + e);
        }
    }

    private static byte[] saveScreenShot(Screenshot screenshot) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
