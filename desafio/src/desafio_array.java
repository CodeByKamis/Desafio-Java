import java.util.Scanner;
import java.text.Normalizer;
import java.util.ArrayList;

public class desafio_array {
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        boolean jogo = true;

        ArrayList<String[]> historico = new ArrayList<>();
        while (jogo = true){
            System.out.println("Quantos nomes você deseja digitar?  ");
            int quantidade = info.nextInt();

            String[] nomes = new String[quantidade];

            for (int i = 0; i < quantidade; i++) {
                System.out.println("Nome " + (i + 1) + ": Digite o nome: ");
                nomes[i] = RemoverAcentuacao(info.next().toLowerCase());
                System.out.println("-------------------------------------------------------------------------------------");
            }
            int[] vezes = new int[nomes.length];

            for (int i=0; i<nomes.length; i++){
                if (vezes[i] !=0) {
                    continue;
                }

                int count = 1;
                for (int k= i + 1; k <nomes.length; k++){
                    if (nomes[i].equals(nomes[k])){
                        count++;
                        vezes[k]= -1;
                    }
                }
                vezes[i] = count;
            }


            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Olha a contagem das ocorrências: ");
            for (int i = 0; i< nomes.length; i++){
                if (vezes[i] != -1){
                    System.out.println(nomes[i]+ ": "+vezes[i]);
                }
            }
            historico.add(nomes);

            System.out.println("Você gostaria de jogar de novo? sim(1), não(2)");
            int pergunta = info.nextInt();

            if (pergunta == 1){
                jogo = true;

            }else if (pergunta == 2) {
                jogo = false;
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Exibição do Histórico:");

                for (int i = 0; i < historico.size(); i++) {
                    System.out.println("Rodada " + (i + 1) + ": " + String.join(", ", historico.get(i)));

                }
                break;
            }
        }




    }
    public static String RemoverAcentuacao(String texto){
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^\\p{ASCII}]", "");
        return texto;
    }

}

