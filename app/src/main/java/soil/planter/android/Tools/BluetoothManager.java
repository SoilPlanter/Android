package soil.planter.android.Tools;

import static androidx.core.content.ContextCompat.checkSelfPermission;
import android.Manifest;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Set;

public class BluetoothManager {
    public static BluetoothAdapter bluetoothAdapter;

    private final AppCompatActivity activity;
    public ActivityResultLauncher<Intent> someActivityResultLauncher;
    public BluetoothManager(AppCompatActivity activity) {
        this.activity = activity;
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

    }

    public void query(){
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
    public void discovery(){

    }
    private void getPermissions() {
        if (checkSelfPermission(activity,Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (checkSelfPermission(activity,android.Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                if (activity.shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
                    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (bluetoothAdapter == null) {
                        // Device doesn't support Bluetooth
                    }
                    if (!bluetoothAdapter.isEnabled()) {
                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        someActivityResultLauncher.launch(enableBtIntent);

                        // Dialog for grant Permission
                    } else {

                        // Dialog for Required permission

                    }

                }
            }
        }

    }
}
