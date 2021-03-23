## Dependências do projeto
- [OpenJDK 11](https://openjdk.java.net/projects/jdk/11/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Passos para executar o projeto

- Fazer o build do java via `mvn clean package`
- Executar via docker-composer (`docker-composer up`)

## Lista de API's
- POST http://localhost:8080/transacoes/api/accouts

    API responsável por criar uma conta

    Ex: Body da request
    ```json
    {
        "documento": "29255951033"
    }
    ```
- GET http://localhost:8080/transacoes/api/accouts/{accoutId}

    API responsável buscar os dados de uma conta

    Ex: Response da api
    ```json
    {
        "id": 1,
        "documento": "29255951033"
    }
    ```

- POST http://localhost:8080/transacoes/api/transactions

    API responsável por criar uma transação.

    Ex: Body da request
    ```json
    {
        "valor": -1000.00,
        "tipoOperacao": "COMPRA_PARCELADA",
        "conta": {
            "id": 1
        }
    }
    ```

    Obs.: Os tipos de operação são:

    ```
    COMPRA_A_VISTA,
    COMPRA_PARCELADA,
    SAQUE,
    PAGMENTO;
    ```
