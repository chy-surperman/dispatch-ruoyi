package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Product;

/**
 * <b><code>ProductMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:55.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public interface ProductMapper
{
    public Product selectById(Long productId);

    public void updateById(Product product);
}
