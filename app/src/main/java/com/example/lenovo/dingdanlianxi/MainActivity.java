package com.example.lenovo.dingdanlianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.dingdanlianxi.Adapter.DingAdapter;
import com.example.lenovo.dingdanlianxi.Bean.DingBean;
import com.example.lenovo.dingdanlianxi.Bean.XiuDingBean;
import com.example.lenovo.dingdanlianxi.Presenter.getPresenter;
import com.example.lenovo.dingdanlianxi.View.DingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DingView {

    @BindView(R.id.tv_dan)
    TextView tvDan;
    @BindView(R.id.tv_yizhi)
    TextView tvYizhi;
    @BindView(R.id.tv_yiqu)
    TextView tvYiqu;
    @BindView(R.id.rlv_dingshow)
    RecyclerView rlvDingshow;
    private getPresenter p;
    private DingAdapter dingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        p=new getPresenter(this);
        p.Ding("1299","0");

    }

    @Override
    public void onDingSuccess(DingBean dingBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        rlvDingshow.setLayoutManager(linearLayoutManager);
        dingAdapter = new DingAdapter(MainActivity.this, dingBean.getData());
        rlvDingshow.setAdapter(dingAdapter);
        dingAdapter.setOnClickLister(new DingAdapter.OnClickLister() {
            @Override
            public void OnClick(String orderid) {
                p.xiu("1299", "2");
                dingAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void XiugaiSuccess(XiuDingBean bean) {

    }

    @OnClick({R.id.tv_dan, R.id.tv_yizhi, R.id.tv_yiqu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dan:
                p.Ding("1299","0");
                break;
            case R.id.tv_yizhi:
                p.Ding("1299","1");
                Toast.makeText(this, "点击le", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_yiqu:
                p.Ding("1299","2");
                break;
        }
    }


}
