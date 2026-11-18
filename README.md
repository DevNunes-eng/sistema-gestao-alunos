# Creative Alunos - Sistema de Gestão Escolar (CRUD)

Um sistema desktop desenvolvido em **Java** com interface gráfica **Swing**, voltado para o gerenciamento de alunos, notas, disciplinas, faltas e informações adicionais. O projeto utiliza manipulação de arquivos `.csv` como banco de dados local para persistência de informações.

## 🚀 Funcionalidades

O sistema oferece uma interface gráfica intuitiva e permite realizar as seguintes operações:

* **Cadastro de Alunos:** Inserção de novos alunos com ID, Nome e Data de Nascimento (com validação de formato `dd/MM/yyyy`).
* **Gestão de Notas e Disciplinas:**
  * Lançamento de múltiplas notas atreladas a disciplinas específicas.
  * Cálculo e armazenamento de histórico escolar.
* **Controle de Faltas:** Adição, remoção e contagem do número total de faltas de cada aluno.
* **Informações Adicionais:** Inserção de dados extras ou observações no perfil do aluno (ex: informações médicas, contatos).
* **Edição de Dados:** Atualização de nome, data de nascimento e informações gerais de alunos já cadastrados.
* **Remoção:** Exclusão de alunos do banco de dados.
* **Persistência de Dados (I/O):**
  * Exportação e importação automática de alunos para o arquivo `alunos.csv`.
  * Exportação e importação de notas e disciplinas para o arquivo `notas.csv`.

## 🛠️ Tecnologias Utilizadas

* **Java (JDK 8+)**: Linguagem principal do projeto.
* **Java Swing**: Biblioteca para construção das interfaces gráficas (telas e menus).
* **Manipulação de Arquivos (java.io)**: Leitura e escrita (`BufferedReader`, `FileWriter`) de arquivos CSV.
* **Expressões Regulares (Regex)**: Utilizadas para validação estrita de IDs, idade e datas de nascimento.
* **API de Datas (java.time)**: Uso do `LocalDate` e `DateTimeFormatter` para garantir que datas inseridas não sejam futuras e sigam o padrão correto.
* **Streams API**: Utilizada para processamento eficiente e formatação de listas de notas e faltas para exportação.

## 📂 Estrutura do Projeto

O projeto foi estruturado seguindo os princípios de Orientação a Objetos. Principais classes:

* `Aluno.java`: Entidade principal que armazena dados pessoais, listas de notas, disciplinas, faltas e informações adicionais.
* `Disciplinas.java`: Entidade que relaciona o nome de uma matéria com suas respectivas notas e o aluno correspondente.
* `Faltas.java`: Classe auxiliar para controle de faltas.
* `BancoDeDados.java`: Classe responsável pela lógica de negócio, armazenando a lista de alunos em memória (`ArrayList`) e gerenciando todas as operações de I/O (leitura e gravação de arquivos CSV) e validações (Regex).
* `Tela*.java`: Conjunto de classes de interface gráfica (Views) geradas via WindowBuilder/Matisse, responsáveis pela interação com o usuário (ex: `TelaAlunos.java`, `TelaAlunoMudança.java`, `Tela.java`).

## ⚙️ Como Executar

1. **Pré-requisitos:** Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado na sua máquina.
2. **Clone o repositório:**
   ```bash
   git clone [https://github.com/DevNunes-eng/sistema-gestao-alunos.git](https://github.com/DevNunes-eng/sistema-gestao-alunos.git)