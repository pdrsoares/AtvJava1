package factory;


public class TesteDrive {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!");
            e.printStackTrace();
            
        }
    }
}

