package com.ruoyi.system.domain.dto;

/**
 * <b><code>ReduceStockRequest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:53.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public class ReduceStockRequest
{
    private Long productId;

    private Integer amount;

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
}
