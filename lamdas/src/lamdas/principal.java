package lamdas;

import java.util.function.Function;
import java.util.stream.Stream;

public class principal {

	public static void main(String[] args) {
		
		
		
		/**
		 * funcion lamda suma
		 */
	Function<Integer, Integer> sumaFunction= numm -> numm+numm;
	
	System.out.println(sumaFunction.apply(40));
	
	Libro l1= new Libro ("El señor de los anillos",1000);
	 Libro l2= new Libro ("La fundacion",500);
	 Libro l3= new Libro ("El caliz de fuego",600);
	 
	 Stream<Libro> st=Stream.of(l1,l2,l2);
	 st.forEach((l)->System.out.println(l.getNombreString())); 
	
	
	
	}

}
