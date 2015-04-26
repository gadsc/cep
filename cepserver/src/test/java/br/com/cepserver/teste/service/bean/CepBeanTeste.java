package br.com.cepserver.teste.service.bean;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.cepserver.service.bean.CepBean;

/**
 * Classe de teste para validar a implementação feita da classe CepBean
 * 
 * @author Gabz
 *
 */
public class CepBeanTeste extends TestCase {

	private CepBean cepBean;
	private final String CEP_TESTE = "90000000";

	protected void setUp() throws Exception {
		super.setUp();
		cepBean = new CepBean();
		cepBean.populaCepBean();
	}

	@Test
	public void testBuscarEnderecoPorCepValido() {
		assertNotNull(cepBean.buscarEnderecoPorCep(CEP_TESTE));
	}

	@Test
	public void testGetCepAlterado() {
		assertEquals(CEP_TESTE, cepBean.getCepAlterado("90000099", 2));
	}

	@Test
	public void testConcatDigitoAlterado() {
		assertEquals("00000", cepBean.concatDigitoAlterado(5));
	}
}