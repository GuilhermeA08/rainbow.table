# Rainbow Table Attack API

![Java](https://img.shields.io/badge/Java-22%2B-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.1-green.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

## Descrição

Esta API em Spring Boot foi desenvolvida para realizar ataques de tabela arco-íris (rainbow table attacks). Ela permite catalogar senhas em texto simples e realizar buscas reversas de hashes SHA-256 para encontrar suas correspondentes senhas.

## Funcionalidades

- **Catalogação de Senhas**: Armazene senhas e seus hashes correspondentes.
- **Busca de Hash**: Encontre a senha original a partir de um hash.
- **Verificação de Senha**: Verifique se uma senha já existe no banco de dados.
- **Catalogação em Massa**: Adicione múltiplas senhas de uma vez, identificando novas entradas e conhecidas.

## Endpoints

### 1. Obter Senha por Hash

- **URL**: `/password/hash`
- **Método**: `POST`
- **Requisição**:
  ```json
  {
    "hash": "exemploHash"
  }


- Resposta:
  ```json
  {
    "id": 2,
    "plainText": "teste",
    "hash": "46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5"
  }


2. Catalogar Senha
- **URL**: `/password/plainText/create`
- **Método**: `POST`
- **Requisição**:
  ```json
  {
    "plainText": "teste"
  }
- Resposta:
  ```json
  {
    "id": 2,
    "plainText": "teste",
    "hash": "46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5"
  }
3. Verificar Senha
- **URL**: `/password/plainText/verify`
- **Método**: `POST`
- **Requisição**:
  ```json
  {
    "plainText": "senhaParaVerificar"
  }
4. Catalogar Múltiplas Senhas
- **URL**: `/password/hash/multi`
- **Método**: `POST`
- **Requisição**:
  ```json
  [
    "teste",
    "admin",
    "teste1",
    "senha123"
  ]
- Resposta:
  ```json
  {
    "newPasswords": [
      {
        "id": 3,
        "plainText": "admin",
        "hash": "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918"
      },
      {
        "id": 4,
        "plainText": "senha123",
        "hash": "55a5e9e78207b4df8699d60886fa070079463547b095d1a05bc719bb4e6cd251"
      }
    ],
    "known": [
      {
        "id": 2,
        "plainText": "teste",
        "hash": "46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5"
      },
      {
        "id": 1,
        "plainText": "teste1",
        "hash": "15bf532d22345576b4a51b96da4754c039ef3458494066d76828e893d69ebd1e"
      }
    ]
  }

Pré-requisitos
Java 22 ou superior
Maven 8.8
Spring Boot 3.3.1 ou superior


# Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

# Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Contato

Se tiver dúvidas, sugestões ou quiser colaborar com o projeto, sinta-se à vontade para entrar em contato.

Conecte-se comigo no LinkedIn:

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Perfil-blue)](https://www.linkedin.com/in/guiherme-saldanha/)




