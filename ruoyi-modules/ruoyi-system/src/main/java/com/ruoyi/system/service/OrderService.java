package com.ruoyi.system.service;

import com.ruoyi.system.domain.dto.PlaceOrderRequest;

/**
 * <b><code>OrderService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:56.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public interface OrderService
{
    /**
     * 下单
     *
     * @param placeOrderRequest 订单请求参数
     */
    void placeOrder(PlaceOrderRequest placeOrderRequest);
}
