package org.knowm.xchange.dto.trade;

import java.io.Serializable;
import java.util.List;

/**
 * DTO representing open orders
 *
 * <p>Open orders are orders that you have placed with the exchange that have not yet been matched
 * to a counter-party.
 */
public final class OpenOrders implements Serializable {

  private final List<LimitOrder> openOrders;

  /**
   * Constructor
   *
   * @param openOrders The list of open orders
   */
  public OpenOrders(List<LimitOrder> openOrders) {

    this.openOrders = openOrders;
  }

  public List<LimitOrder> getOpenOrders() {

    return openOrders;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    if (getOpenOrders().isEmpty()) {
      sb.append("No open orders!");
    } else {
      sb.append("Open orders: \n");
      for (LimitOrder order : getOpenOrders()) {
        sb.append("[order=");
        sb.append(order.toString());
        sb.append("]\n");
      }
    }
    return sb.toString();
  }
}
