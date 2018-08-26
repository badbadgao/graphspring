/**
 * Copyright 2018, Kiwiplan (NZ) Ltd.
 * <p>
 * User: wei.gao
 * Date: 23/08/18
 * Time: 8:53 AM
 */
package application;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * //TODO
 * <p>
 * Copyright 2018, Kiwiplan (NZ) Ltd.
 *
 * @author $Author:wei.gao $
 * Last Modified: $Date: 23/08/18 8:53 AM $
 * $Id: Query.java $
 */
public class Query implements GraphQLQueryResolver {

  @CrossOrigin(origins = "http://localhost:3000")
  public Rate getRate(String currency) {
    return new Rate(currency, 0.9);
  }
}