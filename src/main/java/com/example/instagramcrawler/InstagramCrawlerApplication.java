package com.example.instagramcrawler;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstagramCrawlerApplication {

    public static void main(String[] args) {

        SpringApplication.run(InstagramCrawlerApplication.class, args).getBean(InstagramCrawlerApplication.class).test();
    }

    public void test(){
        //세션 시작
        ChromeOptions options = new ChromeOptions();
        //페이지가 로드될 때까지 대기
        //Normal: 로드 이벤트 실행이 반환 될 때 까지 기다린다.
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new ChromeDriver(options);

        try{
            //login 페이지
            driver.get("https://www.instagram.com/");
            //id, pw 입
            //driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("인스타 아이디");
            //driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("인스타 비번");

            //버튼 클릭
            driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();
            System.out.println("로그인 성공 = " + driver.getCurrentUrl());

        }finally {
            driver.quit();
        }
    }
}
