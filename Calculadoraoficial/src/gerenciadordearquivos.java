import java.io.*;

public class gerenciadordearquivos {
    private String caminhoArquivo;

    public gerenciadordearquivos(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public void salvarResultado(String operacao, double a, double b, double resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            String linha = String.format("%s: %.2f e %.2f = %.2f", operacao, a, b, resultado);
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public void lerResultados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            System.out.println("Resultados salvos:");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}