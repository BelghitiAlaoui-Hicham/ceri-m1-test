package fr.univavignon.pokedex.api.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class CalculatorIV {

    private static final String  PATH_IV = "https://pokeassistant.com/main/ivcalculator?locale=en";
    private WebDriver webDriver;

    public CalculatorIV() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
    }
    public int calculateIV(String name, int cp, int hp, int dust) {

        webDriver.get(PATH_IV);
        
        webDriver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
        webDriver.findElement(By.xpath("//*[@class=\"tt-dataset tt-dataset-0\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
        webDriver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
        webDriver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
        webDriver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
        
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String res = webDriver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
        
        webDriver.quit();
        
        return Math.round(Float.parseFloat(res.replace("%", "")));
    }
}