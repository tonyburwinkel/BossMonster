import java.io.InputStreamReader;

/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */

public class Driver {

	public static void main(String[] args) {
		
		ModelBM model = new ModelBM();
		ControllerBM controller = new ControllerBM(new InputStreamReader(System.in), System.out);
		controller.go(model);
	
	}

}
