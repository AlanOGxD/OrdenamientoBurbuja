class MetodosOrdenamiento {
	
	public void mostrarDatosDeEficiencia(int contadorComparaciones,
 		int contadorIntercambios, int contadorRecorridos, long tiempoTotal){
 		System.out.println("~~~~~~~~~~~~~~~ DATOS DE EFICIENCIA DEL ALGORITMO ~~~~~~~~~~~~~~~~~~");
 		System.out.println();
 		System.out.println("Cantidad de recorridos realizados: "+contadorComparaciones);
 		System.out.println("Cantidad de comparaciones realizadas: "+contadorComparaciones);
 		System.out.println("Cantidad de intercambios realizados: "+contadorIntercambios);
 		System.out.println("Tiempo total de ejecucion: "+tiempoTotal);
 		System.out.println("Tiempo total de ejecucion: "+(double)tiempoTotal/1000000+" milisegundos");
 	}
	
	public void ordenamientoBurbuja1(int[] numeros) {
		int aux = 0, contpasada = 0, contcompara = 0, continter = 0;
		long init = System.currentTimeMillis();
		for (int i = 2; i < numeros.length; i++) {
			contpasada++;
			for (int j = 0; j < numeros.length - i; j++) {
				contcompara++;
				if (numeros[j] > numeros[j + 1]) {
					aux = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = aux;
					continter++;
				}
			}
		}
		long fin = System.currentTimeMillis();
		long tiempoTotal=fin-init;
		mostrarVector(numeros);
		System.out.println();
		
		mostrarDatosDeEficiencia(contcompara, continter, contpasada, tiempoTotal);
	}

	public void ordenamientoBurbuja2(int[] numeros) {
		int recorrido = 0, compas = 0, intercambios = 0, aux = 0;
		int i = 1;
		boolean ordenado = false;

		long init = System.currentTimeMillis();

		while ((i < numeros.length) && (ordenado == false)) {
			i = i + 1;
			ordenado = true;
			for (int j = 0; j <= numeros.length - i; j++) {
				compas++;
				if (numeros[j] > numeros[j + 1]) {
					ordenado = false;
					aux = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = aux;
					intercambios++;
				}
				
			}
			recorrido++;
		}

		long fin = System.currentTimeMillis();
		long tiempoTotal=fin-init;
		
		mostrarVector(numeros);
		System.out.println();
		
		mostrarDatosDeEficiencia(compas, intercambios, recorrido, tiempoTotal);
	}

	public void ordenamientoBurbuja3(int[] numeros) {

		int recorrido = 0, compas = 0, intercambios = 0, aux = 0, i=1;
		boolean ordenado;
		long init = System.currentTimeMillis();
		
		do {
			i = i + 1;
			ordenado = true;

			for (int j = 0; j <= numeros.length - i; j++) {
				compas++;
				if (numeros[j] > numeros[j + 1]) {
					intercambios++;
					aux = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = aux;
				}
			}
			recorrido++;
		} while ((i < numeros.length) && (ordenado == true));

		long fin = System.currentTimeMillis();
		long tiempoTotal=fin-init;
		
		mostrarVector(numeros);
		System.out.println();
		mostrarDatosDeEficiencia(compas, intercambios, recorrido, tiempoTotal);
	}
	
	public void mostrarVector(int[] numeros) {
		byte cont=0;
			for (int i = 0; i < numeros.length; i++) {
				if (cont == 15 ) {
					System.out.println(numeros[i]+", ");
					cont=0;
				}
				else {
					System.out.print(numeros[i]+", ");
				}
			}
			System.out.println();
		}
}

public class PruebaOrdenamientoBurbuja {
	public static void main(String[] args) {
int[] edades={34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
 		
 		MetodosOrdenamiento burbuja=new MetodosOrdenamiento();
 		
 		System.out.println("=================VECTOR ORIGINAL======================");
 		burbuja.mostrarVector(edades);
 		System.out.println();
 		System.out.println();
 		System.out.println("===============ORDENAMIENTO BURBUJA===================");
		System.out.println("burbuja 1");
		burbuja.ordenamientoBurbuja1(edades.clone());
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Burbuja 2");
		burbuja.ordenamientoBurbuja2(edades.clone());
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Burbuja 3");
		burbuja.ordenamientoBurbuja3(edades.clone());
	}
}
