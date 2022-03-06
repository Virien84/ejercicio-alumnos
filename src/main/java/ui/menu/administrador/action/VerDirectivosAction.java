package ui.menu.administrador.action;

import java.util.ArrayList;
import java.util.List;

import business.model.Banco;
import business.model.Directivo;
import business.service.BancoService;
import business.service.DirectivoService;
import business.service.ServiceFactory;
import util.console.Console;
import util.menu.Action;

public class VerDirectivosAction implements Action{

	

	public void execute() throws Exception {
		// Listado de sucursales de un banco
		
		String codigo;
		BancoService bancoService = ServiceFactory.getInstance().getBancoService();

		List<Banco> bancos = bancoService.findAll();
		for(Banco banco: bancos) {
			System.out.println(banco);
		}
		codigo = Console.readString("Código del banco");
		
		DirectivoService directivoService = ServiceFactory.getInstance().getDirectivoService();
		List<Directivo> directivos = new ArrayList<Directivo>();
		directivos = directivoService.findByCodigoBanco(codigo);
		for (Directivo d : directivos) {
			System.out.println(d);
		}
		System.out.println("Número de directivos: " + directivos.size());
		return;		
		
	}

}
