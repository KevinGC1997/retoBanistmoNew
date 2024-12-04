package userInterface;

import net.serenitybdd.screenplay.targets.Target;
import sun.tools.jconsole.Tab;

public class productServiceUI {

    public static final Target BTN_PRODUCT_SERVICES = Target
            .the("button to product and services")
            .locatedBy("//a[@id='menu-productos']");

    public static final Target BTN_INVESTMENTS = Target
            .the("button to investments")
            .locatedBy("//a[@id='header-productos-inversiones']");

    public static final Target BTN_VIRTUAL_INVESTMENTS = Target
            .the("button to virtual investments")
            .locatedBy("(//a[@title='Inversión Virtual'])[2]");

    public static final Target LBL_SCROLL_DOCUMENT = Target
            .the("scroll to document")
            .locatedBy("//*[text()='Documentos']");

    public static final Target BTN_REGULATIONS = Target
            .the("button to regulations")
            .locatedBy("(//a[@class='btn-yellow'])[2]");

}
