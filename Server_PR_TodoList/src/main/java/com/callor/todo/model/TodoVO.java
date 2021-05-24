package com.callor.todo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
	
	Long li_seq;
	String li_todo;
	String li_date;
	String li_time;
	String li_place;

}
