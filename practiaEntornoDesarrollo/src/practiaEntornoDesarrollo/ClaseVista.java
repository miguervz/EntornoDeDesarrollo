package practiaEntornoDesarrollo;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClaseVista extends WindowAdapter implements ActionListener {
	// Creo los frames
	static Frame menu = new Frame("Menú Principal");

	// Creo la barra de menú
	static MenuBar barraMenu = new MenuBar();

	// Creo los menús
	static Menu menuEmpleados = new Menu("Empleados");

	// Creo los menuItems
	static MenuItem menu1 = new MenuItem("Nuevo");
	static MenuItem menu2 = new MenuItem("Eliminar");
	static MenuItem menu3 = new MenuItem("Modificar");
	static MenuItem menu4 = new MenuItem("Consultar");

	// Creo los elementos de Alta de Empleados
	static Dialog altaEmpleado = new Dialog(menu,"ALTA DE EMPLEADOS", true);
	static Label nombreEmpleado = new Label("Nombre del empleado");
	static TextField nombreEmpleado1 = new TextField(20);
	static Button aceptar = new Button("Aceptar");
	static Button limpiar = new Button("Limpiar");

	// Creo los elementos de Baja de Empleados
	static Frame bajaEmpleado = new Frame("Baja");
	static Dialog bajaEmpleadoConfirmacion = new Dialog(bajaEmpleado,"CONFIRMACION", true);
	static Label lblBajaEmpleado = new Label("Elige el empleado a eliminar:");
	static Choice choBajaEmpleado = new Choice();
	static Button btnBEAceptar = new Button("Aceptar");


	// Creo los elementos de modificacion de Empleado
	static Frame modificacionEmpleado = new Frame("MODIFICACION DE EMPLEADOS");
	static Dialog modificacionEmpleadoConfirmacion = new Dialog(modificacionEmpleado,"MODIFICACION", true);
	static Choice choModificacionEmpleado = new Choice();
	static Button btnMEConfirmar = new Button("Confirmar");
	static Button btnMEVolver = new Button("Volver");
	static Label lblModificacionEmpleado = new Label("Modifica los datos del empleado que se requiera:");
	static Button btnMEAceptar = new Button("Aceptar");

	// Creo los elementos de consulta de Empleados
	static Frame consultaEmpleado = new Frame("CONSULTA DE EMPLEADOS");
	static Label lblConsultaEmpleado = new Label("Éstos son los empleados activos en la actualidad");
	static TextArea taConsultaEmpleado = new TextArea(10,20);

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}