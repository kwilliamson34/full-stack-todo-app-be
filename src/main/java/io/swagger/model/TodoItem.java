package io.swagger.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TodoItem
 */
@Entity
@Table(name="todo_item")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:37:26.578Z")

public class TodoItem   {
	@Id
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("listId")
  private String listId = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("done")
  private Boolean done = null;

  public TodoItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "a1b2c3", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TodoItem listId(String listId) {
    this.listId = listId;
    return this;
  }

  /**
   * id of the TodoList it belongs to
   * @return listId
  **/
  @ApiModelProperty(example = "d4e5f6", value = "id of the TodoList it belongs to")


  public String getListId() {
    return listId;
  }

  public void setListId(String listId) {
    this.listId = listId;
  }

  public TodoItem title(String title) {
    this.title = title;
    return this;
  }

  /**
   * name of the TodoItem
   * @return title
  **/
  @ApiModelProperty(example = "Call the dentist", required = true, value = "name of the TodoItem")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TodoItem done(Boolean done) {
    this.done = done;
    return this;
  }

  /**
   * whether the TodoItem is checked/completed
   * @return done
  **/
  @ApiModelProperty(value = "whether the TodoItem is checked/completed")


  public Boolean isDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoItem todoItem = (TodoItem) o;
    return Objects.equals(this.id, todoItem.id) &&
        Objects.equals(this.listId, todoItem.listId) &&
        Objects.equals(this.title, todoItem.title) &&
        Objects.equals(this.done, todoItem.done);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, listId, title, done);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    listId: ").append(toIndentedString(listId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

