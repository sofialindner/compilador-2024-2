package gals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodigoObjeto {
    private String codigo;

    public CodigoObjeto() {
        setCodigo("");
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void adicionar(String instrucoes) {
        setCodigo(getCodigo() + "\n" + instrucoes);
    }

    public void gerarArquivoIL(String caminho) throws IOException {
        String caminhoSemTxt = caminho.split(".txt")[0];
        String caminhoArquivo = caminhoSemTxt + ".il";

        // Cria arquivo se não houver nenhum erro
        File arquivo = new File(caminhoArquivo);

        FileWriter fw = new FileWriter(arquivo);
        fw.write(getCodigo());
        fw.close();
    }
}
