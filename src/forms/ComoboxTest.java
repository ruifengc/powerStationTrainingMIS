package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
//没啥用的一个邮箱窗口
public class ComoboxTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComoboxTest frame = new ComoboxTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComoboxTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Item> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<Item>(getData()));
		comboBox.setBounds(156, 40, 184, 21);
		contentPane.add(comboBox);
	}
	
	public Vector<Item> getData(){
		Vector<Item> items =  new Vector<Item>();
		
		items.add(new Item("n1","v1"));
		items.add(new Item("n2","v2"));
		items.add(new Item("n3","v3"));
		items.add(new Item("n4","v4"));
		
		return items;
		
	}
}


class Item{
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	String value;
	
	public Item(String name,String value){
		this.name = name;
		this.value = value;
	}
	
}