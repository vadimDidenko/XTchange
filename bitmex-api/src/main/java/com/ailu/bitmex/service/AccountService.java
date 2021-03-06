package com.ailu.bitmex.service;

import com.ailu.bitmex.bean.BitmexResult;

/**
 * NOTE: 1token 账户信息调用接口 @Version 1.0 @Since JDK1.8 @Author mr.wang @Company Henan ailu @Date
 * 2018/12/15 14:31
 */
public interface AccountService extends BaseService {

  BitmexResult getPosition(String filter);

  BitmexResult getAccount();

  BitmexResult getWallet(String currency);

  BitmexResult getMargin(String currency);
}
