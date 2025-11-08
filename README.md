# 🚗 Boy Lava Car

**Boy Lava Car** é um sistema web desenvolvido para gerenciamento completo de lavagens automotivas.  
O projeto foi criado para atender a empresa **Boy Lava Car**, oferecendo uma plataforma moderna e intuitiva para **agendamentos de serviços**, **controle operacional** e **análise de desempenho** do lava-rápido.

---

## 🧾 Descrição do Projeto

O sistema permite que **clientes realizem agendamentos online** de lavagens, escolhendo:
- Tipo de veículo (**carro, moto ou caminhonete**);
- Tipo de lavagem (**tradicional, chassi, motor ou detalhada**);
- Data e horário disponíveis conforme o funcionamento do estabelecimento.

Do lado administrativo, o **proprietário do lava-rápido** conta com um **painel de gestão** onde é possível:
- Visualizar agendamentos em cards com status atual (pendente, em andamento, finalizado, cancelado);
- **Criar agendamentos manuais** diretamente no sistema;
- **Editar, cancelar e finalizar** lavagens;
- **Configurar horários de funcionamento** e dias ativos;
- Consultar um **dashboard** com indicadores de desempenho, incluindo:
  - Quantidade de atendimentos (dia, semana e mês);
  - Faturamento total e filtrado por período;
  - Estatísticas personalizadas para acompanhamento da operação.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **Thymeleaf** (front-end integrado)
- **Bootstrap 5** (layout e componentes)
- **H2 / MySQL** (banco de dados)
- **Lombok**
- **Maven**

---

## 🚀 Funcionalidades Principais

| Módulo | Funcionalidades |
|--------|------------------|
| **Cliente** | - Agendamento de lavagens <br> - Escolha de tipo de veículo e serviço <br> - Visualização do status do agendamento |
| **Administrador** | - Painel de agendamentos com cards <br> - Criação, edição e cancelamento de agendamentos <br> - Controle de dias e horários de funcionamento |
| **Dashboard** | - Visualização de atendimentos (dia, semana, mês) <br> - Faturamento total e filtrado <br> - Gráficos e métricas |
| **Configurações** | - Definição de horários e dias de atendimento <br> - Gerenciamento de tipos de serviço e valores |

---

## 🧩 Padrões e Boas Práticas

- Arquitetura **MVC (Model-View-Controller)**;
- Código limpo e orientado a objetos;
- Camadas desacopladas (**Controller → Service → Repository**);
- Utilização de **DTOs e validações com Bean Validation**;
- Organização de templates Thymeleaf em módulos (`templates/Agendamentos`, `templates/MenuLateral`, etc.);
- Boas práticas de **tratamento de erros e mensagens de feedback** ao usuário.

---

## 🧠 Futuras Implementações

- Autenticação e controle de acesso (Spring Security);
- Relatórios em PDF/Excel;
- Sistema multi-tenant para múltiplos lava-rápidos;
- API REST para integração com apps mobile.

---

## 🧑‍💻 Autor

**Luis Terna Nunes**  
Desenvolvedor Back-end | Professor de Desenvolvimento de Sistemas  
📧 luisterna@gmail.com 
💼 www.linkedin.com/in/luisternanunes
  

---

## 🪪 Licença

Este projeto é de uso restrito à empresa **Boy Lava Car** e ao desenvolvedor responsável.  
Não é permitida a reprodução ou redistribuição sem autorização prévia.

---

