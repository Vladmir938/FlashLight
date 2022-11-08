package com.example.flashlightlab;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;

public class FlashClass {
    private boolean flash_status = false;
    private Context context;

    public FlashClass(Context context) {
        this.context = context;
    }
    public void flashOn()
    {
        CameraManager cameraManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, true);
            }
            flash_status = true;


        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }
    public void flashOff()
    {
        CameraManager cameraManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, false);
            }
            flash_status = false;


        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    public boolean isFlash_status() {
        return flash_status;
    }
}
