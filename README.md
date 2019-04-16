# Maven

## Que es maven?
Una herramienta que ahora se puede usar para construir y administrar cualquier proyecto basado en Java

## Objetivos
Hacer el proceso de construcción fácil
Proporcionar un sistema de construcción uniforme
Proporcionar información de calidad sobre el proyecto.
Proporcionar pautas para el desarrollo de mejores prácticas.
Permitir la migración transparente a nuevas funcionalidades.



## POM que significa y para que sirve
Un modelo de objeto de proyecto o POM es la unidad fundamental de trabajo en Maven. Es un archivo XML que contiene información 
sobre el proyecto y los detalles de configuración utilizados por Maven para construir el proyecto. Contiene valores por defecto
para la mayoría de los proyectos.



## Diferecia etre Archetype y Artifacid
##### Archetype: 
Es un conjunto de herramientas para la creación de plantillas del proyecto Maven. Un arquetipo se define como un patrón 
o modelo original a partir del cual se hacen todas las demás cosas del mismo tipo.

##### Artifatid: 
Es el nombre del jar sin versión. Si lo creó, entonces puede elegir el nombre que desee con letras minúsculas y sin 
símbolos extraños. Si se trata de un frasco de un tercero, debe tomar el nombre del frasco tal como se distribuye.



## Goals
##### compile: 
Compilar el código fuente del proyecto
##### package: 
Tomar el código compilado y empaquetarlo en su formato distribuible, como un JAR.
##### install: 
Instalar el paquete en el repositorio local, para usarlo como una dependencia en otros proyectos a nivel local.
##### clean: 
Esto intenta limpiar el directorio de trabajo de un proyecto de los archivos que se generaron en el momento de la compilación. 
Por defecto, descubre y borra los directorios configurados en project.build.directory, project.build.outputDirectory,
project.build.testOutputDirectory,
y project.reporting.outputDirectory.




## Scopes
##### compile:
compilar Este es el alcance predeterminado, usado si no se especifica ninguno. Las dependencias de compilación están disponibles
en todos los classpaths de un proyecto. Además, esas dependencias se propagan a proyectos dependientes.

##### provided:
Esto es muy parecido a la compilación, pero indica que espera que el JDK o un contenedor proporcione la dependencia en tiempo de 
ejecución

##### runtime:
indica que la dependencia no es necesaria para la compilación, pero es para la ejecución. Se encuentra en el entorno de ejecución 
y en la prueba de las rutas de clase, pero no en la compilación de la ruta de clases.

##### test:
indica que la dependencia no es necesaria para el uso normal de la aplicación y solo está disponible para las fases de
compilación y ejecución de la prueba. Este alcance no es transitivo.

##### system:
Este scope es similar al provided, excepto que debe proporcionar el JAR que lo contiene explícitamente. El artefacto 
siempre está disponible y no se busca en un repositorio.

