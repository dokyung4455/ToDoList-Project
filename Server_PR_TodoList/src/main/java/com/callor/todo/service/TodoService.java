package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.TodoVO;

public interface TodoService {
	
	public List<TodoVO> selectAll(); // 
	public TodoVO findById(String li_seq);
	public List<TodoVO> findByDate(String li_date);
	public Integer insert(TodoVO vo);
	public Integer update(TodoVO vo);
	public Integer delete(Long li_seq);

}

