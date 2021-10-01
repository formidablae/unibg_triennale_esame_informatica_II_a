package generica;

public class RicercaDicotomicaGenerica
{
	public static void main(String[] args)
	{
		
	}
	
	static <T> int ricercaDicotomicaQuasiGenericaSenzaComparable(T[] array, T chiave)
	{
		return 0;
	}
	
	static <T extends Comparable<T>> int ricercaDicotomicaQuasiGenerale(T[] array, T chiave)
	{
		return 0;
	}
	
	static <T extends Comparable<? super T>> int ricercaDicotomicaGenerale(T[] array, T chiave)
	{
		return 0;
	}
	
	static <S extends Comparable<S>, T extends S> int ricercaDicotomicaPiuGenerale(T[] array, S chiave)
	{
		return 0;
	}
}
