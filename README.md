# auth-service

/src/main/java/br.com.foursales.auth_service/
│── application/      # Casos de uso (Regras de Negócio) → Clean Architecture  
│   ├── dto/          # Objetos de Transferência de Dados  
│   ├── service/      # Lógica de Aplicação  
│   ├── event/        # Produção e Consumo de Eventos Kafka  
│── domain/           # Camada de Domínio (Regras de Negócio Puras) → Clean Architecture  
│   ├── model/        # Entidades do Domínio (sem JPA)  
│   ├── repository/   # Portas de Persistência (Interfaces) → Hexagonal  
│── infrastructure/   # Adaptadores Secundários → Hexagonal  
│   ├── config/       # Configuração do Spring, Kafka, Security  
│   ├── persistence/  # Implementações de repositórios  
│   ├── client/       # Feign Clients para comunicação com outros serviços  
│── web/              # Adaptadores Primários (API) → Hexagonal  
│   ├── controller/   # Endpoints REST (Interfaces de Entrada)  
│── MicroserviceApplication.java  # Classe principal do Spring Boot  

