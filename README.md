# Computação Gráfica
Projeto de um editor baseado em tipos primitivos em Java, criado no 4º Semestre de **Ciência da Computação da PUC SP**

Julio Cesar Barboza Filho RA: 00297586  

Lucas Costa Pessoa Graziano RA: 00297851  

Igor Masson Calille RA: 00297594  

Gustavo Scacchetti de Sousa RA: 00301499  


- Este projeto está sendo confeccionado por meio de programação em Visual Studio, em união com BlueJ, toda a programação é única e exclusivamente em Java.

- O projeto funciona como um App para gerar diversos tipos primitivos gráficos a partir de pontos, somente com conceitos e funções básicas, a fim de aumentar o aprendizado ao invés de ir direto para funções de otimização mais avançadas que simplificam o trabalho, são eles: 
  - Ponto;
  - Retas;
  - Círculos;
  - Retângulos;
  - Polígonos;
  - Linha Poligonal;
  
- **Pontos**:
  - Se tratando do tipo primitivo mais simples, o ponto se baseia na captura de uma coordenada (x, y) após o clique do usuário. Possui em seus atributos uma cor, nome e diâmetro;
  
    
- **Retas**: 
  - Passando para a reta, como este projeto é baseado apenas em funções simples, a lógica da reta consiste em capturar dois pontos com o mesmo formato de coordenada x e y, identificar e armazenar qual variação (delta x ou delta y) é maior para realizar a criação de uma reta mais precisa (isso está relacionado ao fato da reta ser horizontal, vertical ou diagonal por exemplo), após isso, usando uma estrutura de repetição "for", projetamos a reta desenhando vários pontos do início ao fim da reta.
  
    
   
- **Círculos**:
  - Se tratando de um círculo, o grupo chegou à conclusão que uma lógica inteligente seria produzir o círculo também a partir de dois pontos, assim como a reta, um dos pontos sendo o centro do círculo, e o segundo sendo o lado, tendo essas duas coordenadas, se torna possível projetar (com uma estrutura de repetição "do/while") uma série de pontos e formato circular. Isso é possível pois a distância entre o primeiro ponto e o segundo é o raio do círculo, e sabemos na geometria que a distância entre o centro de um círculo e qualquer ponto ao seu redor é o raio.
    
  
- **Retângulos**:
  - No retângulo, novamente devemos partir de pontos, então capturamos dois que representam as diagonais do retângulo (inferior esquerda e superior direita) e projetamos o retângulo baseado em 4 retas (que são desenhadas com a mesma lógica do tipo primitivo reta) trabalhadas com as coordenadas desses dois pontos (x1,y1) e (x2,y2):
    - A primeira reta inicia na coordenada (x1, y1) e termina na coordenada (x2, y1);
    - A segunda reta inicia na coordenada (x2, y1) e termina na coordenada (x2, y2);
    - A terceira reta inicia na coordenada (x2, y2) e termina na coordenada (x1, y2);
    - A quarta reta inicia na coordenada (x1, y2) e termina na coordenada (x1, y1);


      
- **Polígonos**:
  - Para realizar a implementação dos polígonos, trabalhamos em cima das bibliotecas do mouse (MouseListener, MouseEvent, etc). O funcionamento se baseia em uma sequência de cliques com o botão esquerdo em vários pontos da tela, cada clique é interligado por retas, ao clicar com o botão direito, a figura é "fechada", ou seja, o primeiro ponto do polígono é ligado ao último.  
  
    
- **Linha Poligonal**:
  - A linha Poligonal possui um funcionamento similar ao polígono, a diferença principal é que ela não é fechada, logo, novamente o usuário realiza uma sequência de cliques com o botão esquerdo em vários pontos da tela, mas ao clicar com o direito desta vez, se encerra a criação da linha poligonal, já que nesse caso não se fecha a figura;

  
- Além dos primitivos, o projeto também fornece opções de:
  - Cor;
  - Carregar;
  - Selecionar;
  - Translação;
  - Rotação;
  - Escala;
  - Apagar
  - Salvar;
  - Ler;
  - Limpar;  
  
  
- **Cor**:
  - A opção da cor, ao ser selecionada, mostra um menu para o usuário (seguindo a biblioteca Jcolor) onde se pode alterar a cor dos diversos desenhos do projeto;  
      
- **Carregar**:
  - Esta opção, como o próprio nome diz, carrega uma tela que antes teve seus primitivos gráficos retirados com a opção "limpar";
  
- **Selecionar**:
  - A opção de selecionar destaca um primitivo gráfico de escolha do usuário, esta opção é utilizada para que o usuário escolha qual primitivo irá apagar ou transformar geometricamente;
  
- **Translação**:
  - Esta opção realiza a transformação geométrica de translação; 
  
- **Rotação**:
  - Esta opção realiza a transformação geométrica de rotação; 
  
- **Escala**:
  - Esta opção realiza a transformação geométrica de escala;
  
- **Apagar**:
  - Esta opção apaga o primitivo gráfico selecionado;
  
- **Salvar**:
  - A opção de salvar está relacionada à persistência de arquivos, ao selecionar esta opção, um arquivo .json é criado com todos os primitivos que foram desenhados;
  
- **Ler**:
  - A opção de ler serve para ler outros arquivos .json que seguem o mesmo padrão determinado pela implementação;
  
- **Limpar**:
  - A opção de limpar retira todos os primitivos gráficos da tela, sem apagá-los, para que seja possível visualizar novamente na opção "carregar";
        
- **Segue abaixo um vídeo do projeto em funcionamento**:  
  
    

https://user-images.githubusercontent.com/54064857/199347067-5f71a525-373b-4296-acf6-05311aad2b80.mp4

