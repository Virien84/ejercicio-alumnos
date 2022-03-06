package ui.menu.ladron.action;

import java.util.List;

import business.model.BandaOrganizada;
import business.model.Delincuente;
import business.model.DelincuenteBanda;
import business.service.BandaOrganizadaService;
import business.service.DelincuenteBandaService;
import business.service.DelincuenteService;
import business.service.ServiceFactory;
import util.console.Console;
import util.menu.Action;

public class EntrarEnBandaAction implements Action {

	public void execute() throws Exception {
		// Entrar en Banda Organizada

		Delincuente delincuente;
		BandaOrganizada bandaOrganizada;
		String idDelincuente;
		String idBanda;
		
		DelincuenteService delincuenteService = ServiceFactory.getInstance().getDelincuenteService();

		List<Delincuente> delincuentes = delincuenteService.findAll();
		for (Delincuente ladron : delincuentes) {
			System.out.println(ladron);
		}
		
		idDelincuente = Console.readString("Código del Ladrón");
		
		delincuente = delincuentes.stream()
				.filter(d->d.getIdentificador().equals(idDelincuente))
				.findAny()
				.orElse(null);
		
		BandaOrganizadaService bandaOrganizadaService = ServiceFactory.getInstance().getBandaOrganizadaService();

		List<BandaOrganizada> bandas = bandaOrganizadaService.findAll();
		for (BandaOrganizada banda : bandas) {
			System.out.println(banda);
		}
		
		idBanda = Console.readString("Código de la Banda");
		bandaOrganizada = bandas.stream()
				.filter(d->d.getCodigo().equals(idBanda))
				.findAny()
				.orElse(null);
		
		DelincuenteBandaService delincuenteBandaService = ServiceFactory.getInstance().getDelincuenteBandaService();
		DelincuenteBanda delincuenteBanda = new DelincuenteBanda();
		
		delincuenteBanda.setDelincuente(delincuente);
		delincuenteBanda.setBandaOrganizada(bandaOrganizada);
		
		delincuenteBandaService.insert(delincuenteBanda);
		
		System.out.println("Delincuente y Banda relacionados");
		return;
	}
}
