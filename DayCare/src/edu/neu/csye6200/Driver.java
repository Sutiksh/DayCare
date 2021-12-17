package edu.neu.csye6200;

import edu.neu.csye6200.view.ui.MainJFrame;

public class Driver {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainJFrame().setVisible(true);
			}
		});

	}

}
