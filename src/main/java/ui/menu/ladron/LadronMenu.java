package ui.menu.ladron;

import ui.menu.ladron.action.AtracarSucursalAction;
import ui.menu.ladron.action.EntrarEnBandaAction;
import ui.menu.ladron.action.SalirDeBandaAction;
import ui.menu.ladron.action.VerDelincuentesAction;
import util.menu.BaseMenu;

public class LadronMenu extends BaseMenu{

	
	public LadronMenu() {
		
		menuOptions = new Object[][] { 
			{ "Atracar sucursal", AtracarSucursalAction.class },
			{ "Entrar en banda organizada", EntrarEnBandaAction.class },
			{ "Listar delincuentes en una banda", VerDelincuentesAction.class },
			{ "Salir de banda", SalirDeBandaAction.class }, };
	}
}
