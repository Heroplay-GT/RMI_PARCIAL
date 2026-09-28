@echo off
cd /d "%~dp0"
title Servidor Promedio (Promedio-RMI-Java)
java -cp "EjemploRmiServidorPromedio\bin;EjemploRmiServidorPromedio\lib\*" com.parcial.promedio.rmi.Principal
pause
