package com.ailu.bitmex.service.impl;

import com.ailu.bitmex.bean.BitmexResult;
import com.ailu.bitmex.client.BitmexClient;
import com.ailu.bitmex.service.AccountService;
import com.ailu.bitmex.service.BaseService;


/** NOTE: @Version 1.0 @Since JDK1.8 @Author mr.wang @Company Henan ailu @Date 2018/12/15 15:02 */
public class AccountServiceImpl implements AccountService, BaseService {

  private BitmexClient bitmexClient;

  public AccountServiceImpl(BitmexClient bitmexClient) {
    this.bitmexClient = bitmexClient;
  }

  @Override
  public BitmexResult getPosition(String filter) {
    BitmexResult resultBody =
        this.bitmexClient.client.executeSync(this.bitmexClient.api.getPositions(filter));
    return resultBody;
  }

  @Override
  public BitmexResult getAccount() {
    BitmexResult bitmexAccount =
        this.bitmexClient.client.executeSync(this.bitmexClient.api.getAccount());
    return bitmexAccount;
  }

  @Override
  public BitmexResult getWallet(String currency) {
    BitmexResult bitmexWallet =
        this.bitmexClient.client.executeSync(this.bitmexClient.api.getWallet(currency));
    return bitmexWallet;
  }

  @Override
  public BitmexResult getMargin(String currency) {
    BitmexResult bitmexMarginAccount =
        this.bitmexClient.client.executeSync(
            this.bitmexClient.api.getMarginAccountStatus(currency));
    return bitmexMarginAccount;
  }
}
