package ui.menu;

import ui.menu.administrador.AdministradorMenu;
import ui.menu.ladron.LadronMenu;
import ui.menu.trabajador.TrabajadorMenu;
import util.menu.BaseMenu;

public class MainMenu extends BaseMenu{
	
	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Administrador", AdministradorMenu.class },
			{ "Trabajador", TrabajadorMenu.class },
			{ "Ladron", LadronMenu.class },
		};
	}

	
//	public void execute() {
//		//EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//				BancoService bancoService = ServiceFactory.getInstance().getBancoService();
//				SucursalService sucursalService = ServiceFactory.getInstance().getSucursalService();
//				DelincuenteService delincuenteService = ServiceFactory.getInstance().getDelincuenteService();
//				AtracoService atracoService = ServiceFactory.getInstance().getAtracoService();
//				VigilanteService vigilanteService = ServiceFactory.getInstance().getVigilanteService();
//				ContratoService contratoService = ServiceFactory.getInstance().getContratoService();
//				JuezService juezService = ServiceFactory.getInstance().getJuezService();
//				BandaOrganizadaService bandaOrganizadaService = ServiceFactory.getInstance().getBandaOrganizadaService();
//
//				int opc = -1;
//				Scanner scanner = new Scanner(System.in);
//
//				// Datos para las pruebas de las opciones: 4 a 7
//				Delincuente delincuente = new Delincuente("DEL01", "J.F.F.");
//				Banco banco2 = new Banco("BAN02", "sede central");
//				Sucursal sucursal2 = new Sucursal("SUC02", "direccion 2", "Nombre del director");
//				Atraco atraco = new Atraco(new Date());
//				
//				Vigilante vigilante = new Vigilante("VIG01", "Nombre del vigilante");
//				Contrato contrato = new Contrato("CON01", new Date(), new Date(), Boolean.TRUE);
//
//				while (opc != 0) {
//					System.out.println("1. Asociar sucursal a un banco");
//					System.out.println("2. Ver las sucursales de un banco");
//					System.out.println("3. Eliminar sucursal");
//					System.out.println("-----------------------------------------");
//					System.out.println("4. Atracar sucursal");
//					System.out.println("5. Contratar seguridad");
//					System.out.println("6. Juzgar atraco");
//					System.out.println("7. Asignar delincuente a banda organizada");
//					System.out.println("0. Salir");
//					System.out.println("Introducir opciÃ³n: ");
//
//					opc = scanner.nextInt();
//
//					switch (opc) {
//					case 1:
//						// asociar sucursal a un banco
//						Banco banco1 = new Banco("BAN01", "sede central");
//						Sucursal sucursal1 = new Sucursal("SUC01", "direccion 1", "Nombre del director");
//						banco1.addSucursal(sucursal1);
//						bancoService.insert(banco1);
//						sucursalService.insert(sucursal1);
//						System.out.println("Se ha asociado la sucursal: ");
//						System.out.println(sucursal1);
//						System.out.println("al banco: ");
//						System.out.println(banco1);
//						break;
//					case 2:
//						// Listado de sucursales de un banco
//						List<Sucursal> sucursales = new ArrayList<Sucursal>();
//						sucursales = sucursalService.findByCodigoBanco("BBVA");
//						for (Sucursal s : sucursales) {
//							System.out.println(s);
//						}
//						System.out.println("Número de sucursales: " + sucursales.size());
//						break;
//						
//					case 3:
//						// Eliminar sucursal del banco
//						Sucursal s = sucursalService.findByCodigo("SUC01");
//						Banco b = bancoService.findByCodigo("BAN01");
//						b.removeSucursal(s);
//						sucursalService.update(s);
//						bancoService.update(b);
//						System.out.println(b);
//						//borramos sucursal y banco
//						sucursalService.delete(s);
//						bancoService.delete(b);
//						
//						break;
//
//					case 4:
//						// atracar una sucursal: SUC02 de BAN01
//						//asociamos sucursal al banco
//						banco2.addSucursal(sucursal2);
//
//						//asociar delincuente y atraco
//						delincuente.addAtraco(atraco);
//						//asociar atraco y sucursal
//						sucursal2.addAtraco(atraco);
//
//						//persistimos en BD
//						bancoService.insert(banco2);
//						sucursalService.insert(sucursal2);
//						delincuenteService.insert(delincuente);
//						atracoService.insert(atraco);
//						System.out.println("Se ha registrado el atraco correctamente");
//						System.out.println("Sucursal afectada: ");
//						System.out.println(sucursal2);
//						System.out.println("Registro del atraco: ");
//						System.out.println(atraco);
//						break;
//
//					case 5:
//						// contratar seguridad: vigilante y contrato
//						// aÃ±adir al vigilante y a la sucursal el contrato
//
//						vigilante.addContrato(contrato);
//						sucursal2 = sucursalService.findByCodigo("SUC02");
//						sucursal2.addContrato(contrato);
//
//						// guardar vigilante, contrato y actualizar: sucursal
//						vigilanteService.insert(vigilante);
//						sucursalService.update(sucursal2);
//						contratoService.insert(contrato);
//						break;
//
//					case 6:
//						// juzgar atraco anterior
//						Juez juez = new Juez("J01", "nombre de juez");
//						juez.addAtraco(atraco);
//						atraco.setTipoCondena(TipoCondena.GRAVE);
//						// guardar juez y actualizar atraco
//						juezService.insert(juez);
//						atracoService.update(atraco);
//						break;
//
//					case 7:
//						// Asociar delincuente a banda organizada
//						BandaOrganizada bandaOrganizada = new BandaOrganizada("BAN01", 0);
//						bandaOrganizada.addDelincuente(delincuente);
//						bandaOrganizada.setNumMiembros(bandaOrganizada.getNumMiembros() + 1);
//						// guardar banda y actualizar delincuente
//						bandaOrganizadaService.insert(bandaOrganizada);
//						delincuenteService.update(delincuente);
//						break;
//
//					case 0:
//						JPAUtil.cerrar();
//						scanner.close();
//						break;
//
//					default:
//						System.out.println("OpciÃ³n invÃ¡lida \n");
//					}
//				}
//
//			}
		
	}

