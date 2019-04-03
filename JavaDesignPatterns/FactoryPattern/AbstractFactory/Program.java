package AbstractFactory;

public class Program {
	public static void main(String[] args) {
    	PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
 
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza + "\n");
    }  
}

interface Sauce {
	public String toString();
}
class MarinaraSauce implements Sauce {
	public String toString() {
		return "Marinara Sauce";
	}
}
class PlumTomatoSauce implements Sauce {
	public String toString() {
		return "Tomato sauce with plum tomatoes";
	}
}
interface Veggies {
	public String toString();
}
class BlackOlives implements Veggies {

	public String toString() {
		return "Black Olives";
	}
}
class Eggplant implements Veggies {

	public String toString() {
		return "Eggplant";
	}
}
class Garlic implements Veggies {

	public String toString() {
		return "Garlic";
	}
}
class Mushroom implements Veggies {

	public String toString() {
		return "Mushrooms";
	}
}

class Onion implements Veggies {

	public String toString() {
		return "Onion";
	}
}
class RedPepper implements Veggies {

	public String toString() {
		return "Red Pepper";
	}
}
class Spinach implements Veggies {

	public String toString() {
		return "Spinach";
	}
}
interface Pepperoni {
	public String toString();
}
class SlicedPepperoni implements Pepperoni {

	public String toString() {
		return "Sliced Pepperoni";
	}
}
interface Clams {
	public String toString();
}
class FreshClams implements Clams {

	public String toString() {
		return "Fresh Clams from Long Island Sound";
	}
}
class FrozenClams implements Clams {

	public String toString() {
		return "Frozen Clams from Chesapeake Bay";
	}
}
interface Dough {
	public String toString();
}
class ThickCrustDough implements Dough {
	public String toString() {
		return "ThickCrust style extra thick crust dough";
	}
}
class ThinCrustDough implements Dough {
	public String toString() {
		return "Thin Crust Dough";
	}
}
interface Cheese {
	public String toString();
}
class ParmesanCheese implements Cheese {

	public String toString() {
		return "Shredded Parmesan";
	}
}
class MozzarellaCheese implements Cheese {

	public String toString() {
		return "Shredded Mozzarella";
	}
}
class ReggianoCheese implements Cheese {

	public String toString() {
		return "Reggiano Cheese";
	}
}
abstract class Pizza {
	String name;

	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;

	abstract void prepare();

	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (clam != null) {
			result.append(clam);
			result.append("\n");
		}
		if (pepperoni != null) {
			result.append(pepperoni);
			result.append("\n");
		}
		return result.toString();
	}
}
class VeggiePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
	}
}
class CheesePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
class ClamPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clam = ingredientFactory.createClam();
	}
}
class PepperoniPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
		pepperoni = ingredientFactory.createPepperoni();
	}
}
abstract class PizzaStore {
	 
	protected abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
} 
class NYPizzaStore extends PizzaStore {
	 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
			new NYPizzaIngredientFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		} else if (item.equals("clam")) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
 
		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		return pizza;
	}
}
interface PizzaIngredientFactory {
	 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

	public Dough createDough() {
		return new ThickCrustDough();
	}
	
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}
	
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}
	
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}
	
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}
	
	public Clams createClam() {
		return new FrozenClams();
	}
}
//--- Making a New York Style Cheese Pizza ---
//Preparing New York Style Cheese Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Ethan ordered a ---- New York Style Cheese Pizza ----
//Thin Crust Dough
//Marinara Sauce
//Reggiano Cheese
//
//
//--- Making a Chicago Style Cheese Pizza ---
//Preparing Chicago Style Cheese Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Joel ordered a ---- Chicago Style Cheese Pizza ----
//ThickCrust style extra thick crust dough
//Tomato sauce with plum tomatoes
//Shredded Mozzarella
//
//
//--- Making a New York Style Clam Pizza ---
//Preparing New York Style Clam Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Ethan ordered a ---- New York Style Clam Pizza ----
//Thin Crust Dough
//Marinara Sauce
//Reggiano Cheese
//Fresh Clams from Long Island Sound
//
//
//--- Making a Chicago Style Clam Pizza ---
//Preparing Chicago Style Clam Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Joel ordered a ---- Chicago Style Clam Pizza ----
//ThickCrust style extra thick crust dough
//Tomato sauce with plum tomatoes
//Shredded Mozzarella
//Frozen Clams from Chesapeake Bay
//
//
//--- Making a New York Style Pepperoni Pizza ---
//Preparing New York Style Pepperoni Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Ethan ordered a ---- New York Style Pepperoni Pizza ----
//Thin Crust Dough
//Marinara Sauce
//Reggiano Cheese
//Garlic, Onion, Mushrooms, Red Pepper
//Sliced Pepperoni
//
//
//--- Making a Chicago Style Pepperoni Pizza ---
//Preparing Chicago Style Pepperoni Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Joel ordered a ---- Chicago Style Pepperoni Pizza ----
//ThickCrust style extra thick crust dough
//Tomato sauce with plum tomatoes
//Shredded Mozzarella
//Black Olives, Spinach, Eggplant
//Sliced Pepperoni
//
//
//--- Making a New York Style Veggie Pizza ---
//Preparing New York Style Veggie Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Ethan ordered a ---- New York Style Veggie Pizza ----
//Thin Crust Dough
//Marinara Sauce
//Reggiano Cheese
//Garlic, Onion, Mushrooms, Red Pepper
//
//
//--- Making a Chicago Style Veggie Pizza ---
//Preparing Chicago Style Veggie Pizza
//Bake for 25 minutes at 350
//Cutting the pizza into diagonal slices
//Place pizza in official PizzaStore box
//Joel ordered a ---- Chicago Style Veggie Pizza ----
//ThickCrust style extra thick crust dough
//Tomato sauce with plum tomatoes
//Shredded Mozzarella
//Black Olives, Spinach, Eggplant

