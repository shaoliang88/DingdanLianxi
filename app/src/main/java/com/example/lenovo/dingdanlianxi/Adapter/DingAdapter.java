package com.example.lenovo.dingdanlianxi.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lenovo.dingdanlianxi.Bean.DingBean;
import com.example.lenovo.dingdanlianxi.R;

import java.util.List;


public class DingAdapter extends RecyclerView.Adapter {

    private OnClickLister onClickLister;
    private Context context;
    private List<DingBean.DataBean> list;

    public DingAdapter(Context context, List<DingBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public OnClickLister getOnClickLister() {
        return onClickLister;
    }

    public void setOnClickLister(OnClickLister onClickLister) {
        this.onClickLister = onClickLister;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LinearLayout.inflate(context, R.layout.layout_item_ding, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        /*myViewHolder.tvTitle.setText(list.get(position).getTitle());*/
        myViewHolder.tvPrice.setText("价格:"+list.get(position).getPrice()+"");
        myViewHolder.tvTime.setText("创建时间："+list.get(position).getCreatetime());
        int status = list.get(position).getStatus();
        if (status==0){
            myViewHolder.tvStatus.setText("待支付");
        }else if (status==1){
            myViewHolder.tvStatus.setText("已支付");
        }else if (status==2){
            myViewHolder.tvStatus.setText("已取消");
        }
        myViewHolder.tvQuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final EditText inputServer = new EditText(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("是否取消订单").setIcon(android.R.drawable.ic_dialog_info)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        onClickLister.OnClick(list.get(position).getOrderid()+"");
                        Toast.makeText(context, "已取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final Button tvQuxiao;
        private final TextView tvStatus;
        private final TextView tvTime;
        private final TextView tvPrice;
        private final TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_ding_title);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_ding_price);
            tvTime = (TextView)itemView.findViewById(R.id.tv_ding_time);
            tvStatus = (TextView)itemView.findViewById(R.id.tv_dingstatus);
            tvQuxiao = (Button)itemView.findViewById(R.id.but_quxiao);
        }
    }
    public interface OnClickLister{
        void OnClick(String orderid);
    }
}