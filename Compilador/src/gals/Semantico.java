package gals;

import java.util.ArrayList;
import java.util.Stack;

public class Semantico implements Constants {
    private CodigoObjeto codigoObjeto;
    private Stack<String> pilhaTipos;
    private Stack<String> pilhaRotulos;
    private ArrayList<String> listaIdentificadores;
    private ArrayList<String> tabelaSimbolos;

    public Semantico() {
        this.codigoObjeto = new CodigoObjeto();
        this.pilhaTipos = new Stack<>();
        this.pilhaRotulos = new Stack<>();
        this.listaIdentificadores = new ArrayList<>();
        this.tabelaSimbolos = new ArrayList<>();
    }

    public CodigoObjeto getCodigoObjeto() {
        return codigoObjeto;
    }

    public void executeAction(int action, Token token) throws SemanticError {
        switch (action) {
            case 100:
                acao100();
                break;
            case 101:
                acao101();
                break;
            case 102:
                acao102(token);
                break;
            default:
                break;
        }
    }

    // Cabeçalho
    private void acao100() {
        codigoObjeto.adicionar(
                "assembly extern mscorlib {}\n" +
                        ".assembly _codigo_objeto{}\n" +
                        ".module _codigo_objeto.exe\n" +
                        ".class public UNICA{\n" +
                        ".method static public void _principal() {\n" +
                        ".entrypoint");
    }

    // Fim de programa
    private void acao101() {
        codigoObjeto.adicionar("ret\n" +
                "}\n" +
                "}");
    }

    private void acao102(Token idToken) throws SemanticError {
        String id = idToken.getLexeme();
        if (tabelaSimbolos.contains(id)) {
            throw new SemanticError(id + " já declarado", idToken.getPosition());
        }
        tabelaSimbolos.add(id);

        String prefixo = id.split("_")[0];
        String tipo = "";
        switch (prefixo) {
            case "i":
                tipo = "int64";
                break;
            case "f":
                tipo = "float64";
                break;
            case "s":
                tipo = "string";
                break;
            case "b":
                tipo = "bool";
                break;
            default:
                break;
        }
        codigoObjeto.adicionar(".locals (" + tipo + " "+ id + ")");
    }

    private void acao103() {}

    private void acao104() {}

    private void acao105() {}

    private void acao106() {}

    private void acao107() {}

    // Comando de saída
    private void acao108() {

    }




}
