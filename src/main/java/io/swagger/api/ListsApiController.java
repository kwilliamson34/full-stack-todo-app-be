package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.TodoList;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:37:26.578Z")

@Controller
public class ListsApiController implements ListsApi {

    private static final Logger log = LoggerFactory.getLogger(ListsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ListsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> addTodoList(@ApiParam(value = "Name for TodoList to be added to the store" ,required=true )  @Valid @RequestBody Body body) {
        String accept = request.getHeader("Accept");
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
            try {
                return new ResponseEntity<List<TodoList>>(objectMapper.readValue("[ {  \"id\" : \"d4e5f6\",  \"title\" : \"Todo at Work\",  \"items\" : [ {    \"listId\" : \"82734982370\",    \"id\" : \"a1b2c3\",    \"title\" : \"Call the dentist\",    \"done\" : true  }, {    \"listId\" : \"d4e5f6\",    \"id\" : \"a1b2c3\",    \"title\" : \"Call the dentist\",    \"done\" : true  } ]}, {  \"id\" : \"12093810298\",  \"title\" : \"Todo at Home\",  \"items\" : [ {    \"listId\" : \"d4e5f6\",    \"id\" : \"a1b2c3\",    \"title\" : \"Call the dentist\",    \"done\" : true  }, {    \"listId\" : \"d4e5f6\",    \"id\" : \"a1b2c3\",    \"title\" : \"Call the dentist\",    \"done\" : true  } ]} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<TodoList>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<TodoList>>(HttpStatus.NOT_IMPLEMENTED);
//    	return new ResponseEntity<List<TodoList>>(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<TodoList> getTodoList(@ApiParam(value = "TodoList id to get",required=true) @PathVariable("listId") String listId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TodoList>(objectMapper.readValue("{  \"id\" : \"d4e5f6\",  \"title\" : \"Todo at Work\",  \"items\" : [ {    \"listId\" : \"d4e5f6\",    \"id\" : \"a1b2c3\",    \"title\" : \"Call the dentist\",    \"done\" : true  }, {    \"listId\" : \"d4e5f6\",    \"id\" : \"a1b2c3\",    \"title\" : \"Call the dentist\",    \"done\" : true  } ]}", TodoList.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TodoList>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TodoList>(HttpStatus.NOT_IMPLEMENTED);
    }

}
