package ui.menu.administrador;

import ui.menu.administrador.action.AsociarSucursalAction;
import ui.menu.administrador.action.EliminarSucursalAction;
import ui.menu.administrador.action.VerAdministrativosAction;
import ui.menu.administrador.action.VerDirectivosAction;
import ui.menu.administrador.action.VerEmpleadosAction;
import ui.menu.administrador.action.VerSucursalesAction;
import util.menu.BaseMenu;


public class AdministradorMenu extends BaseMenu{
	
	public AdministradorMenu() {
		
		menuOptions = new Object[][] { 
			{ "Asociar sucursal a un banco", AsociarSucursalAction.class },
			{ "Ver las sucursales de un banco", VerSucursalesAction.class },
			{ "Ver los empleados de un banco", VerEmpleadosAction.class },
			{ "Ver los administrativos de un banco", VerAdministrativosAction.class },
			{ "Ver los directivos de un banco", VerDirectivosAction.class},
			{ "Eliminar sucursal", EliminarSucursalAction.class },
			};
	}
}
