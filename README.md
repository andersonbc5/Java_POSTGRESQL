# 📦 Sistema de Gerenciamento de Produtos

🚀 Tecnologias Utilizadas
Java 8+

PostgreSQL 10+

JDBC para conexão com banco de dados

Padrão DAO (Data Access Object)

Arquitetura em camadas

🗃️ Estrutura do Banco de Dados

Tabela: produto

    CREATE TABLE produto (

    id SERIAL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    qtd INTEGER,
    preco DECIMAL(10,2) NOT NULL CHECK
    );

🎯 Funcionalidades
✅ Cadastrar produto - Inserir novos produtos no sistema

✅ Listar produtos - Visualizar todos os produtos cadastrados

✅ Buscar produto - Localizar produto por ID

✅ Atualizar produto - Editar informações de produtos existentes

✅ Excluir produto - Remover produtos do sistema