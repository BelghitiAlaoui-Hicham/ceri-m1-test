package main.java.fr.univavignon.pokedex.api.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class CalculatorIV {

    private static final String  PATH_IV = "https://pokeassistant.com/main/ivcalculator?locale=en";
    private WebDriver driver;

    public CalculatorIV() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
    public int calculateIV(String name, int cp, int hp, int dust) {

        driver.get(PATH_IV);
        
        driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@class=\"tt-dataset tt-dataset-0\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
        driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
        driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
        driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
        
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String res = driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
        
        driver.quit();
        
        return Math.round(Float.parseFloat(res.replace("%", "")));
    }
}