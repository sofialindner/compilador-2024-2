package gals;

import java.util.ArrayList;
import java.util.Stack;

public class Semantico implements Constants {
    private CodigoObjeto codigoObjeto;
    private Stack<String> pilhaTipos;
    private Stack<String> pilhaRotulos;
    private ArrayList<Token> listaIdentificadores;
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
                acao102();
                break;
            case 103:
                acao103(token);
                break;
            case 104:
                acao104(token);
                break;
            case 107:
                acao107();
                break;
            case 108:
                acao108(token);
                break;
            case 118:
                acao118();
                break;
            case 119:
                acao119();
                break;
            case 127:
                acao127(token);
                break;
            case 128:
                acao128(token);
                break;
            case 129:
                acao129(token);
                break;
            case 130:
                acao130(token);
                break;
            default:
                break;
        }
    }

   private String getTipo(String id) {
       String prefixo = id.split("_")[0];
       switch (prefixo) {
           case "i":
               return "int64";
           case "f":
               return "float64";
           case "s":
               return "string";
           case "b":
               return "bool";
           default:
               return "";
       }
   }

    // Cabeçalho
    private void acao100() {
        codigoObjeto.adicionar(
                ".assembly extern mscorlib {}\n" +
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

    private void acao102() throws SemanticError {
        for (int i = 0; i < listaIdentificadores.size(); i++) {
            Token id = listaIdentificadores.get(i);
            String idLexeme = id.getLexeme();

            if (tabelaSimbolos.contains(idLexeme)) {
                throw new SemanticError(idLexeme + " já declarado", id.getPosition());
            }
            tabelaSimbolos.add(idLexeme);

            codigoObjeto.adicionar(".locals (" + getTipo(idLexeme)+ " " + idLexeme + ")");
        }
        listaIdentificadores.clear();
    }

    // Atribuição
    private void acao103(Token token) throws SemanticError {
        String tipo = pilhaTipos.pop();
        if (tipo.equals("int64")) {
            codigoObjeto.adicionar("conv.i8");
        }

        // Duplica valor da expressão para que todos os identificadores o atribuam
        for (int i = 0; i < listaIdentificadores.size() - 1; i++) {
            codigoObjeto.adicionar("dup");
        }

        // Verifica se identificadores foram declarados
        for (int i = 0; i < listaIdentificadores.size(); i++) {
            String id = listaIdentificadores.get(i).getLexeme();

            if (tabelaSimbolos.contains(id)) {
                codigoObjeto.adicionar("stloc " + id);
            } else {
                throw new SemanticError(id + " não declarado", token.getPosition());
            }
        }
        listaIdentificadores.clear();
    }

    // Adiciona à lista de identificadores em sequência
    private void acao104(Token idToken) {
        listaIdentificadores.add(idToken);
    }

    private void acao105() {
    }

    private void acao106() {
    }

    // Writeln
    private void acao107() {
        codigoObjeto.adicionar("ldstr \" \"\ncall void\n [mscorlib]System.Console::WriteLine(string)");
    }

    // Write
    private void acao108(Token token) {
        String tipo = pilhaTipos.pop();

        if (tipo.equals("int64")) {
            codigoObjeto.adicionar("conv.i8\n");
        }

        codigoObjeto.adicionar("call void\n [mscorlib]System.Console::Write(" + tipo + ")");
    }

    private void acao118(){
        codigoObjeto.adicionar("ldc.i4.1");
        pilhaTipos.add("bool");
    }

    private void acao119(){
        codigoObjeto.adicionar("ldc.i4.0");
        pilhaTipos.add("bool");
    }

    private void acao127(Token token) throws SemanticError{
        String id = token.getLexeme();
        if (!tabelaSimbolos.contains(id)) {
            throw new SemanticError(id + " não declarado", token.getPosition());
        }
        String tipo = getTipo(id) ;
        pilhaTipos.add(tipo);
        codigoObjeto.adicionar("ldloc " +token.getLexeme());

        if (tipo.equals("int64")) {
            codigoObjeto.adicionar("conv.r8\n");
        }
    }

    private void acao128(Token token){
        codigoObjeto.adicionar("ldc.i8 " + token.getLexeme());

        pilhaTipos.add("int64");
    }

    private void acao129(Token token){
        codigoObjeto.adicionar("ldc.r8" + token.getLexeme().replace(",", "."));
        pilhaTipos.add("float64");
    }

    private void acao130(Token token){
        codigoObjeto.adicionar("ldstr " + token.getLexeme());
        pilhaTipos.add("string");
    }


}
