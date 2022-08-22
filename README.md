# Computação Gráfica
Projeto de um editor baseado emm tipos primitivos em Java, criado no 4º Semestre de **Ciência da Computação da PUC SP**

Julio Cesar Barboza Filho RA: 00297586  
Lucas Costa Pessoa Graziano RA: 00297851
Igor Masson Calille RA: 00297594
Gustavo Scacchetti de Sousa RA: 00301499

-Este projeto está sendo confeccionado por meio de programação em Visual Studio, em união com BlueJ, toda a programação é única e exclusivamente em Java.

- O projeto funciona como um App para gerar diversos tipo primitivos gráficos a partir de pontos, somente com conceitos e funções básicas, a fim de aumentar o aprendizado ao invés de ir direto paara funções de otimização mais avançadas que simplificam o trabalho, são eles: 
  - Ponto;
  - Retas;
  - Círculos;
  - Retângulos;
  - Polígonos;
  -(adicionar novo tipo aqui)
  
- **Pontos**:
  - Se tratando do tipo primitivo mais simples, o ponto se baseia na captura de uma coordanada (x,y) após o clique do usuário, possui em seus atributos uma cor, nome e diâmetro;
  
  - (video do ponto aqui)
    
- **Retas**: 
  - Passando para a reta, como este projeto é basado apenas em funções simples, a lógica da reta consiste em capturar dois pontos com o mesmo formato de coordenada x e y, identificar e armazenar qual variação (delta x ou delta y) é maior para realizar a criacao de uma reta mais precisa (isso está relacionado a o fato da reta ser horizontal, vertical ou diagonal por exemplo), após isso, usando uma estrutura de repetição "for", projetamos a reta desenhando vários ponto do início ao fim da reta.
  
  -(video da reta aqui)
    
   
- **Círculos**:
  - Se tratando de um círculo, o grupo chegou a conclusão que uma lógica inteligênte seria produzir o círculo também a partir de dois pontos, assim como a reta, um dos pontos sendo o centro do círculo, e o segundo sendo o lado, tendo essas duas coordenadas, se torna possível projetar (com uma estrutura de repetição "do/while") uma série de pontos e formato circular. Isso é possível pois a distância entre o primeiro ponto e o segundo é o raio do círculo, e sabemos na geometria que a distância entre o centro de um círculo e qualquer ponto ao seu redor é o raio.
  
  -(video do círculo aqui)
  
  
- **Retângulos**:
  - No retângulo, novamente devemos partir de pontos, então capturamos dois que representam as diagonais do retângulo (inferior esquerda e superior direita) e projetamos o retângulo baseado em 4 retas (que são desenhadas com a mesma lógica do tipo primitivo reta) trabalhadas com as coordenadas desses dois pontos (x1,y1) e (x2,y2):
    - A primeira reta inicia na coordenada (x1, y1) e termina na coordenada (x2,y1) ;
    - A segunda reta inicia na coordenada (x2, y1) e termina na coordenada (x2,y2) ;
    - A terceira reta inicia na coordenada (x2, y2) e termina na coordenada (x1,y2) ;
    - A quarta reta inicia na coordenada (x1, y2) e termina na coordenada (x1,y1) ;
    
      -(video do retângulo aqui)
      
- **Polígonos**:
  
      
    
