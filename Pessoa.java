package poo;

import java.time.LocalDate;
        // classe pessoa
public class Pessoa {
    private String nomeCompleto;
    private double altura;
    private LocalDate dataNascimento;
    private String email;

    public Pessoa(String nomeCompleto, double altura, String dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.altura = altura;

        // valida a data de nascimento 
        this.dataNascimento = LocalDate.parse(dataNascimento, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (this.dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento não pode ser posterior à data atual.");
        }

        // cria o email
        this.email = criarEmail(nomeCompleto);
    }

    private String criarEmail(String nomeCompleto) {
        String[] partes = nomeCompleto.split(" ");
        return partes[0].toLowerCase() + "." + partes[partes.length - 1].toLowerCase() + "@dominio.com";
    }
        // metodo tostring
    @Override
    public String toString() {
        return "Nome: " + nomeCompleto + ", Altura: " + altura + ", Data de Nascimento: " + dataNascimento + ", Email: " + email;
    }
        // exibe as informaçoes
    public static void main(String[] args) {
        try {
            Pessoa pessoa = new Pessoa("Ryan Rezani", 1.75, "29/05/2005");
            System.out.println(pessoa);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
