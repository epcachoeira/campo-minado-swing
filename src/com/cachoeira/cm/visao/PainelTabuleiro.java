package com.cachoeira.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.cachoeira.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

		tabuleiro.registrarObservador(e -> {
			SwingUtilities.invokeLater(() -> {
				if (e.isGanhou()) {
					JOptionPane.showMessageDialog(this, "Voc? ganhou :)");
				} else {
					JOptionPane.showMessageDialog(this, "Voc? perdeu :(");
				}
				
				tabuleiro.reiniciar();
			});
		});

	}
}
