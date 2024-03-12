package org.kitapyurdu.base;

import org.openqa.selenium.By;

public class Constans {


    // SETUP
    public static final boolean IS_LOCAL_ANDROID = true;

    public static final String DEVICE_NAME = "emulator-5554";

    public static final String START_APP_ACTIVITY = "com.mobisoft.kitapyurdu.main.SplashActivity";

    public static final String APP_PACKAGE = "com.mobisoft.kitapyurdu";

    public static final String NEW_COMMAND_TIMEOUT = "3000";

    public static final String URL = "http://127.0.0.1:4723/wd/hub";

    // HOME PAGE
    public static final String NAVIGATION_PERMISSION = "//*[@resource-id='com.mobisoft.kitapyurdu:id/btnLaterOn']";

    public static final String SEARCH_BUTTON = "//android.widget.FrameLayout[@content-desc=\"Ara\"]";

    public static final String SEARCH_INPUT = "com.mobisoft.kitapyurdu:id/searchEditText";

    public static final  By TEXT_CONTROL = By.xpath("//*[@text='harry potter']");

    public static final String FIRST_RESULT = "//*[@text='harry potter']";

    public static final String BOOK_SORT = "com.mobisoft.kitapyurdu:id/sortButton";

    public static final String HIGHLY_RATED = "//*[@text='Çok Değerlendirilenler']";

   // public static final  By RANDOM_BOOK = By.id("com.mobisoft.kitapyurdu:id/grid");

    public static final By ADD_BASKET = By.id("com.mobisoft.kitapyurdu:id/textViewNormalCartButton");

    public static final By SAVE_VALUE = By.id("com.mobisoft.kitapyurdu:id/textViewSellPriceBottom");

    public static final String ADD_BASKET2 = ("com.mobisoft.kitapyurdu:id/textViewNormalCartButton");

    public static final String LoginInput = ("//android.widget.RelativeLayout[@content-desc=\"Giriş Yap / Üye Ol\"]/android.widget.TextView");

    public static final String Email = ("com.mobisoft.kitapyurdu:id/textview_mail");

    public static final String Password = ("com.mobisoft.kitapyurdu:id/textview_password");

    public static final String Login_Button = ("com.mobisoft.kitapyurdu:id/loginButton");
    public static final String My_Basket = ("com.mobisoft.kitapyurdu:id/navigation_cart");
    public static final By Product_Price = By.id("com.mobisoft.kitapyurdu:id/textViewTotal");

    public static final String DELETE_BUTTON = ("com.mobisoft.kitapyurdu:id/buttonDelete");
    public static final String DELETE_BUTTON2 = ("//android.widget.RelativeLayout[@content-desc=\"Sil\"]/android.widget.TextView");
    public static final By EMPTY_BASKET = By.id("com.mobisoft.kitapyurdu:id/textViewErrorMessage");

    public static final String HOME_PAGE_BUTTON = ("com.mobisoft.kitapyurdu:id/navigation_home");
    public static final String ACCOUNT = ("com.mobisoft.kitapyurdu:id/btn_ic_header_account");
    public static final String EXIST_BUTTON = ("com.mobisoft.kitapyurdu:id/ln_logout");

}
