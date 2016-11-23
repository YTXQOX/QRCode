package com.ljstudio.android.qrcode.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.widget.Toast;

import com.ljstudio.android.qrcode.CaptureActivity;

public class SimpleCaptureActivity extends CaptureActivity {

    protected Activity mActivity = this;
    private AlertDialog mDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mActivity = this;
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void handleResult(String resultString) {
        if (TextUtils.isEmpty(resultString)) {
            Toast.makeText(mActivity, R.string.scan_failed, Toast.LENGTH_SHORT).show();
            restartPreview();
        } else {
            Intent intent = new Intent(SimpleCaptureActivity.this, SecondActivity.class);
            intent.putExtra(SecondActivity.SCAN_RESULT, resultString);
            startActivity(intent);

//            if (mDialog == null) {
//                mDialog = new AlertDialog.Builder(mActivity)
//                        .setMessage(resultString)
//                        .setPositiveButton("确定", null)
//                        .create();
//                mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//                        restartPreview();
//                    }
//                });
//            }
//
//            if (!mDialog.isShowing()) {
//                mDialog.setMessage(resultString);
//                mDialog.show();
//            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
