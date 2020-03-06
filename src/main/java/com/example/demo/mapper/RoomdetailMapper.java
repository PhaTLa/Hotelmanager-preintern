package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Roomdetail;

public class RoomdetailMapper implements RowMapper<Roomdetail> {

	@Override
	public Roomdetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id=rs.getInt("id");
		int roomnumber=rs.getInt("roomnumber");
		String roomstatus=rs.getString("roomstatus");
		int pricehour=rs.getInt("perhour");
		int priceday=rs.getInt("perday");
		String des=rs.getString("des");
		int idtype=rs.getInt("idtype");
		
		return new Roomdetail(id, roomnumber, roomstatus, pricehour, priceday, des, idtype);
	}

}
