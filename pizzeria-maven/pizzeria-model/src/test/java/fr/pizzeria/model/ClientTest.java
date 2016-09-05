package fr.pizzeria.model;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.exception.CreditException;

public class ClientTest {

	@Test
	public void testCrediterCompte() {
		Client client = new Client(3, "Nom", "prenom", 0);
		client.crediterCompte(10);

		Assert.assertTrue(client.getSolde() == 10);
	}

	// test si l'exception se lance
	@Test(expected = CreditException.class)
	public void testCrediterCompteSolde() {
		Client client = new Client(3, "Nom", "prenom", 0);
		client.crediterCompte(5000 + 1);

	}

}
