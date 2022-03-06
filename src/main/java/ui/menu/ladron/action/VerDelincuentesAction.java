package ui.menu.ladron.action;

import java.util.List;
import java.util.Set;

import business.model.BandaOrganizada;
import business.model.DelincuenteBanda;
import business.service.BandaOrganizadaService;
import business.service.ServiceFactory;
import util.console.Console;
import util.menu.Action;

public class VerDelincuentesAction implements Action {
	public void execute() throws Exception {
		// Entrar en Banda Organizada

		BandaOrganizadaService bandaOrganizadaService = ServiceFactory.getInstance().getBandaOrganizadaService();

		List<BandaOrganizada> bandas = bandaOrganizadaService.findAll();
		for (BandaOrganizada banda : bandas) {
			System.out.println(banda);
		}
				
		String codigo = Console.readString("Código de la Banda");
		
		BandaOrganizada banda = bandaOrganizadaService.findByCodigo(codigo);
		Set<DelincuenteBanda> delincuentes=banda.getDelincuenteBanda();
		for(DelincuenteBanda d:delincuentes){
			System.out.println(d.getDelincuente());
		}
		return;
	}	
}
