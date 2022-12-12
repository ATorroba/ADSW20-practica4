package es.upm.dit.adsw.practica4;

public interface ControlEntrada {

	/**
	 * Este método evita que un vehículo entre en un tramo de una dirección entre dos tramos. 
	 * Dos o más vehículos no pueden estar simultaneamente en el mismo tramo: ni en el mismo sentido,
	 * ni en el sentido contrario. (ni en mismo arco/tramo, ni en arcos/tramos diferentes).
	 * Antes de salir del tramo un vehículo debe entrar en ese mismo tramo. Solo puede ejecutar 
	 * salirDeTramo la hebra que está dentro.
	 * 
	 * @return devuelve una estimación en millisegundos del tiempo que la hebra ha estado bloqueada en el control. 
	 * Si devuelve -1 o menos, la hebra no ha esperado nada.
	 * @throws RuntimeException el vehiculo que está dentro del tramo no debe volver intentar entrar sin haber salido antes
	 */
	public long entrarEnTramo();
	
	/**
	 * La hebra que llama a este método debe haber entrado en el tramo anteriormente (sin haber salido todavía).
	 * Cuando un vehículo llama a este método, deja de estar dentro.
	 * @throws RuntimeException se produce esta excepción si no hay ninguna hebra dentro del tramo o si el que 
	 * llama a este método no es el vehículo que está dentro
	 */
	public void salirDeTramo();
}
