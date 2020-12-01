# Minimal Meditation   
Medite consiste em um aplicativo para auxiliar pessoas a realizar uma sessão rápida de meditação, 
dessa forma adquirindo uma melhor qualidade de vida e paz interior, tudo isso sem gastar muito tempo.


### Estrutura do Layout
A aplicação se divide em 5 activities: meditação padrão, meditação estendida, informações, histórico e activity base. 
A activity base contém o layout padrão da aplicação com logo e botões para cada activity. 
Esse layout está presente em todas as outras activities, que herdam de sua classe e incluem o layout padrão da aplicação.
  

### Funcionalidades
Quanto às funcionalidades do aplicativo, implementamos duas sessões de meditação: 
uma de 1 minuto e outra de 5 minutos, um histórico de acompanhamento que mostra o total de horas meditadas pelo usuário e 
uma linha do tempo para que ele possa acompanhar seu progresso vendo a data em que a sessão ocorreu, 
o tempo de meditação e a sua localização no momento. 
Além disso, também foi implementada uma tela informacional simples que explica a motivação e o funcionamento 
do aplicativo para o usuário, essa tela consiste em uma TextView com scroll que apresenta o texto informativo para o usuário.\
As sessões de meditação começam ao clicar no botão “Iniciar” nas duas primeiras telas do aplicativo. 
Ao se clicar no botão, inicia-se um Countdown Timer, uma classe presente nas bibliotecas nativas do Android, 
que realiza seu processo em uma thread separada da main, e dessa forma é possível desligar a tela do aparelho ou minimizar o aplicativo 
sem que a contagem do tempo seja interrompida. Ao encerrar a contagem, são persistidas em um sqlite as informações do timestamp atual, 
do tempo decorrido de meditação e da localização do usuário, que é obtida a partir do fusedLocationProviderClient, 
classe presente nas bibliotecas nativas do Android. 
Além disso, o usuário pode clicar no botão novamente para que volte ao estado inicial e possa iniciar outra meditação.\
Por fim, implementamos uma tela para acompanhamento do histórico de meditações, no topo mostramos o total de horas meditadas, 
informação essa que é obtida a partir de uma consulta no banco sqlite da aplicação. 
A tela tem um formato de timeline com um scroll, em que cada linha apresentada corresponde a uma entrada 
obtida do banco sqlite de meditações. 
Cada linha mostra a localização, a data e o tempo, para as meditações mais longas de 5 minutos, 
a informação do tempo fica é destacada na linha do tempo.
  

---

**_Solution-First, LLC_**
