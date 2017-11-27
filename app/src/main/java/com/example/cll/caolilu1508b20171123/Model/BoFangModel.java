package com.example.cll.caolilu1508b20171123.Model;

import android.content.Context;

import com.example.cll.caolilu1508b20171123.Bean.BofangBean;
import com.example.cll.caolilu1508b20171123.utils.Api;
import com.example.cll.caolilu1508b20171123.utils.ApiService;
import com.example.cll.caolilu1508b20171123.utils.RetrofitUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by cll on 2017/11/23.
 */

public class BoFangModel {
    private Context context;

    public BoFangModel(Context context) {
        this.context = context;

    }

    public void gWin(final IBofangModel iBofangModel,String mediaId){
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.getApiService(Api.HOST, ApiService.class);
        Observable<BofangBean> getbf = apiService.getbf(mediaId);
        getbf.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<BofangBean, BofangBean>() {
                    @Override
                    public BofangBean call(BofangBean bofangBean) {
                        return bofangBean;
                    }
                })
                .subscribe(new Subscriber<BofangBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BofangBean bofangBean) {
                          iBofangModel.getShouye(bofangBean);
                    }
                });
    }
}
