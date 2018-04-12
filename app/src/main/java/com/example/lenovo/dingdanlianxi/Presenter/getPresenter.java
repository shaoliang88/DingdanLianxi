package com.example.lenovo.dingdanlianxi.Presenter;

import com.example.lenovo.dingdanlianxi.Bean.DingBean;
import com.example.lenovo.dingdanlianxi.Bean.XiuDingBean;
import com.example.lenovo.dingdanlianxi.Model.getModel;
import com.example.lenovo.dingdanlianxi.View.DingView;

/**
 * Created by lenovo on 2018/4/11.
 */

public class getPresenter {
    private final getModel model;
    private DingView view;

    public getPresenter(DingView view) {
        this.view = view;
        model=new getModel();
    }
    public void Ding(String uid, String status){
        model.Dingdan(new getModel.getData() {
            @Override
            public void data(DingBean bean) {
                view.onDingSuccess(bean);
            }
        },uid,status);
    }
    public void xiu(String uid, String orderid){
        model.Xiuding(new getModel.getXiu() {
            @Override
            public void xiu(XiuDingBean xiuDingBean) {
            view.XiugaiSuccess(xiuDingBean);
            }
        },uid,"2");
    }
}
