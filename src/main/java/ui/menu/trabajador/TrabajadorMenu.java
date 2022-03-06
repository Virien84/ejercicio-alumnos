package ui.menu.trabajador;

import ui.menu.administrador.action.VerSucursalesAction;
import util.menu.BaseMenu;

public class TrabajadorMenu extends BaseMenu{

	public TrabajadorMenu() {
		
		menuOptions = new Object[][] { 
			{ "Ver las sucursales de un banco", VerSucursalesAction.class },
 };
	}
}
