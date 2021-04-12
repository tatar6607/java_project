package kutuphane_projesi;

import kutuphane_projesi.logic.AppMenus;

public class AppRunner {

    static AppMenus menu;

    static {
        menu = new AppMenus();
    }

    public static void main(String[] args) {
        menu.getAppMenuMassage();
        menu.getAppMenu();
    }
}
