![](https://camo.githubusercontent.com/4cfa02087094e4dcb52d6a46203b6f0df1e71b63917c655103c79261c7ee7b64/68747470733a2f2f7777772e64756f632e636c2f77702d636f6e74656e742f75706c6f6164732f323032322f30392f6c6f676f2d302e706e67)

🏞️ Llanquihue Tour App
---  
Actividad final transversal (Semana 9)

### Autor:

Alonso Antonio Bonansco Vergara  
Desarrollo Orientado a Objetos I - 006A  
Analista Programador Computacional  
Campus Virtual

---

### Descripción:

"La agencia no dispone de un sistema estructurado ni orientado a objetos
para gestionar sus operaciones. Algunos problemas son: información desorganizada e
inexistencia de registros formales; falta de categorización entre personas;
estructuras no reutilizables ni escalables."

Para solucionar la problemática, se implementan principios de programación
orientada a objetos. Entre ellas: representar entidades por medios de clases,
relacionarlas por medio de herencia o composición donde aplique y uso de interfaz;
relegar las responsabilidades a las clases correspondientes, permitiendo reutilizar
código y generar una estructura escalable.

---

### Estructura:

```text
📁 resources/                               # Archivo txt con los datos de las entidades   
└── 📄 registros.txt

📁 src/
├── 📁 app/                                 # Punto de entrada de la aplicación
│   └── 📄 Main.java               
├── 📁 data/                                # Manejo sobre el archivo y carga de datos
│   ├── 📄 CargadorEntidades.java           
│   └── 📄 EntidadesFactory.java
├── 📁 model/                               # Clases del dominio
│   ├── 📄 Registrable.java                 - Interfaz en común
│   ├── 📄 Persona.java
│   ├── 📄 Empleado.java                   
│   ├── 📄 Chofer.java                  
│   ├── 📄 GuiaTuristico.java
│   ├── 📄 ProveedorHospedaje.java                 
│   ├── 📄 Vehiculo.java                  
│   └── 📄 Direccion.java
├── 📁 service/                             # Lógica del negocio: funciones sobre la lista de arreglos
│   └── 📄 GestorEntidades.java             
├── 📁 ui/                                  # Lógica de la interfaz para el usuario
│   └── 📄 VentanaAgencia.java              
└── 📁 util/                                # Excepciones y herramientas reutilizables
    ├── 📄 LineaInvalidaException.java       
    ├── 📄 RutInvalidoException.java
    └── 📄 RutValidator.java
```

---

### Instrucciones para clonar y ejecutar

Requisitos del sistema:

* **JDK:** Java 25 (LTS) o superior

1. Clonar el repositorio desde la terminal en Intellij:  
   git clone https://github.com/alonsobonansco/LlanquihueTourAppEFT.git
2. Marcar la carpeta `src` como "sources root" haciendo click derecho en ella
   -> Mark Directory As -> Sources Root. Y a su vez la carpeta `resources` como
   Resources Root.
3. Ejecutar el main desde su clase en el paquete app

Repositorio Github:
https://github.com/alonsobonansco/LlanquihueTourAppEFT