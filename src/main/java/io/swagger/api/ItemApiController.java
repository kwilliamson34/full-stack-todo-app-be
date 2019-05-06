package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.TodoItem;
import io.swagger.model.TodoList;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:37:26.578Z")

@Controller
public class ItemApiController implements ItemApi {

    private static final Logger log = LoggerFactory.getLogger(ItemApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private TodoItemRepository repository;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> addTodoItem(@ApiParam(value = "TodoItem object to be added to the store" ,required=true )  @Valid @RequestBody TodoItem body) {
        repository.save(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteItem(@ApiParam(value = "TodoItem id to delete",required=true) @PathVariable("itemId") String itemId) {
    	repository.delete(itemId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	List<TodoItem> allItems = (List<TodoItem>) repository.findAll();
            return new ResponseEntity<List<TodoItem>>(allItems, HttpStatus.OK);
        }
    	return new ResponseEntity<List<TodoItem>>(null);
    }

}
