package com.uniovi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ventana {

	public JLabel textoMemoria;
	JFrame frame;
	JPanel panel;
	JButton botonActualizar;
	JButton botonApagar;
	int peticiones = 0;

	public Ventana() {
		// Frame
		frame = new JFrame("Aplicación Monitorización");
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		// Panel
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		// Botón Actualizar
		botonActualizar = new JButton("Actualizar Memoria");
		botonActualizar.setBorder(new EmptyBorder(10, 10, 10, 10));
		botonActualizar.addActionListener(arg0 -> {
			peticiones++;
			ActualizarMemoriaThread hilo = new ActualizarMemoriaThread(Ventana.this);
			hilo.start();

		});
		panel.add(botonActualizar);
		// Botón Actualizar
		botonApagar = new JButton("Apagar Equipo");
		botonApagar.setBorder(new EmptyBorder(10, 10, 10, 10));
		botonApagar.addActionListener(arg0 -> JOptionPane.showMessageDialog(frame, "Enviado apagar!"));
		panel.add(botonApagar);
		// Texto memoria
		textoMemoria = new JLabel();
		textoMemoria.setBorder(new EmptyBorder(10, 10, 10, 10));
		textoMemoria.setText("Memoria libre:");
		panel.add(textoMemoria);
		// Propiedades visibilidad frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Ventana();

	}

	public void actualizarMemoria(String memoria) {
		SwingUtilities.invokeLater(() -> textoMemoria.setText("Memoria libre: " + memoria + " (" + peticiones + ")"));
	}
}
