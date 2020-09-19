import java.util.*;
public class Main {
	private static Scanner sc;
	private static ArrayList<String> productslist;
	private static ArrayList<Double> productsinhomecenter;
	private static ArrayList<Double> productsinmiddlef;
	private static ArrayList<Double> productsinbf;
	private final static String Blackworkname = "1"; 
	private final static String Whiteworkname = "2";
	private final static String Paintingname = "3";
	private final static int Blackworkprice = 1300000;
	private final static int Whiteworkprice = 2600000;
	private final static int Paintingprice = 980000;
	private final static int NORT = 1;
	private final static int SOUTH = 2;
	private final static int MIDDLE = 3;
	private static double menorHC = 0;
	private static double menormd = 0;
	private static double menorfer = 0;
	private static String menorHomC ;
	private static String menormed;
	private static String menorCent;
	
	
	
	
	public static void initialize() {
		productslist = new ArrayList<String>();
		 sc = new Scanner(System.in);
	}
	
	public static void Showmenu() {
		System.out.println("Bienvenido a la lista para llevar un buen manejo de los materiales");
		System.out.println("Digita el numero de la opcion que deseas realizar");
		System.out.println("1) Ingresar la lista de los materiales");
		System.out.println("2) Ingresar los valores de cada material (deacuerdo a los establecimientos)");
		System.out.println("3) Mostrar total a pagar por establecimiento");
		System.out.println("4) Mostrar donde es mejor comprar cada producto inclyendo su valor");
		System.out.println("5) Mostrar los productos segun el tipo de trabajo que se vaya a usar");
	}
	
/** ingreasar los nombres. 
*ingresar el precio.
*ingresar el tipo.
* de los materias a utilizar
*/
	public static void addproduct( ) {
		System.out.println("ingresa nombre de el material para ser añadido " );
		String name = sc.nextLine();
		System.out.println("Ingresa el precio");
		String price = sc.nextLine();
		System.out.println("Ingresar tipo de obra en la que se va a utilizar\n 1)Obra negra\n 2)Obra Blanca\n 3)Pintura");
		String type = sc.nextLine();
		productslist.add(name + "," + price + "," + type);
	}
	
/** ingreasar el precio los materiales de home center 
*/
	public static void Sethomecenterprice() {
		System.out.println("Ingresando precios de HomeCeneter");
		for(int i = 0; i<productslist.size();i++) {
			String[] temp =  productslist.get(i).split(",");
			System.out.println("Digite el precio del producto " + temp[0]);
			double price = Double.parseDouble(sc.nextLine());
			productsinhomecenter.add(price*Integer.parseInt(temp[1]));
		}
	}
/** ingreasar el precio los materiales de la ferreteria del cetro
*/
	public static void Setmiddleprice() {
		System.out.println("Ingresando precios de ferrteria del centro");
		for(int i = 0; i<productslist.size();i++) {
			String[] temp =  productslist.get(i).split(",");
			System.out.println("Digite el precio del producto " + temp[0]);
			double price = Double.parseDouble(sc.nextLine());
			productsinmiddlef.add(price*Integer.parseInt(temp[1]));
		}
	}
/** ingreasar el precio los materiales de la ferreteria del barrio 
*/
	public static void Setferreteprice() {
		System.out.println("Ingresando precios de ferreteria del barrio");
		for(int i = 0; i<productslist.size();i++) {
			String[] temp =  productslist.get(i).split(",");
			System.out.println("Digite el precio del producto " + temp[0]);
			double price = Double.parseDouble(sc.nextLine());
			productsinbf.add(price*Integer.parseInt(temp[1]));
		}
	}
/** calcular el precio total de los productos de cada lugar 
* home center
* ferreteria el centro 
* ferreteria el barrio 
* y el tipo de obra que se va a realizar
*/
	public static void calculatetotalprice() {
		double totalpriceHC = 0;
		double totalpricemd = 0;
		double totalpricefer = 0;
		for (int i = 0; i<productslist.size(); i++) {
			totalpriceHC += productsinhomecenter.get(i);
			totalpricemd += productsinmiddlef.get(i);
			totalpricefer += productsinbf.get(i);
		}
		System.out.println("digite el tipo de obra \n 1)Obra negra\n 2)Obra Blanca\n 3)Pintura");
		String typeobra = sc.nextLine();
		if (typeobra.equalsIgnoreCase(Blackworkname)) {
			totalpriceHC += Blackworkprice;
			totalpricemd += Blackworkprice;
			totalpricefer += Blackworkprice;
		}else if(typeobra.equalsIgnoreCase(Whiteworkname)){
			totalpriceHC += Whiteworkprice;
			totalpricemd += Whiteworkprice;
			totalpricefer += Whiteworkprice;
		}else {
			totalpriceHC += Paintingprice;
			totalpricemd += Paintingprice;
			totalpricefer += Paintingprice;
		}
	
	}
/** comparar los productos de cada lugar
* home center
* ferreteria el centro
* ferreteria el barrio
* y encontrar en cual de ellos es mas economico comprar el material
*/
	public static void productComparison(){
		menorHC = productsinhomecenter.get(0);
		menormd = productsinmiddlef.get(0);
		menorfer = productsinbf.get(0);
		String menorProduc;
		for(int i = 0; i< productsinhomecenter.size();i++) {
			if (productsinhomecenter.get(i) < menorHC){
				menorHC = productsinhomecenter.get(i); 
				menorHomC = productslist.get(i);
				
			}
		}
		for(int i = 0; i< productsinmiddlef.size();i++){
			if (productsinmiddlef.get(i) < menormd){
				menormd = productsinmiddlef.get(i);
				menormed = productslist.get(i);
			}
		}
		for(int i = 0; i< productsinbf.size();i++){
			if (productsinbf.get(i) < menorfer){
				menorfer = productsinbf.get(i);
				menorCent = productslist.get(i);
			}
		}
		
		
		if(menorHC < menormd && menorHC < menorfer){
			
			System.out.println( "El precio menor del" + menorHomC + "es:" + menorHC +"que correspopnde a HomeCenter" );
		}
		
		if(menormd < menorHC && menormd < menorfer){
			System.out.println( "El precio menor del" + menormed + "es:" + menormd +"que correspopnde a ferreteria del centro");
		}
		
		if(menorfer < menormd && menorfer < menorHC){
			System.out.println("El precio menor del" + menorCent + "es:" + menorfer +"que correspopnde a ferreteria del barrio");
		}
	}

/** desplegar el nombre de los materiales para cada tipo de obra
*/
		public static void deployProducts(){
			for(int i = 0; i<productslist.size();i++){
				if (productslist.get(i).equalsIgnoreCase("Obra negra")){
					System.out.println(productslist.get(i));
				}
				if (productslist.get(i).equalsIgnoreCase("Obra blanca")){
					System.out.println(productslist.get(i));
				}
				if (productslist.get(i).equalsIgnoreCase("Pintura")){
					System.out.println(productslist.get(i));
				}
			}
		}
		
		public static void startProgram(){
		
		int x= 0;
		while(x !=8){
			Showmenu();
			x = sc.nextInt();
			sc.nextLine();
			switch (x) {
				case 1:
					int p;
					System.out.println("Cuantos materiales desea ingresar");
					p = sc.nextInt();
					sc.nextLine();
					for(int i = 0; i<p ;i++) {
					addproduct();
					}
					System.out.println(productslist.size());
				break;
				case 2: showlist();
				break;
				case 3: calculatetotalprice ();
				break;
				case 4: productComparison();
				break;
				case 5: deployProducts() ;
				break;
			}
		}
	}
	
	
	public static void showlist() {
		String  product;
		for(int x = 0; x < productslist.size() ; x++) {
		 product = productslist.get(x).toString();
			System.out.println("el producto #" +x+ " es " + product);
		}
	}
	public static void main(String[] args) {
		productslist = new ArrayList<String>();
		 sc = new Scanner(System.in);
		 startProgram();
	
	}
}

