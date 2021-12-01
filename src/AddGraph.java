
public class AddGraph extends Actions {

	public AddGraph(String nome) {
		this.getGraph().getModel().beginUpdate();
		Object parent = this.getGraph().getDefaultParent();
		Object entity = this.getGraph().insertVertex(parent, null, nome, 330, 30, 100, 50);
		this.getMap().put(nome, entity);
		this.getGraph().getModel().endUpdate();
	}
	
}
