package org.knowm.xchange.abucoins.dto.trade;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO representing the output JSON for the Abucoins <code>GET /orders</code> endpoint. Example:
 * <code><pre>
 * [
 *    {
 *         "id": "7786713",
 *         "price": "0.05367433",
 *         "size": "0.10451686",
 *         "product_id": "ZEC-BTC",
 *         "side": "buy",
 *         "type": "limit",
 *         "time_in_force": "GTC",
 *         "post_only": false,
 *         "created_at": "2017-09-03T03:33:17Z",
 *         "filled_size": "0.00000000",
 *         "status": "closed",
 *         "settled": false
 *     },
 *     {
 *         "id": "7786713",
 *         "price": "0.05367433",
 *         "size": "0.10451686",
 *         "product_id": "ZEC-BTC",
 *         "side": "buy",
 *         "type": "limit",
 *         "time_in_force": "GTC",
 *         "post_only": false,
 *         "created_at": "2017-09-03T03:33:17Z",
 *         "filled_size": "0.00000000",
 *         "status": "closed",
 *         "settled": false
 *     }
 * ]
 * </pre></code>
 *
 * @author bryant_harris
 */
public class AbucoinsOrder {
  String id;
  BigDecimal price;
  BigDecimal size;
  String productID;
  Side side;
  Type type;
  TimeInForce timeInForce;
  boolean postOnly;
  String createdAt;
  BigDecimal filledSize;
  Status status;
  boolean settled;
  String message;

  public AbucoinsOrder(
      @JsonProperty("id") String id,
      @JsonProperty("price") BigDecimal price,
      @JsonProperty("size") BigDecimal size,
      @JsonProperty("product_id") String productID,
      @JsonProperty("side") Side side,
      @JsonProperty("type") Type type,
      @JsonProperty("time_in_force") TimeInForce timeInForce,
      @JsonProperty("post_only") boolean postOnly,
      @JsonProperty("created_at") String createdAt,
      @JsonProperty("filled_size") BigDecimal filledSize,
      @JsonProperty("status") Status status,
      @JsonProperty("settled") boolean settled,
      @JsonProperty("message") String message) {
    this.id = id;
    this.price = price;
    this.size = size;
    this.productID = productID;
    this.side = side;
    this.type = type;
    this.timeInForce = timeInForce;
    this.postOnly = postOnly;
    this.createdAt = createdAt;
    this.filledSize = filledSize;
    this.status = status;
    this.settled = settled;
    this.message = message;
  }

  public String getId() {
    return id;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getSize() {
    return size;
  }

  public String getProductID() {
    return productID;
  }

  public Side getSide() {
    return side;
  }

  public Type getType() {
    return type;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public boolean isPostOnly() {
    return postOnly;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public BigDecimal getFilledSize() {
    return filledSize;
  }

  public Status getStatus() {
    return status;
  }

  public boolean isSettled() {
    return settled;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "AbucoinsOrder [id="
        + id
        + ", price="
        + price
        + ", size="
        + size
        + ", productID="
        + productID
        + ", side="
        + side
        + ", type="
        + type
        + ", timeInForce="
        + timeInForce
        + ", postOnly="
        + postOnly
        + ", createdAt="
        + createdAt
        + ", filledSize="
        + filledSize
        + ", status="
        + status
        + ", settled="
        + settled
        + ", message="
        + message
        + "]";
  }

  public enum Side {
    buy,
    sell
  }

  public enum Type {
    limit,
    market;
  }

  public enum TimeInForce {
    GTC,
    GTT,
    IOC,
    FOK;

    public String toDescription() {
      switch (this) {
        case GTC:
          return "Good Till Canceled";

        case GTT:
          return "Good Till Time";

        case IOC:
          return "Immediate or cancel";

        case FOK:
          return "Fill or kill";
      }
      return ""; // dead code path
    }
  }

  public enum Status {
    pending,
    open,
    done,
    rejected;
  }
}
