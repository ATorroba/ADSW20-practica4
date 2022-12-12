package es.upm.dit.adsw.practica4;

public class ControlEntradaImpl implements ControlEntrada {
	private Thread dentro;

	public ControlEntradaImpl() {
		this.dentro = null;

	}

	/**
	 * Este método evita que un vehículo entre en un tramo de una dirección entre
	 * dos tramos. Dos o más vehículos no pueden estar simultaneamente en el mismo
	 * tramo: ni en el mismo sentido, ni en el sentido contrario. (ni en mismo
	 * arco/tramo, ni en arcos/tramos diferentes). Antes de salir del tramo un
	 * vehículo debe entrar en ese mismo tramo. Solo puede ejecutar salirDeTramo la
	 * hebra que está dentro.
	 * 
	 * @return devuelve una estimación en millisegundos del tiempo que la hebra ha
	 *         estado bloqueada en el control. Si devuelve -1 o menos, la hebra no
	 *         ha esperado nada.
	 * @throws RuntimeException el vehiculo que está dentro del tramo no debe volver
	 *                          intentar entrar sin haber salido antes
	 */
	public synchronized long entrarEnTramo() {


		if (dentro == null) {
			dentro = Thread.currentThread();
			return -1;
		}

		if (dentro == Thread.currentThread())
			throw new RuntimeException();

		else {
			long startTime = System.currentTimeMillis();

			while (dentro != null) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}

			long totalSum;
			long hola = System.currentTimeMillis();
			totalSum = (hola - startTime);

			dentro = Thread.currentThread();

			return totalSum;
		}

	}

	/**
	 * La hebra que llama a este método debe haber entrado en el tramo anteriormente
	 * (sin haber salido todavía). Cuando un vehículo llama a este método, deja de
	 * estar dentro.
	 * 
	 * @throws RuntimeException se produce esta excepción si no hay ninguna hebra
	 *                          dentro del tramo o si el que llama a este método no
	 *                          es el vehículo que está dentro
	 */
	public synchronized void salirDeTramo() {

		if (dentro == null)
			throw new RuntimeException();

		if (dentro != Thread.currentThread())
			throw new RuntimeException();

		dentro = null;
		notifyAll();
	}

}
