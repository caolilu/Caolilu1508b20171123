package com.example.cll.caolilu1508b20171123.Model;

import android.content.Context;

import com.example.cll.caolilu1508b20171123.Bean.ShouyeBean;
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

public class ShouyeModel {
    private Context context;

    public ShouyeModel(Context context) {
        this.context = context;
    }
    public void gWin(final IShouyeModel iShouyeModel){
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        ApiService apiService = retrofitUtil.getApiService(Api.HOST, ApiService.class);
        Observable<ShouyeBean> data = apiService.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ShouyeBean, ShouyeBean>() {
                    @Override
                    public ShouyeBean call(ShouyeBean shouyeBean) {
                        return shouyeBean;
                    }
                })
                .subscribe(new Subscriber<ShouyeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShouyeBean shouyeBean) {
                        iShouyeModel.getShouye(shouyeBean);
                    }
                });
    }
}
