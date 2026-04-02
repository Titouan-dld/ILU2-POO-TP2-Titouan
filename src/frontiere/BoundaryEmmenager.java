package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Binevenue villageois " + nomVisiteur);
					StringBuilder questionF = new StringBuilder();
					questionF.append("Quelle est votre force ?");
					int force = Clavier.entrerEntier(questionF.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue Druide " + nomVisiteur);
		StringBuilder questionF = new StringBuilder();
		questionF.append("Quelle est votre force ?");
		int force = Clavier.entrerEntier(questionF.toString());
		int maxPotion = -2;
		int minPotion = -1;
		StringBuilder question = new StringBuilder();
		while (maxPotion<minPotion) {
			if(maxPotion != -2 || minPotion != -1) {
				System.out.println("Attention Druide vous vous êtes trompé entre le maximum et le minimum");
			}
			question.append("Quel est la potion la plus faible que vous produisiez ?\n");
			minPotion = Clavier.entrerEntier(question.toString());
			question.append("Quel est la potion la plus faible que vous produisiez ?\n");
			maxPotion = Clavier.entrerEntier(question.toString());
		}
		controlEmmenager.ajouterDruide(nomVisiteur, force, minPotion, maxPotion);
	}
}

