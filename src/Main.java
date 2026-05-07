import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {


    public static List<Requisicao> selecionarMaximo(List<Requisicao> requisicoes) {
        // 1. Ordena pelo tempo de término
        requisicoes.sort(Comparator.comparingInt(r -> r.fim));

        // 2. Criação de uma lista para armazenar a solução e uma variavel para armazenar o tempo de término da requisição atual
        List<Requisicao> solucao = new ArrayList<>();
        int terminoAtual = 0;

        // 3. Percorre as requisições
        for (Requisicao r : requisicoes) {
            //  4. Checa se a conflito entre requisições
            if (r.inicio >= terminoAtual) {
                //5. adiciona a requesição á solução e atualiza o tempo de termino
                solucao.add(r);
                terminoAtual = r.fim;
            }
        }

        return solucao;
    }

    public static void imprimir(List<Requisicao> lista) {
        System.out.println("Total de requisições: " + lista.size());
        for (Requisicao r : lista) {
            System.out.println("ID: " + r.id + " [" + r.inicio + ", " + r.fim + "]");
        }
    }

    public static void main(String[] args) {

        List<Requisicao> requisicoes = new ArrayList<>();

        requisicoes.add(new Requisicao(1, 1, 4));
        requisicoes.add(new Requisicao(2, 6, 8));
        requisicoes.add(new Requisicao(3, 0, 6));
        requisicoes.add(new Requisicao(4, 5, 7));
        requisicoes.add(new Requisicao(5, 8, 9));
        requisicoes.add(new Requisicao(6, 7, 9));

        List<Requisicao> resultado = selecionarMaximo(requisicoes);

        System.out.println("Requisições selecionadas:");
        imprimir(resultado);
    }
}