package com.dhaniMobile.utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.dhaniMobile.utilities.CommonUtils.OPERATING_SYSTEM;

public class AppiumServer {

	public static AppiumDriverLocalService service;
	
	public static void start(){
		
		// starting the Appium server code

		String appiumServerPath = System.getenv().get("APPIUM_SERVER_PATH");
		if(OPERATING_SYSTEM.equals("windows")) {

			service = AppiumDriverLocalService.buildService(
					new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
							.withAppiumJS(new File(appiumServerPath))
							.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
							.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		}
		else
		{
				service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
						//TODO: replace with a system variable
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withLogFile(new File(System.getProperty("user.dir") + "/src/test/resources/logs/log.txt"))
						.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
						.withStartUpTimeOut(5, TimeUnit.SECONDS));
		}

		service.start();

	}

	public static void stop(){
		if(service != null) {
			service.stop();
		}
	}
}
