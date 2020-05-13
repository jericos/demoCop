package com.pacifico.framework;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage CurrentPage;

    public <TPage extends Base> TPage GetInstance(Class<TPage> page) {
        Object obj = PageFactory.initElements(DriverContext.Driver, page);
//        Custom control page factory initialization
//        Object obj = ControlFactory.initElements(com.pacifico.framework.DriverContext.Driver, page);
        return page.cast(obj);
    }

}
