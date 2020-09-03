# Minimal_Meditation   
Aplicativo de Meditação Minimalista para executivos e pessoas sem tempo.   
   
### Qual é a sua ideia de aplicativo? Inclua uma breve justificativa.   
Um aplicativo Android baseado no One-Moment Meditation® que além do "Minuto-Básico" de meditação, tem também uma micro-sessão de 30 segundos e uma de 3 minutos.   
( site: https://onemomentcompany.com/app/ e Google Play Store: https://play.google.com/store/apps/details?id=com.onemomentmeditation.omm1&hl=pt_BR )    
   
### Quem usará seu aplicativo e por que eles o usarão?
Pessoas que querem iniciar/aprender a meditar.   
Porque o limiar de entrada é mínimo e os benefícios físico, emocionais, mentais e além são infinitos.   
   
### Existe um aplicativo similar? Se sim, como o seu será diferente?
O citado anteriormente. Ele será em português inicialmente; Irei atacar o mercado nacional e há diferenciais além de apenas o Basic-Minute ( "Minuto-Básico" ) de 1 minuto.

### Como sua aplicação será estruturada? Quais telas o usuário irá interagir, e o que elas fazem? Qual é o fluxo de navegação?
Inicia-se uma splashscreen e em seguida segue para a primeira tela da imagem.   
   
Nesta tela inicial o user pode iniciar uma sessão de "Minuto-Básico" clicando no botão Start (button com click listener)   
ou pode clicar no menu superior para as telas de :   
* Info (explicações em TextView simples e talvez uma imagem embedded),   
* Vídeo Explicativo (youtube embedded) do próprio One-Moment expondo a referência principal,   
* Micro-Meditação de 30 segundos (clone da primeira tela mas com metade do tempo de MEDt) e   
* 3-MEDt (clone da primeira tela mas com 3 minutos de tempo de MEDt).   
* Histórico de Meditação - Persistir em SQLite o número de sessões e o tempo total de meditação.
![Telas_do_One-Moment_Meditation](https://www.thecabinchiangmai.com/wp-content/uploads/2017/01/One-Moment-Meditation-App-600.jpg)   
   
- Há um som de "ding!" ao começo e final da sessão. Serve como boundaries/balizas e ajuda a gerar mindfulness.   
- Uso de animação visual de um cronometro radial regressivo assim que o user iniciar uma sessão.   
(com click listener na animação para dar Stop na sessão de meditação.)   

___

PS - Ao fluir do desenvolvimento com bom desempenho pretendo acrescer as funcionalidades de :
* notificação para sugestão diária da prática meditativa,   
* evoluir de um design cru e feio para um "clear", minimalista e appealing/atraente (eye-candy),   
* animação/s progressiva ao passar da sessão.   
<img src="https://is3-ssl.mzstatic.com/image/thumb/Purple118/v4/88/5c/da/885cda49-955f-bed9-e7fd-1fceb2db4c9f/pr_source.png/300x0w.png" width="20%">
   
* **_QI_Solutions, LLC_**
---
   
