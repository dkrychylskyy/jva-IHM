package toto.controler;

import java.util.ArrayList;

import toto.model.EleveBDD;
import toto.model.EleveBean;
import toto.view.IHM;

public class Controler {
	public IHM ihm;

	public IHM getIhm() {
		return ihm;
	}

	public void load() {
		try {
			ArrayList<EleveBean> Eleves = EleveBDD.getEleves();
			String list = "";
			for (EleveBean eleveBean : Eleves) {
				String nom = eleveBean.getNom();
				String prenom = eleveBean.getPrenom();
				list += nom + ", " + prenom + "\n";
				ihm.updateList(list);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void save(String prenom, String nom) {
		EleveBean eleve = new EleveBean(nom, prenom);
		try {
			ihm.updateErreur("");
			EleveBDD.Save(eleve);
			ihm.updateErreur("Eleve a été ajouté");
			ihm.setColorSucces();
		} catch (Exception e) {
			e.printStackTrace();
			ihm.updateErreur("Erreur : " +e.getMessage());
			ihm.setColorErreur();
		}
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

}
