package tarea5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlumnosCompletosMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumnos alumno[] = new Alumnos[1];

		FileOutputStream ficheroSalida = null;
		ObjectOutputStream dataOb = null;
		File fichero = null;

		try {
			System.out.println("Introduzca el nombre de fichero: ");
			String nombreFichero = sc.nextLine();
			fichero = new File(nombreFichero);

			ficheroSalida = new FileOutputStream(fichero);
			dataOb = new ObjectOutputStream(ficheroSalida);

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

		} catch (DateTimeParseException e) {
			System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
		} catch (InputMismatchException e) {
			System.out.println("Formato incorrecto");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataOb.close();
				ficheroSalida.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}