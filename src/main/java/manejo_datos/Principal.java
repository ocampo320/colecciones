package manejo_datos;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Principal {

	static String namePlayer="";
	public static void main(String[] args) {

//		
//		
//		
		
		List<Player> listPlayers = new TestUtils().getPlayers();
		//namePlayer=JOptionPane.showInputDialog("ingrese el nombre a buscar: ");


		
//lista de clubes:
		List<String> listaClubes = listPlayers.stream()
				.map(Player::getClub)
				.collect(Collectors.toList());
				
		System.out.println("lista de clubes "+listaClubes);
		
		
		
		
//		List<Vehiculo> result4 = vehiculos.stream()
//		        .sorted((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
//		        .collect(Collectors.toList());
//		System.out.println("lista de vehiculos ordenado por kilometro: "+ result4);
		
		
		
		List<Player>edadMayorList=listPlayers.stream()
				.filter(v1->v1.getAge().isEmpty())
				.sorted(Comparator.comparing((Player::getAge)))
						.collect(Collectors.toList());
		System.out.println("lista de edad: "+ edadMayorList);
				
		
		

	}
	

	static class TestUtils implements Utils {

	}



}
