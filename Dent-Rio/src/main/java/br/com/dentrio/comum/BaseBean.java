package br.com.dentrio.comum;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = 750309574357642983L;

	public void addMessage(String summary, String detail) {

		// TODO ver como colocar a severidade da mensagem
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(summary, detail);
		context.addMessage(null, message);
		context.getExternalContext().getFlash().setKeepMessages(true);
	}

}
