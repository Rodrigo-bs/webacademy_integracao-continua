package br.ufac.sgcmapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EStatusAtendimentoTest {

    @Test
    public void testProximo() {
        EStatusAtendimento status = EStatusAtendimento.AGENDADO;
        status = status.next();
        assertEquals(EStatusAtendimento.CONFIRMADO, status);
    }
    
}
