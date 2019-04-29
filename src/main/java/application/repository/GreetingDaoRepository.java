/**
 * Copyright 2018, Kiwiplan (NZ) Ltd.
 * <p>
 * User: wei.gao
 * Date: 24/08/18
 * Time: 4:15 PM
 */
package application.repository;

import application.greeting.Greeting;
import org.springframework.data.repository.CrudRepository;

/**
 * //TODO
 * <p>
 * Copyright 2018, Kiwiplan (NZ) Ltd.
 *
 * @author $Author:wei.gao $
 * Last Modified: $Date: 24/08/18 4:15 PM $
 * $Id: GreetingDaoRepository.java $
 */
public interface GreetingDaoRepository extends CrudRepository<Greeting, Long>{
}