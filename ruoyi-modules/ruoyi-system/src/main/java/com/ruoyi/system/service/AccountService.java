package com.ruoyi.system.service;

/**
 * <b><code>AccountService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:55.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public interface AccountService
{
    /**
     * 账户扣减
     * @param userId 用户 ID
     * @param price 扣减金额
     */
    void reduceBalance(Long userId, Double price);
}
