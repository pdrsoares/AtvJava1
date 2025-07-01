package modelo;

public class Curso {
    private int id;
    private String nome;
    private int cargaHoraria;
    private int limiteAlunos;
    
    public Curso() {
    }

    // Construtor com id (usado para quando tiver id)
    public Curso(int id, String nome, int cargaHoraria, int limiteAlunos) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
    }

    // Novo construtor sem id (para cadastro novo)
    public Curso(String nome, int cargaHoraria, int limiteAlunos) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getLimiteAlunos() {
        return limiteAlunos;
    }

    public void setLimiteAlunos(int limiteAlunos) {
        this.limiteAlunos = limiteAlunos;
    }

    @Override
    public String toString() {
        return nome; // importante para exibir no JComboBox
    }
}




