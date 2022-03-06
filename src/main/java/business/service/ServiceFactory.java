package business.service;

import lombok.Getter;
import lombok.Setter;

public class ServiceFactory {
	private BancoService bancoService;

	@Setter
	@Getter
	private SucursalService sucursalService;

	@Setter
	@Getter
	private DelincuenteService delincuenteService;

	@Setter
	@Getter
	private AtracoService atracoService;

	@Setter
	@Getter
	private VigilanteService vigilanteService;

	@Setter
	@Getter
	private ContratoService contratoService;

	@Setter
	@Getter
	private JuezService juezService;

	@Setter
	@Getter
	private BandaOrganizadaService bandaOrganizadaService;
	
	@Setter
	@Getter
	private DelincuenteBandaService delincuenteBandaService;
	
	@Setter
	@Getter
	private EmpleadoService empleadoService;
	
	@Setter
	@Getter
	private AdministrativoService administrativoService;
	
	@Setter
	@Getter
	private DirectivoService directivoService;

	// tantas propiedades como servicios

	private static ServiceFactory serviceFactory;

	private ServiceFactory() {
		super();
	}

	public static ServiceFactory getInstance() {
		if (serviceFactory == null) {
			serviceFactory = new ServiceFactory();

			serviceFactory.setBancoService(new BancoService());
			serviceFactory.setSucursalService(new SucursalService());
			serviceFactory.setDelincuenteService(new DelincuenteService());
			serviceFactory.setAtracoService(new AtracoService());
			serviceFactory.setVigilanteService(new VigilanteService());
			serviceFactory.setContratoService(new ContratoService());
			serviceFactory.setJuezService(new JuezService());
			serviceFactory.setBandaOrganizadaService(new BandaOrganizadaService());
			serviceFactory.setDelincuenteBandaService(new DelincuenteBandaService());
			serviceFactory.setEmpleadoService(new EmpleadoService());
			serviceFactory.setAdministrativoService(new AdministrativoService());
			serviceFactory.setDirectivoService(new DirectivoService());
			// tantas como servicios
		}
		return serviceFactory;
	}

	public BancoService getBancoService() {
		return bancoService;
	}

	private void setBancoService(BancoService bancoService) {
		this.bancoService = bancoService;
	}

	public static ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public static void setServiceFactory(ServiceFactory serviceFactory) {
		ServiceFactory.serviceFactory = serviceFactory;
	}

}
