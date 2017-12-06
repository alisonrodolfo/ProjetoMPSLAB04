/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author aliso
 */
public class ValidaEntradadeDados {

    private String login;
    private String senha;
    private boolean valid;
    private String errorMessageExceptionAmigavel;

    public ValidaEntradadeDados(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.valid = true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErrorMessageExceptionAmigavel() {
        return errorMessageExceptionAmigavel;
    }

    public void setErrorMessageExceptionAmigavel(String errorMessageExceptionAmigavel) {
        this.errorMessageExceptionAmigavel = errorMessageExceptionAmigavel;
    }

    public void valida() {
        if (login.length() > 12) {
            valid = false;
            errorMessageExceptionAmigavel = "Campo login é inválido\n"
                    + "Deve conter no máximo 12 letras! por favor, verifique novamente...\n";
            //throw new errorMessageException("Campo login é inválido\n"
            //        + "Deve conter no máximo 12 letras! por favor, verifique novamente...\n");

        } else if (login.equalsIgnoreCase("")) {
            valid = false;
            errorMessageExceptionAmigavel = "Campo login é inválido\n"
                    + "Não pode ser vazio! por favor, verifique novamente...\n";

        } else if (login.matches(".*\\d.*")) {
            valid = false;
            errorMessageExceptionAmigavel = "Campo login é inválido\n"
                    + "Não Deve conter números! por favor, verifique novamente...\n";

        }

        if (senha.length() > 20) {
            valid = false;
            errorMessageExceptionAmigavel = "Campo senha é inválido\n"
                    + "Deve conter no máximo 20 caracteres! por favor, verifique novamente...\n";

        } else if (senha.length() < 8) {
            valid = false;
            errorMessageExceptionAmigavel = "Campo senha é inválido\n"
                    + "Deve conter pelo menos 8 caracteres! por favor, verifique novamente...\n";

        } else if ((!senha.matches("[a-zA-Z]*")) && (!senha.matches(".*\\d.*")) || (!senha.matches(".*\\d{2,}.*"))) {
            valid = false;
            errorMessageExceptionAmigavel = "Campo senha é inválido\n"
                    + "Deve conter letras e pelo menos 2 números! por favor, verifique novamente...\n";

        }

    }

}
