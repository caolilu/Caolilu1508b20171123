package com.example.cll.caolilu1508b20171123.View;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.cll.caolilu1508b20171123.Adapter.Fragmen;
import com.example.cll.caolilu1508b20171123.Bean.BofangBean;
import com.example.cll.caolilu1508b20171123.Presenter.BofangPresenter;
import com.example.cll.caolilu1508b20171123.R;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;


public class BofangActivity extends AppCompatActivity implements View.OnClickListener, IBofangView {


    private RadioButton mBut1;
    private RadioButton mBut2;
    private ViewPager mVp;
    private String ids;
    private IjkVideoView mJiecaoPlayer;
    private BofangPresenter bofangPresenter;
    private String smoothURL;
    private String llid;
    private String a;
    private int qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bofang);
        initView();
        Intent intent = getIntent();
        ids = intent.getStringExtra("id");
        llid = intent.getStringExtra("llid");
        if (llid==null){
            a=ids;
        }else{
            a=llid;
        }

        bofangPresenter.getWin();
        llid=null;
    }

    private void initView() {

        mBut1 = (RadioButton) findViewById(R.id.but1);
        mBut1.setOnClickListener(this);
        mBut2 = (RadioButton) findViewById(R.id.but2);
        mBut2.setOnClickListener(this);
        mVp = (ViewPager) findViewById(R.id.vp);
        mJiecaoPlayer = (IjkVideoView) findViewById(R.id.video_view);
        mVp.setAdapter(new Fragmen(getSupportFragmentManager()));
        bofangPresenter = new BofangPresenter(this, this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                mVp.setCurrentItem(1);
                break;
            case R.id.but2:
                mVp.setCurrentItem(0);
                break;
        }
    }

    @Override
    public void Suess(BofangBean bofangBean) {
        smoothURL = bofangBean.getRet().getSmoothURL();
        String title = bofangBean.getRet().getTitle();
        getSupportActionBar().setTitle(title);
        AndroidMediaController controller = new AndroidMediaController(this, false);

        mJiecaoPlayer.setMediaController(controller);
        // mJiecaoPlayer.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
        mJiecaoPlayer.setVideoURI(Uri.parse(smoothURL));
        mJiecaoPlayer.start();
        }

    private void setOrientation(int orientation) {
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mJiecaoPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mJiecaoPlayer.resume();
    }
    @Override
    public String bfid() {
       return  a;
    }
}
