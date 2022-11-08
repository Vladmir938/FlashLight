package com.example.flashlightlab;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.hardware.Camera;
//import android.hardware.Camera.Parameters;
//import android.hardware.camera2.CameraManager;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import java.security.Policy;
//
//public class MainActivity extends AppCompatActivity {
//
//    private Camera.Parameters myParameters;
//    public Camera myCamera;
//    private boolean hasFlash;
//    private boolean flashlightIsOn;
//    private Context context;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        this.context = context;
//        flashlightIsOn = false;
//        hasFlash = getApplicationContext().getPackageManager()
//                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
//        if (hasFlash) {
//            myCamera = Camera.open();
//            myParameters = myCamera.getParameters();
//        } else {
//            Toast myToast = Toast.makeText(getApplicationContext(), "У камеры нет вспышки",
//                    Toast.LENGTH_SHORT);
//            myToast.show();
//        }
//    }
//
//    public void flashOn (View view) {
//        if (!flashlightIsOn) {
//            myParameters = myCamera.getParameters();
//            myParameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
//            myCamera.setParameters(myParameters);
//            myCamera.startPreview();
//            flashlightIsOn = true;
//        } else {
//            myParameters.setFlashMode(Parameters.FLASH_MODE_OFF);
//            myCamera.setParameters(myParameters);
//            myCamera.stopPreview();
//            flashlightIsOn = false;
//        }
//    }
//
//
//}

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bFlash;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        flashClass = new FlashClass(this);

    }
    public void flashOn (View view)
    {
        if(flashClass.isFlash_status())
        {
            flashClass.flashOff();

        }
        else
        {
            flashClass.flashOn();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flashClass.isFlash_status())
        {
            flashClass.flashOff();
        }
    }
}