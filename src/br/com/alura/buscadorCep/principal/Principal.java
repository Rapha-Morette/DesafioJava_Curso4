package br.com.alura.buscadorCep.principal;

import br.com.alura.buscadorCep.modelos.ConsultaCep;
import br.com.alura.buscadorCep.modelos.Endereco;
import br.com.alura.buscadorCep.modelos.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();

        System.out.println("Digite um número de cep para consulta: ");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco =  consulta.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaArquivoJson(novoEndereco);
        }
        catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a plicação");
        }
    }
}
