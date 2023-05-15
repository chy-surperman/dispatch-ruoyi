package com.ruoyi.system.service;

/**
 * <b><code>ProductService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:56.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public interface ProductService
{
    /**
     * 扣减库存
     *
     * @param productId 商品 ID
     * @param amount 扣减数量
     * @return 商品总价
     */
    Double reduceStock(Long productId, Integer amount);
}
