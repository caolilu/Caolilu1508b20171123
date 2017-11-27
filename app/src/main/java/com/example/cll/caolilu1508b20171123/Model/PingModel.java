package com.example.cll.caolilu1508b20171123.Model;

import android.content.Context;

import com.example.cll.caolilu1508b20171123.Bean.PingBean;
import com.example.cll.caolilu1508b20171123.utils.Api;
import com.example.cll.caolilu1508b20171123.utils.ApiService;
import com.example.cll.caolilu1508b20171123.utils.RetrofitUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by cll on 2017/11/24.
 */

public class PingModel {
    private Context context;

    public PingModel(Context context) {
        this.context = context;
    }
    public void gWin(final IPingModel iPingModel, String id){
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.getApiService(Api.HOST, ApiService.class);
        Observable<PingBean> getPi = apiService.getPi(id);
        getPi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<PingBean, PingBean>() {
                    @Override
                    public PingBean call(PingBean bofangBean) {
                        return bofangBean;
                    }
                })
                .subscribe(new Subscriber<PingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PingBean bofangBean) {
                        iPingModel.getShouye(bofangBean);
                    }
                });
    }
}
