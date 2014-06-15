<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><body>
<h1 align="center">Seleção de Status</h1>
<form method="post" action="ListarTarefas.do">
Selecione o status:<p>
  <select name="status" size="1">
    <option value="Aberta"> Abertas </option>
    <option value="Fechada"> Fechadas </option>
  </select>
<br><br>
<center>
  <input type="SUBMIT">
</center>
</form>
</body>
</html>