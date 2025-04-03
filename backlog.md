# 📌 Backlog do MVP - Marketplace

## **1️⃣ Gerenciamento de Usuários**

### **UC01 - Cadastro de Usuário**
- O usuário informa nome, e-mail, senha e papel (comprador ou vendedor).
- O sistema valida e salva no banco.
- O usuário recebe confirmação por e-mail (futuro).

### **UC02 - Login**
- O usuário informa e-mail e senha.
- O sistema valida e retorna um token JWT.

### **UC03 - Atualização de Perfil**
- O usuário pode atualizar seus dados pessoais e senha.

---

## **2️⃣ Gerenciamento de Lojas**

### **UC04 - Criar Loja**
- O vendedor informa nome e descrição da loja.
- O sistema vincula a loja ao usuário vendedor.

### **UC05 - Atualizar Loja**
- O vendedor pode alterar nome e descrição da loja.

### **UC06 - Listar Lojas**
- O sistema retorna todas as lojas cadastradas.

---

## **3️⃣ Gerenciamento de Produtos**

### **UC07 - Criar Produto**
- O vendedor informa nome, descrição, preço e estoque.
- O sistema vincula o produto à loja do vendedor.

### **UC08 - Atualizar Produto**
- O vendedor pode alterar nome, descrição, preço e estoque.

### **UC09 - Listar Produtos de uma Loja**
- Retorna todos os produtos de uma loja específica.

### **UC10 - Buscar Produto por Nome**
- Retorna produtos filtrados pelo nome.

---

## **4️⃣ Processo de Compra (Pedidos e Pagamentos)**

### **UC11 - Criar Pedido**
- O comprador seleciona produtos de diferentes lojas.
- O sistema calcula o valor total.
- O pedido inicia com status "PENDING".

### **UC12 - Adicionar Endereço ao Pedido**
- O comprador seleciona ou cadastra um endereço.

### **UC13 - Confirmar Pagamento**
- O comprador escolhe o método de pagamento (cartão, boleto, Pix).
- O sistema cria um registro de pagamento e altera o status do pedido para "PAID".

### **UC14 - Alterar Status do Pedido**
- O vendedor altera o status (PENDING → SHIPPED → DELIVERED).

### **UC15 - Listar Pedidos do Comprador**
- O sistema retorna o histórico de compras do usuário.

### **UC16 - Listar Pedidos do Vendedor**
- O sistema retorna os pedidos recebidos por uma loja.

---

## **5️⃣ Gerenciamento de Endereços**

### **UC17 - Cadastrar Endereço**
- O usuário informa rua, cidade, estado e CEP.

### **UC18 - Atualizar Endereço**
- O usuário pode alterar um endereço cadastrado.

### **UC19 - Listar Endereços do Usuário**
- O sistema retorna os endereços cadastrados.

---

## **🚀 Fluxo Resumido do MVP**

1️⃣ O **comprador** cria uma conta.
2️⃣ O **vendedor** cria uma conta e uma loja.
3️⃣ O **vendedor** adiciona produtos à sua loja.
4️⃣ O **comprador** vê os produtos e adiciona ao pedido.
5️⃣ O **comprador** seleciona um **endereço** e faz o pagamento.
6️⃣ O **vendedor** processa o pedido e altera status até "DELIVERED".


