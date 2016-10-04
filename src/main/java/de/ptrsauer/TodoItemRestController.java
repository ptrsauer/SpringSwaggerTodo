package de.ptrsauer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "/api"
    , tags = "Retrieve TODOs"
    , description = "Look, here you get all your todo items."
    , produces = "application/json"
    , consumes = "application/json")
public class TodoItemRestController {

  @Autowired
  TodoItemRepository todoItemRepository;

  @RequestMapping(value = "/todos", method = RequestMethod.GET)
  @ApiOperation(value = "Get all your ToDo items."
      , produces = "application/json"
      , notes = "Here are some notes."
  )
  @ApiResponses({
      @ApiResponse(code = 200, message = "All your todo items.", responseContainer = "List", response = TodoItem.class)
  })
  ResponseEntity<Iterable<TodoItem>> getTodoItems() {
    Iterable<TodoItem> all = todoItemRepository.findAll();
    return ResponseEntity.ok(all);
  }

  @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
  @ApiOperation(value = "Information for one specific item."
      , produces = "application/json"
  )
  @ApiResponses({
      @ApiResponse(code = 200, message = "Information on one specific item.", response = TodoItem.class),
      @ApiResponse(code = 404, message = "No item for the given id")
  })
  ResponseEntity<TodoItem> getTodoItem(
      @ApiParam(value = "the id of the item"
                , required = true
                , name = "ID"
                , example = "2") @PathVariable String id
  ) {
    TodoItem todoItem = todoItemRepository.findOne(id);
    if (todoItem != null) {
      return ResponseEntity.ok(todoItem);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
