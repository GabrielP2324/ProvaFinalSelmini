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
			aux += "Não tem nenhum filme cadastrado!";
		} else {
			for (int i = 0; i < pos; i++) {
				aux += "Título do " + (i + 1) + "o filme: " + movies[i].title + "\n";
				aux += "Gênero do" + (i + 1) + "o filme: " + movies[i].genre + "\n";
				aux += "Ano que o " + (i + 1) + "o filme foi lançado: " + movies[i].year + "\n";
				aux += "Pontuação do " + (i + 1) + "o filme: " + movies[i].score + "\n";
				aux += "\n";
			}
		}
		JOptionPane.showMessageDialog(null, aux);
	}

	public void Find() {
		if (pos < 1) {
			JOptionPane.showMessageDialog(null, "Não tem nenhum filme cadastrado!");
		} else {
			String title = JOptionPane.showInputDialog("Informe o título do filme a ser pesquisado:");
			boolean found = false;
			for (int i = 0; i < pos; i++) {
				if (movies[i].title.equalsIgnoreCase(title)) {
					String aux = "";
					found = true;
					aux += "Título do " + (i + 1) + "o filme: " + movies[i].title + "\n";
					aux += "Gênero do" + (i + 1) + "o filme: " + movies[i].genre + "\n";
					aux += "Ano que o " + (i + 1) + "o filme foi lançado: " + movies[i].year + "\n";
					aux += "Pontuação do " + (i + 1) + "o filme: " + movies[i].score + "\n";
					JOptionPane.showMessageDialog(null, aux);
				}
				if(!found) {
					JOptionPane.showMessageDialog(null,"Filme pelo título "+ title + " não encontrado!");
				}
			}
			
		}
	}

	public void Register() {
		String title = JOptionPane.showInputDialog("Título do filme a ser registrado:");
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
			movies[pos].genre = JOptionPane.showInputDialog("Gênero:");
			movies[pos].year = Integer.parseInt(JOptionPane.showInputDialog("Ano em que o filme foi lançado: "));
			movies[pos].score = Integer.parseInt(JOptionPane.showInputDialog("Pontuação do filme: "));
			while(movies[pos].score <0 || movies[pos].score>5) {
				movies[pos].score = Integer.parseInt(JOptionPane.showInputDialog("Por favor insira um valor de 0 a 5: "));
			}
			pos++;

		} else {
			JOptionPane.showMessageDialog(null, "O título "+title + " já está registrado a outro filme!");
		}
	}
}
