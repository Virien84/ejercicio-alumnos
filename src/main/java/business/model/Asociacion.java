package business.model;

public class Asociacion {

	public static class Pertenece {
		public static void link(Banco banco, Sucursal sucursal) {
			sucursal.setBanco(banco);
			banco._getSucursales().add(sucursal);
		}

		public static void unlink(Banco banco, Sucursal sucursal) {
			banco._getSucursales().remove(sucursal);
			sucursal.setBanco(null);
		}
	}
	
	public static class Trabaja {
		public static void link(Banco banco, Empleado empleado) {
			empleado.setBanco(banco);
			banco._getEmpleados().add(empleado);
		}

		public static void unlink(Banco banco, Empleado empleado) {
			banco._getEmpleados().remove(empleado);
			empleado.setBanco(null);
		}
	}

	public static class Delinquir {
		public static void link(Delincuente delincuente, Atraco atraco) {
			atraco.setDelincuente(delincuente);
			delincuente._getAtracos().add(atraco);
		}

		public static void unlink(Delincuente delincuente, Atraco atraco) {
			delincuente._getAtracos().remove(atraco);
			atraco.setDelincuente(null);
		}
	}

	public static class SucursalAtracada {
		public static void link(Sucursal sucursal, Atraco atraco) {
			atraco.setSucursal(sucursal);
			sucursal._getAtracos().add(atraco);
		}

		public static void unlink(Sucursal sucursal, Atraco atraco) {
			sucursal._getAtracos().remove(atraco);
			atraco.setSucursal(null);
		}
	}

	public static class Juzgar {
		public static void link(Juez juez, Atraco atraco) {
			atraco.setJuez(juez);
			juez._getAtracos().add(atraco);
		}

		public static void unlink(Juez juez, Atraco atraco) {
			juez._getAtracos().remove(atraco);
			atraco.setJuez(null);
		}
	}

	public static class Contratar {
		public static void link(Vigilante vigilante, Contrato contrato) {
			contrato.setVigilante(vigilante);
			vigilante._getContratos().add(contrato);
		}

		public static void unlink(Vigilante vigilante, Contrato contrato) {
			vigilante._getContratos().remove(contrato);
			contrato.setVigilante(null);
		}
	}

	public static class AsignarVigilancia {
		public static void link(Sucursal sucursal, Contrato contrato) {
			contrato.setSucursal(sucursal);
			sucursal._getContratos().add(contrato);
		}

		public static void unlink(Vigilante vigilante, Contrato contrato) {
			vigilante._getContratos().remove(contrato);
			contrato.setVigilante(null);
		}
	}
	public static class UnirDelincuenteABanda {
		public static void link(Delincuente delincuente, DelincuenteBanda delincuenteBanda) {
			delincuenteBanda.setDelincuente(delincuente);
			delincuente._getDelincuenteBanda().add(delincuenteBanda);
		}

		public static void unlink(Delincuente delincuente, DelincuenteBanda delincuenteBanda) {
			delincuente._getDelincuenteBanda().remove(delincuenteBanda);
			delincuenteBanda.setDelincuente(null);
		}
	}
	public static class UnirBandaADelincuente {
		public static void link(BandaOrganizada bandaOrganizada, DelincuenteBanda delincuenteBanda) {
			delincuenteBanda.setBandaOrganizada(bandaOrganizada);
			bandaOrganizada._getDelincuenteBanda().add(delincuenteBanda);
		}

		public static void unlink(BandaOrganizada bandaOrganizada, DelincuenteBanda delincuenteBanda) {
			bandaOrganizada._getDelincuenteBanda().remove(delincuenteBanda);
			delincuenteBanda.setBandaOrganizada(null);
		}
	}
}
