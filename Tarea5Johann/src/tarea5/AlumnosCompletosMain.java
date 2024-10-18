package tarea5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlumnosCompletosMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumnos alumno[] = new Alumnos[5];

		FileOutputStream ficheroSalida = null;
		FileInputStream ficheroEntrada = null;
		ObjectOutputStream dataOb = null;
		ObjectInputStream dataIs = null;
		File fichero = null;

		try {
			fichero = new File("alumnos.dat");

			ficheroSalida = new FileOutputStream(fichero);
			dataOb = new ObjectOutputStream(ficheroSalida);

			ficheroEntrada = new FileInputStream(fichero);
			dataIs = new ObjectInputStream(ficheroEntrada);

			for (int i = 0; i < alumno.length; i++) {
				System.out.println("Introduzca la Nia del alumno: ");
				int nia = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca el nombre del alumno: ");
				String nombre = sc.nextLine();

				System.out.println("Introduzca los apellidos del alumno: ");
				String apellidos = sc.nextLine();

				System.out.println("Introduzca el genero del alumno: ");
				char genero = sc.nextLine().charAt(0);

				System.out.println("Introduzca la fecha de nacimiento del alumno(yyyy-MM-dd): ");
				LocalDate nacimiento = null;
				String fechaEntrada = sc.nextLine();
				nacimiento = LocalDate.parse(fechaEntrada);

				System.out.println("Introduzca el cliclo del alumno: ");
				String ciclo = sc.nextLine();

				System.out.println("Introduzca el curso del alumno: ");
				String curso = sc.nextLine();

				System.out.println("Introduzca el grupo del alumno: ");
				String grupo = sc.nextLine();

				alumno[i] = new Alumnos(nia, nombre, apellidos, genero, nacimiento, ciclo, curso, grupo);
				dataOb.writeObject(alumno[i]);
			}

			while (ficheroEntrada.available() > 0) {
				Alumnos alumnoLeido = (Alumnos) dataIs.readObject();
				System.out.println(alumnoLeido);
			}

		} catch (DateTimeParseException e) {
			System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
		} catch (InputMismatchException e) {
			System.out.println("Formato incorrecto");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ficheroEntrada.close();
				dataIs.close();
				dataOb.close();
				ficheroSalida.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}