import javax.swing.JOptionPane;

public class AddLink extends Actions{

	public AddLink() {
		Object parent = this.getGraph().getDefaultParent();
		Object entityOne = this.getMap().get(JOptionPane.showInputDialog("Digite o nome da 1º entidade"));
		Object entityTwo = this.getMap().get(JOptionPane.showInputDialog("Digite o nome da 2º entidade"));
		String name = JOptionPane.showInputDialog("Digite o nome da ligação");
		this.getGraph().insertEdge(parent, null, name, entityOne, entityTwo);
	}
	
}
