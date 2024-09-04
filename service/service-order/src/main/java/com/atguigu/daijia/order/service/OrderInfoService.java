package com.atguigu.daijia.order.service;

import com.atguigu.daijia.model.entity.order.OrderInfo;
import com.atguigu.daijia.model.form.order.OrderInfoForm;
import com.atguigu.daijia.model.form.order.StartDriveForm;
import com.atguigu.daijia.model.form.order.UpdateOrderBillForm;
import com.atguigu.daijia.model.form.order.UpdateOrderCartForm;
import com.atguigu.daijia.model.vo.base.PageVo;
import com.atguigu.daijia.model.vo.order.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

public interface OrderInfoService extends IService<OrderInfo> {

    //乘客下单
    Long saveOrderInfo(OrderInfoForm orderInfoForm);

    //根据订单id获取订单状态
    Integer getOrderStatus(Long orderId);

    //司机抢单
    Boolean robNewOrder(Long driverId, Long orderId);

    //乘客端查找当前订单
    CurrentOrderInfoVo searchCustomerCurrentOrder(Long customerId);

    //司机端查找当前订单  如果有订单，返回小程序时应该先进入订单
    CurrentOrderInfoVo searchDriverCurrentOrder(Long driverId);

    // 司机到达起始点
    Boolean driverArriveStartLocation(Long orderId, Long driverId);

    Boolean updateOrderCart(UpdateOrderCartForm updateOrderCartForm);

    // 开始代驾服务
    Boolean startDriver(StartDriveForm startDriveForm);

    // 得到时间段内的订单数
    Long getOrderNumByTime(String startTime, String endTime);

    Boolean endDrive(UpdateOrderBillForm updateOrderBillForm);

    //获取乘客订单分页列表
    PageVo findCustomerOrderPage(Page<OrderInfo> pageParam, Long customerId);

    PageVo findDriverOrderPage(Page<OrderInfo> pageParam, Long driverId);

    // 根据订单id获得订单信息
    OrderBillVo getOrderBillInfo(Long orderId);

    // 获得分账信息
    OrderProfitsharingVo getOrderProfitsharing(Long orderId);

    // 发送订单信息
    Boolean sendOrderBillInfo(Long orderId, Long driverId);

    // 获取订单支付信息
    OrderPayVo getOrderPayVo(String orderNo, Long customerId);

    Boolean updateOrderPayStatus(String orderNo);

    OrderRewardVo getOrderRewardFee(String orderNo);

    //调用方法取消订单
    void orderCancel(long parseLong);

    Boolean updateCouponAmount(Long orderId, BigDecimal couponAmount);
}
