package com.example.lenovo.dingdanlianxi.Model;

import com.example.lenovo.dingdanlianxi.Bean.DingBean;
import com.example.lenovo.dingdanlianxi.Bean.XiuDingBean;
import com.example.lenovo.dingdanlianxi.Utils.RetrofitHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/4/11.
 */

public class getModel {
    public void Dingdan(final getData data, String uid, String status){
        RetrofitHelp.getAPI().getDing(uid,status).subscribeOn(Schedulers.io())
                //需要在主线程更新UI
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DingBean>() {
                    @Override
                    public void accept(DingBean bean) throws Exception {
                        data.data(bean);
                    }
                });
    }
    public void Xiuding(final getXiu xiu, String uid, String orderid){
RetrofitHelp.getAPI().getXiuDing(uid,"2") .subscribeOn(Schedulers.io())
        //需要在主线程更新UI
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<XiuDingBean>() {
            @Override
            public void accept(XiuDingBean xiuDingBean) throws Exception {
                xiu.xiu(xiuDingBean);
            }
        });
    }
     public  interface getData{
         void data(DingBean bean);
    }
    public interface getXiu{
        void xiu(XiuDingBean xiuDingBean);
    }
}
