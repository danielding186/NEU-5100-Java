package assignment8;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField resultTextField;
	private JButton add, subtract, multiply, divide, compute;

	private JButton numbers[];
	private Font font;

	int first = 0;
	int second = 0;
	boolean inputFirst = true;

	Operation o = Operation.ADD;

	class OperationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String op = "";
			if (e.getSource() == add) {
				o = Operation.ADD;
				op = "+";
			}
			if (e.getSource() == subtract) {
				o = Operation.SUBTRACT;
				op = "-";
			}
			if (e.getSource() == multiply) {
				o = Operation.MULTIPLY;
				op = "*";
			}
			if (e.getSource() == divide) {
				o = Operation.DIVIDE;
				op = "/";
			}
			
			String prev = resultTextField.getText();
			resultTextField.setText(prev + " " + op + " ");
			
			inputFirst = false;
		}

	}
	
	class NumberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int index = 0;
			for (; index < numbers.length; index++) {
				if (button == numbers[index])
					break;
			}
			
			if (inputFirst) {
				first = first * 10 + index;
				resultTextField.setText(first + "");
			}
			else {
				second = second * 10 + index;
				String prev = resultTextField.getText();
				resultTextField.setText(prev + index);
			}
			
		}
		
	}
	

	class ComputeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = 0;
			String error = "";
			if (o == Operation.ADD) {
				result = first + second;
			}
			else if (o == Operation.SUBTRACT) {
				result = first - second;
			}
			else if (o == Operation.DIVIDE) {
				if (second != 0)
					result = first / second;
				else
					error = "Cannot divide 0";
			}
			else if (o == Operation.MULTIPLY) {
				result = first * second;
			}
			else {
				result = first;
			}
			
			String pre = resultTextField.getText() + " = ";
			
			if (error.length() > 0)
				resultTextField.setText(pre + error);
			else
				resultTextField.setText(pre + result);
			
			first = 0;
			second = 0;
			inputFirst = true;
		}

	}

	public Calculator() {
		createComponents();
		setLayout();
		addComponents();
		addBehaviors();
		display();
	}

	private void addBehaviors() {
		ComputeListener cl = new ComputeListener();
		compute.addActionListener(cl);

		OperationListener ol = new OperationListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);

	}

	private void display() {
		setSize(600, 600);
		setVisible(true);

	}

	private void addComponents() {
		Container c = getContentPane();
		c.add(resultTextField);

		JPanel panel = new JPanel();
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		c.add(panel);

		panel = new JPanel();
		panel.add(compute);
		c.add(panel);

		JPanel p = new JPanel();
		p.add(numbers[1]);
		p.add(numbers[2]);
		p.add(numbers[3]);
		p.add(numbers[4]);

		c.add(p);

		p = new JPanel();
		p.add(numbers[5]);
		p.add(numbers[6]);
		p.add(numbers[7]);
		p.add(numbers[8]);

		c.add(p);

		p = new JPanel();
		p.add(numbers[9]);
		p.add(numbers[0]);

		c.add(p);

	}

	private void setLayout() {
		GridLayout gl = new GridLayout(6, 1);
		Container c = this.getContentPane();
		c.setLayout(gl);

	}

	private void createComponents() {
		font = new Font("TimesRoman", Font.PLAIN, 36);
		resultTextField = new JTextField(10);
		resultTextField.setFont(font);
		resultTextField.setEditable(false);

		add = new JButton("+");
		add.setFont(font);
		subtract = new JButton("-");
		subtract.setFont(font);
		multiply = new JButton("x");
		multiply.setFont(font);
		divide = new JButton("%");
		divide.setFont(font);
		compute = new JButton("=");
		compute.setFont(font);

		numbers = new JButton[10];
		NumberListener listener = new NumberListener();
		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton(i + "");
			numbers[i].setFont(font);
			numbers[i].addActionListener(listener);
		}

	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setVisible(true);
	}

}