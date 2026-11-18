/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mathe
 */
public class Aluno {
    private String nome;
    private int id;
    private List<Double> nota;
    private String nascimento;
    private List<String> info;
    private ArrayList<Disciplinas>Disci;
 
    private List<Integer>faltas;
    

    public Aluno(String nome, int id, String nascimento) {
        this.nome = nome;
        this.id = id;
        this.nascimento = nascimento;
        this.nota = new ArrayList<>();
        this.info = new ArrayList<>();
        this.Disci = new ArrayList<>();
     
        this.faltas = new ArrayList<>();
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Double> getNota() {
        return nota;
    }

    public void setNota(List<Double> nota) {
        this.nota = nota;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

     public void AddInfo(String nome){
        info.add(nome);
     }
     
     public void AddNotas(double nome){
        nota.add(nome);
     }
     
     
     

    @Override
    public String toString() {
        String notasStr = String.join(";", nota.stream().map(String::valueOf).toArray(String[]::new));
    String infoStr = String.join(";", info);
    String faltasStr = String.join(";", faltas.stream().map(String::valueOf).toArray(String[]::new));
    
   
   
 
 
    return id+ "-" +nome;
    }
     public void exportar(boolean append) throws IOException {
    FileWriter write = new FileWriter("alunos.csv", append);
    PrintWriter file = new PrintWriter(write);
    
    file.append(this.ExportarCSV());
    file.println();
    
    file.close();
}

  
    public void adicionarFalta(int valor) {
    if (faltas == null) {
        faltas = new ArrayList<>();
    }

    if (faltas.isEmpty()) {
        faltas.add(valor);  // adiciona o valor inicial
    } else {
        int totalAtual = faltas.get(0);
        totalAtual += valor;  // soma o valor passado
        faltas.set(0, totalAtual);
    }
}

    public void removerFalta(int valor) {
    if (faltas == null || faltas.isEmpty()) {
        // Se não tem faltas, não faz nada
        return;
    }

    int totalAtual = faltas.get(0);
    totalAtual -= valor;

    if (totalAtual < 0) {
        totalAtual = 0;  // Evita valor negativo
    }

    faltas.set(0, totalAtual);
}

    // Método para contar o número de faltas
    public int contarFaltas() {
        return faltas.size(); // Retorna o tamanho da lista de faltas (quantidade de faltas)
    }

    public List<Integer> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Integer> faltas) {
        this.faltas = faltas;
    }

    public ArrayList<Disciplinas> getDisci() {
        return Disci;
    }

    public void setDisci(ArrayList<Disciplinas> Disci) {
        this.Disci = Disci;
    }
    public  void exportarNotas() throws IOException{
          for (int i = 0; i < Disci.size(); i++) {
              Disciplinas  Disciplinas = Disci.get(i);
             
              if(i == 0){
              Disciplinas.exportarNotas(false);
              }
              else{
               Disciplinas.exportarNotas(true);
              
              }
              }
              
          }
    public Disciplinas getDisciplinaPorNome(String nome) {
    for (Disciplinas disci : this.Disci) {
        if (disci.getNome().equalsIgnoreCase(nome)) {
            return disci; // achou a disciplina
        }
    }
    return null; // não encontrou
}
 public String ExportarCSV(){
     String notasStr = String.join(";", nota.stream().map(String::valueOf).toArray(String[]::new));
    String infoStr = String.join(";", info);
    String faltasStr = String.join(";", faltas.stream().map(String::valueOf).toArray(String[]::new));
    
   
   
 
 
    return id + "," + nome + "," + nascimento + "," + notasStr + "," + infoStr + "," +faltasStr;
 }   
}
