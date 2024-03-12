package org.kitapyurdu;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kitapyurdu.base.Constans;
import org.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

import static org.kitapyurdu.base.Constans.Product_Price;
import static org.kitapyurdu.base.HookImp.appiumDriver;


public class StepImp {

    Methods methods = new Methods();
    Logger logger = LogManager.getLogger(StepImp.class);



    @Step("Kitap yurdu uygulamasi acilir ve ara butonuna tiklanir")
    public void searchButton() {

        methods.waitForSeconds(3);
        methods.click(Constans.NAVIGATION_PERMISSION,"xpath");
        methods.click(Constans.NAVIGATION_PERMISSION,"xpath");
        logger.info("Pop-Up kapatıldı");
        methods.waitForSeconds(3);
        methods.click(Constans.SEARCH_BUTTON, "xpath");
        logger.info("Arama butonuna tıklandı");
        methods.waitForSeconds(3);
    }

    @Step("Arama alanina Harry Potter yazilir")
    public void writeInSearchFiedl() {

        methods.click(Constans.SEARCH_INPUT,"id");
        methods.sendKeys(Constans.SEARCH_INPUT,"Harry Potter","id");
        methods.waitForSeconds(3);
    }

    @Step("Harry Potter text degerini icerdigi kontrol edilir ve 1.sonuca tiklanir")
    public void harryPotterControl() {

        boolean isPresent = methods.isTextPresent(Constans.TEXT_CONTROL,"harry potter");
        methods.waitForSeconds(3);
        if (isPresent) {
            logger.info("Sayfada Harry Potter metni mevcut.");
        } else {
            logger.error("Sayfada Harry Potter metni mevcut değil.");
        }
        methods.click(Constans.FIRST_RESULT,"xpath");
        methods.waitForSeconds(3);
    }


    @Step("Sirala butonuna tiklanir")

    public void sortButton() {

     methods.click(Constans.BOOK_SORT,"id");
    }

    @Step("Cok degerlendirilenler tiklanir")
    public void highlyRatedButton() {

        methods.click(Constans.HIGHLY_RATED,"xpath");

    }

    @Step("Random kitap secilir")
    public void randomBookSelect() {

        methods.chooseRandomProduct();
        methods.waitForSeconds(5);
    }


    @Step("Kitap ayrıntılarının bulunduğu sayfaya gidildiği doğrulanır")
    public void detailVerification(){

        methods.isTextPresent(Constans.ADD_BASKET,"Sepete Ekle");

    }

    @Step("Ürün fiyatı kaydedilir")
    public void saveValue(){

    methods.saveElementId(Constans.SAVE_VALUE,"price");
    }

    @Step("Sepete ekle tiklanir ve giris yapilir")
    public void addToCardAndLogin(){

        methods.click(Constans.ADD_BASKET2,"id");
        methods.click(Constans.LoginInput,"xpath");
        methods.sendKeys(Constans.Email,"eyupcanbilgin01@gmail.com","id");
        methods.sendKeys(Constans.Password,"Eyupcan0901.","id");
        methods.click(Constans.Login_Button,"id");


    }

    @Step("Sepetim butonuna tiklanir ve sepetteki fiyat karsılastirilir")
    public void AddToBasketTab(){

        methods.click(Constans.My_Basket,"id");

    }
    @Step("Sil butonuna tiklanir ve sepetin bos oldugu dogrulanir")
    public  void deleteButtonAndVerify(){

        methods.click(Constans.DELETE_BUTTON,"id");
        methods.click(Constans.DELETE_BUTTON2,"xpath");
        methods.isTextPresent(Constans.EMPTY_BASKET,"Sepetiniz boş!");

    }

    @Step("Anasayfaya donulup hesaptan cikis yapilir")
    public  void returnHomePageAndExist(){

        methods.click(Constans.HOME_PAGE_BUTTON,"id");
        methods.click(Constans.ACCOUNT,"id");
        methods.click(Constans.EXIST_BUTTON,"id");
    }

}



















