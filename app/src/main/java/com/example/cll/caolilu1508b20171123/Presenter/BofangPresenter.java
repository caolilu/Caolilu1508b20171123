package com.example.cll.caolilu1508b20171123.Presenter;

import android.content.Context;

import com.example.cll.caolilu1508b20171123.Bean.BofangBean;
import com.example.cll.caolilu1508b20171123.Model.BoFangModel;
import com.example.cll.caolilu1508b20171123.Model.IBofangModel;
import com.example.cll.caolilu1508b20171123.View.IBofangView;

/**
 * Created by cll on 2017/11/23.
 */

public class BofangPresenter {
    private Context context;
    private IBofangView iBofangView;
    private final BoFangModel boFangModel;


    public BofangPresenter(Context context, IBofangView iBofangView) {
        this.context = context;
        this.iBofangView = iBofangView;
        boFangModel = new BoFangModel(context);
    }
    public void getWin(){
        String bfid = iBofangView.bfid();
        boFangModel.gWin(new IBofangModel() {
            @Override
            public void getShouye(BofangBean bofangBean) {
                iBofangView.Suess(bofangBean);
            }
        },bfid);
    }
}
