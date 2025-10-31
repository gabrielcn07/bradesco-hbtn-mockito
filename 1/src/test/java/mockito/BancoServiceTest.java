package mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository contaRepository = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("123", 1000.0);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("123")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("123");

        // Verificando se o saldo está correto
        assertEquals(1000.0, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(contaRepository).buscarConta("123");
    }

    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository contaRepository = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("123", 1000.0);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("123")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Executando depósito
        bancoService.depositar("123", 500.0);

        // Verificando se o saldo foi atualizado
        assertEquals(1500.0, conta.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepository).buscarConta("123");
        verify(contaRepository).salvar(conta);
    }
}
