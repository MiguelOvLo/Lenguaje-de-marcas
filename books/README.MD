<div align = “justify">
#Books

## Ejercicio 1

### Texto ingresado
"for $x in (1 to 5)
return <test>{$x}</test>"

### Resultado
<test>1</test>
<test>2</test>
<test>3</test>
<test>4</test>
<test>5</test>

## Ejercicio 2

### Texto ingresado
for $x at $i in doc("books.xml")/bookstore/book/title
return <book>{$i}. {data($x)}</book>

### Resultado
<book>1. Everyday Italian</book>
<book>2. Harry Potter</book>
<book>3. XQuery Kick Start</book>
<book>4. Learning XML</book>

## Ejercicio 3

### Texto ingresado
for $x in (10,20), $y in (100,200)
return <test>x={$x} and y={$y}</test>

### Resultado
<test>x=10 and y=100</test>
<test>x=10 and y=200</test>
<test>x=20 and y=100</test>
<test>x=20 and y=200</test>

## Ejercicio 4

### Texto ingresado
let $x := (1 to 5)
return <test>{$x}</test>

### Resultado
<test>1 2 3 4 5</test>

## Ejercicio 5

### Texto ingresado
for $x in doc("books.xml")/bookstore/book
order by $x/@category, $x/title
return $x/title

### Resultado
<title lang="en">Harry Potter</title>
<title lang="en">Everyday Italian</title>
<title lang="en">Learning XML</title>
<title lang="en">XQuery Kick Start</title>

## Ejercicio 6

### Texto ingresado
for $x in doc("books.xml")/bookstore/book
return $x/title

### Resultado
<title lang="en">Everyday Italian</title>
<title lang="en">Harry Potter</title>
<title lang="en">XQuery Kick Start</title>
<title lang="en">Learning XML</title>


</div>
