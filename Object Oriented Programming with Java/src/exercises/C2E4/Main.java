package exercises.C2E4;

public class Main {
    public static void main(String[] args) {
    	Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
    	int count = 0;
        for (int i = 0; i < 100; i++) {
        	SuitCase suitcase = new SuitCase(100);
        	Thing brick = new Thing("Brick", i + 1);
        	suitcase.addThing(brick);
        	container.addSuitCase(suitcase);
    	}
    }
}