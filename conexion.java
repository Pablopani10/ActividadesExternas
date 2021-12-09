public class conexion {
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
}
