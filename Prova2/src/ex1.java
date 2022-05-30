import java.util.Scanner;

public class ex1 {
	public static void main(String[] args) {
		// Escreva um programa em java contendo um método recursivo para somar todos os
		// números
		// ímpares entre 1 e um valor informado pelo usuário da aplicação.

		Scanner in = new Scanner(System.in);

		System.out.println("Qual número utilizar? ");
		int num = in.nextInt();
		System.out.println("Soma de números ímpares entre 1 e " + num + " = " + sumodd(num));
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
