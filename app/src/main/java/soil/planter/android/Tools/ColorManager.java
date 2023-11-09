package soil.planter.android.Tools;

import java.util.ArrayList;
import java.util.function.Consumer;

import soil.planter.android.Application;
import soil.planter.android.Interfaces.Colorful;

public class ColorManager {
    private final int primaryLight = 0;
    private final int onPrimaryLight = 0;

    private final int primaryVariantLight = 0;
    private final int secondaryLight = 0;
    private final int secondaryVariantLight = 0;
    private final int onSecondaryLight = 0;

    private final int onButtonPressedLight = 0;
    private final int backgroundLight = 0;
    private final int onBackgroundLight = 0;

    private final int surfaceLight = 0;
    private final int onSurfaceLight = 0;

    private final int onErrorLight = 0;

    private final int primaryDark = 0;
    private final int onPrimaryDark = 0;

    private final int primaryVariantDark = 0;
    private final int secondaryDark = 0;
    private final int secondaryVariantDark = 0;
    private final int onSecondaryDark = 0;

    private final int onButtonPressedDark = 0;
    private final int backgroundDark = 0;
    private final int onBackgroundDark = 0;

    private final int surfaceDark = 0;
    private final int onSurfaceDark = 0;

    private final int onErrorDark = 0;
    //Fangpeng
    private static ColorManager.Theme theme = Theme.LIGHT;
    private static ColorTheme themeLight = new ColorTheme.Light(Application.getAppContext());
    private static ColorTheme themeDark = new ColorTheme.Dark(Application.getAppContext());

    public static ColorTheme getLightTheme() {
        return themeLight;
    }


    public enum Theme{
        DARK,LIGHT
    }
    private static ArrayList<Colorful> colorfuls = new ArrayList<>();
    public static void initColorful(Colorful view) {
        colorfuls.add(view);
    }
    public static void switchTheme(ColorManager.Theme theme1){
        theme = theme1;
        update();
    }
    private static void update(){
        colorfuls.forEach(new Consumer<Colorful>() {
            @Override
            public void accept(Colorful colorful) {
                colorful.theme(theme == Theme.LIGHT ? themeLight : themeDark);
            }
        });

    }
}
