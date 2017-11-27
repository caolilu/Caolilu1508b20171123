package com.example.cll.caolilu1508b20171123.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cll.caolilu1508b20171123.Adapter.JianjieAdapter;
import com.example.cll.caolilu1508b20171123.Bean.BofangBean;
import com.example.cll.caolilu1508b20171123.Presenter.BofangPresenter;
import com.example.cll.caolilu1508b20171123.R;

import java.util.List;

/**
 * Created by cll on 2017/11/23.
 */

public class ClassFragment extends Fragment implements IBofangView {
    private View view;
    private TextView mDaoyan;
    private TextView mYanyuan;
    private RecyclerView mGi;
    private BofangPresenter bofangPresenter;
    private String dataId;
    private String llid;
    private String a;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1, container, false);
        Intent intent = getActivity().getIntent();
        dataId = intent.getStringExtra("id");
        llid = intent.getStringExtra("llid");
        if (llid==null){
            a=dataId;
        }else{
            a=llid;
        }
        initView(view);
        bofangPresenter.getWin();
        llid=null;
        return view;
    }

    private void initView(View view) {
        mDaoyan = (TextView) view.findViewById(R.id.daoyan);
        mYanyuan = (TextView) view.findViewById(R.id.yanyuan);
        mGi = (RecyclerView) view.findViewById(R.id.Gi);
        mGi.setLayoutManager(new GridLayoutManager(getActivity(),3));
        bofangPresenter = new BofangPresenter(getActivity(), this);
    }

    @Override
    public void Suess(BofangBean bofangBean) {
        BofangBean.RetBean ret = bofangBean.getRet();
        mDaoyan.setText("导演:"+ret.getDirector());
        mYanyuan.setText("演员:"+ret.getActors());

        List<BofangBean.RetBean.ListBean.ChildListBean> childList = bofangBean.getRet().getList().get(0).getChildList();
        JianjieAdapter jianjieAdapter = new JianjieAdapter(getActivity(), childList);
        mGi.setAdapter(jianjieAdapter);

    }

    @Override
    public String bfid() {
        return a;
    }
}
