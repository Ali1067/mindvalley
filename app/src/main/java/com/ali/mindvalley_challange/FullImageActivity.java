package com.ali.mindvalley_challange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.ali.mindvalley.interfaces.IMDownloadDataType;
import com.ali.mindvalley.models.MDownloadDataType;
import com.ali.mindvalley.models.MDownloadDataTypeImage;
import com.ali.mindvalley.utilities.MProviderMDownloadDataType;
import com.ali.mindvalley_challange.R;


public class FullImageActivity extends Activity {
    private MProviderMDownloadDataType mProvider;
    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        mProvider = MProviderMDownloadDataType.getInstance();
        imageView = (ImageView) findViewById(R.id.full_image_view);

        Intent i = getIntent();
        String url = i.getExtras().getString("url");

        MDownloadDataType mDataTypeImageCancel = new MDownloadDataTypeImage(url , new IMDownloadDataType() {
            @Override
            public void onStart(MDownloadDataType mDownloadDataType) {

            }

            @Override
            public void onSuccess(MDownloadDataType mDownloadDataType) {
                imageView.setImageBitmap(((MDownloadDataTypeImage) mDownloadDataType).getImageBitmap());
            }

            @Override
            public void onFailure(MDownloadDataType mDownloadDataType, int statusCode, byte[] errorResponse, Throwable e) {
                imageView.setImageResource(R.drawable.ic_menu_gallery);
            }

            @Override
            public void onRetry(MDownloadDataType mDownloadDataType, int retryNo) {

            }
        });
        mProvider.getRequest(mDataTypeImageCancel);
    }

}