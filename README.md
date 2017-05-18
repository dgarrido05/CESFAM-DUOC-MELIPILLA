# CESFAM-DUOC-MELIPILLA
PROYECTO DE TITULO DUOC MELIPILLA

Cabros, aquí dejen sus mensajes si hicieron algún cambio, modificación, etc etc.

PARA JAVA:

*Validar sexo al hacer un update

*ARREGLAR INSERT DE CESUSUARIOS

*agregar validador de vigencia y de paciente al mostrar (que no sea usuario en CesPersona) ---->Listo

*agregar tabla de control de errores

*agregar crud de farmacia (David)

*agregar controlador para ingresar medicamento (David)

----------------------------------------------

-BORRADA COLUMNA MED_LABORATORIO DE TABLA CES_MEDICAMENTOS
-TABLA AGREGADA: CES_LABORATORIO
-CLAVE FORANEA AÑADIDA A CES_MEDICAMENTOS: ID_LABORATORIO

----------------------------------------------

*se agregó códigos para .net

----------------------------------------------
15/05/2017 11:53
*Agregada tabla de control de errores a la base de datos

----------------------------------------------

*Se agregó index en tabla ces_usuario para el rut de persona :)

----------------------------------------------

16/05/2017

Ahora las tablas muestran solo usuarios vigentes y la vista de pacientes solo muestra pacientes y no usuarios en
--> CESFAM-DUOC-MELIPILLA/java/DAO/usuarioDAO.java

-----------------------------------------------

18/05/2017

Cambio en los eliminar de java en la capa de modelo, ahora no borran si no que dejan en estado 'n' (no vigente)

En --> CESFAM-DUOC-MELIPILLA/java/DAO/usuarioDAO.java

Agregados metodos para listar tipos (tablas maestras)

En --> CESFAM-DUOC-MELIPILLA/java/DAO/usuarioDAO.java

Agregado controlador para llenar los tipos en formulario de ingreso de medicamentos

En --> CESFAM-DUOC-MELIPILLA/java/Controlador/llenarTiposMedicamento.java

Agregado en la vista formulario de agregar medicamento 

En --> CESFAM-DUOC-MELIPILLA/ingresarMedicamento.jsp
