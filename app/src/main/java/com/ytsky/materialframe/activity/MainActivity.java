package com.ytsky.materialframe.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ytsky.materialframe.R;
import com.ytsky.materialframe.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.recyclerview_test).setOnClickListener(this);
        SimpleDraweeView frescoImage = (SimpleDraweeView) findViewById(R.id.frsco_img1);
        frescoImage.setImageURI(Uri.parse("http://dev.static.17168.com/app/game/700002/intro/2.jpg"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recyclerview_test:
                startActivity(new Intent(this,RecyclerViewActivity.class));
                break;

            default:
                break;
        }
    }
}
