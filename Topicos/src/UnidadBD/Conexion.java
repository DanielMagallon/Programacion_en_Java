package UnidadBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Conexion
{
	Connection conexion;

	public Conexion(String bd, String localhost)
	{
		driver();
		conectarBD(bd, localhost);
	}

	public void driver()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void conectarBD(String bd, String localhost)
	{
		conexion = null;

		try
		{
			conexion = DriverManager.getConnection("jdbc:mysql://" + localhost + "/" + bd, "root", "root");
			System.out.println("Conectado");

		} catch (SQLException e)
		{
			System.out.println("Error de conexion en la bd");
			e.printStackTrace();
		}
	}

	public void agregarCB(String nombre,int edad)
	{
//		String consulta = "INSERT INTO Jugadores Values('" + rfc + "','" + nombre + "','" + dir + "','" + edad + "','"
//				+ tel + "','" + sexo + "')";
		String con = "INSERT INTO Jugadores Values('" + edad + "','" + nombre +"')";
		
		try
		{
			Statement s = conexion.createStatement();
			
			s.executeUpdate(con);
			
			System.out.println("Registro agregado");
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregarV(String nombre, int edad)
	{
		String con = "INSERT INTO Jugadores Values(?,?)";
		
		PreparedStatement ps;
		
		try
		{
			ps = conexion.prepareStatement(con);
		
			ps.setInt(1, edad);
			ps.setString(2, nombre);
			ps.execute();
			System.out.println("Agregado");
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Vector<String>> consulta(String consulta)
	{
		Vector<Vector<String>> vector = new Vector<Vector<String>>();

		try
		{

			Statement st = conexion.createStatement();

			// Execute query-> cuando no se altera la bd
			// Ecuteupdat cuando si, (insert into)
			ResultSet rs = st.executeQuery(consulta);
			int ind = 0;

			while (rs.next())
			{
				vector.add(new Vector<String>());
				vector.get(ind).add(rs.getInt(1) + "");
				vector.get(ind).add(rs.getString(2));
				ind++;
			}
			
			System.out.println(vector);

		} catch (SQLException e)
		{
			System.out.println("Error al consultar");
			e.printStackTrace();
		}

		return vector;
	}

	public void update(int id, String name)
	{
		String s = "UPDATE Jugadores set id=?, nombre=? WHERE id=?";
	}
}
