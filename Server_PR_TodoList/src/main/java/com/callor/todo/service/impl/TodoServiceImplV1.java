package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.connect.DBConnect;
import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {
	protected Connection dbConn;

	public TodoServiceImplV1() {
		dbConn = DBConnect.getDBConnection();
	}

	protected List<TodoVO> select(PreparedStatement pStr) throws SQLException {
		List<TodoVO> tdList = new ArrayList<TodoVO>();

		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {
			TodoVO tdVO = new TodoVO();
			tdVO.setLi_seq(rSet.getLong("li_seq"));
			tdVO.setLi_todo(rSet.getString("li_todo"));
			tdVO.setLi_date(rSet.getString("li_date"));
			tdVO.setLi_time(rSet.getString("li_time"));
			tdVO.setLi_place(rSet.getString("li_place"));
			tdList.add(tdVO);
		}
		System.out.println(tdList.toString());
		return tdList;
	}

	@Override
	public List<TodoVO> selectAll() {
		String sql = " SELECT * FROM tbl_list ";
		sql += " ORDER BY li_seq ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();

			System.out.println(tdList.toString());
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TodoVO findById(String li_seq) {
		// TODO 입력한 seq번호로 찾기
		String sql = " SELECT * FROM tbl_list ";
		sql += " WHERE li_seq = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, li_seq);
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			if(tdList != null && tdList.size() > 0) {
				System.out.println(tdList.toString());
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public List<TodoVO> findByDate(String li_date) {
		// TODO 입력한 날짜에 속하는 데이터 찾기
		String sql = " SELECT * FROM tbl_list ";
		sql += " WHERE li_date = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, li_date);
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert(TodoVO vo) {
		// TODO 데이터 추가하기
		String sql = " INSERT INTO tbl_list ";
		sql += " (";
		sql += " li_todo, ";
		sql += " li_date, ";
		sql += " li_time, ";
		sql += " li_place ) ";
		sql += " values( ?,?,?,? )";
		
		PreparedStatement pStr = null;
		try {
			System.out.println(sql);
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, vo.getLi_todo());
			pStr.setString(2, vo.getLi_date());
			pStr.setString(3, vo.getLi_time());
			pStr.setString(4, vo.getLi_place());
			System.out.println(vo.toString());
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(TodoVO vo) {
		// TODO Auto-generated method stub
		String sql = " UPDATE tbl_list SET ";
		sql += " li_todo = ?, ";
		sql += " li_date = ?, ";
		sql += " li_time = ?, ";
		sql += " li_place = ? ";
		sql += " WHERE li_seq = ? ";
		System.out.println(vo.toString());
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, vo.getLi_todo());
			pStr.setString(2, vo.getLi_date());
			pStr.setString(3, vo.getLi_time());
			pStr.setString(4, vo.getLi_place());
			pStr.setLong(5, vo.getLi_seq());
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public Integer delete(Long li_seq) {
		// TODO Auto-generated method stub
		String sql = " DELETE FROM tbl_list ";
		sql += " WHERE li_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, li_seq);
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

}
