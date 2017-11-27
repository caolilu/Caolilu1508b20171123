package com.example.cll.caolilu1508b20171123.Presenter;

import android.content.Context;

import com.example.cll.caolilu1508b20171123.Bean.ShouyeBean;
import com.example.cll.caolilu1508b20171123.Model.IShouyeModel;
import com.example.cll.caolilu1508b20171123.Model.ShouyeModel;
import com.example.cll.caolilu1508b20171123.View.IShouyeView;

/**
 * Created by cll on 2017/11/23.
 */

public class ShouyePresenter {
    private Context context;
    private IShouyeView iShouyeView;
    private final ShouyeModel shouyeModel;

    public ShouyePresenter(Context context, IShouyeView iShouyeView) {
        this.context = context;
        this.iShouyeView = iShouyeView;
        shouyeModel = new ShouyeModel(context);
    }
    public void getWin(){
        shouyeModel.gWin(new IShouyeModel() {
            @Override
            public void getShouye(ShouyeBean shouyeBean) {
                iShouyeView.Suess(shouyeBean);
            }
        });
    }
}
