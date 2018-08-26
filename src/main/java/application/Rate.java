/**
 * Copyright 2018, Kiwiplan (NZ) Ltd.
 * <p>
 * User: wei.gao
 * Date: 23/08/18
 * Time: 8:54 AM
 */
package application;

/**
 * //TODO
 * <p>
 * Copyright 2018, Kiwiplan (NZ) Ltd.
 *
 * @author $Author:wei.gao $
 * Last Modified: $Date: 23/08/18 8:54 AM $
 * $Id: Rate.java $
 */
public class Rate {
  private String currency;

  private double rate;

  public Rate(String currency, double rate) {
    this.currency = currency;
    this.rate = rate;
  }

  /**
   * Gets currency.
   *
   * @return Value of currency.
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets new currency.
   *
   * @param currency New value of currency.
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Gets rate.
   *
   * @return Value of rate.
   */
  public double getRate() {
    return rate;
  }

  /**
   * Sets new rate.
   *
   * @param rate New value of rate.
   */
  public void setRate(double rate) {
    this.rate = rate;
  }
}