
package com.mycompany.proyectoluis;
package Datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.DiaParcialVO;
import VO.SolicitudVO;

public class DiaParcialDAO {

	
	private static String driver = "com.mysql.cj.jdbc.Driver";

	public static Connection obtenerConexion() {
		Connection conexion = null;

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ActividadesExternas", "root",
					"admin1234");
		} catch (Exception e) {
			System.out.println("error al obtener la conexión");
		}

		return conexion;
	}
	
	
	
	public static int guardarDiaParcial(DiaParcialVO DiaParcial) {

		int estado = 0;
		int idGenerado; 

		try {
			Connection conexion = DiaParcialDAO.obtenerConexion();
			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO DiaParcial(id,diurno,nocturno) VALUES (?,?,?)",  Statement.RETURN_GENERATED_KEYS);
			
			 ps.setBoolean(1, DiaParcial.isId());
			 ps.setBoolean(2, DiaParcial.isDiurno());
			 ps.setBoolean(3, DiaParcial.isNocturno());
		
			estado = ps.executeUpdate();
			
			
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
			         idGenerado = generatedKeys.getInt(1);
			         System.out.println("prueba: "+idGenerado);
			}
			
			conexion.close();

		} catch (Exception e) {

		}

		return estado;

	}
	
	
	public static int modificarDiaParcial(DiaParcialVO DiaParcial){
		int status=0;
		try{
			Connection con=DiaParcialDAO.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("update DiaParcial set id=?, diurno=?,nocturno=?");
			 ps.setBoolean(1, DiaParcial.isId());
			 ps.setBoolean(2, DiaParcial.isDiurno());
			 ps.setBoolean(3, DiaParcial.isNocturno());;
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int borrarDiaParcial(int id){
		int status=0;
		try{
			Connection con=DiaParcialDAO.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("delete from DiaParcial where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	public static List<DiaParcialVO> obtenerDiaParcial(){
		List<DiaParcialVO> list=new ArrayList<DiaParcialVO>();
		
		try{
			Connection con=DiaParcialDAO.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("select * from DiaParcial");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				DiaParcialVO p = new DiaParcialVO();
				p.setId(rs.getBoolean(1));
				p.setDiurno(rs.getBoolean(2));
				p.setNocturno(rs.getBoolean(3));
				list.add(p);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}