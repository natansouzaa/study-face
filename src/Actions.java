import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Actions extends JFrame {

	protected static mxGraph graph = new mxGraph();
	protected static HashMap map = new HashMap();
	private mxGraphComponent graphComponent;
	private JTextField text;
	private JButton buttonAdd;
	private JButton buttonDel;
	private JButton buttonLink;
	private Object cell;
	
	public static mxGraph getGraph() {
		return graph;
	}
	
	public static HashMap getMap() {
		return map;
	}
	
	public Actions() {
		super("Study-face");
		initGUI();
	}
	
	public void initGUI() {
		setSize(800, 600);
		//Centraliza a janela na tela
		setLocationRelativeTo(null);
		
		graphComponent = new mxGraphComponent(graph);
		
		graphComponent.setPreferredSize(new Dimension(770, 480));
		
		getContentPane().add(graphComponent);
		
		text = new JTextField();
		getContentPane().add(text);
		text.setPreferredSize(new Dimension(520, 21));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		buttonAdd = new JButton("Adicionar");
		getContentPane().add(buttonAdd);
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AddGraph add = new AddGraph(text.getText());
			}
			
		});
		
		buttonDel = new JButton("Deletar");
		getContentPane().add(buttonDel);
		buttonDel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				graph.getModel().remove(cell);
			}
			
		});
		
		buttonLink = new JButton("Ligar");
		getContentPane().add(buttonLink);
		buttonLink.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AddLink link = new AddLink();
			}
			
		});
		
		graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				cell =  graphComponent.getCellAt(e.getX(), e.getY());
			}
			
		});
		
	}
	
}
