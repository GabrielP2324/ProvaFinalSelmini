import java.util.Scanner;

public class ex1 {
	public static void main(String[] args) {
		// Escreva um programa em java contendo um m�todo recursivo para somar todos os
		// n�meros
		// �mpares entre 1 e um valor informado pelo usu�rio da aplica��o.

		Scanner in = new Scanner(System.in);

		System.out.println("Qual n�mero utilizar? ");
		int num = in.nextInt();
		System.out.println("Soma de n�meros �mpares entre 1 e " + num + " = " + sumodd(num));
	}

	public static int sumodd(int number) {
		if (number == 1) {
			return 1;
		} else {
			if (number % 2 == 0) {
				return sumodd(number - 1);
			} else {
				return number + sumodd(number - 1);
			}

		}
	}
}
