package org.knowm.xchange.liqui;

import org.knowm.xchange.liqui.Liqui.Pairs;
import org.knowm.xchange.liqui.dto.account.result.LiquiAccountInfoResult;
import org.knowm.xchange.liqui.dto.trade.result.*;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("tapi")
@Produces(MediaType.APPLICATION_JSON)
public interface LiquiAuthenticated {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  LiquiAccountInfoResult getInfo(
      @HeaderParam("Key") String key,
      @HeaderParam("Sign") ParamsDigest signer,
      @FormParam("nonce") SynchronizedValueFactory<Long> nonce,
      @FormParam("method") String method);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  LiquiTradeResult trade(
      @HeaderParam("Key") String key,
      @HeaderParam("Sign") ParamsDigest signer,
      @FormParam("nonce") SynchronizedValueFactory<Long> nonce,
      @FormParam("method") String method,
      @FormParam("pair") Pairs pair,
      @FormParam("type") String type,
      @FormParam("rate") String rate,
      @FormParam("amount") String amount);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  LiquiActiveOrdersResult activeOrders(
      @HeaderParam("Key") String key,
      @HeaderParam("Sign") ParamsDigest signer,
      @FormParam("nonce") SynchronizedValueFactory<Long> nonce,
      @FormParam("method") String method,
      @FormParam("pair") Pairs pair);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  LiquiOrderInfoResult orderInfo(
      @HeaderParam("Key") String key,
      @HeaderParam("Sign") ParamsDigest signer,
      @FormParam("nonce") SynchronizedValueFactory<Long> nonce,
      @FormParam("method") String method,
      @FormParam("order_id") long orderId);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  LiquiCancelOrderResult cancelOrder(
      @HeaderParam("Key") String key,
      @HeaderParam("Sign") ParamsDigest signer,
      @FormParam("nonce") SynchronizedValueFactory<Long> nonce,
      @FormParam("method") String method,
      @FormParam("order_id") long orderId);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  LiquiTradeHistoryResult tradeHistory(
      @HeaderParam("Key") String key,
      @HeaderParam("Sign") ParamsDigest signer,
      @FormParam("nonce") SynchronizedValueFactory<Long> nonce,
      @FormParam("method") String method,
      @FormParam("from") Long fromTrade,
      @FormParam("count") Integer amountOfTrades,
      @FormParam("end_id") Long toTradeId,
      @FormParam("order") String order,
      @FormParam("since") Long startTime,
      @FormParam("end") Long endTime,
      @FormParam("pair") Pairs pair);
}
