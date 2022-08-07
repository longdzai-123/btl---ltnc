package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import MODEL.tinh;

public class Data {
   public static List<tinh> province(Connection conn) throws Exception{
	   
	   ArrayList<tinh> list = new ArrayList<tinh>();
	   String sql = "select * from tinh";
	   PreparedStatement ptmt = conn.prepareStatement(sql);
	   ResultSet rs = ptmt.executeQuery();
	   
	   while(rs.next()) {
		   tinh t = new tinh();
		   int id_tinh = rs.getInt(1);
		   String tentinh = rs.getString(2);
		   t.setId_tinh(id_tinh);
		   t.setTen_tinh(tentinh);
		   
		   list.add(t);
	   }
	   
	   return list;
	   
   }
   public static String tenTinhbyID(int a,Connection conn) throws Exception  {
	   
	   ArrayList<tinh> list = new ArrayList<tinh>();
	   String sql = "select * from tinh";
	   PreparedStatement ptmt = conn.prepareStatement(sql);
	   ResultSet rs = ptmt.executeQuery();
	   
	   while(rs.next()) {
		   tinh t = new tinh();
		   int id_tinh = rs.getInt(1);
		   String tentinh = rs.getString(2);
		   t.setId_tinh(id_tinh);
		   t.setTen_tinh(tentinh);
		   
		   list.add(t);
	   }
	   String tentinh = null;
	   for (tinh t : list) {
		   if(t.getId_tinh() == a ) {
			  tentinh = t.getTen_tinh();
		   }
		
	}
	return tentinh;
	   
   }
public static int idTinhbyTenTinh(String tenTinh,Connection conn) throws Exception  {
	   
	   ArrayList<tinh> list = new ArrayList<tinh>();
	   String sql = "select * from tinh";
	   PreparedStatement ptmt = conn.prepareStatement(sql);
	   ResultSet rs = ptmt.executeQuery();
	   
	   while(rs.next()) {
		   tinh t = new tinh();
		   int id_tinh = rs.getInt(1);
		   String tentinh = rs.getString(2);
		   t.setId_tinh(id_tinh);
		   t.setTen_tinh(tentinh);
		   
		   list.add(t);
	   }
	   int idtinh = 0;
	   for (tinh t : list) {
		   if(t.getTen_tinh().equals(tenTinh) ) {
			  idtinh = t.getId_tinh();
		   }
		
	}
	return idtinh;
	   
   }
}
