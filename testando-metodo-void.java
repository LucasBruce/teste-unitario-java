@Test
	public void testInserirNovaConciliacao() throws Exception {
		this.initSolicitacaoProcessamento();
		this.initFormValid();
		
		this.repositorioProcessamento = Mockito.spy(new RepositorioProcessamento());
		this.gatewayTransacao = Mockito.spy(new BBSolicitacao());				
		
		Mockito.doNothing().when(this.repositorioProcessamento).inserirSolicitacao(1, data, data, data, codigoStr, codigoStr, data, data);
		Mockito.doNothing().when(this.gatewayTransacao).inserirNovaConciliacao();
		
		
		String resultado = "";
		try {
			
			this.gatewayTransacao.inserirNovaConciliacao();
			this.repositorioProcessamento.inserirSolicitacao(1, this.data, this.dataInicial,
				       this.dataFinal, this.codigoStr, this.codigoStr,
				       this.dataInicial, this.dataFinal);
			
		} catch (Exception e) {
			
		}
		
		Mockito.verify(this.repositorioProcessamento, Mockito.atLeastOnce())
	       .inserirSolicitacao(Mockito.anyInt(), Mockito.any(Date.class), 
	       Mockito.any(Date.class), Mockito.any(Date.class), Mockito.any(String.class),
	       Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class));
		
		Mockito.verify(this.gatewayTransacao, Mockito.atLeastOnce())
	       .inserirNovaConciliacao();
	}

