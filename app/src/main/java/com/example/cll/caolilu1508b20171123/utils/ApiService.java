package com.example.cll.caolilu1508b20171123.utils;

import com.example.cll.caolilu1508b20171123.Bean.BofangBean;
import com.example.cll.caolilu1508b20171123.Bean.PingBean;
import com.example.cll.caolilu1508b20171123.Bean.ShouyeBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DELL on 2017/11/20.
 */

public interface ApiService {
    //拼接请求地址
    @GET("homePageApi/homePage.do")
    Observable<ShouyeBean> getData();

    @GET("videoDetailApi/videoDetail.do")
    Observable<BofangBean> getbf(@Query("mediaId") String mediaId);
    @GET("Commentary/getCommentList.do")
    Observable<PingBean> getPi(@Query("mediaId") String mediaId);
}
