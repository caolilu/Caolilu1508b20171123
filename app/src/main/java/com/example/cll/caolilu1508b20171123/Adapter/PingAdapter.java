package com.example.cll.caolilu1508b20171123.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cll.caolilu1508b20171123.Bean.PingBean;
import com.example.cll.caolilu1508b20171123.R;

import java.util.List;

/**
 * Created by cll on 2017/11/24.
 */

public class PingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<PingBean.RetBean.ListBean> list;

    public PingAdapter(Context context, List<PingBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ping, parent, false);
        return new My(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
               My my= (My) holder;
        my.ne.setText(list.get(position).getMsg());
        my.num.setText(list.get(position).getPhoneNumber());
        my.shi.setText(list.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class My extends RecyclerView.ViewHolder{

        private final TextView num;
        private final TextView shi;
        private final TextView ne;

        public My(View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
            shi = itemView.findViewById(R.id.shiji);
            ne = itemView.findViewById(R.id.neir);
        }
    }
}
