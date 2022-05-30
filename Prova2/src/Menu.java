import javax.swing.JOptionPane;

public class Menu {
	Filme[] movies = new Filme[10];
	int choice;
	int pos = 0;

	public void menu() {

		do {
			choice = Integer.parseInt(JOptionPane
					.showInputDialog("1. Registrar Filme \n 2. Consultar Filme \n 3. Exibir Dados \n 4. Sair"));

			switch (choice) {
			case 1:
				Register();
				break;
			case 2:
				Find();
				break;
			case 3:
				ShowAll();
				break;
			}
		} while (choice != 4);

	}

	public void ShowAll() {
		String aux = "";
		if (pos < 1) {
			aux += "N�o tem nenhum filme cadastrado!";
		} else {
			for (int i = 0; i < pos; i++) {
				aux += "T�tulo do " + (i + 1) + "o filme: " + movies[i].title + "\n";
				aux += "G�nero do" + (i + 1) + "o filme: " + movies[i].genre + "\n";
				aux += "Ano que o " + (i + 1) + "o filme foi lan�ado: " + movies[i].year + "\n";
				aux += "Pontua��o do " + (i + 1) + "o filme: " + movies[i].score + "\n";
				aux += "\n";
			}
		}
		JOptionPane.showMessageDialog(null, aux);
	}

	public void Find() {
		if (pos < 1) {
			JOptionPane.showMessageDialog(null, "N�o tem nenhum filme cadastrado!");
		} else {
			String title = JOptionPane.showInputDialog("Informe o t�tulo do filme a ser pesquisado:");
			boolean found = false;
			for (int i = 0; i < pos; i++) {
				if (movies[i].title.equalsIgnoreCase(title)) {
					String aux = "";
					found = true;
					aux += "T�tulo do " + (i + 1) + "o filme: " + movies[i].title + "\n";
					aux += "G�nero do" + (i + 1) + "o filme: " + movies[i].genre + "\n";
					aux += "Ano que o " + (i + 1) + "o filme foi lan�ado: " + movies[i].year + "\n";
					aux += "Pontua��o do " + (i + 1) + "o filme: " + movies[i].score + "\n";
					JOptionPane.showMessageDialog(null, aux);
				}
				if(!found) {
					JOptionPane.showMessageDialog(null,"Filme pelo t�tulo "+ title + " n�o encontrado!");
				}
			}
			
		}
	}

	public void Register() {
		String title = JOptionPane.showInputDialog("T�tulo do filme a ser registrado:");
		boolean found = false;
		for (int i = 0; i < pos; i++) {
			if (title.equals(movies[i].title)) {
				found = true;
				break;
			}
		}
		if (!found) {
			movies[pos] = new Filme();
			movies[pos].title = title;
			movies[pos].genre = JOptionPane.showInputDialog("G�nero:");
			movies[pos].year = Integer.parseInt(JOptionPane.showInputDialog("Ano em que o filme foi lan�ado: "));
			movies[pos].score = Integer.parseInt(JOptionPane.showInputDialog("Pontua��o do filme: "));
			while(movies[pos].score <0 || movies[pos].score>5) {
				movies[pos].score = Integer.parseInt(JOptionPane.showInputDialog("Por favor insira um valor de 0 a 5: "));
			}
			pos++;

		} else {
			JOptionPane.showMessageDialog(null, "O t�tulo "+title + " j� est� registrado a outro filme!");
		}
	}
}
