package com.xc.xcloadingimageview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends Activity {
    private static final int one = 0X0001;
    private int progress=100;
    private   XCLoadingImageView imageView2;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress--;
            switch (msg.what) {
                case one:
                    if (progress >=0) {
                        imageView2.setProgress(progress);
                        sendEmptyMessageDelayed(one, 100);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 imageView2 = (XCLoadingImageView) findViewById(R.id.img2);
        imageView2.setMaskOrientation(XCLoadingImageView.MaskOrientation.TopToBottom);
        imageView2.setProgress(progress);


            handler.sendEmptyMessageDelayed(one, 1000);
    }
}
