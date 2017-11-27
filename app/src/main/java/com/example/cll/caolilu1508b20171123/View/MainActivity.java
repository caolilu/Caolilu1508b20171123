package com.example.cll.caolilu1508b20171123.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cll.caolilu1508b20171123.Adapter.ShouyeAdpater;
import com.example.cll.caolilu1508b20171123.Bean.ShouyeBean;
import com.example.cll.caolilu1508b20171123.Presenter.ShouyePresenter;
import com.example.cll.caolilu1508b20171123.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IShouyeView {
    private List<String> list=new ArrayList<String>();
    private List<String> jid=new ArrayList<String>();
    private Banner mBanname;
    private RecyclerView mRv;
    private ShouyePresenter shouyePresenter;
    private ShouyeAdpater shouyeAdpater;
    private String dataId;
    private List<ShouyeBean.RetBean.ListBean.ChildListBean> childList1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        shouyePresenter.getWin();
    }

    private void initView() {
        mBanname = (Banner) findViewById(R.id.Banname);
        mBanname.setOnClickListener(this);
        mRv = (RecyclerView) findViewById(R.id.Rv);
        shouyePresenter = new ShouyePresenter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Banname:


                break;
        }
    }

    @Override
    public void Suess(ShouyeBean shouyeBean) {
        final List<ShouyeBean.RetBean.ListBean.ChildListBean> childList = shouyeBean.getRet().getList().get(0).getChildList();
        List<ShouyeBean.RetBean.ListBean> listBeen = shouyeBean.getRet().getList();
        for (int q=0;q<listBeen.size();q++){
            childList1 = listBeen.get(q).getChildList();
        }
        shouyeAdpater = new ShouyeAdpater(MainActivity.this, childList1);
        mRv.setAdapter(shouyeAdpater);
        //  for (int i=0;i<listBeen.size();i++){
//            List<ShouyeBean.RetBean.ListBean.ChildListBean> childList1 = listBeen.get(i).getChildList();
//            new
//        }
        for (int a=0;a<childList.size();a++) {
            this.list.add(childList.get(a).getPic());
        }

//        } for (int a=0;a<list.size();a++){
//            dataId = childList.get(a).getDataId();
//        }
        mBanname.setImages(this.list);
        mBanname.setDelayTime(2000);
        mBanname.setImageLoader(new Glider());
        mBanname.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanname.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                dataId = childList.get(position).getDataId();
                Intent intent = new Intent(MainActivity.this, BofangActivity.class);
                intent.putExtra("id",dataId);
                intent.putExtra("qq",1);
                startActivity(intent);
            }
        });
        mBanname.start();

    }
    public class Glider extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into((ImageView) imageView);
        }
    }
}
