package soil.planter.android.Tools;

import android.Manifest;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class BluetoothManager {
    private ArrayList<BluetoothDevice> bluetoothDevices = new ArrayList<>();
    private static BluetoothManager instance;

    private final BroadcastReceiver bStateReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
                if (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1) == BluetoothAdapter.STATE_OFF) {
                    // Bluetooth is disconnected, do handling here
                    blueToothListenerListener.listen(false);

                } else {
                    blueToothListenerListener.listen(true);
                }
            }
        }

    };

    public void connect(BTConnectThread.BTConnection connection, BluetoothDevice device1) {

        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(device1.getAddress());

        new BTConnectThread(connection, device, bluetoothAdapter, activity).run();
    }

    private BlueToothListener blueToothListenerListener;
    private Discovery discoveryListener;

    public static BluetoothManager getInstance() {
        if (instance == null)
            instance = new BluetoothManager();
        return instance;
    }

    private AppCompatActivity activity;

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
        init();
    }

    public boolean blueToothIsOn() {
        return bluetoothAdapter.isEnabled();
    }

    private void init() {

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
        }
        someActivityResultLauncher = activity.registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();

                        }
                    }
                });
        activity.registerReceiver(bStateReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));

    }

    public void startBluetooth() {
        if (!bluetoothAdapter.isEnabled()) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            bluetoothAdapter.enable();

        }


    }

    public void endBluetooth() {
        if (bluetoothAdapter.isEnabled()) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            bluetoothAdapter.disable();

        }


    }

    private static final String TAG = "BluetoothManager";
    public static BluetoothAdapter bluetoothAdapter;
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
                Log.d(TAG, "onReceiveBT: " + deviceName + " " + deviceHardwareAddress + " " + Arrays.toString(device.getUuids()));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    discoveryListener.addDevice(device);
                }
                else
                    discoveryListener.addDevice(device);
                bluetoothDevices.add(device);

            }
        }
    };
    public ActivityResultLauncher<Intent> someActivityResultLauncher;

    private BluetoothManager() {


    }

    public void query() {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }
        }
    }

    public void discovery(Discovery discovery) throws RuntimeException{
        this.discoveryListener = discovery;
        if (bluetoothAdapter == null)
            throw new RuntimeException("start bluetooth first");
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        activity.registerReceiver(receiver, filter);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        bluetoothAdapter.startDiscovery();


    }
    public void endDiscovery(){
        try {
            activity.unregisterReceiver(receiver);
        }catch (Exception e){
            Log.e(TAG, "endDiscovery: ", e);
        }
    }

    public boolean listenBT(BlueToothListener listener) {
        blueToothListenerListener = listener;
        return blueToothIsOn();

    }

    public void terminateReceivers() {
        activity.unregisterReceiver(bStateReceiver);

    }

    public void sendCommand(String toString) {

    }

    public interface BlueToothListener {
        void listen(boolean isOn);
    }
    public interface Discovery{
        void addDevice(BluetoothDevice device);
    }



}
