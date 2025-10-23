### Sistema de Pedidos con Event Bus

###### 

#### Descripción

Este proyecto implementa un sistema de comunicación basado en **eventos (Event Bus)** para simular el funcionamiento de un restaurante.

Cuando una mesa realiza un pedido, los distintos componentes (Barra, Cocina, PanelLED, SistemaDeSonido y Banda) se comunican de forma **asíncrona** mediante la publicación y suscripción de eventos.





#### Estructura del proyecto



##### Clases principales

**EventBus:**

  Clase central que gestiona la suscripción, desuscripción y publicación de eventos.



**Interfaces:**

  - Publicador: define la capacidad de publicar eventos.

  - Suscriptor<T>: define la capacidad de reaccionar a eventos de tipo T.



**Eventos:**

  - PedidoRealizadoEvent.

  - BebidaServidaEvent.

  - ComidaPreparadaEvent.

  - BandaTocandoEvent.



**Suscriptores:**

  - Barra.

  - Cocina.

  - PanelLED.

  - SistemaDeSonido.

&nbsp; - SistemaDeHumo.



**Publicadores:**

  - SistemaDePedidos.

  - Banda.





##### Cómo ejecutar el proyecto



**Requisitos**

\- Tener instalado **Java 17 o superior**

\- Un entorno como **VS Code**, **IntelliJ IDEA**, o **NetBeans**.



**Pasos para ejecutar**

1\. Clonar el repositorio:

   git clone https://github.com/tu-usuario/nombre-del-repo.git

   cd nombre-del-repo

