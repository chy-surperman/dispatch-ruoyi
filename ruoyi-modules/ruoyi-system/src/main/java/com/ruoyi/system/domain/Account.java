package com.ruoyi.system.domain;

import java.util.Date;

/**
 * <b><code>Account</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:47.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public class Account
{
    private Long id;

    /**
     * 余额
     */
    private Double balance;

    private Date lastUpdateTime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance(Double balance)
    {
        this.balance = balance;
    }

    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }
}
