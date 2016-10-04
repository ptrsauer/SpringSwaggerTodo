package de.ptrsauer;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoItem {

  @Id
  @GeneratedValue
  String _id;

  @ApiModelProperty(example = "Document your API", notes = "The text for your todo item.", required = true)
  String text;

  @ApiModelProperty(notes = "Indicates, if your item is done.", allowableValues = "true, false", example = "true")
  boolean done = false;

  public TodoItem() {
  }

  public TodoItem(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public TodoItem setText(String text) {
    this.text = text;
    return this;
  }

  public boolean isDone() {
    return done;
  }

  public TodoItem setDone(boolean done) {
    this.done = done;
    return this;
  }
}
