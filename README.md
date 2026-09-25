# Ejercicio-de-Arreglos
Programa en Java que gestiona las ventas de una tienda mediante un arreglo bidimensional, que consta de 12 meses (filas) y 3 departamentos (columnas).
Incluye menú para poder: 
1. Insertar elementos en el arreglo.
2. Buscar algún elemento en particular.
3. Eliminar ventas en particular de algún departamento.
4. Mostrar tabla completa con sus respectivos meses, departamentos, montos.
5. Botón para poder salir del programa y finalizarlo.

¿Cómo funciona?
insertarElemento(mes, depto, monto): Asigna un valor numérico a la coordenada específica de la matriz. Valida internamente que los índices correspondan a un mes y departamento válidos antes de guardar el registro.

buscarElemento(monto): Recorre toda la matriz bidimensional mediante dos ciclos anidados. Compara cada celda con el monto solicitado e imprime todas las coincidencias encontradas (mes y departamento).

eliminarElemento(mes, depto): Restablece la celda especificada a `0.0`. Al ser un arreglo estático, los espacios en memoria no se destruyen, sino que se reinician a su valor por defecto.
