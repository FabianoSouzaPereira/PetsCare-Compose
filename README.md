## Arquitetura android Jetpack compose

* Kotlin
* JetPack Compose
* Coroutines
* KSP - replacing - old kapt
* Hilt - Dagger
* Retrofit
* Room
* RoboEletric JUni4 - Mockito - NavigationTestingKtx

![](Arquiteture.png)


#### Explicação: 

data/api/: Contém as interfaces para os serviços que fazem chamadas de rede (API) usando algo como Retrofit. 
Os serviços são responsáveis por fazer as requisições HTTP.

data/dao/: Contém os DAOs que são responsáveis por acessar o banco de dados local (usando Room, por exemplo). 
Cada entidade que você salvar localmente teria seu respectivo DAO.

data/repository/: O Repository é a camada que atua como intermediária entre os dados locais e remotos. 
Ele pode fazer requisições à API quando necessário e também acessar os dados locais. 
A lógica de como combinar os dados remotos e locais fica aqui.