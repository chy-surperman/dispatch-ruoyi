package com.ruoyi.system.domain.dto;

/**
 * <b><code>ReduceBalanceRequest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:53.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public class ReduceBalanceRequest
{
    private Long userId;

    private Integer price;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }
}

