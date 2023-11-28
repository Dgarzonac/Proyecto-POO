package uiMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.Cosas.Material;
import gestorAplicacion.Cosas.Plato;

public interface Menu {
	
	public static ArrayList<Plato> crearMenu() {
		Material res = new Material(Material.Tipo.RES, 100, 100);
    	Material especias = new Material(Material.Tipo.ESPECIAS, 100, 50);
    	Material aceites = new Material(Material.Tipo.ACEITES, 100, 100);
    	Material pollos = new Material(Material.Tipo.POLLOS, 100, 200);
    	Material vinos = new Material(Material.Tipo.VINOS, 100, 300);
    	Material cebollas = new Material(Material.Tipo.CEBOLLAS, 100, 50);
    	Material champinones = new Material(Material.Tipo.CHAMPINONES, 500, 100);
    	Material ajos = new Material(Material.Tipo.AJOS, 100, 30);
    	Material tomates = new Material(Material.Tipo.TOMATES, 400, 200);
    	Material quesos = new Material(Material.Tipo.QUESOS, 300, 150);
    	Material cerdos = new Material(Material.Tipo.CERDOS, 100, 200);
    	Material atun = new Material(Material.Tipo.ATUN, 100, 250);
    	Material panes = new Material(Material.Tipo.PANES, 200, 50);
    	Material pescados = new Material(Material.Tipo.PESCADOS ,200 ,300 );
    	Material papas = new Material(Material.Tipo.PAPAS ,200 ,100 );
    	Material huevos = new Material(Material.Tipo.PAPAS ,200 ,100 );
    	Map<Material, Integer> Muton = new HashMap<>();
    	Muton.put(res, 1);Muton.put(especias, 10);Muton.put(aceites, 1);
    	Map<Material, Integer> coq = new HashMap<>();
    	coq.put(pollos, 1);coq.put(vinos, 1);coq.put(cebollas, 1);coq.put(champinones, 5);coq.put(ajos, 1);
    	Map<Material, Integer> ratatouille = new HashMap<>();
    	ratatouille.put(champinones, 5);ratatouille.put(tomates, 4);ratatouille.put(aceites, 1);ratatouille.put(ajos, 2);
    	Map<Material, Integer> boeuf = new HashMap<>();
    	boeuf.put(res, 1);boeuf.put(vinos, 1);boeuf.put(cebollas, 1);boeuf.put(champinones, 5);boeuf.put(ajos, 1);    	
    	Map<Material, Integer> quiche = new HashMap<>();
    	quiche.put(huevos, 3);quiche.put(quesos, 3);quiche.put(cerdos, 1);
    	Map<Material, Integer> salade = new HashMap<>();
    	salade.put(huevos, 3);salade.put(tomates, 3);salade.put(atun, 1);salade.put(cebollas, 2);salade.put(aceites, 1);
    	Map<Material, Integer> soupe = new HashMap<>();
    	soupe.put(cebollas, 5);soupe.put(panes, 2);soupe.put(quesos, 3);    	
    	Map<Material, Integer> croque = new HashMap<>();
    	croque.put(panes ,2 );croque.put(cerdos ,1 );croque.put(quesos ,1 );
    	Map<Material, Integer> bouilla = new HashMap<>();
    	bouilla.put(pescados ,2 );bouilla.put(tomates ,2 );bouilla.put(ajos ,2 );bouilla.put(aceites ,1 );    	
    	Map<Material, Integer> tartiflette = new HashMap<>();
    	tartiflette.put(papas ,2 );tartiflette.put(cebollas ,2 );tartiflette.put(cerdos ,1 );tartiflette.put(quesos ,1 );    	
    	
    	ArrayList<Plato> menu=new ArrayList<>();
    	
    	menu.add(new Plato("Muton Shot",30000,"Costillas de Res con Salsa especial",30,Muton));
    	menu.add(new Plato("Coq au Vin",45000,"Guiso de Pollo cocido en Vino y Verduras",25,coq));
    	menu.add(new Plato("Rat a Toulile",15000,"Verduras asadas en aceite de oliva",20,ratatouille));
    	menu.add(new Plato("Boeuf Bourguignon",60000,"Guiso de Res cocido en Vino y Verduras",30,boeuf));
    	menu.add(new Plato("Quiche Lorraine",30000,"Pastel salado con cerdo",35,quiche));
    	menu.add(new Plato("Salade Nicoise",15000,"Ensalada con Huevo y Atun",10,salade));
    	menu.add(new Plato("Soupe a l'oignon",20000,"Sopa espesa de Cebolla",25,soupe));
    	menu.add(new Plato("Croque Monsieur",15000,"Sandwich con Cerdo y Queso",10,croque));
    	menu.add(new Plato("Bouillabaisse",20000,"Sopa de Pescado tradicional",25,bouilla));
    	menu.add(new Plato("Tartiflette",40000,"Gratinado de Papa y Cerdo",20,tartiflette));
    	return menu;
	}
	
}
