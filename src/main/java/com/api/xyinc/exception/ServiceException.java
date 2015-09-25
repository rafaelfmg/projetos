package com.api.xyinc.exception;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends RuntimeException {

    /**
     * Lista de par�metros para as mensagens para o usu�rio final.
     */
    private List<String> params = new ArrayList<String>();

    /** Ves&atilde;o de implementa&ccedil;&atilde;o da classe. */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor default da exce&ccedil;&atilde;o.
     */
    public ServiceException() {
        super();
    }

    /**
     * Construtor da exce&ccedil;&atilde;o.
     *
     * @param message Mensagem da exce&ccedil;&atilde;o.
     * @param cause Exce&ccedil;&atilde;o causadora desta exce&ccedil;&atilde;o.
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor da exce&ccedil;&atilde;o.
     *
     * @param message Mensagem da exce&ccedil;&atilde;o.
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Construtor da exce&ccedil;&atilde;o.
     *
     * @param cause Exce&ccedil;&atilde;o causadora desta exce&ccedil;&atilde;o.
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Obt�m a lista de par�metros para mensagens (opcional).
     *
     * @return Lista de par�metros.
     */
    public List<String> getParams() {
        return params;
    }

    /**
     * Configura a lista de par�metros para mensagens.
     *
     * @param params Lista de par�metros.
     */
    public void setParams(final List<String> params) {
        this.params = params;
    }

    /**
     * Adiciona um par�metro a lista de par�metros.
     *
     * @param param Par�metroa a ser adicionado.
     */
    public void addParams(final String param) {
        if (params == null) {
            params = new ArrayList<String>();
        }
        params.add(param);
    }

}