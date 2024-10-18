package tarea5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LeerAlumnos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileInputStream ficheroEntrada = null;
		ObjectInputStream dataIs = null;
		File fichero = null;

		try {
			System.out.println("Introduzca el nombre de fichero: ");
			String nombreFichero = sc.nextLine();
			fichero = new File(nombreFichero);
			ficheroEntrada = new FileInputStream(fichero);
			dataIs = new ObjectInputStream(ficheroEntrada);

			while (ficheroEntrada.available() > 0) {
				Alumnos alumnoLeido = (Alumnos) dataIs.readObject();
				System.out.println(alumnoLeido);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ficheroEntrada.close();
				dataIs.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
