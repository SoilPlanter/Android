package soil.planter.android;

import android.content.Context;

import soil.planter.android.Tools.BluetoothManager;

public class Application extends android.app.Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        BluetoothManager.getInstance().terminateReceivers();
    }

    public static Context getAppContext() {
        return applicationContext;
    }
}
