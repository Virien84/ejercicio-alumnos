package ui.menu.administrador.action;

import java.util.ArrayList;
import java.util.List;

import business.model.Banco;
import business.model.Sucursal;
import business.service.BancoService;
import business.service.ServiceFactory;
import business.service.SucursalService;
import util.console.Console;
import util.menu.Action;

public class VerSucursalesAction implements Action{

	

	public void execute() throws Exception {
		// Listado de sucursales de un banco
		
		String codigo;
		BancoService bancoService = ServiceFactory.getInstance().getBancoService();

		List<Banco> bancos = bancoService.findAll();
		for(Banco banco: bancos) {
			System.out.println(banco);
		}
		codigo = Console.readString("Código del banco");
		
		SucursalService sucursalService = ServiceFactory.getInstance().getSucursalService();
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales = sucursalService.findByCodigoBanco(codigo);
		for (Sucursal s : sucursales) {
			System.out.println(s);
		}
		System.out.println("Número de sucursales: " + sucursales.size());
		return;
		
	}

}
