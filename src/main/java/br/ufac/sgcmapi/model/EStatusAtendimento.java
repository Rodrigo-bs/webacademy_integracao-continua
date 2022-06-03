package br.ufac.sgcmapi.model;

public enum EStatusAtendimento {

    CANCELADO,
    AGENDADO,
    CONFIRMADO,
    CHEGADA,
    ATENDIMENTO,
    ENCERRADO;

    public EStatusAtendimento next() {
        EStatusAtendimento status = this;
        int index = ordinal() + 1;
        if (index < values().length) {
            status = values()[index];
        }
        return status;
    }
    
}
