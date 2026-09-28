@echo off
cd /d "%~dp0"
title Cliente Promedio (Promedio-RMI-Java)
java -cp "EjemploRmiClientePromedio\bin;EjemploRmiClientePromedio\lib\*" com.parcial.promedio.rmi.Principal
pause
