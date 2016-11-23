package com.ljstudio.android.qrcode.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String SCAN_RESULT = "scan_result";

    private TextView tvResult;
    private AlertDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = (TextView) findViewById(R.id.id_result);

        final String strResult = getIntent().getStringExtra(SCAN_RESULT);
        tvResult.setText(strResult);

        tvResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDialog == null) {
                    mDialog = new AlertDialog.Builder(SecondActivity.this)
                            .setMessage(strResult)
                            .setPositiveButton("确定", null)
                            .create();

                    mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {

                        }
                    });
                }

                if (!mDialog.isShowing()) {
                    mDialog.setMessage(strResult);
                    mDialog.show();
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
