package com.cachoeira.cm.modelo;

@FunctionalInterface
public interface CampoObservador {

	public void eventoOcorrido(Campo campo, CampoEvento evento);
	
}
