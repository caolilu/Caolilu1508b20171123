package com.example.cll.caolilu1508b20171123.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cll.caolilu1508b20171123.Adapter.PingAdapter;
import com.example.cll.caolilu1508b20171123.Bean.PingBean;
import com.example.cll.caolilu1508b20171123.Presenter.PingPresenter;
import com.example.cll.caolilu1508b20171123.R;

import java.util.List;

/**
 * Created by cll on 2017/11/23.
 */

public class HomeFragment extends Fragment implements IPingView{
    private View view;
    private RecyclerView mRv;
    private String id1;
    private PingPresenter pingPresenter;
    private String ids;
    private String llid;
    private String a;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2, container, false);
        Intent intent = getActivity().getIntent();
        ids = intent.getStringExtra("id");
        llid = intent.getStringExtra("llid");
        if (llid==null){
            a=ids;
        }else{
            a=llid;
        }
        initView(view);
        pingPresenter.getWin();
        llid=null;
        return view;
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        pingPresenter = new PingPresenter(getActivity(), this);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void Suess(PingBean pingBean) {
        List<PingBean.RetBean.ListBean> list = pingBean.getRet().getList();
       PingAdapter pingAdapter = new PingAdapter(getActivity(), list);
        mRv.setAdapter(pingAdapter);
    }

    @Override
    public String bfid() {
        return a;
    }
}
