# ejercicio-alumnos
Ejercicio de ejemplo de JPA en Java

public static class Afiliarse{
	static DelincuenteBandaService delincuenteBandaService = ServiceFactory.getInstance().getDelincuenteBandaService();
	static DelincuenteBanda delBan = new DelincuenteBanda();
	static DelincuenteService delincuenteService = ServiceFactory.getInstance.getDelincuenteService();
	static BandaOrganizadaService bandaService = ServiceFactory.getInstance().getBandaOrganizadaService();

	public static void link(BandaOrganizada bandaOrganizada, Delincuente delincuente){
		delBan.setBanda(bandaOrganizada);
		delBan.setDelincuente(delincuente);
		delincuente._getBandas().add(delBan);
		bandaOrganizada._getDelincuentes().add(delBan);
		delincuenteService.update(delincuente);
		bandaService.update(bandaOrganizada);
		delincuenteBandaService.insert(delBan);
	}

	public static void unlink(BAndaOrganizada bandaOrganizada, Delincuente delincuente){
		delBan=delincuenteBandaService.findByDelinBanda(delincuente,bandaOrganizada);
		delincuente._getBandas().remove(delBan);
		bandaOrganizada._getDelincuentes().remove(delBan);
		delincuenteService.update(delincuente);
		bandaService.update(bandaOrganizada);
		delincuenteBandaService.delete(delBan);
	}
}
