package soil.planter.android.Tools;

import android.content.Context;

public class ColorTheme {

    private int primary = 0;
    private int onPrimary = 0;

    private int primaryVariant = 0;
    private int secondary = 0;
    private int secondaryVariant = 0;
    private int onSecondary = 0;

    private int onButtonPressed = 0;
    private int background= 0;
    private int onBackground = 0;
    private int surface = 0;
    private int onSurface = 0;

    private int onError = 0;

    public int getPrimary() {
        return primary;
    }

    public int getOnPrimary() {
        return onPrimary;
    }

    public int getPrimaryVariant() {
        return primaryVariant;
    }

    public int getSecondary() {
        return secondary;
    }

    public int getSecondaryVariant() {
        return secondaryVariant;
    }

    public int getOnSecondary() {
        return onSecondary;
    }

    public int getOnButtonPressed() {
        return onButtonPressed;
    }

    public int getBackground() {
        return background;
    }

    public int getOnBackground() {
        return onBackground;
    }

    public int getSurface() {
        return surface;
    }

    public int getOnSurface() {
        return onSurface;
    }

    public int getOnError() {
        return onError;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
    }

    public void setOnPrimary(int onPrimary) {
        this.onPrimary = onPrimary;
    }

    public void setPrimaryVariant(int primaryVariant) {
        this.primaryVariant = primaryVariant;
    }

    public void setSecondary(int secondary) {
        this.secondary = secondary;
    }

    public void setSecondaryVariant(int secondaryVariant) {
        this.secondaryVariant = secondaryVariant;
    }

    public void setOnSecondary(int onSecondary) {
        this.onSecondary = onSecondary;
    }

    public void setOnButtonPressed(int onButtonPressed) {
        this.onButtonPressed = onButtonPressed;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setOnBackground(int onBackground) {
        this.onBackground = onBackground;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setOnSurface(int onSurface) {
        this.onSurface = onSurface;
    }

    public void setOnError(int onError) {
        this.onError = onError;
    }

    public static class Light extends ColorTheme {
        public Light(Context context) {


        }
    }
    public static class Dark extends ColorTheme {
        public Dark(Context context) {
        }
    }
}
