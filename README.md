<h1 align="center"> Presentación del tercer desafío BackEnd del programa Oracle Next Education </h1>

Foro Hub

<h2>Descripción del proyecto:</h2>
En este proyecto creé una API Rest con JAVA y SPRING BOOT que consta de una plataforma de cursos online donde los estudiantes pueden realizar sus preguntas a través de un foro, como apoyo a su proceso de aprendizaje de los contenidos de los cursos. Todas las dudas (topicos) que envíen los estudiantes son guardados en una base de datos en MySQL, a partir es esta data se podrán realizar las operaciones CRUD (CREATE, READ, UPDATE, DELETE). El usuario podrá: Crear un nuevo tópico, Mostrar todos los tópicos creados, Mostrar un tópico específico, Actualizar un tópico y Eliminar un tópico.

Además, se implementó un mecanismo de autenticación en la API para que los usuarios puedan autenticarse y enviar solicitudes a ella. Cuando el usuario envía su username y password al servidor, se genera un token JWT que es un estándar utilizado para compartir información entre cliente y servidor. El token se crea usando el algoritmo HMAC256.

<h2>Funcionalidades:</h2>
En esta API los estudiantes podrán:
<ul>
  <li>API con rutas implementadas siguiendo las mejores prácticas del modelo REST</li>
  <li>Validaciones realizadas según las reglas de negocio</li>
  <li>Implementación de una base de datos relacional para la persistencia de la información</li>
  <li>Servicio de autenticación/autorización para restringir el acceso a la información</li>
</ul>

<h2>Demostración:</h2>
Podrás ver en acción todas las funcionalidades de la API en este video: https://youtu.be/9gh9SnyuRe0

<h2>Tecnologías utilizadas:</h2>
Java, Spring Boot, Maven. Se usaron las dependencias: Lombok, Spring Web, Spring Boot DevTools, Spring Data JPA, Flyway Migration, MySQL Driver, Validation, Spring Security

Hecho por: Luz Angela Barrios Pulido
