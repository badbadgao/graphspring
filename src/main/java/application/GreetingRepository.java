package application;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepository {

  private Map<String, Greeting> greetings;

  public GreetingRepository() {
    greetings = new HashMap<>();
    Greeting greeting1 = new Greeting("AAAA", "Hi Wei, I am the first one");
    Greeting greeting2 = new Greeting("BBBB", "Hi Wei, I am the second one");
    greetings.put(greeting1.getId(), greeting1);
    greetings.put(greeting2.getId(), greeting2);
  }

  public Greeting save(Greeting greeting) {
    String id = UUID.randomUUID().toString();

    greetings.put(id, greeting);
    greeting.setId(id);

    return greeting;
  }

  public Greeting find(String id) {
    return greetings.get(id);
  }

  public List<Greeting> getAllGreetings() {
    List<Greeting> greetingList = new ArrayList<>();
    greetingList.addAll(greetings.values());
    return greetingList;
  }
}