package de.ptrsauer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataCommandLineRunner implements CommandLineRunner {

  @Autowired
  TodoItemRepository todoItemRepository;

  @Override
  public void run(String... strings) throws Exception {
    todoItemRepository.save(new TodoItem("Item One"));
    todoItemRepository.save(new TodoItem("Item Two"));
  }
}
