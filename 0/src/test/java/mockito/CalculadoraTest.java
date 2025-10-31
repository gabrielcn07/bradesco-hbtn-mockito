package mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculadoraTest {

    @Test
    void testSomarComMock() {
        // Cria um mock de ServicoMatematico
        ServicoMatematico servicoMock = mock(ServicoMatematico.class);

        // Configura o comportamento do mock
        when(servicoMock.somar(2, 3)).thenReturn(5);

        // Injeta o mock na Calculadora
        Calculadora calculadora = new Calculadora(servicoMock);

        // Executa o método
        int resultado = calculadora.somar(2, 3);

        // Verifica o resultado esperado
        assertEquals(5, resultado);

        // Verifica se o método do mock foi chamado corretamente
        verify(servicoMock).somar(2, 3);
    }
}
