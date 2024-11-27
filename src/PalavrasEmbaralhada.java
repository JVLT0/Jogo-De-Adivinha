import java.io.*;
import java.text.Normalizer;
import java.util.*;

public class PalavrasEmbaralhada {
    
    private String palavraOriginal;
    

    public PalavrasEmbaralhada() {
        List<String> palavras = carregarPalavrasDoArquivo("/files/Lista de Palavras.txt");
        if (palavras.isEmpty()) {
            throw new IllegalStateException("Nenhuma palavra foi carregada do arquivo.");
        }
        palavraOriginal = palavras.get(new Random().nextInt(palavras.size()));
    }

    public String getPalavraEmbaralhada(){
        List<Character> caracteres = new ArrayList<>();
        for (char c : palavraOriginal.toCharArray()) {
            caracteres.add(c);
        }
        Collections.shuffle(caracteres);
        StringBuilder embaralhar = new StringBuilder();
        for (char c : caracteres) {
            embaralhar.append(c);
        }
        return embaralhar.toString();
    }

    public String getPalavraOriginal(){
        return palavraOriginal;
    }

    private List<String> carregarPalavrasDoArquivo(String nomeDoArquivo) {
        List<String> palavras = new ArrayList<>();
        
        // Depuração: Imprimir o caminho absoluto do arquivo
        InputStream input = getClass().getResourceAsStream(nomeDoArquivo);
        
        if (input == null) {
            System.out.println("Arquivo não encontrado: " + nomeDoArquivo);
        }
    
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                palavras.add(linha.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Depuração: Verificar quantas palavras foram carregadas
        System.out.println("Número de palavras carregadas: " + palavras.size());
    
        return palavras;
    }    
}
