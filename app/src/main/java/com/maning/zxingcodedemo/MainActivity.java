package com.maning.zxingcodedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baozi.Zxing.CaptureActivity;
import com.baozi.Zxing.ZXingConstants;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_show);

    }

    public void scanCode(View view) {
        Intent intent = new Intent(MainActivity.this,
                CaptureActivity.class);
        intent.putExtra(ZXingConstants.ScanIsShowHistory,false);
        startActivityForResult(intent, ZXingConstants.ScanRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (requestCode) {
            case ZXingConstants.ScanRequestCode:
                /**
                 * 拿到解析完成的字符串
                 */
                String result = data.getStringExtra(ZXingConstants.ScanResult);
                textView.setText(result);
                break;
        }
    }

}
