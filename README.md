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



## Login properties

### What has been moved to the ViewModel:

Like username, password, isUserNameEmpty, isPasswordEmpty, and isFormValid, which were being used directly to control
the UI, have now been centralized in the ViewModel to make state management more consistent and ensure that business
logic does not depend on the Composable in this way.
username and password: These variables store the values of input fields and can be kept in the ViewModel to centralize
state and data manipulation logic.

isUserNameEmpty and isPasswordEmpty: These variables are dependent on the values of username and password.
Instead of keeping them in the Composable, they will be calculated directly in the ViewModel using derivedStateOf.

### What can remain in the Composables:

isFormValid: This value will be calculated locally in the Composable, since it only depends on the local state of
username and password. However, this variable can also be calculated in the ViewModel, since username and
password are there.

Other UI-specific variables: Things like showPassword, snackbarHostState, focusRequester, keyboardController, and
showRetryLimitReached can remain in Composables because they are UI-specific and do not need to be centralized in
the ViewModel.