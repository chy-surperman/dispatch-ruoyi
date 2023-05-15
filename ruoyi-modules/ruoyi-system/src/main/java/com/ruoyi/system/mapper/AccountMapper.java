package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Account;

/**
 * <b><code>AccountMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21 15:54.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
public interface AccountMapper
{
    public Account selectById(Long userId);

    public void updateById(Account account);
}
