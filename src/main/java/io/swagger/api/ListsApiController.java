package io.swagger.api;

import java.util.ArrayList;
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
import io.swagger.model.Body;
import io.swagger.model.TodoItem;
import io.swagger.model.TodoList;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:37:26.578Z")

@Controller
public class ListsApiController implements ListsApi {

    private static final Logger log = LoggerFactory.getLogger(ListsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private TodoItemRepository repository;
    
    public ArrayList<TodoList> allLists = new ArrayList<>();

    @org.springframework.beans.factory.annotation.Autowired
    public ListsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        
        TodoList homeList = new TodoList();
    	homeList.setTitle("TODO at home");
    	this.allLists.add(homeList);
    	TodoList workList = new TodoList();
    	workList.setTitle("TODO at work");
    	this.allLists.add(workList);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> addTodoList(
    		@ApiParam(value = "Name for TodoList to be added to the store" ,required=true )
    		@Valid @RequestBody Body body
    	) {
        
        TodoList newList = new TodoList();
        newList.setTitle(body.getTitle());
    	this.allLists.add(newList);
        
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteList(@ApiParam(value = "TodoList id to delete",required=true) @PathVariable("listId") String listId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<TodoList>> getAllTodoLists() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<TodoList>>(this.allLists, HttpStatus.OK);
        }
    	return new ResponseEntity<List<TodoList>>(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<TodoItem>> getTodoListItems(
		@ApiParam(value = "TodoList id to get items for",required=true) 
		@PathVariable("listId") String listId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	List<TodoItem> matches = repository.getByListId(listId);
        	return new ResponseEntity<List<TodoItem>>(matches, HttpStatus.OK);
        }

        return new ResponseEntity<List<TodoItem>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
