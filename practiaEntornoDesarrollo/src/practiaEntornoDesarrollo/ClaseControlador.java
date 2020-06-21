package practiaEntornoDesarrollo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClaseControlador extends WindowAdapter implements ActionListener
{
	ClaseControlador()
	{
		ClaseVista.menu.setLayout(new FlowLayout());
		ClaseVista.menu.setSize(500, 250);
		ClaseVista.menu.setResizable(false);
		ClaseVista.menu.addWindowListener(this);
		ClaseVista.menu.setLocationRelativeTo(null);
		ClaseVista.menu.setVisible(true);
		ClaseVista.menu.setMenuBar(ClaseVista.barraMenu);

		
		ClaseVista.menuEmpleados.add(ClaseVista.menu1);
		ClaseVista.menu1.addActionListener(this);
		ClaseVista.menuEmpleados.add(ClaseVista.menu2);
		ClaseVista.menu2.addActionListener(this);
		ClaseVista.menuEmpleados.add(ClaseVista.menu3);
		ClaseVista.menu3.addActionListener(this);
		ClaseVista.menuEmpleados.add(ClaseVista.menu4);
		ClaseVista.menu4.addActionListener(this);

		// Asigno el menú a la barrra de menú
		ClaseVista.barraMenu.add(ClaseVista.menuEmpleados);
	}
	public void windowClosing(WindowEvent arg0)
	{
		if(ClaseVista.altaEmpleado.isActive())
		{
			ClaseVista.altaEmpleado.setVisible(false);
		}
		else if(ClaseVista.bajaEmpleado.isActive())
		{
			ClaseVista.bajaEmpleado.setVisible(false);
		}
		else if(ClaseVista.bajaEmpleadoConfirmacion.isActive())
		{
			ClaseVista.bajaEmpleadoConfirmacion.setVisible(false);
		}
		else if(ClaseVista.consultaEmpleado.isActive())
		{
			ClaseVista.consultaEmpleado.setVisible(false);
		}
		else if(ClaseVista.modificacionEmpleado.isActive())
		{
			ClaseVista.modificacionEmpleado.setVisible(false);
		}
		else if(ClaseVista.modificacionEmpleadoConfirmacion.isActive())
		{
			ClaseVista.modificacionEmpleadoConfirmacion.setVisible(false);
		}

		else
		{
			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent evento)
	{						

		// Alta de empleados

		if(evento.getSource().equals(ClaseVista.menu1)) 
		{
			ClaseVista.altaEmpleado.setLayout(new FlowLayout());
			ClaseVista.altaEmpleado.setSize(350, 170);
			ClaseVista.altaEmpleado.setResizable(false);
		    ClaseVista.altaEmpleado.addWindowListener(this);
			ClaseVista.aceptar.addActionListener(this);
			ClaseVista.limpiar.addActionListener(this);
			ClaseVista.altaEmpleado.add(ClaseVista.nombreEmpleado);
			ClaseVista.altaEmpleado.add(ClaseVista.nombreEmpleado1);
			ClaseVista.altaEmpleado.add(ClaseVista.aceptar);
			ClaseVista.altaEmpleado.add(ClaseVista.limpiar);
			ClaseVista.altaEmpleado.setLocationRelativeTo(null);
			ClaseVista.altaEmpleado.setVisible(true);
		}
		if(evento.getSource().equals(ClaseVista.aceptar)) 
		{
			try
			{
				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				ClaseModelo.sentencia = "INSERT INTO empleados (nombreEmpleado) VALUES ('" + ClaseVista.nombreEmpleado1.getText()+ "')";
				ClaseModelo.statement.executeUpdate(ClaseModelo.sentencia);
				System.out.println("Empleado insertado");
			}

			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}

			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}

			finally
			{
				try
				{
					if(ClaseModelo.connection != null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			}

		}
		if(evento.getSource().equals(ClaseVista.limpiar)) 
		{
			ClaseVista.nombreEmpleado1.selectAll();
			ClaseVista.nombreEmpleado1.setText("");
			ClaseVista.nombreEmpleado1.requestFocus();
		}
		// Baja de empleados
		else if(evento.getSource().equals(ClaseVista.menu2)) 
		{
			//Sentencia para recopilar los datos e introducirlos en el choice
			try
			{
				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				ClaseModelo.sentencia = "SELECT * FROM empleados";
				ClaseModelo.rs = ClaseModelo.statement.executeQuery(ClaseModelo.sentencia);

				while(ClaseModelo.rs.next())
				{
					String s=Integer.toString(ClaseModelo.rs.getInt("idEmpleado"));s = s + "-"+ ClaseModelo.rs.getString("nombreEmpleado");ClaseVista.choBajaEmpleado.add(s);
				}
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}
			finally
			{
				try
				{
					if(ClaseModelo.connection!=null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			}

			ClaseVista.bajaEmpleado.setLayout(new FlowLayout());
			ClaseVista.bajaEmpleado.setSize(400, 120);
			ClaseVista.bajaEmpleado.setResizable(false);
			ClaseVista.bajaEmpleado.addWindowListener(this);
			ClaseVista.bajaEmpleado.add(ClaseVista.lblBajaEmpleado);
			ClaseVista.bajaEmpleado.add(ClaseVista.choBajaEmpleado);
			ClaseVista.btnBEAceptar.addActionListener(this);
			ClaseVista.bajaEmpleado.add(ClaseVista.btnBEAceptar);
			ClaseVista.btnBEAceptar.addActionListener(this);
			ClaseVista.bajaEmpleado.setLocationRelativeTo(null);
			ClaseVista.bajaEmpleado.setVisible(true);
		}
		else if(evento.getSource().equals(ClaseVista.btnBEAceptar))
		{
			try
			{
				String[] ESeleccionado=ClaseVista.choBajaEmpleado.getSelectedItem().split("-");

				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				ClaseModelo.sentencia = "DELETE FROM empleados WHERE idEmpleado = " + Integer.parseInt(ESeleccionado[0]);
				ClaseModelo.statement.executeUpdate(ClaseModelo.sentencia);
				System.out.println("Modificado!");
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}
			finally
			{
				try
				{
					if(ClaseModelo.connection!=null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			}	

		}
		// Modificacion de proveedores
		else if(evento.getSource().equals(ClaseVista.menu3)) 
		{
			//Sentencia para recopilar los datos e introducirlos en el choice
			try
			{
				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				ClaseModelo.sentencia = "SELECT * FROM empleados";
				ClaseModelo.rs = ClaseModelo.statement.executeQuery(ClaseModelo.sentencia);
				ClaseVista.choModificacionEmpleado.add("Elija un empleado");
				while(ClaseModelo.rs.next())
				{
					String s=Integer.toString(ClaseModelo.rs.getInt("idEmpleado"));s = s + "-"+ ClaseModelo.rs.getString("nombreEmpleado");
					ClaseVista.choModificacionEmpleado.add(s);
				}
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}
			finally
			{
				try
				{
					if(ClaseModelo.connection!=null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			}

			ClaseVista.modificacionEmpleado.setLayout(new FlowLayout());
			ClaseVista.modificacionEmpleado.setSize(600, 170);
			ClaseVista.modificacionEmpleado.setResizable(false);
			ClaseVista.modificacionEmpleado.addWindowListener(this);
			ClaseVista.btnMEAceptar.addActionListener(this);
			ClaseVista.modificacionEmpleado.add(ClaseVista.lblModificacionEmpleado);
			ClaseVista.modificacionEmpleado.add(ClaseVista.choModificacionEmpleado);
			ClaseVista.modificacionEmpleado.add(ClaseVista.btnMEAceptar);
			ClaseVista.modificacionEmpleado.setLocationRelativeTo(null);
			ClaseVista.modificacionEmpleado.setVisible(true);
		}
		else if(evento.getSource().equals(ClaseVista.btnMEAceptar))
		{
			ClaseVista.modificacionEmpleadoConfirmacion.setLayout(new FlowLayout());
			ClaseVista.modificacionEmpleadoConfirmacion.setSize(350, 170);
			ClaseVista.modificacionEmpleadoConfirmacion.setResizable(false);
			ClaseVista.modificacionEmpleadoConfirmacion.addWindowListener(this);
			ClaseVista.btnMEConfirmar.addActionListener(this);
			ClaseVista.btnMEVolver.addActionListener(this);
			ClaseVista.modificacionEmpleadoConfirmacion.add(ClaseVista.nombreEmpleado);
			ClaseVista.modificacionEmpleadoConfirmacion.add(ClaseVista.nombreEmpleado1);
			ClaseVista.modificacionEmpleadoConfirmacion.add(ClaseVista.btnMEConfirmar);
			ClaseVista.modificacionEmpleadoConfirmacion.add(ClaseVista.btnMEVolver);
			ClaseVista.modificacionEmpleadoConfirmacion.setLocationRelativeTo(null);
			ClaseVista.modificacionEmpleadoConfirmacion.setVisible(true);
			try
			{
				System.out.println();
				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				int idEmpleadoElegido = Integer.parseInt(ClaseVista.choModificacionEmpleado.getSelectedItem().split("-")[0]);
				ClaseModelo.sentencia = "SELECT * FROM empleados WHERE idEmpleado="+idEmpleadoElegido;
				ClaseModelo.rs = ClaseModelo.statement.executeQuery(ClaseModelo.sentencia);
				ClaseModelo.rs.next();
				//Le doy a los text field los valores extraidos del elemento seleccionado
				ClaseVista.nombreEmpleado1.setText(ClaseModelo.rs.getString("nombreEmpleado"));
				System.out.println("Modificado!");
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}
			finally
			{
				try
				{
					if(ClaseModelo.connection!=null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			}

		}	
		else if(evento.getSource().equals(ClaseVista.btnMEConfirmar))
		{
			try
			{
				int idEmpleadoElegido = Integer.parseInt(ClaseVista.choModificacionEmpleado.getSelectedItem().split("-")[0]);
				String nombre = ClaseVista.nombreEmpleado1.getText();

				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				ClaseModelo.sentencia = "UPDATE empleados SET nombreEmpleado = '"+nombre+"' WHERE idEmpleado="+idEmpleadoElegido;
				ClaseModelo.statement.executeUpdate(ClaseModelo.sentencia);
				System.out.println("Actualizado!");
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}
			finally
			{
				try
				{
					if(ClaseModelo.connection!=null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			}		
		}
		else if(evento.getSource().equals(ClaseVista.btnMEVolver))
		{
			ClaseVista.modificacionEmpleadoConfirmacion.setVisible(false);
		}
		// Consulta de empleados
		else if(evento.getSource().equals(ClaseVista.menu4)) 
		{
			ClaseVista.consultaEmpleado.setLayout(new FlowLayout());
			ClaseVista.consultaEmpleado.setSize(380, 300);
			ClaseVista.consultaEmpleado.setResizable(false);
			ClaseVista.consultaEmpleado.addWindowListener(this);
			ClaseVista.consultaEmpleado.add(ClaseVista.lblConsultaEmpleado);
			ClaseVista.consultaEmpleado.add(ClaseVista.taConsultaEmpleado);
			ClaseVista.taConsultaEmpleado.setEditable(false);
			ClaseVista.consultaEmpleado.setLocationRelativeTo(null);
			ClaseVista.consultaEmpleado.setVisible(true);
			try
			{
				Class.forName(ClaseModelo.driver);
				ClaseModelo.connection = DriverManager.getConnection(ClaseModelo.url, ClaseModelo.usuario, ClaseModelo.clave);
				ClaseModelo.statement = ClaseModelo.connection.createStatement();
				ClaseModelo.sentencia = "SELECT * FROM empleados";
				ClaseModelo.rs = ClaseModelo.statement.executeQuery(ClaseModelo.sentencia);
				System.out.println("Consulta realizada con éxito");
				ClaseVista.taConsultaEmpleado.setText("");
				while(ClaseModelo.rs.next())
				{
					if(ClaseVista.taConsultaEmpleado.getText().length()==0)
					{
						ClaseVista.taConsultaEmpleado.setText(ClaseModelo.rs.getInt("idEmpleado")+
								" - " + ClaseModelo.rs.getString("nombreEmpleado"));
					}
					else
					{
						ClaseVista.taConsultaEmpleado.setText(ClaseVista.taConsultaEmpleado.getText() + "\n" +
								ClaseModelo.rs.getInt("idEmpleado")+
								" - " + ClaseModelo.rs.getString("nombreEmpleado"));
					}
				}
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println("ERROR"+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				System.out.println("ERROR"+sqle.getMessage());
			}
			finally
			{
				try
				{
					if(ClaseModelo.connection!=null)
					{
						ClaseModelo.connection.close();
					}
				}
				catch (SQLException e)
				{
					System.out.println("ERROR"+e.getMessage());
				}
			} 
		}	
	}
}
