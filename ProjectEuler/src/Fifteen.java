

public class Fifteen {
	public static void main(String[] args) {
		System.out.println(lattice(0 ,0));

	}
	public static int lattice (int length, int width) {
		if (length == 20 && width == 20) return 1;
		if (length == 20) return lattice(length, width+1);
		if (width == 20) return lattice(length+1, width);
		return lattice(length+1, width) + lattice(length, width+1);
	}

}
