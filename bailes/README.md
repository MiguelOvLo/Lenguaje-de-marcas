<div align = “justify">

## Bailes

## Ejercicio 1

for $baile in doc ("bailes.xml")/balies/balie/nombre/text()
return$baile

## Ejercicio 2

for $baile in doc ("bailes.xml")//baile
return
<baile>
  <nombre>{$baile/nombre/text()}</nombre>
  <precio>{$baile/precio/text()}</precio>
</baile>

## Ejercicio 3

for $baile in doc ("bailes.xml")//baile
where $baile/number(precio) > 40
return
<baile>
  <nombre>{$baile/nombre/text()}</nombre>
  <precio>{$baile/precio/text()}</precio>
</baile>

## Ejercicio 4

for $baile in doc ("bailes.xml")//baile
order by $baile/nombre 
return
<baile>
 <nombre>{$baile/nombre/text()}</nombre>
</baile>

## Ejercicio 5

for $baile in doc ("bailes.xml")//baile
where $baile/nombre[contains(text(),'a')]
return
<baile>
 <nombre>{$baile/nombre/text()}</nombre>
</baile>

## Ejercicio 6

for $baile in doc ("bailes.xml")//baile
where $baile/profesor[contains(text(),'lia')]
return
<baile>
 <profesor>{$baile/profesor/text()}</profesor>
</baile>

## Ejercicio 7

for $baile in doc ("bailes.xml")//baile
where $baile[@id != 3 and  @id != 5] 
return
<baile>
 <nombre>{$baile/nombre/text()}</nombre>
</baile>

## Ejercicio 8

for $baile in doc ("bailes.xml")//baile
where $baile/precio[@cuota="mensual"]
return
<baile>
 <profesor>{$baile/profesor/text()}</profesor>
</baile>

## Ejercicio 9

for $baile in doc ("bailes.xml")//baile
where $baile/sala[text()= 001 and ../precio/@moneda="euros"] 
return
<baile>
 <nombre>{$baile/nombre/text()}</nombre>
</baile>

## Ejercicio 10

for $baile in doc ("bailes.xml")//baile
return
<bailes>
  <nombre>{$baile/nombre/text()}</nombre>
  <precio>{$baile/(precio * plazas)}</precio>
</bailes>

## Ejercicio 11

for $baile in doc ("bailes.xml")//baile
where $baile/sala[text()= 001 and ../precio/@moneda="euros" and ../precio>35 ]
return
<baile>
 <nombre>{$baile/nombre/text()}</nombre>
</baile>

## Ejercicio 12

 <html>
  <head><title>Consulta Pagina Web</title></head>
  <body>
  <table border ="2"> Tabla1
  <tr>
    <th>Nombre baile</th>
    <th>Precio</th>
  </tr>
  {for $baile in doc ("bailes.xml")//baile
  where $baile/number(precio) > 40
  return
  <tr>
    <td>{$baile/nombre/text()}</td>
    <td>{$baile/precio/text()}</td>
  </tr>
  }
  </table>
  </body>
</html>



</div>
