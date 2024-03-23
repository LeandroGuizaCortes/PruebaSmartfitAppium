package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Smart {

    public static void main(String[] args) {

        // Definir las capacidades para la automatización

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "ZY32CXMFDB"); // Nombre de tu dispositivo virtual o físico
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage","com.eokoe.smartfitcoach"); // Paquete de la aplicación que deseas automatizar
        caps.setCapability("appActivity", "com.smartfit.app.smartapp.app.MainActivity"); // Actividad principal de la aplicación
        URL url;
        try {
            url = new URL("http://127.0.0.1:4723"); // La URL del servidor Appium
        } catch (Exception e) {
            throw new RuntimeException("La URL del servidor Appium no es válida: " + e.getMessage());
        }
        // Inicializar el driver de Appium

        AppiumDriver<MobileElement> driver = new AndroidDriver<>(url, caps);

        // En la pagina pricipal "SELECCIONA TU PAIS" hacer tap en el botón "Colômbia"

        driver.findElementByXPath("//android.widget.Button[@content-desc=\"Colômbia\"]").click();

        // Hacer tap en el botón de "COMPRAR PLAN"

        driver.findElementByXPath("//android.widget.Button[@content-desc=\"COMPRAR PLAN\"]").click();

        // Hacer tap en el botón de "SEGUIR"

        driver.findElementByXPath("//android.widget.Button[@content-desc=\"SEGUIR\"]").click();

        // En esta pagina se despliega un mensaje "solicitud de permiso de ubicación" hacer tap en el botón de "Mientras la app está en uso"

        driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();


        //driver.quit();

        // driver.closeApp();


    }
}