package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

@Component
public class GreetingQuery implements GraphQLQueryResolver {

  @Autowired
  private GreetingRepository greetingRepository;

  @Autowired
  private GreetingDaoRepository greetingDaoRepository;

  @SuppressWarnings("unused")
  public Iterable<Greeting>  getGreetings() {
    return greetingDaoRepository.findAll();
//    return  greetingRepository.getAllGreetings();
  }

  @SuppressWarnings("unused")
  public Greeting getGreeting(String id) {
//    return greetingRepository.find(id);
    return new Greeting("hi", "wei");
  }
}