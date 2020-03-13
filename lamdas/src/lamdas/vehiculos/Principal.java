package lamdas.vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(new Vehiculo("1111AAA", Modelo.BMW, 0));
		vehiculos.add(new Vehiculo("2222BBB", Modelo.AUDI, 20000));
		vehiculos.add(new Vehiculo("3333CCC", Modelo.OPEL, 30000));
		vehiculos.add(new Vehiculo("4444DDD", Modelo.BMW, 100000));
		vehiculos.add(new Vehiculo("5555EEE", Modelo.AUDI, 200000));
		vehiculos.add(new Vehiculo("6666FFF", Modelo.OPEL, 300000));
		vehiculos.add(new Vehiculo("7777GGG", Modelo.CITROEN, 0));

		/**
		 * Uso de map
		 * recorre la lista , toma el valor de kilometro,lo cambia y lo guarda en una lista
		 */

		List<Integer> result = vehiculos.stream()
				.map(v -> v.getKilometros()*2).collect(Collectors.toList());
		System.out.println("lista de kilometros multiplicado por dos"+ result);
		
		

		List<Integer> result2 = vehiculos.stream()
				.map(Vehiculo::getKilometros).collect(Collectors.toList());
		System.out.println("lista de kilometros de todos los vehiculos"+result2);

		//vehiculos.forEach((l) -> System.out.println(l.getKilometros() * 2));
		
		/**
		 * uso del filter
		 * recorre la lista y la filtra con un parametro
		 */

		List<Vehiculo> resultadoList=vehiculos.stream()
				.filter(v->v.getModelo().equals(Modelo.AUDI))
				.collect(Collectors.toList());
		
		System.out.println("lista de vehiculos audi: "+ resultadoList);
		
		
		/**
		 * uso de sorted
		 * compara los valores y los arganiza de menor a mayor
		 * 
		 */
		List<Vehiculo> result4 = vehiculos.stream()
		        .sorted((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
		        .collect(Collectors.toList());
		System.out.println("lista de vehiculos ordenado por kilometro: "+ result4);
		
		
		/**
		 * distinct: Retorna un stream con elementos no
		 *  repetidos basándose en la comparación entre objetos con la función equals (Object.equals(object)).
		 */
		
		List<Integer>respuesta5=vehiculos.stream()
				.map(Vehiculo::getKilometros)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("lista de vehiculos sin repetidos: "+ respuesta5+"\n");

		
		/**
		 * peek: Esta operación no realiza cambios sobre el stream y lo devuelve tal y 
		 * como entra. El propósito 
		 * principal consiste en hacer debugging al ejecutar cualquier otra 
		 * operación, ya que permite imprimir valores de los elementos del stream
		 */
			
		
		List<String>respuesta6=vehiculos.stream()
				.filter(v->v.getKilometros()>20000)
				.peek(v->System.out.println(v))
				.map(Vehiculo::getMatricula)
				.peek(v->System.out.println( v))
				.collect(Collectors.toList());
				System.out.println("\n");
				
				
				
		
		/**
		 * limit: Limita el número de elementos que tiene como salida el nuevo stream
		 */
		
		
		List<Vehiculo> result7 = vehiculos.stream()
		        .limit(1)
		        .peek(v->System.out.println("resultado limitado: "+ v))
		        .collect(Collectors.toList());
		System.out.println("\n");
		
		
		/**
		 * forEach: Realiza la acción de la función por parámetro para cada elemento
		 */
		
		vehiculos.parallelStream()
		.limit(2)
		.peek(v->System.out.println( "resultado"))
		.forEach(System.out::println);
		System.out.println("\n");
		
		
		
		/**
		 * collect: Ejecuta lo que denominan mutable reduction, 
		 * que consiste en acumular los resultados en una Collection a medida que los va procesando en la pipeline del stream
		 */
		List<Vehiculo> vehiculosCollect = vehiculos.parallelStream()
		        .limit(5)
		        .collect(Collectors.toList());
		        
		Map<Modelo, List<Vehiculo>> groupByModel = vehiculos.parallelStream()
		        .collect(Collectors.groupingBy(Vehiculo::getModelo));
			
		System.out.println(vehiculosCollect);
		System.out.println(groupByModel);


		
	}

}
