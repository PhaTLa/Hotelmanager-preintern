package com.example.demo.services;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.RoomdetailMapper;
import com.example.demo.model.Roomdetail;

@Repository
@Transactional
public class RoomdetailService extends JdbcDaoSupport {
	@Autowired
	public RoomdetailService(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<Roomdetail> getAllRoomDetail(){
		String sql="SELECT r.id,r.roomnumber,r.roomstatus,p.perhour,p.perday,p.des,p.idtype FROM rooms r INNER JOIN prices p ON r.idprice=p.id ORDER BY r.id";
		
		Object[] params= new Object[] {};
		RoomdetailMapper bookingMapper=new RoomdetailMapper();
		List<Roomdetail> list=this.getJdbcTemplate().query(sql,params,bookingMapper);
		return list;
	}
	public Roomdetail getARoomDetail(int id) {
		String sql="SELECT r.id,r.roomnumber,r.roomstatus,p.perhour,p.perday,p.des,p.idtype \r\n" + 
				"FROM `rooms` r INNER JOIN `prices` p ON r.idprice=p.id \r\n" + 
				"WHERE  r.id= ? ";
		Object[] param=new Object[] {id};
		RoomdetailMapper bookingmapper=new RoomdetailMapper();
		Roomdetail booking=this.getJdbcTemplate().queryForObject(sql, param,bookingmapper);
		return booking;
	}
//	public Roomdetail addARoom(Roomdetail aroom) {
//		List<Roomdetail> checklist=this.getAllRoomDetail();
//		for(int i=0;i<checklist.size();i++) {
//			if(aroom.getRoomnumber()==checklist.get(i).getRoomnumber()) {
//				return null;
//			}
//			else if(aroom.getPricehour()==checklist.get(i).getPricehour() && aroom.getPriceday()==checklist.get(i).getPriceday()) {
//				return null;
//			}
//			else {
//				String sql1="INSERT INTO rooms (roomnumber,roomstatus,idprice)\r\n" + 
//						"VALUES \r\n" + 
//						"(:roomnumber,:roomstatus,:idprice)";
//				SqlParameterSource prs=new MapSqlParameterSource()
//						.addValue("roomnumber", aroom.getRoomnumber())
//						.addValue("roomstatus", aroom.getRoomstatus())
//						.addValue("idprice", aroom.getIdprice());
//			}
//		}
//	}
	
}
