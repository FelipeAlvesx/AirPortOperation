# ✈️ AirPort Operation

Bem-vindo ao **AeroOps**, uma API RESTful desenvolvida para gerenciar operações críticas de aeroportos, incluindo fluxo de voos, alocação inteligente de portões e check-in de passageiros.

Este projeto foi criado com foco em **Arquitetura em Camadas**, **Boas Práticas de Design** e **Regras de Negócio Complexas**.

## 🚀 Tecnologias Utilizadas

*   **Java 17** (LTS)
*   **Spring Boot 3.x**
*   **Spring Data JPA** (Persistência de Dados)
*   **H2 Database** (Banco em memória para desenvolvimento rápido)
*   **Lombok** (Redução de boilerplate code)
*   **Bean Validation** (Validação de DTOs)
*   **Maven** (Gerenciador de dependências)

## ⚙️ Funcionalidades Principais

### 1. Gestão de Infraestrutura
*   **Cadastro de Aeroportos e Portões:** Estrutura relacional entre Aeroportos e seus Terminais/Portões.
*   **Data Seeding Automático:** Importação automática de portões via arquivo CSV (`gates.csv`) na inicialização do sistema, utilizando `CommandLineRunner`.

### 2. Operação de Voos
*   **CRUD de Voos:** Criação e gerenciamento de status de voos (Agendado, Atrasado, Cancelado, etc).
*   **Alocação Inteligente de Portões:** Lógica de negócio que impede conflitos de horário. O sistema valida se um portão está livre no intervalo de tempo necessário para o pouso e decolagem.

### 3. Passageiros e Check-in
*   **Emissão de Bilhetes:** Associação entre Passageiro e Voo.
*   **Check-in:** Validação de janela de tempo (48h antes do voo) e atribuição de assentos.

## 🛠️ Como Rodar o Projeto

### Pré-requisitos
*   Java 17+ instalado.
*   Maven instalado (ou use o wrapper incluso).

### Passo a Passo

1.  **Clone o repositório:**
