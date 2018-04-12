package com.example.lenovo.dingdanlianxi.Utils;

import com.example.lenovo.dingdanlianxi.Bean.DingBean;
import com.example.lenovo.dingdanlianxi.Bean.XiuDingBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/4/11.
 */

public interface ServiceApi {
    @GET("getOrders")
    Observable<DingBean> getDing(@Query("uid") String uid, @Query("status") String status);
    //http://120.27.23.105/product/updateOrder?uid=1299&status=2&orderId=6535
    @GET("updateOrder")
    Observable<XiuDingBean> getXiuDing(@Query("uid") String uid, @Query("status") String status);
}
