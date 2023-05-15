package com.ruoyi.system.domain.dto;

/**
 * <b><code>PlaceOrderRequest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:53.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public class PlaceOrderRequest
{
    private Long userId;

    private Long productId;

    private Integer amount;

    public PlaceOrderRequest()
    {
    }

    public PlaceOrderRequest(Long userId, Long productId, Integer amount)
    {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

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
