import java.util.Scanner;

public class jugando extends preguntasDB {
	Scanner ingreso = new Scanner(System.in);
	String name;
	int seguirJugando;
	int respuesta, categoriaElegida, iteradorCategorias;
	int vidas = 3;
	int caminoAlTriunfo = 0;
	int numeroDePregunta;

	public void loguearse() {
		System.out.println("Bienvenides al mejor juego de preguntas y respuestas");
		System.out.println("|---------------------------------------------------|");
		System.out.print("Ingrese su nombre: ");
		name = ingreso.nextLine();
		System.out.println("Hola " + name + " vamos a jugar.");
	}// cierra metodo loguearse

	public void jugar() {
		do {
			System.out.println("Vidas: " + vidas + "\nRespuestas correctas: " + caminoAlTriunfo);
			do {
				System.out.println("Las categorias son las siguientes:");
				for (iteradorCategorias=0;iteradorCategorias<5;iteradorCategorias++)
					System.out.println(iteradorCategorias+1+"-"+categorias[iteradorCategorias]);
				System.out.println("Elija una categoría");
				categoriaElegida = ingreso.nextInt();
			} while (categoriaElegida < 1 || categoriaElegida > 5);
			System.out.println("Categoría elegida: " + categorias[categoriaElegida - 1]);
			numeroDePregunta = (int) (Math.random() * 5);
			System.out.println(preguntas[categoriaElegida - 1][numeroDePregunta]);
			respuesta = ingreso.nextInt();
			if (respuestasCorrectas[categoriaElegida - 1][numeroDePregunta] == respuesta) {
				System.out.println("Muy bien!");
				caminoAlTriunfo++;
			} else {
				System.out.println("Respuesta erronea");
				vidas--;
			}
			if ((vidas > 0) && (caminoAlTriunfo < 10)) {
				System.out.println("¿Desea seguir jugando? Escriba 1 para seguir...");
				seguirJugando = ingreso.nextInt();
			}
		} while ((seguirJugando == 1) && (vidas > 0) && (caminoAlTriunfo < 10));
		if (seguirJugando != 1)
			System.out.println("Maldito abandonador!");
		else if (vidas == 0)
			System.out.println("Perdiste :(");
		else if (caminoAlTriunfo == 10)
			System.out.println("Bien, campeón, ganaste!");
		System.out.println("Hasta luego, vaquero!");
	}// cierra metodo jugar
}// cierra clase jugando