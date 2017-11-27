package com.example.cll.caolilu1508b20171123.Adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cll.caolilu1508b20171123.Bean.ShouyeBean;
import com.example.cll.caolilu1508b20171123.R;
import com.example.cll.caolilu1508b20171123.View.BofangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by cll on 2017/11/23.
 */

public class ShouyeAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShouyeBean.RetBean.ListBean.ChildListBean> list;

    public ShouyeAdpater(Context context, List<ShouyeBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouitem, parent, false);
        return new MyApater(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                        MyApater myApater= (MyApater) holder;
            myApater.dym.setText(list.get(position).getTitle());
            String pic = list.get(position).getPic();
            Uri parse = Uri.parse(pic);
            myApater.imageView.setImageURI(parse);
            myApater.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BofangActivity.class);
                    intent.putExtra("id",list.get(position).getDataId());
                    Toast.makeText(context,list.get(position).getDataId(),Toast.LENGTH_SHORT).show();
                    context.startActivity(intent);
                }
            });
        }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyApater extends RecyclerView.ViewHolder{

        private final SimpleDraweeView imageView;
        private final TextView dym;

        public MyApater(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagename);
            dym = itemView.findViewById(R.id.dym);
        }
    }
}
