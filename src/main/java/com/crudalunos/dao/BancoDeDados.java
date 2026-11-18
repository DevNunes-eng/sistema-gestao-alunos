/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudalunos.dao;

import crudalunos.model.Aluno;
import crudalunos.model.Disciplinas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mathe
 */
public class BancoDeDados {
    private ArrayList<Aluno>ListaAluno;
    private Aluno objeto;
   

    public BancoDeDados() {
     ListaAluno = new ArrayList<Aluno>();
    
    }
    public void Addconta(Aluno nome){
        ListaAluno.add(nome);
    }

    public ArrayList<Aluno> getListaAluno() {
        return ListaAluno;
    }

    public void setListaAluno(ArrayList<Aluno> ListaAluno) {
        this.ListaAluno = ListaAluno;
    }
    
  public Aluno BancoEmClass(String nome){
        for (int i = 0; i < ListaAluno.size(); i++) {
            Aluno objeto = ListaAluno.get(i);
            if(objeto.getNome().equals(nome)){
                return objeto;
            }
            
        }
        return null;
    }
    public void exportarAlunos() throws IOException {
        // Cria o arquivo já em modo de sobrescrita. Se a lista estiver vazia, ele salva um arquivo em branco (apagando o removido)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("alunos.csv"))) {
            for (Aluno aluno : ListaAluno) {
                bw.write(aluno.ExportarCSV());
                bw.newLine();
            }
        }
    }
  public void importarDadosArquivo(String caminhoArquivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
        String linha;

        while ((linha = br.readLine()) != null) {
            System.out.println(linha);

            String[] campos = linha.split(","); // Divide a linha pelos campos principais
            
            if (campos.length >= 3) { // Garante que tenha pelo menos ID, Nome, Idade e Notas
                int id = Integer.parseInt(campos[0].trim());
                String nome = campos[1].trim();
                String nascimento = campos[2].trim();

                Aluno aluno = new Aluno(nome, id, nascimento);

                // Importando as notas
                List<Double> notas = new ArrayList<>();
                if (campos.length > 3 &&!campos[3].isEmpty()) {
                    String[] notasStr = campos[3].split(";");
                    for (String nota : notasStr) {
                        notas.add(Double.parseDouble(nota.trim()));
                    }
                }
                aluno.setNota(notas);

                
                List<String> info = new ArrayList<>();
                if (campos.length >4 && !campos[4].isEmpty()) {
                    info.addAll(Arrays.asList(campos[4].split(";")));
            
             
                
                }
                aluno.setInfo(info);
                List<Integer>faltas = new ArrayList<>();
             if (campos.length > 5 && !campos[5].isEmpty()) {
                    // Aqui você precisa verificar a quantidade de faltas e adicioná-las corretamente
                    String[] faltasStr = campos[5].split(";");
                    for (String falta : faltasStr) {
                     faltas.add(Integer.parseInt(falta.trim()));
                    }
                    
                }
             aluno.setFaltas(faltas);
                ListaAluno.add(aluno); // Adiciona o aluno importado à lista
            }
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.err.println("Erro ao converter número: " + e.getMessage());
    }
    
}

    public void importarDadosArquivo2(String caminhoArquivo) throws FileNotFoundException, IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
        String linha;

        while ((linha = br.readLine()) != null) {
            System.out.println(linha);

            String[] campos = linha.split(","); // Divide a linha pelos campos principais
            
            if (campos.length >= 4) { // Garante que tenha pelo menos ID, Nome, Idade e Notas
                Disciplinas objeto = new Disciplinas();
                String aluno = campos[2].trim();
               int id = Integer.parseInt(campos[3].trim());
                
                Aluno desconhecido = BancoEmClass2(id);
                
                String nome = campos[0].trim();
               List<Double> notas = new ArrayList<>();
               objeto.setNome(nome);
                
                    String[] notasStr = campos[1].split(";");
                    for (String nota : notasStr) {
                        notas.add(Double.parseDouble(nota.trim()));
                    }
                    objeto.setNotas(notas);
                    objeto.setAluno(desconhecido);
                   desconhecido.getDisci().add(objeto);
                    
                    
                }
                

               
            }
        }
    
    }


    public Aluno getObjeto() {
        return objeto;
    }

    public void setObjeto(Aluno objeto) {
        this.objeto = objeto;
    }
    public void exportarTodasAsNotas() throws IOException {
     try (BufferedWriter bw = new BufferedWriter(new FileWriter("notas.csv"))) { // sem 'true' aqui: sobrescreve, mas é intencional
        for (Aluno aluno : ListaAluno) {
            for (Disciplinas dis : aluno.getDisci()) {
                String nomeDis = dis.getNome();
                String notasStr = dis.getNotas().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(";"));
                String linha = nomeDis + "," + notasStr + "," + aluno.getNome()+ "," +aluno.getId();
                bw.write(linha);
                bw.newLine();
            }
        }
    }
}
    public Aluno BancoEmClass2(int nome){
        for (int i = 0; i < ListaAluno.size(); i++) {
            Aluno objeto = ListaAluno.get(i);
            if(nome == objeto.getId()){
                return objeto;
            }
            
        }
        return null;
    }
public static boolean validarID(String entrada) {
    // Verifica se a entrada é composta apenas por dígitos (número inteiro)
    return entrada.matches("\\d+");
}

public static boolean validarIdade(String entrada){
    return entrada.matches("\\d+");
}
public static boolean validarNascimento(String entrada) {
        // 1º passo: regex para garantir formato
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$";
        if (!entrada.matches(regex)) {
            return false;
        }

        // 2º passo: validação real
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate data = LocalDate.parse(entrada, formatter);

            // opcional: não permitir datas futuras
            if (data.isAfter(LocalDate.now())) {
                return false;
            }

            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
public void removerAluno(Aluno aluno){
    if(aluno != null){
        
        ListaAluno.remove(aluno);
    }
}
}
    

    
    
    
    
    
  
