package gals;

import java.util.ArrayList;
import java.util.Stack;

public class Semantico implements Constants {
    private CodigoObjeto codigoObjeto;
    private Stack<String> pilhaTipos;
    private Stack<String> pilhaRotulos;
    private ArrayList<Token> listaIdentificadores;
    private ArrayList<String> tabelaSimbolos;
    private String operadorRelacional;
    private int numRotulo = 0;

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
            case 105:
                acao105(token);
                break;
            case 106:
                acao106(token);
                break;
            case 107:
                acao107();
                break;
            case 108:
                acao108(token);
                break;
            case 109:
                acao109();
                break;
            case 110:
                acao110();
                break;
            case 111:
                acao111();
                break;
            case 112:
                acao112();
                break;
            case 113:
                acao113();
                break;
            case 114:
                acao114();
                break;
            case 115:
                acao115();
                break;
            case 116:
                acao116();
                break;
            case 117:
                acao117();
                break;
            case 118:
                acao118();
                break;
            case 119:
                acao119();
                break;
            case 120:
                acao120();
                break;
            case 121:
                acao121(token);
                break;
            case 122:
                acao122();
                break;
            case 123:
                acao123();
                break;
            case 124:
                acao124();
                break;
            case 125:
                acao125();
                break;
            case 126:
                acao126();
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
            case 131:
                acao131();
                break;
            default:
                break;
        }
    }

    private String criarRotulo() {
        String rotulo = "L" + numRotulo;
        numRotulo++;
        return rotulo;
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

    private String getTipoAritmetica() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();

        if (tipo1.equals("int64") && tipo2.equals("int64")) {
            return "int64";
        }

        return "float64";
    }

    private String getTipoRelacional() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();

        return "bool";
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

            codigoObjeto.adicionar(".locals (" + getTipo(idLexeme) + " " + idLexeme + ")");
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

    // Read
    private void acao105(Token token) throws SemanticError {
        String id = token.getLexeme();
        if (!tabelaSimbolos.contains(id)) {
            throw new SemanticError(id + " não declarado", token.getPosition());
        }

        String tipo = getTipo(id);
        codigoObjeto.adicionar("call string\n [mscorlib]System.Console::ReadLine()");

        if (!tipo.equals("string")) {
            String classe = "";
            switch (tipo) {
                case "int64":
                    classe = "Int64";
                    break;
                case "float64":
                    classe = "Double";
                    break;
                case "bool":
                    classe = "Boolean";
                    break;
            }
            codigoObjeto.adicionar("call " + tipo + "\n [mscorlib]System." + classe + "::Parse(string)");
        }
        codigoObjeto.adicionar("stloc " + id);
    }

    private void acao106(Token token) {
        codigoObjeto.adicionar("ldstr " + token.getLexeme());
        codigoObjeto.adicionar("call void\n [mscorlib]System.Console::WriteLine(string)");
    }

    // Writeln
    private void acao107() {
        codigoObjeto.adicionar("ldstr \" \"\ncall void\n [mscorlib]System.Console::WriteLine(string)");
    }

    // Write
    private void acao108(Token token) {
        String tipo = pilhaTipos.pop();

        if (tipo.equals("int64")) {
            codigoObjeto.adicionar("conv.i8");
        }

        codigoObjeto.adicionar("call void\n [mscorlib]System.Console::Write(" + tipo + ")");
    }

    private void acao109() {
        pilhaRotulos.add(criarRotulo());
        String rotulo2 = criarRotulo();
        codigoObjeto.adicionar("brfalse " + rotulo2);
        pilhaRotulos.add(rotulo2);
    }

    private void acao110() {
        String rotulo2 = pilhaRotulos.pop();
        String rotulo1 = pilhaRotulos.pop();

        codigoObjeto.adicionar("br " + rotulo1);
        pilhaRotulos.add(rotulo1);
        codigoObjeto.adicionar("\n" + rotulo2 + ":");
    }

    private void acao111() {
        String rotulo = pilhaRotulos.pop();
        codigoObjeto.adicionar("\n" + rotulo + ":");
    }

    private void acao112() {
        String rotulo = criarRotulo();
        codigoObjeto.adicionar("brfalse " + rotulo);
        pilhaRotulos.add(rotulo);
    }

    private void acao113() {
        String rotulo = criarRotulo();
        codigoObjeto.adicionar("\n" + rotulo + ":");
        pilhaRotulos.add(rotulo);
    }

    private void acao114() {
        String rotulo = pilhaRotulos.pop();
        codigoObjeto.adicionar("brtrue " + rotulo);
    }

    private void acao115() {
        String rotulo = pilhaRotulos.pop();
        codigoObjeto.adicionar("brfalse " + rotulo);
    }

    private void acao116() {
        pilhaTipos.add(getTipoRelacional());
        codigoObjeto.adicionar("and");
    }

    private void acao117() {
        pilhaTipos.add(getTipoRelacional());
        codigoObjeto.adicionar("or");
    }

    private void acao118() {
        codigoObjeto.adicionar("ldc.i4.1");
        pilhaTipos.add("bool");
    }

    private void acao119() {
        codigoObjeto.adicionar("ldc.i4.0");
        pilhaTipos.add("bool");
    }

    private void acao120() {
        codigoObjeto.adicionar("ldc.i4.1\nxor");
    }

    private void acao121(Token token) {
        operadorRelacional = token.getLexeme();
    }

    private void acao122() {
        pilhaTipos.add(getTipoRelacional());

        switch (operadorRelacional) {
            case "==":
                codigoObjeto.adicionar("ceq");
                break;
            case "!=":
                codigoObjeto.adicionar("ceq");
                codigoObjeto.adicionar("ldc.i4.1\nxor");
                break;
            case "<":
                codigoObjeto.adicionar("clt");
                break;
            case ">":
                codigoObjeto.adicionar("cgt");
                break;
            default:
                break;
        }
    }

    // Adição
    private void acao123() {
        pilhaTipos.add(getTipoAritmetica());
        codigoObjeto.adicionar("add");
    }

    // Subtração
    private void acao124() {
        pilhaTipos.add(getTipoAritmetica());
        codigoObjeto.adicionar("sub");
    }

    // Multiplicação
    private void acao125() {
        pilhaTipos.add(getTipoAritmetica());
        codigoObjeto.adicionar("mul");
    }

    // Divisão
    private void acao126() {
        pilhaTipos.add("float64");
        codigoObjeto.adicionar("div");
    }

    private void acao127(Token token) throws SemanticError {
        String id = token.getLexeme();
        if (!tabelaSimbolos.contains(id)) {
            throw new SemanticError(id + " não declarado", token.getPosition());
        }
        String tipo = getTipo(id);
        pilhaTipos.add(tipo);
        codigoObjeto.adicionar("ldloc " + token.getLexeme());

        if (tipo.equals("int64")) {
            codigoObjeto.adicionar("conv.r8");
        }
    }

    private void acao128(Token token) {
        codigoObjeto.adicionar("ldc.i8 " + token.getLexeme());
        codigoObjeto.adicionar("conv.r8");

        pilhaTipos.add("int64");
    }

    private void acao129(Token token) {
        codigoObjeto.adicionar("ldc.r8 " + token.getLexeme().replace(",", "."));
        pilhaTipos.add("float64");
    }

    private void acao130(Token token) {
        codigoObjeto.adicionar("ldstr " + token.getLexeme());
        pilhaTipos.add("string");
    }

    private void acao131() {
        codigoObjeto.adicionar("ldc.r8 -1.0");
        codigoObjeto.adicionar("mul");
    }
}
