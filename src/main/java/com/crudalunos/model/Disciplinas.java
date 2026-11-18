/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudalunos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class Disciplinas {
    private List<Double>notas = new ArrayList<>();
   private String nome;
private Aluno aluno;
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void AddNota2( double nota){
      
        notas.add(nota);
    }

    @Override
    public String toString() {
        String notasStr = String.join(";", notas.stream().map(String::valueOf).toArray(String[]::new));
        return nome + "," + notasStr + "," +aluno.getNome()+ "," +aluno.getId();
    }
    public void exportarNotas(boolean append) throws IOException {
    FileWriter write = new FileWriter("notas.csv", append);
    PrintWriter file = new PrintWriter(write);
    
    file.append(this.toString());
    file.println();
    
    file.close();
}

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

   
}

