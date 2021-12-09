package Datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.DatosProfsoradoVO;
import VO.SolicitudVO;

public class ProfesorDAO {

	
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
	
	
	
	public static int guardarProfesor(ProfesorVO profesor) {

		int estado = 0;
		int idGenerado; 

		try {
			Connection conexion = ProfesorDAO.obtenerConexion();
			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO profesor(DNI,Nombre,NRP, Domicilio, Telefono, Departamento, ActividadesEscolares) VALUES (NULL,?,?,?,?,?,?,?)",  Statement.RETURN_GENERATED_KEYS);
			
			 ps.setString(1, profesor.getDNI());
			 ps.setString(2, profesor.getNombre());
			 ps.setInt(3, profesor.getNRP());
			 ps.setString(4, profesor.getDomicilio());
			 ps.setInt(5, profesor.getTelefono());
			 ps.setString(6, profesor.getDepartamento());
			 ps.setString(7, profesor.getActividadesEscolares());
			 
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
	
	
	public static int modificarProfesor(ProfesorVO p){
		int status=0;
		try{
			Connection con=ProfesorDAO.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("update profesor set DNI=?,  nombre=?,NRP=?,domicilio=?,telefono=?, departamento=? , ActividadesEscolares=?  where id=?");
			ps.setString(1, p.getDNI());
			 ps.setString(2, p.getNombre());
			 ps.setInt(3, p.getNRP());
			 ps.setString(4, p.getDomicilio());
			 ps.setInt(5, p.getTelefono());
			 ps.setString(6, p.getDepartamento());
			 ps.setString(7, p.getActividadesEscolares());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int borrarProfesor(int id){
		int status=0;
		try{
			Connection con=ProfesorDAO.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("delete from profesor where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	public static List<ProfesorVO> obtenerProfesor(){
		List<ProfesorVO> list=new ArrayList<ProfesorVO>();
		
		try{
			Connection con=ProfesorDAO.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("select * from profesor");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProfesorVO p=new ProfesorVO();
				p.setId(rs.getInt(1));
				p.setDNI(rs.getString(2));
				p.setNombre(rs.getString(3));
				p.setNRP(rs.getInt(4));
				p.setDomicilio(rs.getString(5));
				p.setTelefono(rs.getInt(6));
				p.setDepartamento(rs.getString(7));
				p.setActividadesExternas(rs.getString(8));
				list.add(p);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}

