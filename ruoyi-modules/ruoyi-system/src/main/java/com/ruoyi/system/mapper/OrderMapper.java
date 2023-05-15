package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Order;

/**
 * <b><code>OrderMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:54.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public interface OrderMapper
{
    public void insert(Order order);

    public void updateById(Order order);
}
