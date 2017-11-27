package com.example.cll.caolilu1508b20171123.Presenter;

import android.content.Context;

import com.example.cll.caolilu1508b20171123.Bean.PingBean;
import com.example.cll.caolilu1508b20171123.Model.IPingModel;
import com.example.cll.caolilu1508b20171123.Model.PingModel;
import com.example.cll.caolilu1508b20171123.View.IPingView;

/**
 * Created by cll on 2017/11/24.
 */

public class PingPresenter {
    private Context context;
    private IPingView iPingView;
    private final PingModel pingModel;

    public PingPresenter(Context context, IPingView iPingView) {
        this.context = context;
        this.iPingView = iPingView;
        pingModel = new PingModel(context);
    }
    public void getWin(){
        String bfid = iPingView.bfid();
        pingModel.gWin(new IPingModel() {
            @Override
            public void getShouye(PingBean pingBean) {
                iPingView.Suess(pingBean);
            }
        },bfid);
    }
}
