package org.knowm.xchange.therock;

import org.knowm.xchange.therock.dto.TheRockException;
import org.knowm.xchange.therock.dto.trade.TheRockOrder;
import org.knowm.xchange.therock.service.TheRockDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * The old API V0 https://api.therocktrading.com/doc/v0/index.html#api-Trading_API-GetOrders
 */
@Path("api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TheRockAuthenticatedV0 {

  String X_TRT_NONCE = "X-TRT-NONCE";

  //account

  @POST
  @Path("get_orders")
  TheRockOrder placeOrder(@HeaderParam("X-TRT-KEY") String publicKey, @HeaderParam("X-TRT-SIGN") TheRockDigest signer,
                          @HeaderParam(X_TRT_NONCE) SynchronizedValueFactory<Long> nonceFactory, TheRockOrder order) throws TheRockException, IOException;

}
