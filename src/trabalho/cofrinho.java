package trabalho;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

class Cofrinho {
    
    private Map<Class<? extends Moeda>, List<Moeda>> moedasPorTipo = new HashMap<>();

    // Adiciona as moedas ao cofrinho
    public void adicionarMoeda(Moeda moeda, int quantidade) {
        List<Moeda> listaMoedas = moedasPorTipo.getOrDefault(moeda.getClass(), new ArrayList<>());
        for (int i = 0; i < quantidade; i++) {
            listaMoedas.add(moeda);
        }
        moedasPorTipo.put(moeda.getClass(), listaMoedas);
    }

    // Remove  a quantida de solicitada de moedas
    public void removerMoeda(Class<? extends Moeda> tipo, int quantidade) {
        if (moedasPorTipo.containsKey(tipo)) {
            List<Moeda> listaMoedas = moedasPorTipo.get(tipo);
            if (listaMoedas.size() >= quantidade) {
                for (int i = 0; i < quantidade; i++) {
                    listaMoedas.remove(0);  
                }
                System.out.println(quantidade + " moeda(s) de " + tipo.getSimpleName() + " removida(s) com sucesso.");
            } else {
                System.out.println("Quantidade insuficiente de " + tipo.getSimpleName() + " para remover.");
            }
        } else {
            System.out.println("Não há moedas desse tipo no cofrinho.");
        }
    }

    // Lista as moedas no cofrinho 
    public void listarMoedas() {
        if (moedasPorTipo.isEmpty()) {
            System.out.println("Cofrinho vazio.");
        } else {
            for (Map.Entry<Class<? extends Moeda>, List<Moeda>> entry : moedasPorTipo.entrySet()) {
                Class<? extends Moeda> tipo = entry.getKey();
                List<Moeda> listaMoedas = entry.getValue();
                int quantidade = listaMoedas.size();

             
                double total = 0;
                for (Moeda moeda : listaMoedas) {
                    total += moeda.converterParaReal();
                }

                // Exibe o valor total da moeda em reais
                if (tipo.equals(Real.class)) {
                    System.out.printf("R$ %.2f reais\n", total);
                } else if (tipo.equals(Dolar.class)) {
                    System.out.printf("$ %.2f dólares\n", total);
                } else if (tipo.equals(Euro.class)) {
                    System.out.printf("€ %.2f euros\n", total);
                }
            }
        }
    }

    
    public double calcularTotalEmReais() {
        double total = 0;
        for (Map.Entry<Class<? extends Moeda>, List<Moeda>> entry : moedasPorTipo.entrySet()) {
            List<Moeda> listaMoedas = entry.getValue();

            // Calcula o valor total de cada tipo de moeda
            for (Moeda moeda : listaMoedas) {
                total += moeda.converterParaReal();
            }
        }
        return total;
    }
}
