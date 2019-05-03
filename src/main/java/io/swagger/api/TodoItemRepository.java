package io.swagger.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.model.TodoItem;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, String> {

	TodoItem findById(String itemId);

	@Transactional
	TodoItem deleteById(String itemId);
	
	@SuppressWarnings("unchecked")
	@Transactional
	TodoItem save(TodoItem item);

	List<TodoItem> getByListId(String listId);
}