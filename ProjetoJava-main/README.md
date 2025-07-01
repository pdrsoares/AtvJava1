# 🎓 Sistema de Cadastro de Cursos e Alunos - FATEC SJC

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/Java_Swing-ED8B00?style=for-the-badge&logo=java&logoColor=white)

Projeto acadêmico desenvolvido por **Pedro Henrique de Paula Soares** no 2º semestre do curso de **Análise e Desenvolvimento de Sistemas** da **FATEC São José dos Campos**.

## 📌 Visão Geral

Sistema de gestão acadêmica que permite:
- Cadastro e gerenciamento de cursos
- Matrícula e administração de alunos
- Geração de relatórios em formato TXT

## 🚀 Começando

### Pré-requisitos
- Java JDK 8+
- MySQL Server 8.0+
- MySQL Workbench

### Instalação
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-cursos-alunos.git
   ```

2. Importe o projeto na sua IDE favorita (Eclipse, IntelliJ, etc.)

3. Configure o banco de dados:
   - Execute o script `sistema_gestao_db.sql` no MySQL Workbench
   - Credenciais padrão:
     ```
     Usuário: root
     Senha: root
     ```

4. Execute a classe `Main.java` para iniciar o sistema

## 🛠️ Funcionalidades

### Gerenciamento de Cursos
- ✅ Cadastro de novos cursos
- 📋 Listagem completa de cursos
- ✏️ Edição de informações
- ❌ Exclusão de registros
- 📤 Exportação para TXT

### Gerenciamento de Alunos
- 👤 Cadastro com validação de CPF
- � Associação automática a cursos
- 🔄 Atualização de vagas disponíveis
- 📄 Geração de relatórios

## 🗂️ Estrutura do Projeto

```
src/
├── gui/            # Interface gráfica (Swing)
├── modelo/         # Entidades (Aluno, Curso)
├── dao/            # Acesso a dados (DAO Pattern)
├── factory/        # Conexão com banco
└── Main.java       # Ponto de entrada
```

## 📄 Documentação

- [Manual do Usuário](docs/MANUAL.md)
- [Diagrama de Classes](docs/diagrama-classes.png)
- [Script SQL](cursos_db_backup.sql)

## 🤝 Contribuição
Este é um projeto acadêmico e não está aberto a contribuições externas no momento.

## 📜 Licença
Este projeto está licenciado para fins **exclusivamente educacionais**.

---

Desenvolvido por [Pedro Soares]((https://github.com/pdrsoares)) | FATEC SJC - 2025
