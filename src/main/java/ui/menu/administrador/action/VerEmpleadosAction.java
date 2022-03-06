package ui.menu.administrador.action;

import java.util.ArrayList;
import java.util.List;

import business.model.Banco;
import business.model.Empleado;
import business.service.BancoService;
import business.service.EmpleadoService;
import business.service.ServiceFactory;
import util.console.Console;
import util.menu.Action;

public class VerEmpleadosAction implements Action{

	public void execute() throws Exception {
		// Listado de sucursales de un banco
		
		String codigo;
		BancoService bancoService = ServiceFactory.getInstance().getBancoService();

		List<Banco> bancos = bancoService.findAll();
		for(Banco banco: bancos) {
			System.out.println(banco);
		}
		codigo = Console.readString("Código del banco");
		
		EmpleadoService empleadoService = ServiceFactory.getInstance().getEmpleadoService();
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados = empleadoService.findByCodigoBanco(codigo);
		for (Empleado e : empleados) {
			System.out.println(e);
		}
		System.out.println("Número de empleados: " + empleados.size());
		return;		
	}
}
