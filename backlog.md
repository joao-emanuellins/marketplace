# 🍟 Sistema de Pedidos para Lanchonetes - Casos de Uso (MVP)

## 🎭 Atores do Sistema

- **Lanchonete:** Representa o administrador do sistema, responsável por configurar e operar seu próprio restaurante.
- **Cliente:** Usuário final que realiza pedidos no sistema.

---

## 🔐 1. Autenticação e Cadastro

### UC01 - Cadastro da Lanchonete

**Ator:** Lanchonete  
**Descrição:** Permite que a lanchonete se cadastre para começar a utilizar o sistema.  
**Funcionalidades:**

- Nome da lanchonete, e-mail, senha, CNPJ, telefone, endereço.
- Criação automática do painel de administração da lanchonete.

---

### UC02 - Login (JWT)

**Atores:** Lanchonete, Cliente  
**Descrição:** Autentica o usuário e gera tokens JWT.  
**Funcionalidades:**

- Login com e-mail e senha.
- Retorno de access token e refresh token.

---

### UC03 - Refresh Token

**Ator:** Sistema  
**Descrição:** Gera um novo access token a partir do refresh token.  
**Funcionalidades:**

- Verifica validade do token.
- Gera novo access token.

---

### UC04 - Cadastro do Cliente

**Ator:** Cliente  
**Descrição:** Permite que clientes se cadastrem no sistema.  
**Funcionalidades:**

- Nome, telefone, e-mail, senha.
- Possibilidade de autenticação futura.

---

## 🏪 2. Gestão da Lanchonete

### UC05 - Atualizar Informações da Lanchonete

**Ator:** Lanchonete  
**Descrição:** Atualiza dados cadastrais e de funcionamento.  
**Funcionalidades:**

- Nome, logotipo, horário, formas de pagamento, localização.

---

### UC06 - Configurar Tipos de Pedido

**Ator:** Lanchonete  
**Descrição:** Define se aceita delivery, retirada e/ou consumo no local.  
**Funcionalidades:**

- Marcar tipos permitidos de atendimento.

---

## 🍔 3. Gestão de Produtos e Categorias

### UC07 - Cadastro de Categorias de Produto

**Ator:** Lanchonete  
**Descrição:** Permite criar categorias para organizar os produtos.  
**Funcionalidades:**

- Nome da categoria.
- Ativação/desativação.

---

### UC08 - Cadastro de Produto

**Ator:** Lanchonete  
**Descrição:** Permite adicionar produtos que a lanchonete oferece.  
**Funcionalidades:**

- Nome, descrição, imagem, categoria, preço e disponibilidade.

---

### UC09 - Edição de Produto

**Ator:** Lanchonete  
**Descrição:** Permite atualizar ou remover produtos.  
**Funcionalidades:**

- Edição de preço, descrição, disponibilidade.

---

### UC10 - Listar Produtos

**Atores:** Lanchonete, Cliente  
**Descrição:** Exibe os produtos organizados por categoria.  
**Funcionalidades:**

- Filtro por categoria, busca por nome.

---

## 📋 4. Pedidos

### UC11 - Criar Pedido

**Ator:** Cliente  
**Descrição:** Realiza um pedido via app ou site.  
**Funcionalidades:**

- Seleção de produtos.
- Escolha de tipo (retirada, consumo local ou delivery).
- Observações adicionais.

---

### UC12 - Gestão de Comandas (Consumo Local)

**Ator:** Lanchonete  
**Descrição:** Permite criar comandas para controle de pedidos nas mesas.  
**Funcionalidades:**

- Identificação por número ou código.
- Vários pedidos associados a uma comanda.

---

### UC13 - Acompanhamento de Status do Pedido

**Atores:** Cliente, Lanchonete  
**Descrição:** Permite acompanhar a evolução de um pedido.  
**Funcionalidades:**

- Estados: Recebido, Em produção, Pronto, Saiu para entrega, Entregue.

---

### UC14 - Cancelamento de Pedido

**Atores:** Cliente (enquanto não em produção), Lanchonete  
**Descrição:** Permite cancelar um pedido.  
**Funcionalidades:**

- Registro de motivo.
- Ajustes de estoque (se aplicável).

---

## 💳 5. Pagamento e Financeiro

### UC15 - Configurar Formas de Pagamento

**Ator:** Lanchonete  
**Descrição:** Define quais métodos de pagamento são aceitos.  
**Funcionalidades:**

- Cartão, Dinheiro, Pix, entre outros.

---

### UC16 - Registrar Pagamento

**Ator:** Lanchonete  
**Descrição:** Marca o pedido como pago.  
**Funcionalidades:**

- Escolha de forma de pagamento.
- Registro do pagamento no sistema.

---

### UC17 - Relatórios de Vendas

**Ator:** Lanchonete  
**Descrição:** Permite consultar estatísticas e vendas.  
**Funcionalidades:**

- Totais por período, forma de pagamento, produto.

---

## 🚚 6. Entrega e Retirada

### UC18 - Cadastro de Endereço para Entrega

**Ator:** Cliente  
**Descrição:** Cliente informa onde deseja receber o pedido.  
**Funcionalidades:**

- Rua, número, bairro, complemento, referência.

---

### UC19 - Acompanhamento da Entrega

**Ator:** Cliente  
**Descrição:** Cliente pode visualizar o progresso da entrega.  
**Funcionalidades:**

- Exibição do status atual do pedido.

---

## 👥 7. Funcionalidades do Cliente

### UC20 - Histórico de Pedidos

**Ator:** Cliente  
**Descrição:** Permite visualizar pedidos anteriores.  
**Funcionalidades:**

- Listagem por data, status e valores.

---

### UC21 - Atualização de Perfil

**Ator:** Cliente  
**Descrição:** Cliente pode editar dados cadastrais.  
**Funcionalidades:**

- Nome, e-mail, senha, telefone.

---

