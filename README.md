
# Jogo de Adivinhação

Este é um projeto desenvolvido como parte da disciplina Paradigmas de Linguagens de Programação, ministrada pela professora Aline Dos Santos. O objetivo principal é explorar conceitos de programação em Java através da criação de um jogo interativo.
Alunos participantes  
João Vitor Leal Targino RGM 31050379
Luis Gustavo de Carvalho Briedis RGM 31260381


## 📋 Descrição do Projeto


O Jogo de Adivinhação é composto por dois modos principais:

    1. Adivinhar o Número: O jogador tenta adivinhar um número secreto gerado aleatoriamente entre 1 e 100.
    2. Adivinhar a Palavra: O jogador tenta adivinhar uma palavra original a partir de sua versão embaralhada.
O projeto utiliza Java Swing para construir a interface gráfica e garantir uma interação amigável com o usuário.





## 🚀 Funcionalidades

- Interface gráfica intuitiva e colorida.
- Modo de jogo de números:
- Dicas como "Muito Alto" ou "Muito Baixo".
- Pontuação baseada nos acertos.
- Modo de jogo de palavras:
- Apresenta uma palavra embaralhada.
- Pontuação acumulada por acertos.
- Retorno ao menu principal a qualquer momento.
- Exibição da pontuação atual no menu principal.


## 🛠️ Tecnologias Utilizadas

## 📂 Estrutura do Projeto

resources/  
└── files Lista de Palavras.txt # Arquivo com as palavras usadas no jogo  
src/  
├── Main.java                   # Classe principal para inicializar o jogo  
├── Player.java                 # Gerencia a pontuação do jogador  
├── PanelMenuPrincipal.java     # Menu principal para escolher o modo de jogo  
├── PanelAdivinharNumero.java   # Implementa o modo de adivinhação de números  
├── PanelAdivinharPalavra.java  # Implementa o modo de adivinhação de palavras  
└── PalavrasEmbaralhada.java    # Gerencia o carregamento e embaralhamento de palavras
 

## Como Executar o Projeto

    1. Certifique-se de ter o Java JDK instalado (versão 8 ou superior).
    2. Clone o repositório:
        git clone https://github.com/seu-usuario/jogo-adivinhacao.git
    3. Importe o projeto em sua IDE (como IntelliJ IDEA ou Eclipse).
    4. Compile e execute o arquivo Main.java.
    
## 📚 Aprendizados

Este projeto permitiu aplicar conceitos de:

- Manipulação de arquivos para carregar palavras.
- Interface gráfica com Java Swing.
- Orientação a Objetos, com encapsulamento e reuso de código.
- Utilização de coleções e manipulação de strings.

## 👩‍🏫 Professora Orientadora

Este projeto foi orientado pela professora Aline Dos Santos, no curso de Paradigmas de Linguagens de Programação, na Universidade Braz Cubas UBC
## ✨ Melhorias Futuras

- Adicionar níveis de dificuldade para os modos de jogo.
- Melhorar o design da interface gráfica com bibliotecas modernas como JavaFX.
- Persistência de dados (salvar pontuação em arquivos ou banco de dados).
