package ui.menu.administrador.action;

import java.util.ArrayList;
import java.util.List;

import business.model.Administrativo;
import business.model.Banco;
import business.model.Empleado;
import business.service.AdministrativoService;
import business.service.BancoService;
import business.service.ServiceFactory;
import util.console.Console;
import util.menu.Action;

public class VerAdministrativosAction implements Action{

	

	public void execute() throws Exception {
		// Listado de sucursales de un banco
		
		String codigo;
		BancoService bancoService = ServiceFactory.getInstance().getBancoService();

		List<Banco> bancos = bancoService.findAll();
		for(Banco banco: bancos) {
			System.out.println(banco);
		}
		codigo = Console.readString("Código del banco");
		
		AdministrativoService administrativoService = ServiceFactory.getInstance().getAdministrativoService();
		List<Administrativo> administrativos = new ArrayList<Administrativo>();
		administrativos = administrativoService.findByCodigoBanco(codigo);
		for (Empleado e : administrativos) {
			System.out.println(e);
		}
		System.out.println("Número de empleados: " + administrativos.size());
		return;		
	}
}
